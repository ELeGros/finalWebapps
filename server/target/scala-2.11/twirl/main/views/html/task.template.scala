
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

class task extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[play.api.Environment,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(implicit environment: play.api.Environment):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.46*/("""

"""),_display_(/*3.2*/main("Play with Scala.js")/*3.28*/ {_display_(Seq[Any](format.raw/*3.30*/("""
"""),format.raw/*4.1*/("""<h2>Draw Stuff So Well Man</h2>
<ul>
  <li>if mozilla, press r for red, g for green, b for black, and c to clear</li>
</ul>

<canvas id="canvas" width="800" height="800" style="border:1px solid #000000;"></canvas>
<script type="text/javascript">
	example.ScalaJSExample().start();
</script>
""")))}),format.raw/*13.2*/("""
"""))
      }
    }
  }

  def render(environment:play.api.Environment): play.twirl.api.HtmlFormat.Appendable = apply(environment)

  def f:((play.api.Environment) => play.twirl.api.HtmlFormat.Appendable) = (environment) => apply(environment)

  def ref: this.type = this

}


}

/**/
object task extends task_Scope0.task
              /*
                  -- GENERATED --
                  DATE: Sun May 08 17:05:56 CDT 2016
                  SOURCE: /users/elegros/task10/server/app/views/task.scala.html
                  HASH: b958e17edeed6eb4899abbb54c8c8f649be741f1
                  MATRIX: 539->1|678->45|706->48|740->74|779->76|806->77|1128->369
                  LINES: 20->1|25->1|27->3|27->3|27->3|28->4|37->13
                  -- GENERATED --
              */
          