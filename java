import java.util.Scanner;

public class Transformations {

    // Translação 2D
    public static double[] translate2D(double[] vector, double dx, double dy) {
        return new double[]{vector[0] + dx, vector[1] + dy};
    }

    // Translação 3D
    public static double[] translate3D(double[] vector, double dx, double dy, double dz) {
        return new double[]{vector[0] + dx, vector[1] + dy, vector[2] + dz};
    }

    // Rotação 2D
    public static double[] rotation2D(double[] vector, double angle) {
        double cosA = Math.cos(angle);
        double sinA = Math.sin(angle);
        return new double[]{
                vector[0] * cosA - vector[1] * sinA,
                vector[0] * sinA + vector[1] * cosA
        };
    }

    // Rotação em torno do eixo X (3D)
    public static double[] rotation3DX(double[] vector, double angle) {
        double cosA = Math.cos(angle);
        double sinA = Math.sin(angle);
        return new double[]{
                vector[0],
                vector[1] * cosA - vector[2] * sinA,
                vector[1] * sinA + vector[2] * cosA
        };
    }

    // Rotação em torno do eixo Y (3D)
    public static double[] rotation3DY(double[] vector, double angle) {
        double cosA = Math.cos(angle);
        double sinA = Math.sin(angle);
        return new double[]{
                vector[0] * cosA + vector[2] * sinA,
                vector[1],
                -vector[0] * sinA + vector[2] * cosA
        };
    }

    // Rotação em torno do eixo Z (3D)
    public static double[] rotation3DZ(double[] vector, double angle) {
        double cosA = Math.cos(angle);
        double sinA = Math.sin(angle);
        return new double[]{
                vector[0] * cosA - vector[1] * sinA,
                vector[0] * sinA + vector[1] * cosA,
                vector[2]
        };
    }

    // Reflexão sobre o eixo X em 2D
    public static double[] reflection2DX(double[] vector) {
        return new double[]{vector[0], -vector[1]};
    }

    // Reflexão sobre o eixo Y em 2D
    public static double[] reflection2DY(double[] vector) {
        return new double[]{-vector[0], vector[1]};
    }

    // Reflexão sobre o eixo X em 3D
    public static double[] reflection3DX(double[] vector) {
        return new double[]{vector[0], -vector[1], -vector[2]};
    }

    // Reflexão sobre o eixo Y em 3D
    public static double[] reflection3DY(double[] vector) {
        return new double[]{-vector[0], vector[1], -vector[2]};
    }

    // Reflexão sobre o eixo Z em 3D
    public static double[] reflection3DZ(double[] vector) {
        return new double[]{-vector[0], -vector[1], vector[2]};
    }

    // Projeção sobre o eixo X em 2D
    public static double[] projection2DX(double[] vector) {
        return new double[]{vector[0], 0};
    }

    // Projeção sobre o eixo Y em 2D
    public static double[] projection2DY(double[] vector) {
        return new double[]{0, vector[1]};
    }

    // Projeção sobre o eixo X em 3D
    public static double[] projection3DX(double[] vector) {
        return new double[]{vector[0], 0, 0};
    }

    // Projeção sobre o eixo Y em 3D
    public static double[] projection3DY(double[] vector) {
        return new double[]{0, vector[1], 0};
    }

    // Projeção sobre o eixo Z em 3D
    public static double[] projection3DZ(double[] vector) {
        return new double[]{0, 0, vector[2]};
    }

    // Cisalhamento em 2D
    public static double[] shearing(double[] vector, double kx, double ky) {
        return new double[]{
                vector[0] + kx * vector[1],
                vector[1] + ky * vector[0]
        };
    }

    // Método para leitura e escolha de transformações
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
                System.out.print("Insira dx: ");
                double dx = scanner.nextDouble();
                System.out.print("Insira dy: ");
                double dy = scanner.nextDouble();
                displayResult(translate2D(vector, dx, dy));
                break;

            case "2": // Translação 3D
                vector = parseInputVector(scanner, 3);
                System.out.print("Insira dx: ");
                dx = scanner.nextDouble();
                System.out.print("Insira dy: ");
                dy = scanner.nextDouble();
                System.out.print("Insira dz: ");
                double dz = scanner.nextDouble();
                displayResult(translate3D(vector, dx, dy, dz));
                break;

            case "3": // Rotação 2D
                vector = parseInputVector(scanner, 2);
                System.out.print("Insira o ângulo em radianos: ");
                double angle = scanner.nextDouble();
                displayResult(rotation2D(vector, angle));
                break;

            case "4": // Rotação 3D
                vector = parseInputVector(scanner, 3);
                System.out.print("Insira o ângulo em radianos: ");
                angle = scanner.nextDouble();
                System.out.print("Escolha o eixo de rotação (X, Y, ou Z): ");
                char axis = scanner.next().toUpperCase().charAt(0);
                if (axis == 'X') {
                    displayResult(rotation3DX(vector, angle));
                } else if (axis == 'Y') {
                    displayResult(rotation3DY(vector, angle));
                } else if (axis == 'Z') {
                    displayResult(rotation3DZ(vector, angle));
                } else {
                    System.out.println("Eixo inválido.");
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
                System.out.print("Escolha a reflexão (X, Y ou Z): ");
                char reflectionAxis3D = scanner.next().toUpperCase().charAt(0);
                if (reflectionAxis3D == 'X') {
                    displayResult(reflection3DX(vector));
                } else if (reflectionAxis3D == 'Y') {
                    displayResult(reflection3DY(vector));
                } else if (reflectionAxis3D == 'Z') {
                    displayResult(reflection3DZ(vector));
                } else {
                    System.out.println("Eixo inválido.");
                }
                break;

            case "7": // Projeção 2D
                vector = parseInputVector(scanner, 2);
                System.out.print("Escolha a projeção (X ou Y): ");
                char projectionAxis2D = scanner.next().toUpperCase().charAt(0);
                if (projectionAxis2D == 'X') {
                    displayResult(projection2DX(vector));
                } else if (projectionAxis2D == 'Y') {
                    displayResult(projection2DY(vector));
                } else {
                    System.out.println("Eixo inválido.");
                }
                break;

            case "8": // Projeção 3D
                System.out.print("Escolha a projeção (X, Y ou Z): ");
                char projectionAxis3D = scanner.next().toUpperCase().charAt(0);
                vector = parseInputVector(scanner, 3);
                if (projectionAxis3D == 'X') {
                    displayResult(projection3DX(vector));
                } else if (projectionAxis3D == 'Y') {
                    displayResult(projection3DY(vector));
                } else if (projectionAxis3D == 'Z') {
                    displayResult(projection3DZ(vector));
                } else {
                    System.out.println("Eixo inválido.");
                }
                break;

            case "9": // Cisalhamento 2D
                vector = parseInputVector(scanner, 2);
                System.out.print("Insira kx: ");
                double kx = scanner.nextDouble();
                System.out.print("Insira ky: ");
                double ky = scanner.nextDouble();
                displayResult(shearing(vector, kx, ky));
                break;

            default:
                System.out.println("Opção inválida.");
        }
        scanner.close();
    }

    // Método auxiliar para exibir o resultado
    private static void displayResult(double[] result) {
        System.out.print("Resultado: ");
        for (double val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // Método auxiliar para converter entrada do usuário para vetor
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
