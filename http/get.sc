// --> https://index.scala-lang.org/lihaoyi/requests-scala
import $ivy.`com.lihaoyi::requests:0.1.6`

// $ curl -v "http://httpbin.org/get" 
val r = requests.get("http://httpbin.org/get")

s"< ${r.statusCode} ${r.statusMessage}"

r.headers.map { case (key, value) => s"< ${key}: ${value.mkString}" }.mkString("\n")
