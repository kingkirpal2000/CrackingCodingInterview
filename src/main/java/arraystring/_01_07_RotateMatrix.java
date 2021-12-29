package arraystring;

//import java.util.ArrayList;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is
 * 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
 * place?
 */
class _01_07_RotateMatrix {
    int[][] rotate(int[][] m) {

        int rPointer = 0, cPointer = 0;
        int[][] newArr = new int[m.length][m.length];
        for (int j = 0; j < m[0].length; j++) {
            for (int i = m.length - 1; i >= 0; i--) {
                newArr[rPointer][cPointer] = m[i][j];
                cPointer++;
            }
            rPointer++;
            cPointer = 0;
        }
        // System.out.print("{ ");
        // for (int i = 0; i < m.length; i++) {
        // System.out.print("{ ");
        // for (int j = 0; j < m[i].length; j++) {
        // System.out.print(newArr[i][j]);
        // System.out.print(", ");
        // }
        // System.out.print(" }");
        // }
        return newArr;
    }

    public static void main(String[] args) {
        _01_07_RotateMatrix obj = new _01_07_RotateMatrix();

        obj.rotate(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });

    }
}
