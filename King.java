package chessfigure;

// King extends Queen to leverage its move logic
public class King extends Queen {
    public King(String color, int column, int row) {
        super(color, column, row);
    }

    @Override
    public String getPieceName() {
        return "King"; // Override to ensure correct name
    }

    @Override
    public boolean moveTo(int targetColumn, int targetRow) {
        // King move is a limited Queen move: only 1 square in any direction.

        // 1. Check if the target is reachable by a Queen (diagonal, horizontal, or vertical)
        if (super.moveTo(targetColumn, targetRow)) {
            // 2. Limit the distance to 1 square.
            int colDiff = Math.abs(targetColumn - getColumn());
            int rowDiff = Math.abs(targetRow - getRow());

            if (colDiff <= 1 && rowDiff <= 1) {
                return true;
            }
        }
        
        // If the Queen move fails, or the distance is > 1
        // (The super.moveTo already prints an error for invalid Queen move type)

        // Need to print an error specifically for the distance limit if the type of move was valid.
        int colDiff = Math.abs(targetColumn - getColumn());
        int rowDiff = Math.abs(targetRow - getRow());
        if((colDiff > 1 || rowDiff > 1) && super.moveTo(targetColumn, targetRow)) {
             System.out.println(this.getPieceName() + ": Invalid move. Kings can only move one square in any direction.");
        }

        return false;
    }
}