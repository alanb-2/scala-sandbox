package uk.org.aeb.sandbox.play

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import play.api.libs.json._
import uk.org.aeb.sandbox.play.models.{Address, Person}

class PlayJsonSpec extends AnyFlatSpec with should.Matchers {

  val AddressJson = """{"city":"Los Angeles","postCode":"Unknown","country":"USA","house":"Unknown","region":"California","street":"Unknown"}"""
  val AddressObject: Address = Address(city="Los Angeles", country="USA", house="Unknown", postCode="Unknown", region="California", street="Unknown")
  val AddressAST: JsValue = JsObject(
    Map(
      "house" -> JsString("Unknown"),
      "street" -> JsString("Unknown"),
      "city" -> JsString("Los Angeles"),
      "region" -> JsString("California"),
      "country" -> JsString("USA"),
      "postCode" -> JsString("Unknown")
    )
  )
  val PersonJson = s"""{"firstName":"Tyler","lastName":"Durden","age":45,"address":$AddressJson}"""
  val PersonObject: Person = Person(firstName="Tyler", lastName="Durden", age=45, address=AddressObject)
  val PersonAST: JsValue = JsObject(
    Map(
      "firstName" -> JsString("Tyler"),
      "lastName" -> JsString("Durden"),
      "age" -> JsNumber(45),
      "address" -> AddressAST)
  )

  "Play JSON" should "convert a JSON string to its Abstract Syntax Tree (AST) representation" in {

    Json.parse(PersonJson) shouldBe PersonAST

  }

  it should "convert an AST to a JSON string" in {

    Json.stringify(PersonAST) shouldBe PersonJson

  }

  it should "convert a class instance to an AST" in {

    import Person.personWrites

    Json.toJson(PersonObject) shouldBe PersonAST

  }

  it should "convert an AST to a class instance" in {

    import Person.personReads

    Json.fromJson(PersonAST) shouldBe JsSuccess(PersonObject)

  }

}
