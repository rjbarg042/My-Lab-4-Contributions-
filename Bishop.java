package chessfigure;

import chessinterface.IntBishop;

public class Bishop extends Figure implements IntBishop {
    public Bishop(String color, int column, int row) {
        super("Bishop", color, column, row);
    }

    // Bishop must implement moveTo (from Figure/IntFigure) AND moveToBishop (from IntBishop)

    @Override
    public boolean moveToBishop(int targetColumn, int targetRow) {
        // Bishop moves diagonally: the change in column must equal the change in row.
        int colDiff = Math.abs(targetColumn - getColumn());
        int rowDiff = Math.abs(targetRow - getRow());

        return colDiff == rowDiff && colDiff != 0; // Must move, and diagonally
    }

    @Override
    public boolean moveTo(int targetColumn, int targetRow) {
        // Handle no move
        if (getColumn() == targetColumn && getRow() == targetRow) {
            System.out.println(this.getPieceName() + ": Invalid move. Piece is already at the target location.");
            return false;
        }

        if (moveToBishop(targetColumn, targetRow)) {
            return true;
        } else {
            System.out.println(this.getPieceName() + ": Invalid move. Bishops must move diagonally.");
            return false;
        }
    }
}