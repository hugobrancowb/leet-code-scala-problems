package problems

/** Link to problem https://leetcode.com/problems/baseball-game */
object CalPoints {
  def calPoints(ops: Array[String]): Int = {
    var gameRecord = Array[Int]()

    for (score <- ops) {
      val s = gameRecord.length
      score match {
        case "+" => gameRecord = gameRecord :+ (gameRecord.apply(s - 2) + gameRecord.apply(s - 1))
        case "D" => gameRecord = gameRecord :+ (gameRecord.apply(s - 1) * 2)
        case "C" => gameRecord = gameRecord.dropRight(1)
        case default => gameRecord = gameRecord :+ score.toInt
      }
    }

    gameRecord.reduce((a, b) => a + b)
  }
}

// match (switch) e dropRight
