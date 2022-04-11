import problems.ShiftGrid
object Main extends App {
  println("-" * 30)

  Array(
    ShiftGrid.shiftGrid(Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9)), 4),
    ShiftGrid.shiftGrid(
      Array(Array(1), Array(2), Array(3), Array(4), Array(6), Array(7), Array(5)),
      23
    )
  ).foreach(f => {
    println(f.mkString)
  })

  println("-" * 30)
}
