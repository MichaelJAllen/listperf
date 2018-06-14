case class Node[T](data: T, var next: Node[T])

class StackList[T] {

  private var top: Node[T] = _

  private var total: Int = 0

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

  val out = new StackList[T]

  private var total: Int = 0

  /**
    * Add an element to the queue's tail
    */
  override def enqueue(item: T): Unit = {
    total = total + 1
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
    if (total == 0) {
      head = n
      tail = n
    }
    total += 1
    tail.next = n
    tail = n
  }
}
