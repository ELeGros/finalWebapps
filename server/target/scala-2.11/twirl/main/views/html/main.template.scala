
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,Html,play.api.Environment,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html)(implicit environment: play.api.Environment):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.76*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
  <head>
    <title>"""),_display_(/*7.13*/title),format.raw/*7.18*/("""</title>
    <link rel="stylesheet" media="screen" href=""""),_display_(/*8.50*/routes/*8.56*/.Assets.at("stylesheets/main.css")),format.raw/*8.90*/("""">
    <link rel="shortcut icon" type="image/png" href=""""),_display_(/*9.55*/routes/*9.61*/.Assets.at("images/favicon.png")),format.raw/*9.93*/("""">
    <script src=""""),_display_(/*10.19*/routes/*10.25*/.Assets.at("lib/jquery/jquery.min.js")),format.raw/*10.63*/("""" type="text/javascript"></script>
  </head>
  <body>
   """),_display_(/*13.5*/content),format.raw/*13.12*/("""
   """),_display_(/*14.5*/playscalajs/*14.16*/.html.scripts("client")),format.raw/*14.39*/("""
  """),format.raw/*15.3*/("""</body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html,environment:play.api.Environment): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)(environment)

  def f:((String) => (Html) => (play.api.Environment) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => (environment) => apply(title)(content)(environment)

  def ref: this.type = this

}


}

/**/
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Tue Apr 26 11:59:33 CDT 2016
                  SOURCE: /users/mlewis/Local/HTML-Documents/CSCI3345-S16/play-with-scalajs-example/server/app/views/main.scala.html
                  HASH: 1801b4a5381a6a7c62b5337000cdbb91aa01810f
                  MATRIX: 551->1|720->75|748->77|819->122|844->127|928->185|942->191|996->225|1079->282|1093->288|1145->320|1193->341|1208->347|1267->385|1351->443|1379->450|1410->455|1430->466|1474->489|1504->492
                  LINES: 20->1|25->1|27->3|31->7|31->7|32->8|32->8|32->8|33->9|33->9|33->9|34->10|34->10|34->10|37->13|37->13|38->14|38->14|38->14|39->15
                  -- GENERATED --
              */
          