package Lab01;

import javax.swing.JOptionPane;
import java.lang.Double;

import static java.lang.Math.abs;

public class Calc {
    public static void main(String args[]){
        String SNum1, SNum2;
        double Num1, Num2;

        SNum1 = JOptionPane.showInputDialog(null, "Please enter the first number:", "Input", JOptionPane.INFORMATION_MESSAGE);
        SNum2 = JOptionPane.showInputDialog(null, "Please enter the second number:", "Input", JOptionPane.INFORMATION_MESSAGE);
        Num1 = Double.parseDouble(SNum1);
        Num2 = Double.parseDouble(SNum2);
        while(Double.compare(Num2, 0d) == 0 ){
            JOptionPane.showMessageDialog(null, "The divisor can't be 0", "error", JOptionPane.WARNING_MESSAGE);
            SNum2 = JOptionPane.showInputDialog(null, "Please re-enter the second number:", "Input", JOptionPane.INFORMATION_MESSAGE);
            Num2 = Double.parseDouble(SNum2);
        }

        double Sum, Diff, Product;
        int Quotient;
        Sum = Num1 + Num2;
        Diff = Num1 - Num2;
        Product = Num1 * Num2;
        Quotient = (int)(Num1 / Num2);

        String strNoti = "Here are the results:\nSum: " + Double.toString(Sum) + '\n' + "Difference: " + Double.toString(Diff) + "\n" + "Product: " + Double.toString(Product) + "\n" + "Quotient: "  + Integer.toString(Quotient);
        JOptionPane.showMessageDialog(null, strNoti, "Result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
