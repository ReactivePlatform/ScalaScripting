import $ivy.`com.lihaoyi::requests:0.1.6`
import $ivy.`org.json4s::json4s-jackson:3.6.5`

import org.json4s._
import org.json4s.jackson.Serialization
import org.json4s.jackson.Serialization.{read, write}

case class Headers(Accept: String, Host: String, `User-Agent`: String)
case class Body(headers: Headers, origin: String, url: String)

val r = requests.get("http://httpbin.org/get")
read[Body](r.text)
