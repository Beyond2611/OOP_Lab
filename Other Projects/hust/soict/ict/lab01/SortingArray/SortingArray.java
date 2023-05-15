package Lab01.hust.soict.ict.lab01.SortingArray;

import java.util.Arrays;
import java.util.Scanner;

public class SortingArray {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int Arr[] = new int[n];
        int Sum = 0;
        for(int i = 0; i < n; ++i) {
            Arr[i] = in.nextInt();
            Sum += Arr[i];
        }
        double Avg =(double) Sum / n;
        Arrays.sort(Arr);
        System.out.println("Sorted Array:\n" + Arrays.toString(Arr) + "\nSum of array: " + Sum + "\n" + "Average Value:" + Avg);
    }
}
