public class P79 {

    public static class Solution {
        private int width;
        private int height;

        public boolean backtrack(char[][] board, String word, int i, int j, int pos) {
            if(pos == word.length())
                return true;
            if(i < 0 || i >= height || j < 0 || j >= width || board[i][j] != word.charAt(pos))
                return false;
            char tmp = word.charAt(pos);
            board[i][j] = '?'; 
            boolean res = backtrack(board, word, i - 1, j, pos + 1) || backtrack(board, word, i + 1, j, pos + 1) || backtrack(board, word, i, j + 1, pos + 1) || backtrack(board, word, i, j - 1, pos + 1);
            board[i][j] = tmp;
            return res;

        }
        public boolean exist(char[][] board, String word) {
            width = board[0].length;
            height = board.length;
            for(int i = 0; i < height; i ++)
                for(int j = 0; j < width; j ++)
                    if(backtrack(board, word, i, j, 0))
                        return true;
            return false;
        }
    }
    public static void main(String[] args) {
        
        char[][] board = new char [][]{
              {'A','B','C','E'},
              {'S','F','E','S'},
              {'A','D','E','E'}
        };

        // char[][]board = new char[][] {
        //     {'A', 'A'}
        // };
        // char[][] board = new char[][] {
        //     {'C', 'A', 'A'},
        //     {'A', 'A', 'A'},
        //     {'B', 'C', 'D'}
        // };
        // System.out.println(board.length); // 3
        // System.out.println(board[0].length); // 4

        System.out.println(new Solution().exist(board, "ABCESEEEFS"));
    }
}
