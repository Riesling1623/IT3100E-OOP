// Exercise 6.5
import java.util.*;

public class NumericArray {
    public static void main(String[] args){
        double sum = 0;
        Scanner scan = new Scanner(System.in);
        
        // Input the elements of array
        System.out.print("Enter length of the array: ");
        int lengthArray = scan.nextInt();
        double[] arr = new double[lengthArray];
        for (int i = 0; i < lengthArray; i++){
            System.out.print("a[" + i + "] = ");
            arr[i] = scan.nextDouble();            
        }
        scan.close();

        // Sort the array
        Arrays.sort(arr);
        System.out.println("After sorting: ");
        for (int i = 0; i < lengthArray; i++){
            System.out.print(arr[i] + " ");
            sum += arr[i];
        }
        System.out.println();

        // Print sum and average of array elements
        System.out.println("Sum of array elements: " + sum);
        double avg = sum / lengthArray;
        System.out.println("Average of array elements: " + avg);
    }
}
