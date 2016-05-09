package models

import scala.collection.mutable.Buffer

class Player(var x:Double, var y:Double) {
    
}
 
object Player{
    private var _players = Buffer[Player]()
    var keys = Buffer[Char]()
    
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
    
    def addKey(k:Char):Unit = {
      keys.append(k)
    }
    
    def removeKey(k:Char):Unit = {
      keys -= k
    }
    
    def movePlayer(playerID:Int, dir:Char):Unit = {      
      if(keys.contains('w')) _players(playerID).y -= 5.0
      if(keys.contains('a')) _players(playerID).x -= 5.0
      if(keys.contains('s')) _players(playerID).y += 5.0
      if(keys.contains('d')) _players(playerID).x += 5.0
//      dir match {
//        case 'w' => _players(playerID).y -= 5.0
//        case 'a' => _players(playerID).x -= 5.0
//        case 's' => _players(playerID).y += 5.0
//        case 'd' => _players(playerID).x += 5.0
//      }
    }
    
    def clear:Unit = {
//      if(_status == 'a') {_status = 'b'}
//      else if(_status == 'b') {_status = 'a'}
//      _line = List[Line]()
//      _line = _line :+ new Line("black",1.0,1.0,2.0,2.0)
    }
}