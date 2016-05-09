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

class Application @Inject()(environment: Environment, dbConfigProvider: DatabaseConfigProvider) extends Controller {

	val dbConfig = dbConfigProvider.get[JdbcProfile]

  def index = Action {
	  Ok(views.html.task(environment))
  }
  
  def addPlayer = Action { implicit request =>
    Ok(models.Player.addPlayer.toString)
  }
  def getPlayers(playerID:Int) = Action { implicit request =>
    Ok(models.Player.getPlayers(playerID))
  }
  
  def movePlayer(playerID:Int, dir:Char) = Action { implicit request =>
    models.Player.addKey(dir)
    models.Player.movePlayer(playerID, dir)
    models.Player.removeKey(dir)
    Ok("GOOD")
  }
  
  def sendLine(c:String, x1:Double, y1:Double, x2:Double, y2:Double) = Action { implicit request =>
    models.Line.addLine(c,x1,y1,x2,y2)
    Ok("GOOD")
  }
  
  def clear = Action { implicit request =>
    models.Line.clear
    Ok("GOOD")
  }

}
