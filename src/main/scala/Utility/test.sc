def splitList[A](l:List[A],f:A=>Boolean): (List[A],List[A]) = {
  val passList: List[A] = List()
  val failList: List[A] = List()
  def splitter(originalList: List[A],trueList: List[A],falseList: List[A]): (List[A],List[A]) = {
    originalList match {
      case Nil => (trueList,falseList)
      case head::Nil if f(head) => (trueList:+ head,falseList)
      case head::Nil if !(f(head)) => (trueList,falseList:+ head)
      case head::tail if f(head) => splitter(tail,trueList:+ head,falseList)
      case head::tail if !(f(head)) => splitter(tail,trueList,falseList:+ head)
    }
  }
  splitter(l,passList,failList)
}
splitList(List(1,"Hi",Nil,6),(input: A)=> input.isInstanceOf[Int])