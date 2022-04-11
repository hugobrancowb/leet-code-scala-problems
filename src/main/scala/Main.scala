object Main extends App {
  println("-" * 30)

  Array(
    CalPoints.calPoints(Array("5", "2", "C", "D", "+")),
    CalPoints.calPoints(Array("5", "-2", "4", "C", "D", "9", "+", "+")),
    CalPoints.calPoints(Array("1"))
  ).foreach(f => {
    println(f)
  })

  println("-" * 30)
}
