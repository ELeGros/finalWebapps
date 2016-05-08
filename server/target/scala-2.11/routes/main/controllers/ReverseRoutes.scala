
// @GENERATOR:play-routes-compiler
// @SOURCE:/users/elegros/task10/server/conf/routes
// @DATE:Sun May 08 16:44:00 CDT 2016

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:17
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def at(file:String): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def ajax(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "ajax")
    }
  
    // @LINE:14
    def sendLine(c:String, x1:Double, y1:Double, x2:Double, y2:Double): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "send/" + implicitly[PathBindable[String]].unbind("c", dynamicString(c)) + "/" + implicitly[PathBindable[Double]].unbind("x1", x1) + "/" + implicitly[PathBindable[Double]].unbind("y1", y1) + "/" + implicitly[PathBindable[Double]].unbind("x2", x2) + "/" + implicitly[PathBindable[Double]].unbind("y2", y2))
    }
  
    // @LINE:10
    def poll(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "poll")
    }
  
    // @LINE:6
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix)
    }
  
    // @LINE:12
    def clear(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "clear")
    }
  
  }


}
