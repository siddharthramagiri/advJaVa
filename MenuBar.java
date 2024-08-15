import javax.swing.*;

class Frame1 extends JFrame {
    JLabel l1;
    JMenuBar menubar;
    JMenu fileMenu,editMenu,viewMenu,helpMenu; 

    Frame1 () {
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        viewMenu = new JMenu("View");
        helpMenu = new JMenu("Help");

        JMenuItem newFile = new JMenuItem("New");
        JMenuItem openFile = new JMenuItem("Open folder");
        JMenuItem saveFile = new JMenuItem("Save File");
        JMenuItem closeFile = new JMenuItem("Close");
        
        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(closeFile);

        menubar = new JMenuBar();
        menubar.add(fileMenu);
        menubar.add(editMenu);
        menubar.add(viewMenu);
        menubar.add(helpMenu);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setJMenuBar(menubar);
        this.setSize(500,500);
        this.setVisible(true);
    }
}

public class MenuBar {
    public static void main(String[] args) {
        Frame1 f1 = new Frame1();
    }
}
