package simulator

import scala.util.Try

object Util {

  def convertCharToIndex(code: Char) = code.toChar.toString

  def indexToAlphabet(rowIndex: Int) = ('A' + rowIndex).toChar

  def inputParser(input: String) = Try {
    val inputSegments = input.split("\\s+")
    val piece = Piece(inputSegments(0))
    val initialPosition = inputSegments(1)
    val initialCell = Cell(initialPosition)
    if (initialCell.isDefined) {
      Some(initialCell.get, piece)
    } else None
  }.getOrElse(None)
}
