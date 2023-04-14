import java.util.Scanner;

public class AddingMatrices {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Input the dimensions of the matrix:");
        int n = in.nextInt();
        int m = in.nextInt();

        int Matrix1[][] = new int[n + 1][m + 1];
        int Matrix2[][] = new int[n + 1][m + 1];
        System.out.println("Input the matrices");
        for(int i = 1; i <= n; ++i)
            for(int j = 1; j <= m; ++j){
                Matrix1[i][j] = in.nextInt();
            };
        for(int i = 1; i <= n; ++i)
            for(int j = 1; j <= m; ++j){
                Matrix2[i][j] = in.nextInt();
            };
        System.out.println("The sum matrix:");
        for(int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                Matrix1[i][j] += Matrix2[i][j];
                System.out.print(Matrix1[i][j] + " ");
            }
            ;System.out.print('\n');
        }
    }
}
