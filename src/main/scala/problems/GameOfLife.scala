package problems

/** Link to problem https://leetcode.com/problems/game-of-life */
object GameOfLife {
  def gameOfLife(board: Array[Array[Int]]): Unit = {
    val og    = board.map(_.clone)
    val sizeY = board.length
    val sizeX = board.apply(0).length

    for (j <- 0 until sizeY; i <- 0 until sizeX) {
      // informs if cell is alive
      val isAlive = if (og.apply(j).apply(i) == 1) true else false

      // number of neighbors still alive
      var nAlives = 0

      for (dj <- -1 to 1; di <- -1 to 1)
        if (di != 0 || dj != 0)
          nAlives = nAlives + og
            .applyOrElse(j + dj, (_: Int) => Array[Int](0))
            .applyOrElse(i + di, (_: Int) => 0)

      if (isAlive && (nAlives != 2 && nAlives != 3))
        board.apply(j).update(i, 0)

      if (!isAlive && nAlives == 3)
        board.apply(j).update(i, 1)
    }

    println(board.map(_.mkString).mkString("\n"))
    println("-" * sizeX)
  }
}

// nested loops, nested applyOrElse
