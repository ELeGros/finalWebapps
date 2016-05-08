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
  var down = false
  case class Point(x: Double, y: Double)
  case class Line(c:String, p1: Point, p2: Point)
  var nLines = List[Line]()
  var lastPoll = List[Line]()
  var lastResponse = 'a'
  var currentColor = "black"
  var last = Point(-1, -1)
  val canvas = js.Dynamic.global.document.getElementById("canvas").asInstanceOf[html.Canvas]
  val ctx = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]

  @JSExport
  def main(): Unit = {
    import dom.ext._
    import scala.scalajs
    import scala.concurrent.ExecutionContext.Implicits.global

    canvas.width = canvas.parentElement.clientWidth
    canvas.height = canvas.parentElement.clientHeight
    ctx.fillStyle = "#f8f8f8"
    ctx.fillRect(0, 0, canvas.width, canvas.height)
    ctx.lineWidth = 5

    dom.onkeypress = { (e: dom.KeyboardEvent) =>
      {
        if (e.key == "c") {
          Ajax.get("clear")
          ctx.fillStyle = "#f8f8f8"
          ctx.fillRect(0, 0, canvas.width, canvas.height)
          if (lastResponse == 'a') { lastResponse = 'b' }
          else if (lastResponse == 'b') { lastResponse = 'a' }
          nLines = List[Line]()
        }
        if (e.key == "r") {
          currentColor = "red"
        }
        if (e.key == "b") {
          currentColor = "black"
        }
        if (e.key == "g") {
          currentColor = "green"
        }
      }
    }

    canvas.onmousedown = {
      (e: dom.MouseEvent) =>
        down = true
        val rect = canvas.getBoundingClientRect()
        last = Point(e.clientX - rect.left, e.clientY - rect.top)
    }
    canvas.onmouseup = {
      (e: dom.MouseEvent) =>
        down = false
        last = Point(-1, -1)
    }
    canvas.onmousemove = {
      (e: dom.MouseEvent) =>
        val rect =
          canvas.getBoundingClientRect()
        if (down) {
          Ajax.get("send/"+ currentColor + "/" + last.x + "/" + last.y + "/" + (e.clientX - rect.left) + "/" + (e.clientY - rect.top))
          last = Point(e.clientX - rect.left, e.clientY - rect.top)
        }
    }

    dom.setInterval(() => { poll() }, 35)
  }

  @JSExport
  def poll() {
    import dom.ext._
    import scala.scalajs
    import scala.concurrent.ExecutionContext.Implicits.global

    val url = "poll"
    Ajax.get(url).onSuccess {
      case xhr =>
        val (response, newPoll) = parsePoll(xhr.responseText) //all the lines stored on the server
        if (newPoll.length == 1) {
          lastPoll = newPoll
          nLines = List[Line]()
          ctx.fillStyle = "#f8f8f8"
          ctx.fillRect(0, 0, canvas.width, canvas.height)
        } else {
          val dif = newPoll.diff(lastPoll)
          if (dif.length > 0) {
            for (l <- dif) {
              nLines = nLines :+ l
            }
            lastPoll = newPoll
            
            for (l <- nLines) {
              ctx.beginPath()
              ctx.strokeStyle = l.c
              ctx.moveTo(l.p1.x, l.p1.y)
              ctx.lineTo(l.p2.x, l.p2.y)
              ctx.stroke()
              ctx.closePath
            }
            
            
            nLines = List[Line]()
          }
        }

    }

  }

  def parsePoll(in: String): (Char, List[Line]) = {
    var out = List[Line]()
    if (in.length == 0) return ('z', out)
    val response = in.split('$')
    val lineStrings = response(1).split('|')
    //  dom.window.alert(lineStrings.mkString(","))
    for (s <- lineStrings) {
      if (s.length > 0) {
        val strPts = s.split(' ')
        // dom.window.alert(s)
        out = out :+ Line(strPts(0), Point(strPts(1).toDouble, strPts(2).toDouble), Point(strPts(3).toDouble, strPts(4).toDouble))
      }
    }
    (response(0).charAt(0), out)
  }

}
