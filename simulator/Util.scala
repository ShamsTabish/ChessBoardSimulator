package simulator

import scala.util.Try

object Util {

  def convertCharToIndex(code: Char) = code.toChar.toString

  def rowIndexToAlphabet(rowIndex: Int) = ('A' + rowIndex).toChar

  def stringToCell(cell: String) =
    Try(Some(Cell(cell.charAt(0), cell.charAt(1).toString.toInt))).getOrElse(None)

  def parseStringToPiece(piece: String) =
    piece.toUpperCase match {
      case "KING" => new King
      case "QUEEN" => new Queen
      case "ROOK" => new Rook
      case "BISHOP" => new Bishop
      case "HORSE" => new Horse
      case "PAWN" => new Pawn
    }

  def inputParser(input: String) = Try {
    val inputSegments = input.split("\\s+")
    val piece = parseStringToPiece(inputSegments(0))
    val initialPosition = inputSegments(1)
    val initialCell = stringToCell(initialPosition)
    if (initialCell.isDefined) {
      Some(initialCell.get, piece)
    } else None
  }.getOrElse(None)
}
