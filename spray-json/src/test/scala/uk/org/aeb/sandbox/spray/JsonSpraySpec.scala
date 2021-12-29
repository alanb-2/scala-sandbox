package uk.org.aeb.sandbox.spray

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import spray.json._
import uk.org.aeb.sandbox.spray.models.{Address, Person}

class JsonSpraySpec extends AnyFlatSpec with should.Matchers {

  val AddressJson = """{"city":"Los Angeles","country":"USA","house":"Unknown","postCode":"Unknown","region":"California","street":"Unknown"}"""
  val AddressObject: Address = Address(city="Los Angeles", country="USA", house="Unknown", postCode="Unknown", region="California", street="Unknown")
  val AddressAST: JsValue = JsObject(
    "house" -> JsString("Unknown"),
    "street" -> JsString("Unknown"),
    "city" -> JsString("Los Angeles"),
    "region" -> JsString("California"),
    "country" -> JsString("USA"),
    "postCode" -> JsString("Unknown")
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

  "Json Spray" should "convert a JSON string to its Abstract Syntax Tree (AST) representation" in {

    PersonJson.parseJson shouldBe PersonAST

  }

  it should "convert an AST to a JSON string" in {

    PersonAST.toString shouldBe PersonJson

  }

  it should "convert a class instance to an AST" in {

    PersonObject.toJson shouldBe PersonAST

  }

  it should "convert an AST to a class instance" in {

    PersonAST.convertTo[Person] shouldBe PersonObject

  }

}
