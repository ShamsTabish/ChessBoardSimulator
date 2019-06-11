package simulator

class Rook extends Piece {
  override def move(initialPosition: Cell, board: ChessBoard): List[Cell] = {
    val columnIndex = initialPosition.columnId.toString.toInt
    val startIndex = 0
    val endIndex = 8

    val rowId = Range(initialPosition.rowIndex - 1, initialPosition.rowIndex + 2)
      .filter(_ >= startIndex)
      .filter(_ <= endIndex)
      .map(c => (c + 'A').toChar)

    val columnId = Range(columnIndex - 1, columnIndex + 2)
      .filter(_ > 0)
      .filter(_ <= 8)

    rowId.flatMap { r => columnId.map(c => Cell(r, c)).toList.filter(_ != initialPosition) }.toList
  }
}
