package simulator

class Pawn extends Piece {
  override def move(initialPosition: Cell, board: ChessBoard): List[Cell] = {
    if(initialPosition.rowId  <7)
      List(initialPosition.copy(rowId = initialPosition.rowId+1))
    else List.empty
  }
}
