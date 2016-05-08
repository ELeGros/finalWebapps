package models

import slick.driver.MySQLDriver.api._ 


/**
 * @author mlewis
 */
object Bindings {
  class Users(tag:Tag) extends Table[User](tag,"users") {
    val username: Rep[String] = column[String]("username", O.Length(50,varying=true))
    val password: Rep[String] = column[String]("password", O.Length(50,varying=true))
    
    def * = (username, password) <> (User.tupled, User.unapply)
  }
  
  lazy val Users = new TableQuery(tag => new Users(tag))
  
  
  class Tasks(tag:Tag) extends Table[Task](tag,"tasks") {
    val username:Rep[String] = column[String]("username", O.Length(50,varying=true))
    val taskdesc:Rep[String] = column[String]("task",O.Length(150,varying=true))

    def * = (username, taskdesc) <> (Task.tupled, Task.unapply)
  }
  
  lazy val Tasks = TableQuery(tag => new Tasks(tag))
  
}