package uk.org.aeb.sandbox.akka.basic

import akka.actor.{Actor, ActorSystem, Props}

class HelloActor(name: String) extends Actor {

  def receive = {

    case "hello" => println(s"$name: Hello, world")
    case _       => println(s"$name: ?")

  }

}

object Main extends App {

  val system = ActorSystem("HelloSystem")

  val helloActor = system.actorOf(Props(new HelloActor("Dave")), name = "helloactor")

  helloActor ! "hello"
  helloActor ! "hi"

  Thread.sleep(1000)

  system.stop(helloActor)
  system.terminate

}
