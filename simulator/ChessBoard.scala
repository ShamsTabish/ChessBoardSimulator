package simulator

case class Cell(rowId: Char, columnId: Int) {
  def rowIndex() = rowId - 'A'

  override def toString: String = rowId.toString + columnId

}

class ChessBoard {
  val cells: List[List[Cell]] = {
    val cellRange = Range(1, 9)
    cellRange.map { row =>
      val rowAsAlphabet = Util.rowIndexToAlphabet(row - 1)
      cellRange.map(column => Cell(rowAsAlphabet, column)).toList
    }.toList
  }
}
