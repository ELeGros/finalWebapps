package example

import scala.scalajs.js
import org.scalajs.dom
import shared.SharedMessages
import org.scalajs.dom.html
import scala.scalajs.js.annotation.JSExport
import scala.scalajs.js.JSApp
import scala.collection.mutable
import scala.collection.mutable.MutableList
import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom
import org.scalajs.dom.html
import dom.html //???
import dom.ext._ //???
import scala.scalajs.js.timers._
import js.Dynamic.{ global => jslog }
import dom.ext._
import scala.scalajs
import scala.concurrent.ExecutionContext.Implicits.global

@JSExport
object ScalaJSExample extends js.JSApp {
  case class Coordinate(x: Double, y: Double)
  val canvas = js.Dynamic.global.document.getElementById("canvas").asInstanceOf[html.Canvas]
  val ctx = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]
  val playerSize = 3
  val bulletSize = 1
  var playerID = -1
  
  @JSExport
  def main(): Unit = {
    
    
    Ajax.get("addPlayer").onSuccess({case x => playerID = x.responseText.toInt})
    
    dom.onkeypress = { (e: dom.KeyboardEvent) =>
      {
        if (e.key == "w") {
          Ajax.get("movePlayer/" + playerID + "/w")
        }
        if (e.key == "a") {
          Ajax.get("movePlayer/" + playerID + "/a")
        }
        if (e.key == "s") {
          Ajax.get("movePlayer/" + playerID + "/s")
        }
        if (e.key == "d") {
          Ajax.get("movePlayer/" + playerID + "/d")
        }
      }
    }

    canvas.onmousedown = {
      (e: dom.MouseEvent) =>
        
    }
    dom.setInterval(() => { render() }, 35)
  }
  
  def drawPlayer(color:String, position:Coordinate):Unit = {
    drawCircle(color, playerSize, position)
  }
  
  def drawBullet(color:String, position:Coordinate):Unit = {
    drawCircle(color, bulletSize, position)
  }
  
  def drawCircle(color:String, size:Int, position:Coordinate):Unit = {
    ctx.fillStyle = color
    ctx.fillCircle(position.x, position.y, size*10.0)
  }
  
  def render():Unit = {
    Ajax.get("getPlayers/" + playerID).onSuccess({ case y => parseAndDraw(y.responseText)})
  }
  
  def parseAndDraw(in:String):Unit = {
    ctx.fillStyle = "white"
    ctx.fillRect(0, 0, canvas.width, canvas.height)
    val players = in.split('|')
    for(s <- players) {
      if(s.charAt(0) == '$') {
        val thisPlayer = s.drop(1).split(' ')
        drawPlayer("blue", Coordinate(thisPlayer(0).toDouble, thisPlayer(1).toDouble))
      }
      else {
        val otherPlayer = s.split(' ')
        drawPlayer("red", Coordinate(otherPlayer(0).toDouble, otherPlayer(1).toDouble))
      }
    }
    
  }

}
