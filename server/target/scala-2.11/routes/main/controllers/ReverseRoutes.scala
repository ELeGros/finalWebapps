
// @GENERATOR:play-routes-compiler
// @SOURCE:/users/elegros/projectFinal/server/conf/routes
// @DATE:Sun May 08 20:46:58 CDT 2016

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:19
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
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

  
    // @LINE:10
    def getPlayers(playerID:Int): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getPlayers/" + implicitly[PathBindable[Int]].unbind("playerID", playerID))
    }
  
    // @LINE:16
    def sendLine(c:String, x1:Double, y1:Double, x2:Double, y2:Double): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "send/" + implicitly[PathBindable[String]].unbind("c", dynamicString(c)) + "/" + implicitly[PathBindable[Double]].unbind("x1", x1) + "/" + implicitly[PathBindable[Double]].unbind("y1", y1) + "/" + implicitly[PathBindable[Double]].unbind("x2", x2) + "/" + implicitly[PathBindable[Double]].unbind("y2", y2))
    }
  
    // @LINE:8
    def addPlayer(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "addPlayer")
    }
  
    // @LINE:12
    def movePlayer(playerID:Int, dir:Char): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "movePlayer/" + implicitly[PathBindable[Int]].unbind("playerID", playerID) + "/" + implicitly[PathBindable[Char]].unbind("dir", dir))
    }
  
    // @LINE:6
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix)
    }
  
    // @LINE:14
    def clear(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "clear")
    }
  
  }


}
