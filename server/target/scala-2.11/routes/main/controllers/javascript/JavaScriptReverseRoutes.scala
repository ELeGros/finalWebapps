
// @GENERATOR:play-routes-compiler
// @SOURCE:/users/elegros/projectFinal/server/conf/routes
// @DATE:Sun May 08 20:46:58 CDT 2016

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:19
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
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
    def sendLine: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.sendLine",
      """
        function(c0,x11,y12,x23,y24) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "send/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("c", encodeURIComponent(c0)) + "/" + (""" + implicitly[PathBindable[Double]].javascriptUnbind + """)("x1", x11) + "/" + (""" + implicitly[PathBindable[Double]].javascriptUnbind + """)("y1", y12) + "/" + (""" + implicitly[PathBindable[Double]].javascriptUnbind + """)("x2", x23) + "/" + (""" + implicitly[PathBindable[Double]].javascriptUnbind + """)("y2", y24)})
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
  
    // @LINE:12
    def movePlayer: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.movePlayer",
      """
        function(playerID0,dir1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "movePlayer/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("playerID", playerID0) + "/" + (""" + implicitly[PathBindable[Char]].javascriptUnbind + """)("dir", dir1)})
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
  
    // @LINE:14
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
