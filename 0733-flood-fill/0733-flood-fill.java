class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        fill(image, sr, sc, image[sr][sc], color);
        return image;
    }

    public void fill(int[][] image, int i, int j, int color, int newColor) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != color)
            return;

        image[i][j] = newColor;
        int[][] d = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }; // gives direction

        for (int a = 0; a < 4; a++) {
            fill(image, i + d[a][0], j + d[a][1], color, newColor);
        }
    }
}