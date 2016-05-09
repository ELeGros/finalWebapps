
// @GENERATOR:play-routes-compiler
// @SOURCE:/users/elegros/projectFinal/server/conf/routes
// @DATE:Mon May 09 18:00:04 CDT 2016

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:29
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def startServer: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.startServer",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "startServer"})
        }
      """
    )
  
    // @LINE:12
    def movePlayer: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.movePlayer",
      """
        function(playerID0,dir1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "movePlayer/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("playerID", playerID0) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("dir", encodeURIComponent(dir1))})
        }
      """
    )
  
    // @LINE:10
    def getPlayers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getPlayers",
      """
        function(playerID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getPlayers/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("playerID", playerID0)})
        }
      """
    )
  
    // @LINE:16
    def getBullets: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getBullets",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getBullets"})
        }
      """
    )
  
    // @LINE:35
    def createUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.createUser",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "createUser"})
        }
      """
    )
  
    // @LINE:20
    def inGamePoll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.inGamePoll",
      """
        function(playerID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "inGamePoll/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("playerID", playerID0)})
        }
      """
    )
  
    // @LINE:26
    def sendLine: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.sendLine",
      """
        function(c0,x11,y12,x23,y24) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "send/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("c", encodeURIComponent(c0)) + "/" + (""" + implicitly[PathBindable[Double]].javascriptUnbind + """)("x1", x11) + "/" + (""" + implicitly[PathBindable[Double]].javascriptUnbind + """)("y1", y12) + "/" + (""" + implicitly[PathBindable[Double]].javascriptUnbind + """)("x2", x23) + "/" + (""" + implicitly[PathBindable[Double]].javascriptUnbind + """)("y2", y24)})
        }
      """
    )
  
    // @LINE:33
    def ingame: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.ingame",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ingame"})
        }
      """
    )
  
    // @LINE:18
    def getWalls: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getWalls",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getWalls"})
        }
      """
    )
  
    // @LINE:32
    def lobby: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.lobby",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "lobby"})
        }
      """
    )
  
    // @LINE:8
    def addPlayer: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.addPlayer",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "addPlayer"})
        }
      """
    )
  
    // @LINE:14
    def addBullet: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.addBullet",
      """
        function(playerID0,x1,y2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "addBullet/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("playerID", playerID0) + "/" + (""" + implicitly[PathBindable[Double]].javascriptUnbind + """)("x", x1) + "/" + (""" + implicitly[PathBindable[Double]].javascriptUnbind + """)("y", y2)})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:34
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.login",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
    // @LINE:24
    def clear: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.clear",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "clear"})
        }
      """
    )
  
  }


}
