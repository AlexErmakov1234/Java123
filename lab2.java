import java.util.Random;
import java.util.Scanner;
public class lab2 {


    int m;   // количество строк
    int n ;    // количество столбцов
    int[][] matrix;

    lab2( int rows, int cols){
        m = rows;
        n = cols;
        matrix = new int[m][n];
    };

    // инициализация матрицы случайными целыми числами
    public void initialize () {
        Random r = new Random();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = r.nextInt(100);
            }
        }
    }

    // вывести матрицу на экран
    public void showMatrix () {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // вычислить среднее значение матрицы
    public int average () {
        return sum() / (m * n);    // дробная часть отброшена для упрощения
    }

    // вычислить сумму элементов матрицы
    private int sum () {
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    // вычитание числа из элементов матрицы
    public void subtractNumber ( int num){
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] -= num;
            }
        }
    }
}

class TestMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Количество строк: ");
        int m = scanner.nextInt() ;    // количество строк
        System.out.println("Количество столбцов: ");
        int n = scanner.nextInt();    // количество столбцов
        lab2 matrix = new lab2(m, n);

        matrix.initialize();
        matrix.showMatrix();
        System.out.println();

        int average = matrix.average();
        System.out.println("Среднее значение матрицы равно: " + average);
        System.out.println();

        System.out.println("Вычитание среднего значения из матрицы");
        matrix.subtractNumber(average);
        matrix.showMatrix();
    }
}