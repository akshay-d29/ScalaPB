import addressbook.{AddressBook, Person}
import addressbook.Person.{PhoneNumber, PhoneType}
import helloworld.GreeterGrpc.Greeter
import helloworld.{HelloReply, HelloRequest}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object GG extends App {
  val person = Person("gg", 1, "gg@gmail.com", List(PhoneNumber("99", PhoneType.HOME)))

  val addressBook = AddressBook(List(person))

  println(addressBook)

  private val greeter: Greeter = new Greeter {
    /** Sends a greeting
     */
    override def sayHello(request: HelloRequest): Future[HelloReply] = Future(HelloReply(s"hello ${request.name}"))

    /** Sends another greeting
     */
    override def sayHelloAgain(request: HelloRequest): Future[HelloReply] = Future(HelloReply(s"hello ${request.name}"))
  }

  greeter.sayHello(HelloRequest("gg")).foreach(println)
}
