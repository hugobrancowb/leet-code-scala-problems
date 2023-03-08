package problems
import scala.util.control.Breaks.{break, breakable}

/** Link to problem https://leetcode.com/problems/koko-eating-bananas */
object MinEatingSpeed {
  def minEatingSpeed(piles: Array[Int], h: Int): Int = {
    var kMin = 1
    var kMax = piles.max

    while (kMax > kMin) {
      val kMid         = Math.ceil((kMin + kMax) / 2).toInt
      val isEnoughTime = hasTimeToEatPilesOfBananas(piles, h, kMid)

      if (isEnoughTime) kMax = kMid
      else kMin = kMid + 1
    }

    kMin
  }

  private def hasTimeToEatPilesOfBananas(piles: Array[Int], h: Int, k: Int): Boolean = {
    var hoursNeeded = 0

    for (pile <- piles) {
      hoursNeeded += (pile / k).floor.toInt

      if (pile % k != 0) hoursNeeded += 1

      if (hoursNeeded > h) return false
    }

    hoursNeeded <= h
  }
}
