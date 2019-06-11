package simulator

class King extends Piece {
  override def move(initialPosition: Cell, board: ChessBoard): List[Cell] = {
    val rowIndex = initialPosition.rowId.toString.toInt
    val startIndex = 0
    val endIndex = 8
    val startAlphabet = 'A'
    val endAlphabet = 'H'

    val columnId = Range(initialPosition.columnId - 1, initialPosition.columnId + 2)
      .filter(_ >= startAlphabet)
      .filter(_ <= endAlphabet)
      .map(_.toChar)

    val rowIndexes = Range(rowIndex - 1, rowIndex + 2)
      .filter(_ > startIndex)
      .filter(_ <= endIndex)

    columnId.flatMap { c => rowIndexes.map(r => Cell(c, r)).toList.filter(_ != initialPosition) }.toList
  }
}
