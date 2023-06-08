package Ejercicio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MatrixCalculator {
    public static void main(String[] args) {
        try {
            // Leer matrices A y C desde archivos de texto
            int[][] A = readMatrixFromFile("MatricesA.txt");
            int[][] C = readMatrixFromFile("MatricesC.txt");

            // Calcular matriz B
            int[][] B = calculateMatrixB(A, C);

            // Escribir matriz B en un archivo de texto
            writeMatrixToFile("MatricesB.txt", B);

            System.out.println("El cálculo de la matriz B se ha completado correctamente.");
        } catch (IOException e) {
            System.out.println("Se produjo un error al leer o escribir los archivos.");
            e.printStackTrace();
        }
    }

    // Método para leer una matriz desde un archivo de texto
    private static int[][] readMatrixFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int rowCount = 0;
            int[][] matrix = null;

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (matrix == null) {
                    matrix = new int[values.length][values.length];
                }

                for (int i = 0; i < values.length; i++) {
                    matrix[rowCount][i] = Integer.parseInt(values[i]);
                }

                rowCount++;
            }

            return matrix;
        }
    }

    // Método para escribir una matriz en un archivo de texto
    private static void writeMatrixToFile(String filePath, int[][] matrix) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int[] row : matrix) {
                for (int i = 0; i < row.length; i++) {
                    writer.write(String.valueOf(row[i]));

                    if (i != row.length - 1) {
                        writer.write(",");
                    }
                }

                writer.newLine();
            }
        }
    }

    // Método para calcular la matriz B a partir de las matrices A y C
    private static int[][] calculateMatrixB(int[][] A, int[][] C) {
        int size = A.length;
        int[][] B = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                B[i][j] = C[i][j] - A[i][j];
            }
        }

        return B;
    }
}

