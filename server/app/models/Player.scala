package models

import scala.collection.mutable.Buffer

class Player(var x:Double, var y:Double) {
    
}

class Bullet(var px:Double, var py:Double, var vx:Double, var vy:Double, var life:Double)
 
object Player{
    private var _players = Buffer[Player]()
    private var _bullets = Buffer[Bullet]()
    private val _bulletLifespan = 50
    private val _bulletSpeed = 5
    private var running = false
    
    def startup:Unit = {
      if(!running) {
        val thread = new Thread {
          override def run {
            while(true) {
              _bullets = updateBullets()
              Thread sleep 35 
            }
          }
        }
        thread.run()
      }
    }
    
    def addPlayer():Int = {
      //add the player to the database
      _players.append(new Player(50.0,50.0))
      (_players.length - 1)
      //_line = _line :+ new Line(c,x1,y1,x2,y2)
    }
    
    def getPlayers(playerID:Int):String = {
      var out = ""
      for(p <- 0 to _players.length - 1) {
        if(p == playerID) {out = out.concat("$")}
        out = out.concat(_players(p).x + " " + _players(p).y + "|")
      }
      out = out.dropRight(1)
      return out
    }
    
    def movePlayer(playerID:Int, dir:String):Unit = {   
      for(c <- dir) {
        if(c == 'w') _players(playerID).y -= 5.0
        if(c == 'a') _players(playerID).x -= 5.0
        if(c == 's') _players(playerID).y += 5.0
        if(c == 'd') _players(playerID).x += 5.0
      }
    }
    
    def addBullet(playerID:Int, x:Double, y:Double): Unit = {
      val px = _players(playerID).x
      val py = _players(playerID).y
      var vx = x - px
      var vy = y - py
      val mag = scala.math.sqrt(vx*vx + vy*vy)
      vx = vx/mag
      vy = vy/mag
      _bullets.append(new Bullet(px, py, vx, vy, _bulletLifespan))
    }
    
    def getBullets():String = {
      var out = ""
      for(b <- _bullets) {
        out = out.concat(b.px + " " + b.py + "|")
      }
      out = out.dropRight(1)
      return out
    }
    
    def updateBullets():Buffer[Bullet] = {
      var newBullets = Buffer[Bullet]()
      for(b <- _bullets) {
        if(b.life > 1)
          newBullets.append(new Bullet(b.px+b.vx*_bulletSpeed, b.py+b.vy*_bulletSpeed, b.vx, b.vy, b.life - 1))
      }
      newBullets
    }
    
    def clear:Unit = {
//      if(_status == 'a') {_status = 'b'}
//      else if(_status == 'b') {_status = 'a'}
//      _line = List[Line]()
//      _line = _line :+ new Line("black",1.0,1.0,2.0,2.0)
    }
}