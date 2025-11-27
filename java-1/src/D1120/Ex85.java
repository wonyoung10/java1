package D1120;
import javax.swing.*;
import java.awt.*;

public class Ex85 extends JFrame {

    public Ex85() {
        super("GridLayout 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        contentPane.setLayout(new GridLayout(4,3));

        for(int i =0;i<10;i++) {
            if(i == 9){
                JButton button = new JButton("+");
                contentPane.add(button);
            }
            String text = Integer.toString(i);
            JButton button = new JButton(text);
            contentPane.add(button);
        }
        JButton button = new JButton("-");
                contentPane.add(button);
        setSize(500,200);
        setVisible(true);
    }
 public static void main(String[] args) {
    new Ex85();
 }   
}
