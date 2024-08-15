import javax.swing.*;

class myFrame extends JFrame {
    JLabel L1;
    myFrame() {
        ImageIcon imgL1 = new ImageIcon("058db7ce44b613483cb3ef02a0580219.jpeg");
        L1 = new JLabel("Set Text");
        L1.setIcon(imgL1);
        this.add(L1);
        this.setIconImage(imgL1.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,800);
        this.setVisible(true);
    }
}

public class JFrame1st{
    public static void main(String[] args) {
        myFrame myFrame = new myFrame();
    }
}