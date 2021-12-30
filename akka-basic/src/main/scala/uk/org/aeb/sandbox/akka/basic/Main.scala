package uk.org.aeb.sandbox.akka.basic

import akka.actor.{Actor, ActorSystem, Props}
import akka.pattern.gracefulStop

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

class HelloActor(name: String) extends Actor {

  def receive = {

    case "hello" => println(s"$name: Hello, world")
    case _       => println(s"$name: ?")

  }

  override def postStop() = {
    println("HelloActor: postStop")
  }

}

object Main extends App {

  val system = ActorSystem("HelloSystem")

  val helloActor = system.actorOf(Props(new HelloActor("Dave")), name = "helloactor")

  helloActor ! "hello"
  helloActor ! "hi"

  try {
    val stopped: Future[Boolean] = gracefulStop(helloActor, 2 seconds)
    Await.result(stopped, 3 seconds)
    println("HelloActor was stopped")
  } catch {
    case e: Exception => e.printStackTrace()
  } finally {
    system.terminate
  }

}
