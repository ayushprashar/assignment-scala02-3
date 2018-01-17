import Utility.Operations
import org.apache.log4j.Logger

object Application extends App {
  val perform = new Operations
  val log = Logger.getLogger(this.getClass)
  val lengthInputListElement1 = "Ayush"
  val lengthInputListElement2 = 4
  val lengthInputListElement3 = Nil
  val lengthInputListElement4 = 1
  val lengthInputListElement5 = 9
  val lengthInputList = List(lengthInputListElement1,lengthInputListElement2,
    lengthInputListElement3,lengthInputListElement4,lengthInputListElement5)

  log.info(s"Length of the input list ${lengthInputList} is ${perform.length(lengthInputList)}")
}
