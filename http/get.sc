// --> https://index.scala-lang.org/lihaoyi/requests-scala
import $ivy.`com.lihaoyi::requests:0.1.6`

// $ curl -v "http://httpbin.org/get" 
val r = requests.get("http://httpbin.org/get")

def dump(r: requests.Response): Unit = {
  println("---------------------------------------------------")
  println(s"< ${r.statusCode} ${r.statusMessage}")
  r.headers
   .map { case (key, value) => s"< ${key}: ${value.mkString}" }
   .foreach(println)
  println("---------------------------------------------------")
}


// $ curl -X GET "http://httpbin.org/headers" -H  "user-agent: dada's demo"
// # REPL-friendly coding style
requests.get(
  "http://httpbin.org/headers",
  headers = Map("user-agent" -> "data's demo")
).text


// $ curl -X GET "http://httpbin.org/drip?duration=2&numbytes=10"
requests.get(
  "http://httpbin.org/drip",
  params = Map("duration" -> "2", "numbytes" -> "10")
).text


// curl -v -L http://github.com/ReactivePlatform/ScalaScripting.git -o /dev/null
val git = requests.get("http://github.com/ReactivePlatform/ScalaScripting.git")
def dumpHistory(git: requests.Response, level: Int): Unit = {
  git.history.foreach { h =>
    dumpHistory(h, level + 1)
  }
  println(s"${level}:")
  dump(git)
}
dumpHistory(git, 1)
