package Utility

class Operations {

  def hasSubsequence[A](list: List[A], sub: List[A]): Boolean = {
    if (length(list)>=length(sub)){
      (list,sub) match {
        case (Nil,_) => false //empty main list cannot contain a subsequence
        case (_,Nil) => true //empty subsequence is present in any not null list
        case (headMain::_,headSub::Nil) if headMain.equals(headSub) => true
        case (headMain::tailMain,headSub::tailSub) if headMain.equals(headSub) => hasSubsequence(tailMain,tailSub)
        case (headMain::tailMain,headSub::tailSub) if !(headMain.equals(headSub)) => hasSubsequence(tailMain,sub)
      }
    }
    else{
      false
    }
  }

  def length[A](l: List[A]): Int = {
    l.foldRight(0)((_, b) => (b + 1))
  }

  def concateList[A](l1: List[A],l2: List[A]): List[A] = {
    (l1,l2) match {
      case(Nil,Nil) => Nil
      case(Nil,secondList) => secondList
      case(firstList,Nil) => firstList
      case(_,head::Nil) => l1:+head
      case(_,head::tail) => concateList(l1:+head,tail)
    }
  }



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
}

