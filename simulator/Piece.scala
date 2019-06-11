package simulator

trait Piece {
  def move(initialPosition: Cell, board: ChessBoard): List[Cell]
}

object Piece {
  def apply(piece: String): Piece =
    piece.toUpperCase match {
      case "KING" => new King
      case "QUEEN" => new Queen
      case "ROOK" => new Rook
      case "BISHOP" => new Bishop
      case "HORSE" => new Horse
      case "PAWN" => new Pawn
    }
}