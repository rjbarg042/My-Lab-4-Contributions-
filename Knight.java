package chessfigure;

public class Knight extends Figure {
    public Knight(String color, int column, int row) {
        super("Knight", color, column, row);
    }

    @Override
    public boolean moveTo(int targetColumn, int targetRow) {
        // Handle no move
        if (getColumn() == targetColumn && getRow() == targetRow) {
            System.out.println(this.getPieceName() + ": Invalid move. Piece is already at the target location.");
            return false;
        }

        int colDiff = Math.abs(targetColumn - getColumn());
        int rowDiff = Math.abs(targetRow - getRow());

        // Knight moves in an 'L' shape: 2 squares in one direction (column or row) and 1 square perpendicularly.
        boolean isLMove = (colDiff == 1 && rowDiff == 2) || (colDiff == 2 && rowDiff == 1);

        if (isLMove) {
            return true;
        } else {
            System.out.println(this.getPieceName() + ": Invalid move. Knights must move in an 'L' shape.");
            return false;
        }
    }
}