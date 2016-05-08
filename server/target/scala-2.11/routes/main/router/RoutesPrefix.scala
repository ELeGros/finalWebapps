
// @GENERATOR:play-routes-compiler
// @SOURCE:/users/elegros/task10/server/conf/routes
// @DATE:Sun May 08 16:44:00 CDT 2016


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
