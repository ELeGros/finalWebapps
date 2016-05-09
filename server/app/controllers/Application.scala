package controllers

import play.api._
import play.api.mvc._
import shared.SharedMessages

import javax.inject._
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile
import slick.driver.MySQLDriver.api._
import slick.lifted.Tag
import slick.lifted.Rep
import scala.concurrent.ExecutionContext.Implicits.global
import models._
import scala.concurrent.Future
import play.api.data.Form
import play.api.data.Forms._

class Application @Inject()(environment: Environment, dbConfigProvider: DatabaseConfigProvider) extends Controller {

	val dbConfig = dbConfigProvider.get[JdbcProfile]

  def index = Action {
    val tmp:Seq[models.Lobby] = Seq[models.Lobby]()
	  Ok(views.html.task(tmp, tmp)(environment))
  }
  
  def addPlayer = Action { implicit request =>
    Ok(models.Player.addPlayer.toString)
  }
  
  def getPlayers(playerID:Int) = Action { implicit request =>
    Ok(models.Player.getPlayers(playerID))
  }
  
  def movePlayer(playerID:Int, dir:String) = Action { implicit request =>
    models.Player.movePlayer(playerID, dir)
    Ok("GOOD")
  }
  
  def addBullet(playerID:Int, x:Double, y:Double) = Action { implicit request =>
    models.Player.addBullet(playerID, x, y)
    Ok("GOOD")  
  }
  
  def inGamePoll(playerID:Int) = Action {implicit request =>
    Ok(models.Player.inGamePoll(playerID).toString)
  }
  
  def getBullets = Action { implicit request => 
      Ok(models.Player.getBullets)
  }
  
  def getWalls = Action { implicit request => 
      Ok(models.Player.getWalls)
  }
  
  def startServer = Action { implicit request =>
    models.Player.startup
    Ok("DONE")
  }
  
  def sendLine(c:String, x1:Double, y1:Double, x2:Double, y2:Double) = Action { implicit request =>
    models.Line.addLine(c,x1,y1,x2,y2)
    Ok("GOOD")
  }
  
  def clear = Action { implicit request =>
    models.Line.clear
    Ok("GOOD")
  }
  
  def lobby = Action.async { implicit request => 
    val db = dbConfig.db
    val lobbylist = models.Queries.lobbys("n", db)
    lobbylist.map(users => {Ok(views.html.task(users, users)(environment))})
  }
  
  def ingame = Action.async { implicit request =>
    val db = dbConfig.db
    val gamelist = models.Queries.lobbys("y", db)
    gamelist.map(users => {Ok(views.html.task(users, users)(environment))})
  }
  
  val loginForm = Form(
      mapping(
           "user" -> nonEmptyText(4,12),
           "pass" -> nonEmptyText(4,12))(Login.apply)(Login.unapply))
  
  val createForm = Form(
      mapping(
           "user" -> nonEmptyText(4,12),
           "pass" -> nonEmptyText(4,12))(Login.apply)(Login.unapply))
  
  def login = Action.async { implicit request =>
    println("please")
    loginForm.bindFromRequest().fold(
        formWithErrors => {
          println("errors")
          Future(Ok(views.html.login(formWithErrors)(environment)))
          //Future(Redirect(routes.Application.index))
        },
        value => {
          val db = dbConfig.db
          Queries.validLogin(value.username, db).map(_ match {
            case -1 => {
              Redirect(routes.Application.login)}
            case 2 => {
              val tmp:Seq[models.Lobby] = Seq[models.Lobby]()
              Ok(views.html.task(tmp,tmp)(environment))}
          })
          //Future(Redirect(routes.Application.index))
              
        }) 
  }

  def createUser = Action { implicit request =>
    createForm.bindFromRequest().fold(
        formWithErrors=> {
          Ok(views.html.createUser(formWithErrors)(environment))
        },
        value => {
          val db = dbConfig.db
          Queries.addUser(value.username, value.password, db)
          Redirect(routes.Application.login)
        })}
}

