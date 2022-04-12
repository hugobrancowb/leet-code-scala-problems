package problems

import scala.collection.mutable.HashMap

/** Link to problem https://leetcode.com/problems/top-k-frequent-elements */
object TopKFrequent {
  def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {
    var frequencies = HashMap[Int, Int]()

    for (n <- nums) {
      var v: Int = frequencies.getOrElse(n, 0)
      frequencies += n -> (v + 1)
    }

    frequencies.toArray
      .sortWith(_._2 > _._2)
      .map(t => t._1)
      .slice(0, k)
  }
}

// HashMap, sort e getOrElse
