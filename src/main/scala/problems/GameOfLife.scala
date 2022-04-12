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

/** [[GameOfLifeBitwiseSolution]] was based on
  * [[https://leetcode.com/problems/game-of-life/discuss/1937883/Java-or-Simple-or-Explained Java | Simple | Explained]]
  *
  * PS: the bits solution applied to Scala wasnt as performative as the decimal/clone board one, so
  * i'm keeping the second as my final solution.
  *
  * Link to problem https://leetcode.com/problems/game-of-life
  */

object GameOfLifeBitwiseSolution {
  def gameOfLife(board: Array[Array[Int]]): Unit = {
    val sizeY = board.length
    val sizeX = board.apply(0).length

    for (j <- 0 until sizeY; i <- 0 until sizeX) {
      // informs if cell is alive
      val isAlive = if (board.apply(j).apply(i) % 10 == 1) true else false

      // number of neighbors still alive
      val nAlives = countLivingCells(board, i, j)

      // updates board
      if (isAlive && (nAlives == 2 || nAlives == 3))
        board.apply(j).update(i, 3) // 3 = 0xb11

      if (!isAlive && nAlives == 3)
        board.apply(j).update(i, 2) // 2 = 0xb10;
    }

    // right shift bits
    for (j <- 0 until sizeY; i <- 0 until sizeX)
      board.apply(j).update(i, board.apply(j).apply(i) >> 1)

    println(board.map(_.mkString).mkString("\n"))
    println("-" * sizeX)
  }

  /** Count alive neighbors around cell in position (i, j).
    *
    * Since we only care if the total of living cells is equal or not to 2 or 3, we stop counting
    * after realize n > 3, where n is the number of living cells.
    *
    * @param board
    *   Original board used for reference.
    * @param i
    *   column index (or index pointing to an array of array).
    * @param j
    *   row index (or index pointing to an array).
    * @return
    *   Alive neighbors around cell.
    */
  def countLivingCells(board: Array[Array[Int]], i: Int, j: Int): Int = {
    var nAlives = 0

    for (dj <- -1 to 1; di <- -1 to 1)
      if (di != 0 || dj != 0) {
        nAlives = nAlives + (board
          .applyOrElse(j + dj, (_: Int) => Array[Int](0))
          .applyOrElse(i + di, (_: Int) => 0) & 1) // binary AND for the last digit

        if (nAlives > 3) return nAlives
      }

      nAlives
  }
}

// nested loops, nested applyOrElse, bit operation
