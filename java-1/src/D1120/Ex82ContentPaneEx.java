package D1120;
import javax.swing.*;
import java.awt.*;

public class Ex82ContentPaneEx extends JFrame{
    
    public Ex82ContentPaneEx() {
        setTitle("ContentPane과 JFrame 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.ORANGE);
        contentPane.setLayout(new FlowLayout());

        contentPane.add(new JButton("OK"), BorderLayout.CENTER);
        contentPane.add(new JButton("Cancel"),BorderLayout.EAST);
        contentPane.add(new JButton("Ignore"),BorderLayout.SOUTH);
        contentPane.add(new JButton("OK"),BorderLayout.WEST);
        contentPane.add(new JButton("Cancel"),BorderLayout.NORTH);
        setSize(300,150);
        setVisible(true);
    }
        
    public static void main(String[] args) {
        new Ex82ContentPaneEx();        


    }
    
}
