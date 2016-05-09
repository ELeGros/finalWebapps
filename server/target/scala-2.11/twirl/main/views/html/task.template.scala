
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object task_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class task extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Seq[Lobby],Seq[Lobby],play.api.Environment,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(lobbylist: Seq[Lobby], gamelist: Seq[Lobby])(implicit environment: play.api.Environment):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import play.api.Play.current
import play.api.i18n.Messages.Implicits._

Seq[Any](format.raw/*1.91*/("""

"""),format.raw/*5.1*/("""
"""),_display_(/*6.2*/main("Play with Scala.js")/*6.28*/ {_display_(Seq[Any](format.raw/*6.30*/("""
"""),format.raw/*7.1*/("""<h2>Draw Stuff So Well Man</h2>
<ul>
  <li>if mozilla, press r for red, g for green, b for black, and c to clear</li>
</ul>

<table id="ingame">
	"""),_display_(/*13.3*/for(player <- gamelist) yield /*13.26*/ {_display_(Seq[Any](format.raw/*13.28*/("""
		"""),format.raw/*14.3*/("""<tr>
		<td>please</td>
		<td>"""),_display_(/*16.8*/player/*16.14*/.user),format.raw/*16.19*/("""</td>
		</tr>
	""")))}),format.raw/*18.3*/("""
"""),format.raw/*19.1*/("""</table>

<canvas id="canvas" width="800" height="800" style="border:1px solid #000000;"></canvas>
<script type="text/javascript">
	example.ScalaJSExample().start();
</script>

<table id="lobby">
	"""),_display_(/*27.3*/for(player <- lobbylist) yield /*27.27*/ {_display_(Seq[Any](format.raw/*27.29*/("""
		"""),format.raw/*28.3*/("""<tr>
		<td>please</td>
		<td>"""),_display_(/*30.8*/player/*30.14*/.user),format.raw/*30.19*/("""</td>
		</tr>
	""")))}),format.raw/*32.3*/("""
"""),format.raw/*33.1*/("""</table>
""")))}))
      }
    }
  }

  def render(lobbylist:Seq[Lobby],gamelist:Seq[Lobby],environment:play.api.Environment): play.twirl.api.HtmlFormat.Appendable = apply(lobbylist,gamelist)(environment)

  def f:((Seq[Lobby],Seq[Lobby]) => (play.api.Environment) => play.twirl.api.HtmlFormat.Appendable) = (lobbylist,gamelist) => (environment) => apply(lobbylist,gamelist)(environment)

  def ref: this.type = this

}


}

/**/
object task extends task_Scope0.task
              /*
                  -- GENERATED --
                  DATE: Mon May 09 18:00:05 CDT 2016
                  SOURCE: /users/elegros/projectFinal/server/app/views/task.scala.html
                  HASH: 1c14a489d79090238b7f66100a6ee586b4fcaa5d
                  MATRIX: 561->1|815->90|843->165|870->167|904->193|943->195|970->196|1143->343|1182->366|1222->368|1252->371|1308->401|1323->407|1349->412|1395->428|1423->429|1647->627|1687->651|1727->653|1757->656|1813->686|1828->692|1854->697|1900->713|1928->714
                  LINES: 20->1|26->1|28->5|29->6|29->6|29->6|30->7|36->13|36->13|36->13|37->14|39->16|39->16|39->16|41->18|42->19|50->27|50->27|50->27|51->28|53->30|53->30|53->30|55->32|56->33
                  -- GENERATED --
              */
          