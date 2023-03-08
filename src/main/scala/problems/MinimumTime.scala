package problems

/** Link to problem https://leetcode.com/problems/minimum-time-to-complete-trips/ */
object MinimumTime {
  def minimumTime(time: Array[Int], totalTrips: Int): Long = {
    var minTime = 1L
    var maxTime = 100000000000000L

    while (minTime < maxTime) {
      val mid   = (minTime + maxTime) / 2
      val trips = time.map(dur => Math.floorDiv(mid, dur)).sum

      if (trips >= totalTrips) maxTime = mid
      else minTime = mid + 1L
    }

    minTime
  }
}
