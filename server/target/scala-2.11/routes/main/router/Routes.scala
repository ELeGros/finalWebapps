
// @GENERATOR:play-routes-compiler
// @SOURCE:/users/elegros/task10/server/conf/routes
// @DATE:Sun May 08 16:44:00 CDT 2016

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Application_1: controllers.Application,
  // @LINE:17
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_1: controllers.Application,
    // @LINE:17
    Assets_0: controllers.Assets
  ) = this(errorHandler, Application_1, Assets_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Application.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ajax""", """controllers.Application.ajax"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """poll""", """controllers.Application.poll"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """clear""", """controllers.Application.clear"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """send/""" + "$" + """c<[^/]+>/""" + "$" + """x1<[^/]+>/""" + "$" + """y1<[^/]+>/""" + "$" + """x2<[^/]+>/""" + "$" + """y2<[^/]+>""", """controllers.Application.sendLine(c:String, x1:Double, y1:Double, x2:Double, y2:Double)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Application_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index0_invoker = createInvoker(
    Application_1.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """ Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_Application_ajax1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ajax")))
  )
  private[this] lazy val controllers_Application_ajax1_invoker = createInvoker(
    Application_1.ajax,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "ajax",
      Nil,
      "GET",
      """""",
      this.prefix + """ajax"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Application_poll2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("poll")))
  )
  private[this] lazy val controllers_Application_poll2_invoker = createInvoker(
    Application_1.poll,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "poll",
      Nil,
      "GET",
      """""",
      this.prefix + """poll"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Application_clear3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("clear")))
  )
  private[this] lazy val controllers_Application_clear3_invoker = createInvoker(
    Application_1.clear,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "clear",
      Nil,
      "GET",
      """""",
      this.prefix + """clear"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Application_sendLine4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("send/"), DynamicPart("c", """[^/]+""",true), StaticPart("/"), DynamicPart("x1", """[^/]+""",true), StaticPart("/"), DynamicPart("y1", """[^/]+""",true), StaticPart("/"), DynamicPart("x2", """[^/]+""",true), StaticPart("/"), DynamicPart("y2", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_sendLine4_invoker = createInvoker(
    Application_1.sendLine(fakeValue[String], fakeValue[Double], fakeValue[Double], fakeValue[Double], fakeValue[Double]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "sendLine",
      Seq(classOf[String], classOf[Double], classOf[Double], classOf[Double], classOf[Double]),
      "GET",
      """""",
      this.prefix + """send/""" + "$" + """c<[^/]+>/""" + "$" + """x1<[^/]+>/""" + "$" + """y1<[^/]+>/""" + "$" + """x2<[^/]+>/""" + "$" + """y2<[^/]+>"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_Assets_at5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at5_invoker = createInvoker(
    Assets_0.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(Application_1.index)
      }
  
    // @LINE:8
    case controllers_Application_ajax1_route(params) =>
      call { 
        controllers_Application_ajax1_invoker.call(Application_1.ajax)
      }
  
    // @LINE:10
    case controllers_Application_poll2_route(params) =>
      call { 
        controllers_Application_poll2_invoker.call(Application_1.poll)
      }
  
    // @LINE:12
    case controllers_Application_clear3_route(params) =>
      call { 
        controllers_Application_clear3_invoker.call(Application_1.clear)
      }
  
    // @LINE:14
    case controllers_Application_sendLine4_route(params) =>
      call(params.fromPath[String]("c", None), params.fromPath[Double]("x1", None), params.fromPath[Double]("y1", None), params.fromPath[Double]("x2", None), params.fromPath[Double]("y2", None)) { (c, x1, y1, x2, y2) =>
        controllers_Application_sendLine4_invoker.call(Application_1.sendLine(c, x1, y1, x2, y2))
      }
  
    // @LINE:17
    case controllers_Assets_at5_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at5_invoker.call(Assets_0.at(path, file))
      }
  }
}
