package D1120;

import javax.swing.*;
import java.awt.*;

public class Ex86 extends JFrame{
    public Ex86() {
        setTitle("배치관리자 없이 절대 위치에 배치하는 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        JLabel la = new JLabel("Hello, Press Buttons!");
        la.setLocation(130,50);
        la.setSize(200,20);
        contentPane.add(la);

        JButton b = new JButton("click");
        b.setBounds(30,100,80,20);
        contentPane.add(b);

        setSize(300,200);
        setVisible(true);
    }    
    public static void main(String[] args) {
        new Ex86();
    }
}
