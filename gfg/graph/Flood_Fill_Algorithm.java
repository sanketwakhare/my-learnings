package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* Flood fill Algorithm */

/* https://practice.geeksforgeeks.org/problems/flood-fill-algorithm1856/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=flood-fill-algorithm */

public class Flood_Fill_Algorithm {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("gfg/resources/Flood_Fill_Algorithm.txt")));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S2 = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Flood_Fill_Algorithm obj = new Flood_Fill_Algorithm();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
            System.out.println("------");
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return image;
        int n = image.length;
        int m = image[0].length;
        dfs(sr, sc, n, m, image, oldColor, newColor);
        return image;
    }

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public void dfs(int i, int j, int n, int m, int[][] image, int oldColor, int newColor) {
        image[i][j] = newColor;
        for (int index = 0; index < dx.length; index++) {
            int newRow = i + dx[index];
            int newCol = j + dy[index];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && image[newRow][newCol] == oldColor) {
                dfs(newRow, newCol, n, m, image, oldColor, newColor);
            }
        }
    }
}
