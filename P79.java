public class P79 {

    public static class Solution {

        private int width = 0;
        private int height = 0;
        private boolean res = false;

        public void backtrack(char[][] board, String s, String word, int i0, int j0, int pos, boolean [][]visit){
            if(pos == word.length()) {
                res = true;
                return;
            }            
            if(j0 + 1 < width && !visit[i0][j0 + 1]) {
                char c1 = board[i0][j0 + 1];
                if(c1 == word.charAt(pos)) {
                    visit[i0][j0 + 1] = true;
                    backtrack(board, s + c1, word, i0, j0 + 1, pos + 1, visit);
                    return;
                }
            }
            if(j0 - 1 >= 0 && !visit[i0][j0 - 1]) {
                char c2 = board[i0][j0 - 1];
                if(c2 == word.charAt(pos)){
                    visit[i0][j0 - 1] = true;
                    backtrack(board, s + c2, word, i0, j0 - 1, pos + 1, visit);
                    return;
                }
            }
            if(i0 + 1 < height && !visit[i0 + 1][j0]) {
                char c3 = board[i0 + 1][j0];
                if(c3 == word.charAt(pos)){
                    visit[i0 + 1][j0] = true;
                    backtrack(board, s + c3, word, i0 + 1, j0, pos + 1, visit);
                    return;
                }
            }
            if(i0 - 1 >= 0 && !visit[i0 - 1][j0]) {
                char c4 = board[i0 - 1][j0];
                if(c4 == word.charAt(pos)){
                    visit[i0 - 1][j0] = true;
                    backtrack(board, s + c4, word, i0 - 1, j0, pos + 1, visit);
                    return;
                }
            }
        }
        public boolean exist(char[][] board, String word) {
            
            height = board.length;
            width = board[0].length;
            
            for(int i = 0; i < height; i ++){
                for(int j = 0; j < width; j ++) {
                    String s = "";
                    boolean [][] visit = new boolean[height][width];

                    if(board[i][j] == word.charAt(0)) {
                        s += board[i][j];
                        visit[i][j] = true;
                    } else continue;

                    backtrack(board, s, word, i, j, 1, visit);
                    if(res) break;
                }
            }
            return res;
        }
    }
    public static void main(String[] args) {
        
        // char[][] board = new char [][]{
        //       {'A','B','C','E'},
        //       {'S','F','C','S'},
        //       {'A','D','E','E'}
        // };

        // char[][]board = new char[][] {
        //     {'A', 'A'}
        // };
        char[][]board = new char[][] {
            {'C', 'A', 'A'},
            {'A', 'A', 'A'},
            {'B', 'C', 'D'}
        };
        // System.out.println(board.length); // 3
        // System.out.println(board[0].length); // 4

        System.out.println(new Solution().exist(board, "AAB"));
    }
}
