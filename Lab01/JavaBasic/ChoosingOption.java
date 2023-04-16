import javax.swing.JOptionPane;
public class ChoosingOption {
    public static void main(String args[]){
        Object[] options={"I do", "I don't"};
        int option = JOptionPane.showOptionDialog(null, "Do you want to change to the first class ticket?", "Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        JOptionPane.showMessageDialog(null, "You have chosen: " + (option == JOptionPane.YES_OPTION ? "I Do" : "No"));
        System.exit(0);
    }
}
