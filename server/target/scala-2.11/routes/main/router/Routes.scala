
// @GENERATOR:play-routes-compiler
// @SOURCE:/users/elegros/projectFinal/server/conf/routes
// @DATE:Sun May 08 20:46:58 CDT 2016

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
  // @LINE:19
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_1: controllers.Application,
    // @LINE:19
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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addPlayer""", """controllers.Application.addPlayer"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getPlayers/""" + "$" + """playerID<[^/]+>""", """controllers.Application.getPlayers(playerID:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """movePlayer/""" + "$" + """playerID<[^/]+>/""" + "$" + """dir<[^/]+>""", """controllers.Application.movePlayer(playerID:Int, dir:Char)"""),
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
  private[this] lazy val controllers_Application_addPlayer1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addPlayer")))
  )
  private[this] lazy val controllers_Application_addPlayer1_invoker = createInvoker(
    Application_1.addPlayer,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "addPlayer",
      Nil,
      "GET",
      """""",
      this.prefix + """addPlayer"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Application_getPlayers2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getPlayers/"), DynamicPart("playerID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPlayers2_invoker = createInvoker(
    Application_1.getPlayers(fakeValue[Int]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getPlayers",
      Seq(classOf[Int]),
      "GET",
      """""",
      this.prefix + """getPlayers/""" + "$" + """playerID<[^/]+>"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Application_movePlayer3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("movePlayer/"), DynamicPart("playerID", """[^/]+""",true), StaticPart("/"), DynamicPart("dir", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_movePlayer3_invoker = createInvoker(
    Application_1.movePlayer(fakeValue[Int], fakeValue[Char]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "movePlayer",
      Seq(classOf[Int], classOf[Char]),
      "GET",
      """""",
      this.prefix + """movePlayer/""" + "$" + """playerID<[^/]+>/""" + "$" + """dir<[^/]+>"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Application_clear4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("clear")))
  )
  private[this] lazy val controllers_Application_clear4_invoker = createInvoker(
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

  // @LINE:16
  private[this] lazy val controllers_Application_sendLine5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("send/"), DynamicPart("c", """[^/]+""",true), StaticPart("/"), DynamicPart("x1", """[^/]+""",true), StaticPart("/"), DynamicPart("y1", """[^/]+""",true), StaticPart("/"), DynamicPart("x2", """[^/]+""",true), StaticPart("/"), DynamicPart("y2", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_sendLine5_invoker = createInvoker(
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

  // @LINE:19
  private[this] lazy val controllers_Assets_at6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at6_invoker = createInvoker(
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
    case controllers_Application_addPlayer1_route(params) =>
      call { 
        controllers_Application_addPlayer1_invoker.call(Application_1.addPlayer)
      }
  
    // @LINE:10
    case controllers_Application_getPlayers2_route(params) =>
      call(params.fromPath[Int]("playerID", None)) { (playerID) =>
        controllers_Application_getPlayers2_invoker.call(Application_1.getPlayers(playerID))
      }
  
    // @LINE:12
    case controllers_Application_movePlayer3_route(params) =>
      call(params.fromPath[Int]("playerID", None), params.fromPath[Char]("dir", None)) { (playerID, dir) =>
        controllers_Application_movePlayer3_invoker.call(Application_1.movePlayer(playerID, dir))
      }
  
    // @LINE:14
    case controllers_Application_clear4_route(params) =>
      call { 
        controllers_Application_clear4_invoker.call(Application_1.clear)
      }
  
    // @LINE:16
    case controllers_Application_sendLine5_route(params) =>
      call(params.fromPath[String]("c", None), params.fromPath[Double]("x1", None), params.fromPath[Double]("y1", None), params.fromPath[Double]("x2", None), params.fromPath[Double]("y2", None)) { (c, x1, y1, x2, y2) =>
        controllers_Application_sendLine5_invoker.call(Application_1.sendLine(c, x1, y1, x2, y2))
      }
  
    // @LINE:19
    case controllers_Assets_at6_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at6_invoker.call(Assets_0.at(path, file))
      }
  }
}
