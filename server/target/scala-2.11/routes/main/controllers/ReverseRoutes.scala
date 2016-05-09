
// @GENERATOR:play-routes-compiler
// @SOURCE:/users/elegros/projectFinal/server/conf/routes
// @DATE:Mon May 09 18:00:04 CDT 2016

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:29
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
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

  
    // @LINE:22
    def startServer(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "startServer")
    }
  
    // @LINE:12
    def movePlayer(playerID:Int, dir:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "movePlayer/" + implicitly[PathBindable[Int]].unbind("playerID", playerID) + "/" + implicitly[PathBindable[String]].unbind("dir", dynamicString(dir)))
    }
  
    // @LINE:10
    def getPlayers(playerID:Int): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getPlayers/" + implicitly[PathBindable[Int]].unbind("playerID", playerID))
    }
  
    // @LINE:16
    def getBullets(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getBullets")
    }
  
    // @LINE:35
    def createUser(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "createUser")
    }
  
    // @LINE:20
    def inGamePoll(playerID:Int): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "inGamePoll/" + implicitly[PathBindable[Int]].unbind("playerID", playerID))
    }
  
    // @LINE:26
    def sendLine(c:String, x1:Double, y1:Double, x2:Double, y2:Double): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "send/" + implicitly[PathBindable[String]].unbind("c", dynamicString(c)) + "/" + implicitly[PathBindable[Double]].unbind("x1", x1) + "/" + implicitly[PathBindable[Double]].unbind("y1", y1) + "/" + implicitly[PathBindable[Double]].unbind("x2", x2) + "/" + implicitly[PathBindable[Double]].unbind("y2", y2))
    }
  
    // @LINE:33
    def ingame(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "ingame")
    }
  
    // @LINE:18
    def getWalls(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getWalls")
    }
  
    // @LINE:32
    def lobby(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "lobby")
    }
  
    // @LINE:8
    def addPlayer(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "addPlayer")
    }
  
    // @LINE:14
    def addBullet(playerID:Int, x:Double, y:Double): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "addBullet/" + implicitly[PathBindable[Int]].unbind("playerID", playerID) + "/" + implicitly[PathBindable[Double]].unbind("x", x) + "/" + implicitly[PathBindable[Double]].unbind("y", y))
    }
  
    // @LINE:6
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix)
    }
  
    // @LINE:34
    def login(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "login")
    }
  
    // @LINE:24
    def clear(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "clear")
    }
  
  }


}
