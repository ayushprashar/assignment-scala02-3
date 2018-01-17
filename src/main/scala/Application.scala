import Utility.Operations
import org.apache.log4j.Logger

object Application extends App {
  val perform = new Operations
  val log = Logger.getLogger(this.getClass)
  val lengthInputListElement1 = 8
  val lengthInputListElement2 = 4
  val lengthInputListElement3 = 90
  val lengthInputListElement4 = 1
  val lengthInputListElement5 = 9
  val lengthInputList = List(lengthInputListElement1,lengthInputListElement2,
    lengthInputListElement3,lengthInputListElement4,lengthInputListElement5)
  val itemHolders = lengthInputList
  val subsequence = List(lengthInputListElement4,lengthInputListElement5)
  val concat1 = 21
  val concat2 = 44
  val concat3 = 51
  val concatinators = List(concat1,concat2,concat3)
  val splitList = lengthInputList
  log.info(s"Length of the input list $lengthInputList is ${perform.length[Int](lengthInputList)}\n")
  log.info(s"The list $subsequence is a subsequence in $itemHolders : ${perform.hasSubsequence[Int](itemHolders,subsequence)} \n")
  log.info(s"The concatination of $subsequence & $concatinators is ${perform.concateList[Int](subsequence, concatinators)}\n")
  log.info(s"Splitting $splitList as odd and even gives ${perform.splitList[Int](splitList, (x) => x % 2 == 0)}")
}
