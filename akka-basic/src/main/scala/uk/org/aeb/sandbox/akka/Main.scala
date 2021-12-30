package uk.org.aeb.sandbox.akka

import akka.actor.{Actor, ActorSystem, Props}

class HelloActor extends Actor {

  def receive = {

    case "hello" => println("Hello, world")
    case _       => println("?")

  }

}

object Main extends App {

  val system = ActorSystem("HelloSystem")

  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")

  helloActor ! "hello"
  helloActor ! "hi"

  system.stop(helloActor)
  system.terminate()

}
