import org.scalameter.api._
import org.scalameter.picklers.noPickler._
import scala.annotation.tailrec

object RangeBenchmark
extends Bench.ForkedTime {

  val MinValue = 0
  val MaxValue = 1000000

  // Unit generator, does nothing. (ScalaMeter doesn't make it easy to have no arguments!)
  val unit = Gen.single("list")(())

  // Queue stack benchmark. Create queue stack and add necessary elements to the queue.
  // Note: Benchmark unavoidably includes overhead of looping through values (but same both classes).
  performance of "QueueStackDq[Int[" in {
    measure method "enqueue(Int)" in {
      using(unit) in {_ =>
        val q = new QueueStackDq[Int]()
        // Tail recursive helper function, optimized into a loop.
        @tailrec
        def loop(i: Int): Unit = {
          if(i < MaxValue) {
            q.enqueue(i)
            loop(i + 1)
          }
        }
        loop(MinValue)
      }
    }
  }

  // Queue list benchmark. Create queue stack and add necessary elements to the queue.
  // Note: Benchmark unavoidably includes overhead of looping through values (but same both classes).
  performance of "QueueList[Int[" in {
    measure method "enqueue(Int)" in {
      using(unit) in {_ =>
        val q = new QueueList[Int]()
        // Tail recursive helper function, optimized into a loop.
        @tailrec
        def loop(i: Int): Unit = {
          if(i < MaxValue) {
            q.enqueue(i)
            loop(i + 1)
          }
        }
        loop(MinValue)
      }
    }
  }
}
