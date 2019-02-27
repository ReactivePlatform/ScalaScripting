import $ivy.`org.json4s::json4s-jackson:3.6.5`

import org.json4s._
import org.json4s.jackson.Serialization
import org.json4s.jackson.Serialization.{read, write}

implicit val formats = Serialization.formats(NoTypeHints)

case class Person(firstName: String)
write(Person("joe"))

read[Person](""" {"firstName": "joe"} """)

case class Status(code: Int, error: String)
read[Status](""" {"code": 0, "error": null} """)
