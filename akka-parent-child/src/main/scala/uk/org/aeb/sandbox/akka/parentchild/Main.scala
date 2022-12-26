package uk.org.aeb.sandbox.akka.parentchild

import akka.actor.{Actor, ActorSystem, PoisonPill, Props}

case class CreateChild(name: String)
case class Name(name: String)

class Child extends Actor {

  var name = "No name"

  override def postStop(): Unit = println(s"D'oh!  They killed me ($name): ${self.path}")

  def receive = {
    case Name(name) => this.name = name
    case _          => println(s"Child $name received message")
  }

}

class Parent extends Actor {

  def receive = {
    case CreateChild(name) =>
      println(s"Parent about to create child $name...")
      val child = context.actorOf(Props[Child](), name = s"$name")
      child ! Name(name)
    case _                 => println(s"Parent received some other message.")
  }

}

object Main extends App {

  val system = ActorSystem("ParentChild")
  val parent = system.actorOf(Props[Parent](), name = "Parent")

  parent ! CreateChild("Adam")
  parent ! CreateChild("Barbara")
  Thread.sleep(1000)

  println("Sending Adam a PoisonPill ...")
  val adam = system.actorSelection("/user/Parent/Adam")
  adam ! PoisonPill
  println("Adam was killed")

  Thread.sleep(5000)
  system.terminate()

}
