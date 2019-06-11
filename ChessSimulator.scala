import simulator._

object ChessSimulator extends App {

  println("------------------Chess Simulator Menu------------------")
  println("Please input the Piece with initial position (separated by Space): ")

  val rawInput: String = scala.io.StdIn.readLine()
  Util.inputParser(rawInput).map {
    input =>
      val initialPosition: Cell = input._1
      val piece: Piece = input._2
      val test = new ChessBoard()

      test.cells.map(println)
      piece.move(initialPosition, test).map(println)
  }
}