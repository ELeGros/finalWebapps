package models

import slick.driver.MySQLDriver.api._ 


/**
 * @author mlewis
 */
object Bindings {
  class Users(tag:Tag) extends Table[User](tag,"users") {
    val user: Rep[String] = column[String]("user", O.Length(20,varying=true))
    val pass: Rep[String] = column[String]("pass", O.Length(20,varying=true))
    
    def * = (user, pass) <> (User.tupled, User.unapply)
  }
  
  lazy val Users = new TableQuery(tag => new Users(tag))
  
/*  class Settings(tag:Tag extends Table[Setting](tag, "settings") {
    val user: Rep[String] = column[String]("user")
    val tank: Rep[String] = column[String]("tank")
    val back: Rep[String] = column[String]("back")
  
    def * = (user, tank, back)
  }*/
  
  
  class Lobbys(tag:Tag) extends Table[Lobby](tag,"lobby") {
    val user:Rep[String] = column[String]("user", O.Length(30,varying=true))
    val ingame:Rep[String] = column[String]("ingame",O.Length(1,varying=false))

    def * = (user, ingame) <> (Lobby.tupled, Lobby.unapply)
  }
  
  lazy val Lobbys = TableQuery(tag => new Lobbys(tag))
  
}