package uk.org.aeb.sandbox.play.models

import play.api.libs.json.{Json, Reads, Writes}

case class Address(house: String,
                   street: String,
                   city: String,
                   region: String,
                   country: String,
                   postCode: String
)

object Address {

  implicit val addressReads: Reads[Address] = Json.reads[Address]
  implicit val addressWrites: Writes[Address] = Json.writes[Address]

}

case class Person(firstName: String,
                  lastName: String,
                  age: Int,
                  address: Address,
                  height: Option[Double] = None
)

object Person {

  implicit val personReads: Reads[Person] = Json.reads[Person]
  implicit val personWrites: Writes[Person] = Json.writes[Person]

}
