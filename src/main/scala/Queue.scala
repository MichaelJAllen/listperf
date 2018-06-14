case class Node[T](data: T, var next: Node[T])

class StackList[T] {

  private var top: Node[T] = _

  // Make public so that it can be accessed from QueueStackDq[T].
  var total: Int = 0

  def push(item: T): Unit = {
    val o = top
    val n = Node(item, o)
    total = total + 1
    top = n
  }
}

trait Queue[T] {
  def enqueue(item: T): Unit
}

class QueueStackDq[T] extends Queue[T] {

  val in = new StackList[T]

  // Commented out as not used.
  //val out = new StackList[T]

  // Replaced with call to total in StackList.
  private def total = in.total

  /**
    * Add an element to the queue's tail
    */
  override def enqueue(item: T): Unit = {
    // Redundant total update removed.
    //total = total + 1
    in.push(item)
  }
}



class QueueList[T] extends Queue[T] {

  private var tail: Node[T] = _

  private var head: Node[T] = _

  private var total: Int = 0


  /**
    * Add an element to the queue's tail
    */
  override def enqueue(item: T): Unit = {
    val n = Node(item, null) // Create new node
    // If nothing in list, head and tail are the same.
    if (total == 0) {
      head = n
      tail = n
    }

    // Otherwise, current tail points to this and update tail.
    else {
      tail.next = n
      tail = n
    }

    // Increment total.
    total += 1
  }
}
