package Lab01.hust.soict.ict.lab01;
import javax.swing.JOptionPane;
public class InputDialog {
    public static void main(String args[]){
        String result;
        result = JOptionPane.showInputDialog("Tran Nam Duong 20210263 - Enter your name");
        JOptionPane.showMessageDialog(null, "Hi " + result + "!");
        System.exit(0);
    }
}
