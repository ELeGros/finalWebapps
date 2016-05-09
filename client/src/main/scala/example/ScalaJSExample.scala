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

@JSExport
object ScalaJSExample extends js.JSApp {
  case class Coordinate(x: Double, y: Double)
  val canvas = js.Dynamic.global.document.getElementById("canvas").asInstanceOf[html.Canvas]
  val ctx = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]
  val playerSize = 3
  val bulletSize = 1
  
  @JSExport
  def main(): Unit = {
    import dom.ext._
    import scala.scalajs
    import scala.concurrent.ExecutionContext.Implicits.global

    dom.onkeypress = { (e: dom.KeyboardEvent) =>
      {
        if (e.key == "c") {
  //        Ajax.get("clear")
        }
      }
    }

    canvas.onmousedown = {
      (e: dom.MouseEvent) =>
        
    }
  //  dom.setInterval(() => { poll() }, 35)
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
  

}
