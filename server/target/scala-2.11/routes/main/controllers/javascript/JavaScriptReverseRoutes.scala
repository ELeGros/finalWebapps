
// @GENERATOR:play-routes-compiler
// @SOURCE:/users/elegros/task10/server/conf/routes
// @DATE:Sun May 08 16:44:00 CDT 2016

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:17
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
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

  
    // @LINE:8
    def ajax: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.ajax",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax"})
        }
      """
    )
  
    // @LINE:14
    def sendLine: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.sendLine",
      """
        function(c0,x11,y12,x23,y24) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "send/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("c", encodeURIComponent(c0)) + "/" + (""" + implicitly[PathBindable[Double]].javascriptUnbind + """)("x1", x11) + "/" + (""" + implicitly[PathBindable[Double]].javascriptUnbind + """)("y1", y12) + "/" + (""" + implicitly[PathBindable[Double]].javascriptUnbind + """)("x2", x23) + "/" + (""" + implicitly[PathBindable[Double]].javascriptUnbind + """)("y2", y24)})
        }
      """
    )
  
    // @LINE:10
    def poll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.poll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "poll"})
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
  
    // @LINE:12
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
