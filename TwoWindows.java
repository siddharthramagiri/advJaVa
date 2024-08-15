import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Frame2 extends JFrame implements ActionListener {
    JLabel l1;
    JLabel l2;
    JTextField t1;
    JTextField t2;
    JButton b1;
    JButton b2;
    JLabel Result;

    Frame2() {
        l1 = new JLabel("Username");
        l2 = new JLabel("Password");
        t1 = new JTextField(100);
        t2 = new JTextField(100);
        b1 = new JButton("Login");
        b2 = new JButton("Sign Up");
        this.add(l1);
        this.add(l2);
        this.add(t1);
        this.add(t2);
        this.add(b1);
        this.add(b2);
        Result = new JLabel();
        this.add(Result);

        b1.addActionListener(this);
        b2.addActionListener(this);
        this.setLayout(new FlowLayout());
        this.setTitle("Login Window");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(300, 300);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == b1) {
            Result.setText("Logging In");
        } else if (evt.getSource() == b2) {
            Result.setText("Signing In");
        }
    }
}

class Frame1 extends JFrame implements ActionListener {
    JButton b1;

    Frame1() {
        b1 = new JButton("Click to Open Window");
        b1.addActionListener(this);
        this.add(b1);

        this.setTitle("Main Window");
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == b1) {
            Frame2 f2 = new Frame2();
        }
    }

}

public class TwoWindows {
    public static void main(String[] args) {
        Frame1 f1 = new Frame1();
    }
}