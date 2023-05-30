package hust.soict.dsai.lab01;
// Exercise 6.3
import java.util.*;

public class DisplayTriangle{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter n: ");
    int n = scan.nextInt();
    scan.close();

    for (int row = 0; row < n; row++){
      for (int numBlank = 0; numBlank < n - row; numBlank++){
        System.out.print(" ");
      }
      for (int numStar = 0; numStar < 2*row + 1; numStar++){
        System.out.print("*");
      }
      System.out.println();
    }
  }
}