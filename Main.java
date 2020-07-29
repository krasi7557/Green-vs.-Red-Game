package greenVsRed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * This is implementation of the classic game "Green vs. Red"
 * It is presented through 2D array. There are two types of options:
 *   0 - Red, 1 - Green
 *   Game ends when N generations are made. Our task is to keep track of
 *   how many times one concrete cell from the grid has been Green(1).
 *   Every generation cells can change, depending on how many of its neighbours are Green.
 *
 * @author  Krasimir Ivanov
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Dimensions input for our multi-dimensional array
        int[] dimensions = Arrays.stream(reader.readLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        //Create new instance for our matrix
        Matrix matrix = new Matrix(dimensions);
        //Create secondary multi-dimensional array to keep temporary changes between the generations
        String[][] temp2dArray = new String[matrix.getRows()][matrix.getColumns()];

        //Last line input, which includes our suspected cell and generations count, all separated by comma and space
        String[] targetCellAndGenerationInputLine = reader.readLine().split(", ");
        int colTarget = Integer.parseInt(targetCellAndGenerationInputLine[0]);
        int rowTarget = Integer.parseInt(targetCellAndGenerationInputLine[1]);
        int generationsTarget = Integer.parseInt(targetCellAndGenerationInputLine[2]);

        //Counter for keeping track if our target cell is green
        int counterIfTargetIsGreen = 0;

        //Starts rotating the generations
        for (int k = 0; k <= generationsTarget; k++) {

            //Iterating through every cell in the matrix
            for (int i = 0; i < matrix.getRows(); i++) {
                for (int j = 0; j < matrix.getColumns(); j++) {
                    int greenNeighboursCount = 0;

                    //Checking if there is sequence between current cell and our green target cell
                    if (i == rowTarget && j == colTarget && matrix.getMatrix()[i][j].equals("1"))
                        counterIfTargetIsGreen++;


                    //Iterating through possible neighbours and finding out greens
                    if (!isOutOfBounds(i, j, matrix.getMatrix())) {
                        if (!isOutOfBounds(i + 1, j, matrix.getMatrix())) {
                            if (matrix.getMatrix()[i + 1][j].equals("1")) {
                                greenNeighboursCount++;
                            }
                        }
                        if (!isOutOfBounds(i - 1, j, matrix.getMatrix())) {
                            if (matrix.getMatrix()[i - 1][j].equals("1")) {
                                greenNeighboursCount++;
                            }
                        }
                        if (!isOutOfBounds(i, j + 1, matrix.getMatrix())) {
                            if (matrix.getMatrix()[i][j + 1].equals("1")) {
                                greenNeighboursCount++;
                            }
                        }
                        if (!isOutOfBounds(i, j - 1, matrix.getMatrix())) {
                            if (matrix.getMatrix()[i][j - 1].equals("1")) {
                                greenNeighboursCount++;
                            }
                        }
                        if (!isOutOfBounds(i - 1, j + 1, matrix.getMatrix())) {
                            if (matrix.getMatrix()[i - 1][j + 1].equals("1")) {
                                greenNeighboursCount++;
                            }
                        }
                        if (!isOutOfBounds(i + 1, j - 1, matrix.getMatrix())) {
                            if (matrix.getMatrix()[i + 1][j - 1].equals("1")) {
                                greenNeighboursCount++;
                            }
                        }
                        if (!isOutOfBounds(i + 1, j + 1, matrix.getMatrix())) {
                            if (matrix.getMatrix()[i + 1][j + 1].equals("1")) {
                                greenNeighboursCount++;
                            }
                        }
                        if (!isOutOfBounds(i - 1, j - 1, matrix.getMatrix())) {
                            if (matrix.getMatrix()[i - 1][j - 1].equals("1")) {
                                greenNeighboursCount++;
                            }
                        }
                    }
                    //Check if current cell is red or green and respectively
                    if (matrix.getMatrix()[i][j].equals("1")) { //If it is Green
                        switch (greenNeighboursCount) {
                            case 0:
                            case 1:
                            case 4:
                            case 5:
                            case 7:
                            case 8:
                                temp2dArray[i][j] = "0"; //Change to Red if green neighbours are enough
                                break;
                            default:
                                temp2dArray[i][j] = "1";
                        }

                    } else if (matrix.getMatrix()[i][j].equals("0")) { //If it is Red
                        switch (greenNeighboursCount) {
                            case 3:
                            case 6:
                                temp2dArray[i][j] = "1"; //Change to Green if green neighbours are enough
                                break;
                            default:
                                temp2dArray[i][j] = "0";
                        }
                    }
                }

            }
            //This method copies tempCreatedArray to the default multi-dimensional array, for the next generation work
            copyTempArrayToMatrix(temp2dArray, matrix);
        }
        //Print result
        System.out.println(counterIfTargetIsGreen);
    }

    private static void copyTempArrayToMatrix(String[][] temp2dArray, Matrix matrix) {
            matrix.setMatrix(temp2dArray);
    }


    //Checks if neighbour is out of bounds
    private static boolean isOutOfBounds(int nextRow, int nextCol, String[][] matrix) {
        return nextRow < 0 || nextRow >= matrix.length || nextCol < 0
                || nextCol >= matrix[nextRow].length;
    }
}
