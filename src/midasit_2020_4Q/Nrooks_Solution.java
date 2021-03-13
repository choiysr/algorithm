package midasit_2020_4Q;

public class Nrooks_Solution {

    private static int[] idxRow_valCol;
    private static int[][] chessBoard;
    private static int maxValue, n;

    public static void main(String[] args) {

        Nrooks_Solution ns = new Nrooks_Solution();
        int[][] input = {{3,6,8},{1,4,7},{2,1,4}};
        int[][] input2= {{12,15},{19,21}};
        System.out.println(ns.solution(input2));

    }

    private int solution(int[][] board) {
        n = board.length;
        chessBoard = board;

        for (int i = 0; i < n; ++i) {
            idxRow_valCol = new int[n];
            idxRow_valCol[0] = i;
            backtracking(n, 1, chessBoard[0][idxRow_valCol[0]]);
        }

        return maxValue;
    }

    private void backtracking(int depth, int row, int countValue) {
        if (row == depth) {
            idxRow_valCol[row - 1] = 0;
            maxValue = Math.max(countValue, maxValue);
            return;
        }

        for (int i = 0; i < depth; i++) {
            idxRow_valCol[row] = i;
            if (isPossible(row)) {
                backtracking(depth, row + 1, (countValue+chessBoard[row][idxRow_valCol[row]]));
            } else {
                idxRow_valCol[row] = 0;
            }
        }
        idxRow_valCol[row] = 0;
    }

    private boolean isPossible(int row) {

        for (int i = 0; i < row; i++) {
            if (idxRow_valCol[i] == idxRow_valCol[row]) return false;
        }

        return true;

    }



}
