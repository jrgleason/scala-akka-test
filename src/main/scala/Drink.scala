import akka.actor._
import akka.event.Logging
 
class DrinkActor extends Actor {
  val log = Logging(context.system, this)
  def receive = {
    case "tea" => log.info("Tea time!")
    case "coffee" => log.info("Coffee time!")
    case _ => log.info("Hmmm...")
  }
}
object MyApp extends App {
  val system = ActorSystem("MyActorSystem")
  val drinkActor = system.actorOf(Props[DrinkActor], name = "drink")
  drinkActor ! "tea"
  drinkActor ! "beer"
  system.terminate()
}
