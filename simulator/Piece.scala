package simulator

trait Piece {
  def move(initialPosition: Cell, board: ChessBoard): List[Cell]
}
