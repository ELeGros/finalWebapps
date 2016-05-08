
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,play.api.Environment,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String)(implicit environment: play.api.Environment):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.63*/("""

"""),_display_(/*3.2*/main("Play with Scala.js")/*3.28*/ {_display_(Seq[Any](format.raw/*3.30*/("""
"""),format.raw/*4.1*/("""<h2>Play and Scala.js share a same message</h2>
<ul>
  <li>Play shouts out: <em>"""),_display_(/*6.29*/message),format.raw/*6.36*/("""</em></li>
  <li>Scala.js shouts out: <em id="scalajsShoutOut"></em></li>
</ul>
""")))}),format.raw/*9.2*/("""
"""))
      }
    }
  }

  def render(message:String,environment:play.api.Environment): play.twirl.api.HtmlFormat.Appendable = apply(message)(environment)

  def f:((String) => (play.api.Environment) => play.twirl.api.HtmlFormat.Appendable) = (message) => (environment) => apply(message)(environment)

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Tue Apr 26 11:59:33 CDT 2016
                  SOURCE: /users/mlewis/Local/HTML-Documents/CSCI3345-S16/play-with-scalajs-example/server/app/views/index.scala.html
                  HASH: d884ecfe866fdb2e11accc5b4820ae6ca8020f4e
                  MATRIX: 548->1|704->62|732->65|766->91|805->93|832->94|939->175|966->182|1076->263
                  LINES: 20->1|25->1|27->3|27->3|27->3|28->4|30->6|30->6|33->9
                  -- GENERATED --
              */
          