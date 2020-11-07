import java.util.Scanner;

class Main {
    public static int[] findColumnArray(int[][] matrix, int rows, int columnNum) {
        int[] columnArr = new int[rows];

        for (int i = 0; i < rows; i++) {
            columnArr[i] = matrix[i][columnNum];
        }

        return columnArr;
    }

    public static int[][] reassignColumn(int[][] matrix, int[] column, int columnNum, int rows) {
        //IMPORTANT: column is #1, columnNum is the index of the column which #1 is replacing
        int[][] newMatrix = matrix;

        for (int i = 0; i < rows; i++) {
            newMatrix[i][columnNum] = column[i];
        }

        return newMatrix;
    }

    public static void printMatrix(int[][] matrix, int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            String line = "";
            for (int j = 0; j < columns; j++) {
                line = line.concat(matrix[i][j] + " ");
            }

            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int columns = scanner.nextInt();

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int columnOne = scanner.nextInt();
        int columnTwo = scanner.nextInt();

        int[] columnOneArr = findColumnArray(matrix, rows, columnOne);
        int[] columnTwoArr = findColumnArray(matrix, rows, columnTwo);

        matrix = reassignColumn(matrix, columnOneArr, columnTwo, rows);
        matrix = reassignColumn(matrix, columnTwoArr, columnOne, rows);

        printMatrix(matrix, rows, columns);
    }
}