package models

import slick.driver.MySQLDriver.api._
import scala.concurrent.duration.Duration
import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


object Queries {
  def main(args:Array[String]) {
  }
  
  def lobbys(ingame: String, db: Database): Future[Seq[Lobby]] = {
    db.run {
      (for {
        l <- Bindings.Lobbys
        if l.ingame === ingame
      } yield l).result.map(_.distinct)
    }
    //db.run(Bindings.Lobbys.filter(u => u.ingame === ingame).result)
  }
  
  def validLogin(user: String, db: Database): Future[Int] = {
    val matches = db.run(Bindings.Users.filter(u => u.user === user).result)
    matches.map(us => if(us.isEmpty) -1 else 2)
  }
  
  def addUser(user: String, pass: String, db: Database) {
    db.run(Bindings.Users += User(user, pass))
  } 
  
}