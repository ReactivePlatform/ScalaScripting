// --> https://index.scala-lang.org/lihaoyi/requests-scala
import $ivy.`com.lihaoyi::requests:0.1.6`

// $ curl -v "http://httpbin.org/get" 
val r = requests.get("http://httpbin.org/get")

s"< ${r.statusCode} ${r.statusMessage}"

r.headers.map { case (key, value) => s"< ${key}: ${value.mkString}" }.mkString("\n")


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
