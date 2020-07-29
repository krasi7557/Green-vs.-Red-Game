package greenVsRed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class Matrix {
    private int rows;
    private int columns;
    private String[][] matrix;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Matrix(int[] dimensions) throws IOException {
        setRows(dimensions[1]);
        setColumns(dimensions[0]);
        this.matrix = readMatrixFromConsole(getRows(), getColumns(), reader);
    }

    public void setMatrix(String[][] matrix) {
        this.matrix = matrix;
    }

    public String[][] getMatrix() {
        return this.matrix;
    }

    public int getRows() {
        return this.rows;
    }

    private void setRows(int rows) {
        if (rows<=0){
            throw new IllegalStateException("Invalid row input");
        }
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    private void setColumns(int columns) {
        if (columns<=0){
            throw new IllegalStateException("Invalid columns input");
        }
        this.columns = columns;
    }

    public String[][] readMatrixFromConsole(int rows, int columns, BufferedReader reader) throws IOException {
        String[][] matrix = new String[rows][columns];
        for (int row = 0; row < rows; row++) {
            String[] inputTokens = reader.readLine().split("");
            for (int column = 0; column < columns; column++) {
                matrix[row][column] =
                        (inputTokens[column]);
            }
        }
        return matrix;
    }
    public void printMatrixToConsole(String[][] matrix){
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
