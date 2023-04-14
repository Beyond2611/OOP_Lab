package Lab01;
import javax.swing.JOptionPane;
import java.lang.Math.*;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Solve {
    public static void solveLinear1stDegree(){
        double a, b;
        Scanner input = new Scanner(System.in);
        System.out.println("Input a:");
        a = input.nextDouble();
        System.out.println("Input b:");
        b = input.nextDouble();

        if(Double.compare(a, 0d) == 0){
            System.out.println("The solution is all x");
            return;
        }
        double x = -b / a;
        System.out.println("x = " + Double.toString(x));
    }

    public static void solveSystem1stDegree(){
        double a11, a12, a21, a22, b1, b2;
        Scanner input = new Scanner(System.in);
        System.out.println("Input a11:");
        a11 = input.nextDouble();
        System.out.println("Input a12:");
        a12 = input.nextDouble();
        System.out.println("Input b1:");
        b1 = input.nextDouble();
        System.out.println("Input a21:");
        a21 = input.nextDouble();
        System.out.println("Input a22:");
        a22 = input.nextDouble();
        System.out.println("Input b1:");
        b2 = input.nextDouble();

        double eps = 1e-15;
        double det = (a11 * a22) - (a21 * a12);
        if(det == 0){
            System.out.println("The system has no solutions or infinite many solutions exists");
            return;
        }
        double x1 = (b1 * a22 - a12 * b2) / det;
        double x2 = (a11 * b2 - b1 * a21) / det;
        System.out.println("The system has the solution:\nx = " + x1 + '\n' + "y = " + x2);
    }

    public static void solve2ndDegree(){
        double a, b, c;
        Scanner input = new Scanner(System.in);
        System.out.println("Input a:");
        a = input.nextDouble();
        System.out.println("Input b:");
        b = input.nextDouble();
        System.out.println("Input c:");
        c = input.nextDouble();

        if(a == 0 && b == 0 && c == 0){
            System.out.println("The solution is all x");
            return;
        }
        if(a == 0 && b == 0)
        {
            System.out.println("No solution");
            return;
        }
        if(a == 0)
        {
            double x = -c / b;
            System.out.println("x = " + x );
            return;
        }

        double delta = b * b  - 4 * a * c;
        if(delta == 0){
            double x = -b / (2 * a);
            System.out.println("The solution have a double root x = " + x );
            return;
        }
        double x1 = (-b - sqrt(delta)) / (2 * a);
        double x2 = (-b + sqrt(delta)) / (2 * a);
        System.out.println("x1 = " + x1 );
        System.out.println("x2 = " + x2 );
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("1. 1st Degree linear equation\n");
        System.out.println("2. 1st Degree System of equation with two variables\n");
        System.out.println("3. 2nd Degree equation with one variable\n");
        System.out.println("im too lazy to impliment the while loop so please recompile :P\n");
        System.out.println("Input:");
        int MenuInput = in.nextInt();
        switch (MenuInput){
            case 1:
                solveLinear1stDegree();
                break;
            case 2:
                solveSystem1stDegree();
                break;
            case 3:
                solve2ndDegree();
                break;
        }
    }
}
