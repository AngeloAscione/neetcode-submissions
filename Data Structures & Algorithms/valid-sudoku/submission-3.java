class Solution {
    public boolean isValidSudoku(char[][] board) {
        
                Map<Integer, Set<Character>> seenInRow = new HashMap<>();
        Map<Integer, Set<Character>> seenInCol = new HashMap<>();
        Map<String, Set<Character>> seenInSquare = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char current = board[r][c];
                if (current == '.') continue;
                    
                String squareKey = (r / 3) + "," + (c / 3);    

                if (seenInRow.computeIfAbsent(r, k -> new HashSet<>()).contains(current) || 
                    seenInCol.computeIfAbsent(c, k -> new HashSet<>()).contains(current) ||
                    seenInSquare.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(current)) {
                    return false;
                }

                seenInRow.get(r).add(current);
                seenInCol.get(c).add(current);
                seenInSquare.get(squareKey).add(current);
            }
        }

        return true;

    }
}
