package wordsearch;


public class Solution {
    boolean visited[][];

    private boolean backtrack(int i, int j, char[][] board, String word){
        if (word.isEmpty()){
            return true;
        }
        if ( i<0 || i>=board.length || j<0 || j>=board[i].length || word.charAt(0)!=board[i][j] || visited[i][j]){
            return false;
        }

        visited[i][j] = true;
        String modified_word = word.substring(1);
        if (
                backtrack(i+1, j, board, modified_word)||
                        backtrack(i, j+1, board, modified_word)||
                        backtrack( i, j-1, board, modified_word)||
                        backtrack(i-1, j, board, modified_word)
        ) return true;
        visited[i][j] = false;

        return false;
    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[rows-1].length;

        visited = new boolean[rows][columns];
        for ( int i=0; i < rows; i++ ){
            for ( int j=0; j < columns; j++ ){
                if ( board[i][j]==word.charAt(0) && backtrack(i, j, board, word) )
                    return true;
            }
        }

        return false;
    }
}
