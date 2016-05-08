package models

import slick.driver.MySQLDriver.api._
import scala.concurrent.duration.Duration
import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


object Queries {
  def main(args:Array[String]) {
  }
  
  def tasks(username: String, db: Database): Future[Seq[Task]] = {
    db.run {
      (for {
        t <- Bindings.Tasks
        if t.username === username
      } yield t).result.map(_.distinct)
    }
  }
  
  def addTask(t:Task, db: Database):Unit = {
      db.run(Bindings.Tasks+=t)
  }
  
  def removeTask(t:Task, db: Database):Unit = {
//      db.run(Bindings.Tasks.filter(_.username === t.username && _.taskdesc === t.taskdesc).delete)
  }
}