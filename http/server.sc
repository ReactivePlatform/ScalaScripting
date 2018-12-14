import $ivy.`net.freeutils:jlhttp:2.4`

@doc("SimpleHTTPServer for Scala Scripting")
@main
def main(
  dir: String,
  port: Int = 80
): Unit = {
  net.freeutils.httpserver.HTTPServer.main(Array(dir, port.toString))
  println(s"I'm serving `${dir}`")
  println("Press ENTER to quit!")
  scala.io.StdIn.readLine()
}
