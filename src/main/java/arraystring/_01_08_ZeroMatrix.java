package arraystring;

import java.util.*;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire
 * row and column are set to 0.
 */
class _01_08_ZeroMatrix {
    int[][] zero(int[][] matrix) {
        if (matrix.length == 1) {
            return matrix;
        }
        LinkedList<LinkedList<Integer>> z = new LinkedList<LinkedList<Integer>>();
        for (int i = 0; i < matrix.length; i++) {
            LinkedList<Integer> y = new LinkedList<Integer>();
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    y.add(j);
                }
            }
            z.add(y);
        }
        for (int i = 0; i < z.size(); i++) {
            for (int j = 0; j < z.get(i).size(); j++) {
                // 1
                for (int k = 0; k < matrix[i].length; k++) {
                    matrix[i][k] = 0;
                    matrix[k][z.get(i).get(j)] = 0;
                }
            }
        }
        return matrix;
    }

}
