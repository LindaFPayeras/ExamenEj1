package Ejercicio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixCaltulatorTest {

    @Test
    // Prueba calcular la matriz B
    public void testCalculateMatrixB() {
        int[][] A = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] C = { { 10, 11, 12 }, { 13, 14, 15 }, { 16, 17, 18 } };

        int[][] expectedB = { { 9, 9, 9 }, { 9, 9, 9 }, { 9, 9, 9 } };

        int[][] actualB = MatrixCalculator.calculateMatrixB(A, C);

        Assertions.assertArrayEquals(expectedB, actualB);
    }

    @Test
    // Prueba leer una matriz desde un archivo de texto
    public void testReadMatrixFromFile() {
        int[][] expectedMatrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        int[][] actualMatrix = MatrixCalculator.readMatrixFromFile("testFiles/testMatrix.txt");

        Assertions.assertArrayEquals(expectedMatrix, actualMatrix);
    }

    @Test
    // Prueba escribir una matriz en un archivo de texto
    public void testWriteMatrixToFile() {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        String expectedContent = "1,2,3\n4,5,6\n7,8,9\n";

        MatrixCalculator.writeMatrixToFile("testFiles/outputMatrix.txt", matrix);

        String actualContent = getFileContent("testFiles/outputMatrix.txt");

        Assertions.assertEquals(expectedContent, actualContent);
    }

    private String getFileContent(String filePath) {
        // Implementa la lógica para leer el contenido del archivo y devolverlo como una cadena
        // Esto puede ser similar a la función readMatrixFromFile del código original
    }
}
