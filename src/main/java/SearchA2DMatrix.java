package src.main.java;

public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        return binarySearch(matrix, 0, matrix.length * matrix[0].length - 1, target);
    }

    private boolean binarySearch(int[][] arr, int first, int last, int key) {
        int mid = (first + last) / 2;
        int row = mid / arr[0].length;
        int col = mid % arr[0].length;
        while (first <= last) {
            if (arr[row][col] < key) {
                first = mid + 1;
            } else if (arr[row][col] == key) {
                return true;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
            row = mid / arr[0].length;
            col = mid % arr[0].length;
        }
        return false;
    }

}
