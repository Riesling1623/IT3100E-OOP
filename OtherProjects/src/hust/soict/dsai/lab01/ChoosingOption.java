package hust.soict.dsai.lab01;
// Exercise 6.1 
import javax.swing.JOptionPane;
public class ChoosingOption {
    public static void main(String[] args){
        int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?", null, JOptionPane.YES_OPTION);
        JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_OPTION?"Yes":"No"));
        System.exit(0);
    }
}

// Questions:
//     - If users choose "Cancel", It prints "You've chosen: No"
//     - Change the integer option:
//          int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?", null, JOptionPane.YES_OPTION);
