package goldman_sachs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Map_Of_Highest_Peak {

    static class Pair {
        int row, col;

        Pair(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }

    private static int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;

        int[][] height = new int[n][m];
        for(int[] arr: height) Arrays.fill(arr, Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(isWater[i][j] == 1) {
                    height[i][j] = 0;
                    q.add(new Pair(i, j));
                }
            }
        }

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int i = p.row;
            int j = p.col;

            for(int k = 0; k < 4; k++) {
                int nrow = i + dr[k];
                int ncol = j + dc[k];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && height[nrow][ncol] > 1 + height[i][j]) {
                    height[nrow][ncol] = 1 + height[i][j];
                    q.add(new Pair(nrow, ncol));
                }
            }
        }

        return height;
    }

    public static void main(String[] args) {
        int[][] isWater = {{0,0,1}, {1,0,0}, {0,0,0}};
        
        int[][] result = highestPeak(isWater);
        for(int[] arr: result) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
