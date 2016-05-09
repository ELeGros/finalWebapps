package models

import scala.collection.mutable.Buffer

class Player(var x: Double, var y: Double, var id:Int, var lastPoll:Long) {

}

class Bullet(var px: Double, var py: Double, var vx: Double, var vy: Double, var life: Double)

class Wall(val x1: Double, val y1: Double, val x2: Double, val y2: Double, val vertical: Boolean)

object Player { // this is no longer a "player" object, so needs renaming
  private var _players = Buffer[Player]()
  private var _maxPlayers = 2
  private var _queue = Buffer[Player]()
  private var _index = -1
  private var _walls = Buffer[Wall]()
  private val _wallRadius = 10 // distance from center of wall to outer wall |----*    |
  //                                               ^ this distance

  private var _bullets = Buffer[Bullet]()
  private val _bulletLifespan = 100
  private val _bulletSpeed = 15

  private var running = false

  def startup: Unit = {
    if (!running) {
      //Outlined walls
      _walls.append(new Wall(  0.0,   0.0, 800.0,   0.0, false))
      _walls.append(new Wall(  0.0,   0.0,   0.0, 800.0,  true))
      _walls.append(new Wall(800.0, 0.0, 800.0, 800.0, true))
      _walls.append(new Wall(0.0, 800.0, 800.0, 800.0, false))
      running = true
      val thread = new Thread {
        override def run {
          while (true) {
            _bullets = updateBullets()
            if(_players.length < _maxPlayers && _queue.length > 0) {
              _players.append(_queue.head)
              _queue = _queue.drop(1)
            }
            for(p <- _players) {
              var timeSince = (System.nanoTime() - p.lastPoll) / 1000.0 / 1000.0 / 1000.0
              if(timeSince > 0.5) {
                //remove the palayeraoueirhe
                //println("Player removed")
                _players = _players - p
              }
            }
            Thread sleep 35
          }
        }
      }
      thread.run()
    }
  }

  //---------------------------Player Stuff-------------------------------------
  def addPlayer(): Int = {
    //add the player to the database
    _index += 1
    if(_players.length < _maxPlayers)
      _players.append(new Player(50.0, 50.0, _index, System.nanoTime()))
    else
      _queue.append(new Player(50.0, 50.0, _index, System.nanoTime()))
    _index
  }
  
  def inGamePoll(playerID:Int): Boolean = {
    for(p <- _players){ 
      //println("Player " + playerID + " polled")
      p.lastPoll = System.nanoTime()
      if(p.id == playerID) return true
    }
    false
  }

  def getPlayers(playerID: Int): String = {
    var out = ""
    for (p <- _players) {
      if (p.id == playerID) { out = out.concat("$") }
      out = out.concat(p.x + " " + p.y + "|")
    }
    out = out.dropRight(1)
    return out
  }

  def movePlayer(playerID: Int, dir: String): Unit = { // also will deal with wall collisions
    for (c <- dir) {
      if (c == 'w') _players.filter(_.id == playerID)(0).y -= 5.0
      if (c == 'a') _players.filter(_.id == playerID)(0).x -= 5.0
      if (c == 's') _players.filter(_.id == playerID)(0).y += 5.0
      if (c == 'd') _players.filter(_.id == playerID)(0).x += 5.0
    }
  }
  
  def playerWalls(p:Player):Array[Boolean] = {
    var ret = Array[Boolean](false, false, false, false)
    for(w <- _walls) {
      
    }
    return ret
  }

  //----------------------------------End Player Stuff--------------------------------

  //-------------------------------Bullet Stuff----------------------------------
  def addBullet(playerID: Int, x: Double, y: Double): Unit = {
    val px = _players.filter(_.id == playerID)(0).x
    val py = _players.filter(_.id == playerID)(0).y
    var vx = x - px
    var vy = y - py
    val mag = scala.math.sqrt(vx * vx + vy * vy)
    vx = vx / mag
    vy = vy / mag
    _bullets.append(new Bullet(px, py, vx, vy, _bulletLifespan))
  }

  def getBullets(): String = {
    var out = ""
    for (b <- _bullets) {
      out = out.concat(b.px + " " + b.py + "|")
    }
    out = out.dropRight(1) //drop off last "|"
    return out
  }

  def checkWalls(b: Bullet): Array[Boolean] = {
    var out = Array[Boolean](false, false, false, false)
    var newX = b.px + b.vx * _bulletSpeed
    var newY = b.py + b.vy * _bulletSpeed
    for (w <- _walls) {
      //println("--checking new wall")
      /* Return: charAt(0,1,2,3) corresponds to left, right, top, bottom walls
       */
      if (w.vertical) {
        val left = ((b.px - w.x1) < 0)
        if (left) { // bullet left of wall
          //println("----bullet to the left")
          val newdist = (newX + 10.0) - (w.x1 - _wallRadius)
          val olddist = (b.px + 10.0) - (w.x1 - _wallRadius)
          val comp = newdist * olddist
          if (comp <= 0) out(0) = true //newBullets.append(new Bullet(b.px - b.vx * _bulletSpeed, b.py + b.vy * _bulletSpeed, -b.vx, b.vy, b.life - 1))
          else out(0) = false //newBullets.append(new Bullet(b.px + b.vx * _bulletSpeed, b.py + b.vy * _bulletSpeed, b.vx, b.vy, b.life - 1))
        } else { // bullet right of wall
          //println("----bullet to the right")
          val newdist = (newX + 10.0) - (w.x1 + _wallRadius)
          val olddist = (b.px + 10.0) - (w.x1 + _wallRadius)
          val comp = newdist * olddist
          if (comp <= 0) out(1) = true //newBullets.append(new Bullet(b.px - b.vx * _bulletSpeed, b.py + b.vy * _bulletSpeed, -b.vx, b.vy, b.life - 1))
          else out(1) = false //newBullets.append(new Bullet(b.px + b.vx * _bulletSpeed, b.py + b.vy * _bulletSpeed, b.vx, b.vy, b.life - 1))
        }
      } else { // wall horizontal
        val above = ((b.py - w.y1) < 0)
        if (above) { // bullet above wall
          //println("----bullet above")
          val newdist = (newY + 10.0) - (w.y1 - _wallRadius)
          val olddist = (b.py + 10.0) - (w.y1 - _wallRadius)
          val comp = newdist * olddist
          if (comp <= 0) out(2) = true //newBullets.append(new Bullet(b.px + b.vx * _bulletSpeed, b.py - b.vy * _bulletSpeed, b.vx, -b.vy, b.life - 1))
          else out(2) = false // newBullets.append(new Bullet(b.px + b.vx * _bulletSpeed, b.py + b.vy * _bulletSpeed, b.vx, b.vy, b.life - 1))
        } else { // bullet below wall
          //println("----bullet below")
          val newdist = (newY + 10.0) - (w.y1 + _wallRadius)
          val olddist = (b.py + 10.0) - (w.y1 + _wallRadius)
          val comp = newdist * olddist
          if (comp <= 0) out(3) = true //newBullets.append(new Bullet(b.px + b.vx * _bulletSpeed, b.py - b.vy * _bulletSpeed, b.vx, -b.vy, b.life - 1))
          else out(3) = false //newBullets.append(new Bullet(b.px + b.vx * _bulletSpeed, b.py + b.vy * _bulletSpeed, b.vx, b.vy, b.life - 1))
        }
      }
    }
    out
  }
  
  def distance(x1:Double, y1:Double, x2:Double, y2:Double):Double = {
    math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)))
  }

  def checkPlayers(b:Bullet): Boolean = {
    for(p <- _players) {
      if(b.life < (_bulletLifespan - 3) && distance(p.x, p.y, b.px, b.py) < 40.0) {
        //println("a collision happen")
        _players = _players - p
        _queue.append(p)
        println("PLAYERS="+_players.mkString(" "))
        println("QUEUE="+_queue.mkString(" "))
        movePlayer(_players.indexOf(p), "")
        return true
      }
    }
    return false
  }
  
  def updateBullets(): Buffer[Bullet] = { //anything for bullet collisions will go here, and i believe player bullet collisions as well
    var newBullets = Buffer[Bullet]()
    //println("=============Start update bullets==============")
    for (b <- _bullets) {
      //println("checking new bullet")
      if (b.life > 1) { // exclude "dead" bullets
        var newX = b.px
        var newY = b.py
        var newVX = b.vx
        var newVY = b.vy
        // for ( w <- walls) blah blah labh
        val walls = checkWalls(b)
        if(walls(0) || walls(1)) { //bullet on left or right
          newX -= b.vx*_bulletSpeed
          newVX *= -1
        } else {
          newX += b.vx*_bulletSpeed
        }
        if(walls(2) || walls(3)) { //bullet on top or bottom
          newY -= b.vy*_bulletSpeed
          newVY *= -1
        } else {
          newY += b.vy*_bulletSpeed
        }
        
        //check for bullet-player collisions here
        if(checkPlayers(b)) println(" === dead bullet - did not append")
        else newBullets.append(new Bullet(newX, newY, newVX, newVY, b.life-1))
      }
      
    }
    //println("=============================End update bullets=======================")
    newBullets
  }
  //---------------------------------End Bullet Stuff------------------------------

  //-----------------------------------Wall Stuff----------------------------------

  def getWalls(): String = {
    var out = ""
    for (w <- _walls) {
      out = out.concat(w.x1 + " " + w.y1 + " " + w.x2 + " " + w.y2 + "|")
    }
    out = out.dropRight(1) //drop off last "|"
    return out
  }

  //---------------------------------End Wall Stuff-------------------------------
  def clear: Unit = {
    //      if(_status == 'a') {_status = 'b'}
    //      else if(_status == 'b') {_status = 'a'}
    //      _line = List[Line]()
    //      _line = _line :+ new Line("black",1.0,1.0,2.0,2.0)
  }
}