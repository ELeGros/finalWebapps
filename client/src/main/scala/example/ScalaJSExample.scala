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
  var wDown = false
  var aDown = false
  var sDown = false
  var dDown = false
  var playerID = -1

  @JSExport
  def main(): Unit = {

    Ajax.get("addPlayer").onSuccess({ case x => playerID = x.responseText.toInt })
    Ajax.get("startServer")

    dom.onkeydown = { (e: dom.KeyboardEvent) =>
      {
        if (e.key == "w") {
          wDown = true
        } else if (e.key == "a") {
          aDown = true
        } else if (e.key == "s") {
          sDown = true
        } else if (e.key == "d") {
          dDown = true
        }
      }
    }

    dom.onkeyup = { (e: dom.KeyboardEvent) =>
      {
        if (e.key == "w") {
          wDown = false
        } else if (e.key == "a") {
          aDown = false
        } else if (e.key == "s") {
          sDown = false
        } else if (e.key == "d") {
          dDown = false
        }
      }
    }

    canvas.onmousedown = {
      (e: dom.MouseEvent) =>
        val rect = canvas.getBoundingClientRect()
        Ajax.get("addBullet/" + playerID + '/' + (e.clientX - rect.left) + '/' +  (e.clientY - rect.top) )
    }
    
    dom.setInterval(() => { render() }, 35)
  }

  def drawPlayer(color: String, position: Coordinate): Unit = {
    drawCircle(color, playerSize, position)
  }

  def drawBullet(color: String, position: Coordinate): Unit = {
    drawCircle(color, bulletSize, position)
  }

  def drawCircle(color: String, size: Int, position: Coordinate): Unit = {
    ctx.fillStyle = color
    ctx.fillCircle(position.x, position.y, size * 10.0)
  }

  def render(): Unit = {
    sendMovement()
    Ajax.get("getPlayers/" + playerID).onSuccess({ case y => Ajax.get("getBullets").onSuccess({ case z => parseAndDraw(y.responseText, z.responseText) }) })
  }

  def sendMovement(): Unit = {
    var keys = ""
    if (wDown) keys = keys + 'w'
    if (aDown) keys = keys + 'a'
    if (sDown) keys = keys + 's'
    if (dDown) keys = keys + 'd'
    if (keys.length > 0) Ajax.get("movePlayer/" + playerID + "/" + keys)
  }

  def parseAndDraw(players: String, bullets: String): Unit = {
    ctx.fillStyle = "white"
    ctx.fillRect(0, 0, canvas.width, canvas.height)
    val ps = players.split('|')
    for (s <- ps) {
      if (s.charAt(0) == '$') {
        val thisPlayer = s.drop(1).split(' ')
        drawPlayer("blue", Coordinate(thisPlayer(0).toDouble, thisPlayer(1).toDouble))
      } else {
        val otherPlayer = s.split(' ')
        drawPlayer("red", Coordinate(otherPlayer(0).toDouble, otherPlayer(1).toDouble))
      }
    }
    if (bullets.length > 0) {
      val bs = bullets.split('|')
      for (s <- bs) {
        val bullet = s.split(' ')
        drawBullet("black", Coordinate(bullet(0).toDouble, bullet(1).toDouble))
      }
    }

  }

}
