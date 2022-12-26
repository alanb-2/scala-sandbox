package uk.org.aeb.sandbox.akka.state

import akka.actor.{Actor, ActorSystem, Props}
import akka.pattern.gracefulStop

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}
import scala.language.postfixOps

case object Calm
case object Frustrated
case object Angry

class DrBruceBanner extends Actor {

  def angryState: Receive = { case Calm =>
    println("Betty...")
    context.become(normalState)
  }

  def normalState: Receive = {
    case Frustrated => println("You wouldn't like me when I'm angry")
    case Angry      =>
      println("HULKKK SMAAASH!")
      context.become(angryState)
  }

  def receive = {
    case Angry => context.become(angryState)
    case Calm  => context.become(normalState)
  }

}

object Main extends App {

  val system = ActorSystem("IncredibleHulk")
  val drBruceBanner = system.actorOf(Props[DrBruceBanner](), name = "DrBruceBanner")

  drBruceBanner ! Calm
  drBruceBanner ! Frustrated
  drBruceBanner ! Angry

  Thread.sleep(1000)

  drBruceBanner ! Calm

  try {
    val stopped: Future[Boolean] = gracefulStop(drBruceBanner, 2 seconds)
    Await.result(stopped, 3 seconds)
  } catch {
    case e: Exception => e.printStackTrace()
  } finally system.terminate()

}
