package models

class Line(val c:String, val x1:Double, val y1:Double, val x2:Double, val y2:Double) {
    
}

object Line{
    private var _line = List[Line]()
    private var _status = 'a'
    _line = _line :+ new Line("black",1.0,1.0,2.0,2.0)
    def poll:String = synchronized {
      var out = ""
      out += _status
      out += '$'
      _line.foreach { x =>out +=x.c + " " + x.x1 + " " + x.y1 + " " + x.x2 + " " + x.y2 + "|"}
      out = out.substring(0, out.length - 1)
      out
    }
    
    def addLine(c:String, x1:Double, y1:Double, x2:Double, y2:Double):Unit = {
      _line = _line :+ new Line(c,x1,y1,x2,y2)
    }
    
    def clear:Unit = {
      if(_status == 'a') {_status = 'b'}
      else if(_status == 'b') {_status = 'a'}
      _line = List[Line]()
      _line = _line :+ new Line("black",1.0,1.0,2.0,2.0)
    }
}