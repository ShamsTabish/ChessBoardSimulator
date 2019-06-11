package simulator

case class Cell(columnId: Char, rowId: Int) {
  def columnIndex() = columnId - 'A'

  override def toString: String = columnId.toString + rowId
}

object Cell {
  def apply(cell: String): Option[Cell] = {
    validateInput(cell)
  }

  def validateInput(cell: String) = {
    lazy val columnID = cell.charAt(0).toUpper
    lazy val rowID = cell.charAt(1).toString.toInt
    lazy val isValidColumnID = Range('A', 'I').contains(columnID)
    lazy val isValidRowID = Range(1, 9).contains(rowID)
    if (cell.trim.length == 2 && isValidColumnID && isValidRowID)
      Some(Cell(columnID, rowID))
    else None
  }
}

class ChessBoard {
  val cells: List[List[Cell]] = {
    val rowRange = Range(1, 9)
    val colRange = Range('A', 'I')
    colRange.map { col =>
      rowRange.map(row => Cell(col.toChar, row)).toList
    }.toList
  }
}
