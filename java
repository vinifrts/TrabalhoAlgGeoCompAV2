import java.util.Scanner;

public class Transformations {

    // Translação 2D usando coordenadas homogêneas
    public static double[] translate2D(double[] vector, double dx, double dy) {
        double[][] matrizTranslacao = {
                {1, 0, dx},
                {0, 1, dy},
                {0, 0, 1}
        };
        return multiplicarMatrizVetor(matrizTranslacao, new double[]{vector[0], vector[1], 1});
    }

    // Translação 3D usando coordenadas homogêneas
    public static double[] translate3D(double[] vector, double dx, double dy, double dz) {
        double[][] matrizTranslacao = {
                {1, 0, 0, dx},
                {0, 1, 0, dy},
                {0, 0, 1, dz},
                {0, 0, 0, 1}
        };
        return multiplicarMatrizVetor(matrizTranslacao, new double[]{vector[0], vector[1], vector[2], 1});
    }

    // Rotação 2D usando coordenadas homogêneas
    public static double[] rotation2D(double[] vector, double angle) {
        double cosA = Math.cos(angle);
        double sinA = Math.sin(angle);
        double[][] matrizRotacao = {
                {cosA, -sinA, 0},
                {sinA, cosA, 0},
                {0, 0, 1}
        };
        return multiplicarMatrizVetor(matrizRotacao, new double[]{vector[0], vector[1], 1});
    }

    // Rotação em torno do eixo X (3D) usando coordenadas homogêneas
    public static double[] rotation3DX(double[] vector, double angle) {
        double cosA = Math.cos(angle);
        double sinA = Math.sin(angle);
        double[][] matrizRotacao = {
                {1, 0, 0, 0},
                {0, cosA, -sinA, 0},
                {0, sinA, cosA, 0},
                {0, 0, 0, 1}
        };
        return multiplicarMatrizVetor(matrizRotacao, new double[]{vector[0], vector[1], vector[2], 1});
    }

    // Rotação em torno do eixo Y (3D) usando coordenadas homogêneas
    public static double[] rotation3DY(double[] vector, double angle) {
        double cosA = Math.cos(angle);
        double sinA = Math.sin(angle);
        double[][] matrizRotacao = {
                {cosA, 0, sinA, 0},
                {0, 1, 0, 0},
                {-sinA, 0, cosA, 0},
                {0, 0, 0, 1}
        };
        return multiplicarMatrizVetor(matrizRotacao, new double[]{vector[0], vector[1], vector[2], 1});
    }

    // Rotação em torno do eixo Z (3D) usando coordenadas homogêneas
    public static double[] rotation3DZ(double[] vector, double angle) {
        double cosA = Math.cos(angle);
        double sinA = Math.sin(angle);
        double[][] matrizRotacao = {
                {cosA, -sinA, 0, 0},
                {sinA, cosA, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        return multiplicarMatrizVetor(matrizRotacao, new double[]{vector[0], vector[1], vector[2], 1});
    }

    // Reflexão sobre o eixo X em 2D usando coordenadas homogêneas
    public static double[] reflection2DX(double[] vector) {
        double[][] matrizReflexao = {
                {1, 0, 0},
                {0, -1, 0},
                {0, 0, 1}
        };
        return multiplicarMatrizVetor(matrizReflexao, new double[]{vector[0], vector[1], 1});
    }

    // Reflexão sobre o eixo Y em 2D usando coordenadas homogêneas
    public static double[] reflection2DY(double[] vector) {
        double[][] matrizReflexao = {
                {-1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        return multiplicarMatrizVetor(matrizReflexao, new double[]{vector[0], vector[1], 1});
    }

    // Reflexão em torno do eixo XY em 3D
    public static double[] reflection3DXY(double[] vector) {
        double[][] matrizReflexao = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, -1, 0},
                {0, 0, 0, 1}
        };
        return multiplicarMatrizVetor(matrizReflexao, new double[]{vector[0], vector[1], vector[2], 1});
    }

    // Reflexão em torno do eixo XZ em 3D
    public static double[] reflection3DXZ(double[] vector) {
        double[][] matrizReflexao = {
                {1, 0, 0, 0},
                {0, -1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        return multiplicarMatrizVetor(matrizReflexao, new double[]{vector[0], vector[1], vector[2], 1});
    }

    // Reflexão em torno do eixo YZ em 3D
    public static double[] reflection3DYZ(double[] vector) {
        double[][] matrizReflexao = {
                {-1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        return multiplicarMatrizVetor(matrizReflexao, new double[]{vector[0], vector[1], vector[2], 1});
    }

    // Projeção ortogonal 2D
    public static double[] projection2D(double[] vector) {
        double[][] matrizProjecao = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        return multiplicarMatrizVetor(matrizProjecao, new double[]{vector[0], vector[1], 1});
    }

    // Projeção ortogonal 3D
    public static double[] projection3D(double[] vector) {
        double[][] matrizProjecao = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        };
        return multiplicarMatrizVetor(matrizProjecao, new double[]{vector[0], vector[1], vector[2], 1});
    }

    // Cisalhamento 2D
    public static double[] shear2D(double[] vector, double shx, double shy) {
        double[][] matrizCisalhamento = {
                {1, shx, 0},
                {shy, 1, 0},
                {0, 0, 1}
        };
        return multiplicarMatrizVetor(matrizCisalhamento, new double[]{vector[0], vector[1], 1});
    }

    // Função para multiplicar uma matriz 3x3 ou 4x4 com um vetor de coordenadas homogêneas
    private static double[] multiplicarMatrizVetor(double[][] matriz, double[] vetor) {
        double[] resultado = new double[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < vetor.length; j++) {
                resultado[i] += matriz[i][j] * vetor[j];
            }
        }
        return resultado;
    }

    // Interface do usuário com as opções adicionais
    public static void userInterface() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o tipo de transformação:");
        System.out.println("1: Translação 2D");
        System.out.println("2: Translação 3D");
        System.out.println("3: Rotação 2D");
        System.out.println("4: Rotação 3D (X, Y, ou Z)");
        System.out.println("5: Reflexão 2D");
        System.out.println("6: Reflexão 3D");
        System.out.println("7: Projeção 2D");
        System.out.println("8: Projeção 3D");
        System.out.println("9: Cisalhamento 2D");

        String choice = scanner.nextLine();
        double[] vector;

        switch (choice) {
            case "1": // Translação 2D
                vector = parseInputVector(scanner, 2);
                System.out.print("dx: ");
                double dx = scanner.nextDouble();
                System.out.print("dy: ");
                double dy = scanner.nextDouble();
                displayResult(translate2D(vector, dx, dy));
                break;

            case "2": // Translação 3D
                vector = parseInputVector(scanner, 3);
                System.out.print("dx: ");
                dx = scanner.nextDouble();
                System.out.print("dy: ");
                dy = scanner.nextDouble();
                System.out.print("dz: ");
                double dz = scanner.nextDouble();
                displayResult(translate3D(vector, dx, dy, dz));
                break;

            case "3": // Rotação 2D
                vector = parseInputVector(scanner, 2);
                System.out.print("Qual o ângulo em graus: ");
                double angleDegrees2D = scanner.nextDouble();
                double angle2D = Math.toRadians(angleDegrees2D); // Converte para radianos
                displayResult(rotation2D(vector, angle2D));
                break;

            case "4": // Rotação 3D
                vector = parseInputVector(scanner, 3);
                System.out.print("Qual o ângulo em graus: ");
                double angleDegrees3D = scanner.nextDouble();
                double angle3D = Math.toRadians(angleDegrees3D); // Converte para radianos
                System.out.print("Escolha o eixo de rotação (X, Y, ou Z): ");
                char axis = scanner.next().toUpperCase().charAt(0);
                if (axis == 'X') {
                    displayResult(rotation3DX(vector, angle3D));
                } else if (axis == 'Y') {
                    displayResult(rotation3DY(vector, angle3D));
                } else if (axis == 'Z') {
                    displayResult(rotation3DZ(vector, angle3D));
                } else {
                    System.out.println("Inválido.");
                }
                break;

            case "5": // Reflexão 2D
                vector = parseInputVector(scanner, 2);
                System.out.print("Escolha a reflexão (X ou Y): ");
                char reflectionAxis2D = scanner.next().toUpperCase().charAt(0);
                if (reflectionAxis2D == 'X') {
                    displayResult(reflection2DX(vector));
                } else if (reflectionAxis2D == 'Y') {
                    displayResult(reflection2DY(vector));
                } else {
                    System.out.println("Eixo inválido.");
                }
                break;

            case "6": // Reflexão 3D
                vector = parseInputVector(scanner, 3);
                System.out.print("Escolha o plano de reflexão (XY, XZ ou YZ): ");
                String plane = scanner.next().toUpperCase();
                if (plane.equals("XY")) {
                    displayResult(reflection3DXY(vector));
                } else if (plane.equals("XZ")) {
                    displayResult(reflection3DXZ(vector));
                } else if (plane.equals("YZ")) {
                    displayResult(reflection3DYZ(vector));
                } else {
                    System.out.println("Plano inválido.");
                }
                break;

            case "7": // Projeção 2D
                vector = parseInputVector(scanner, 2);
                displayResult(projection2D(vector));
                break;

            case "8": // Projeção 3D
                vector = parseInputVector(scanner, 3);
                displayResult(projection3D(vector));
                break;

            case "9": // Cisalhamento 2D
                vector = parseInputVector(scanner, 2);
                System.out.print("shx: ");
                double shx = scanner.nextDouble();
                System.out.print("shy: ");
                double shy = scanner.nextDouble();
                displayResult(shear2D(vector, shx, shy));
                break;

            default:
                System.out.println("Inválido.");
        }
        scanner.close();
    }
    // Exibir o resultado
    private static void displayResult(double[] result) {
        System.out.print("Resultado: ");
        for (double val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // Converter entrada do usuário para vetor
    private static double[] parseInputVector(Scanner scanner, int size) {
        System.out.print("Insira o vetor (valores separados por vírgula): ");
        String[] input = scanner.next().split(",");
        double[] vector = new double[size];
        for (int i = 0; i < size; i++) {
            vector[i] = Double.parseDouble(input[i]);
        }
        return vector;
    }

    public static void main(String[] args) {
        userInterface();
    }
}
