package easy;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) fill(image, sr, sc, color, newColor);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (image[sr][sc] == color) {
            image[sr][sc] = newColor;
            if (sr >= 1) fill(image, sr - 1, sc, color, newColor);
            if (sc >= 1) fill(image, sr, sc - 1, color, newColor);
            if (sr < image.length - 1) fill(image, sr + 1, sc, color, newColor);
            if (sc < image[0].length - 1) fill(image, sr, sc + 1, color, newColor);
        }
    }

}
