import problems._
object Main extends App {
  println("-" * 30)

  Array(
    GameOfLife.gameOfLife(Array(Array(0, 1, 0), Array(0, 0, 1), Array(1, 1, 1), Array(0, 0, 0))),
    GameOfLife.gameOfLife(Array(Array(1, 1), Array(1, 0)))
  ).foreach(f => {
    println(f)
  })

  println("-" * 30)
}
