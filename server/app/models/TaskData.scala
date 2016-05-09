package models

case class User(username:String, password:String)

case class Task(username:String, taskdesc:String)

case class Lobby(user:String, ingame:String)