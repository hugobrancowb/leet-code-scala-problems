import problems._
object Main extends App {
  println("-" * 30)

  Array(
    MinEatingSpeed.minEatingSpeed(Array(3, 6, 7, 11), 8),
    MinEatingSpeed.minEatingSpeed(Array(30, 11, 23, 4, 20), 5),
    MinEatingSpeed.minEatingSpeed(Array(30, 11, 23, 4, 20), 6),
    MinEatingSpeed.minEatingSpeed(Array(312884470), 312884469),
    MinEatingSpeed.minEatingSpeed(Array(312884470), 968709470)
  ).foreach(println)

  println("-" * 30)
}
