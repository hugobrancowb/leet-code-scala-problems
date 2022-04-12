package problems

/** Link to problem https://leetcode.com/problems/shift-2d-grid */
object ShiftGrid {
  def shiftGrid(grid: Array[Array[Int]], k: Int): List[List[Int]] = {
    val sizeGrid: Int   = grid.length
    val sizePerRow: Int = grid.apply(0).length
    val shift: Int      = k % (sizeGrid * sizePerRow)

    var array: Array[Int] = grid.reduce((res, arr) => res.concat(arr))
    array = array
      .slice(sizeGrid * sizePerRow - shift, sizeGrid * sizePerRow)
      .concat(array.dropRight(shift))

    var result: List[List[Int]] = List()

    for (i <- 0 until sizeGrid) {
      val tempList = array.slice(i * sizePerRow, i * sizePerRow + sizePerRow)
      result = result :+ tempList.toList
    }

    result
  }
}

// matrix, for until,
