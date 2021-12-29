package uk.org.aeb.sandbox.spray.models

import spray.json._

case class Address(house: String,
                   street: String,
                   city: String,
                   region: String,
                   country: String,
                   postCode: String
)

object Address extends DefaultJsonProtocol {

  implicit val addressFormat: RootJsonFormat[Address] = jsonFormat6(Address.apply)

}

case class Person(firstName: String,
                  lastName: String,
                  age: Int,
                  address: Address,
                  height: Option[Double] = None
)

object Person extends DefaultJsonProtocol {

  implicit val personFormat: RootJsonFormat[Person] = jsonFormat5(Person.apply)

}
