import java.util.Scanner;

public class Pyramid
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int i, j;
        for (i = 0; i < row; i++)
        {
            for (j = row * 2 - i; j > 1; j--)
            {
                System.out.print(" ");
            }
            for (j = 0; j <= i * 2; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}