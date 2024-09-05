import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class ViewInsertDelete extends JFrame implements ActionListener {
    JLabel l1, l2, l3, result;
    JTextArea t1, t2, t3, tbl;
    JButton insert, view, delete;

    public ViewInsertDelete() {
        this.setLayout(null);

        l1 = new JLabel("ID : ");
        t1 = new JTextArea(2, 200);
        l1.setBounds(30, 40, 40, 20);
        t1.setBounds(80, 40, 100, 20);
        this.add(l1);
        this.add(t1);

        l2 = new JLabel("NAME : ");
        t2 = new JTextArea(2, 200);
        l2.setBounds(220, 40, 60, 20);
        t2.setBounds(270, 40, 100, 20);
        this.add(l2);
        this.add(t2);

        l3 = new JLabel("Age : ");
        t3 = new JTextArea(2, 200);
        l3.setBounds(400, 40, 50, 20);
        t3.setBounds(450, 40, 100, 20);
        this.add(l3);
        this.add(t3);

        insert = new JButton("INSERT");
        view = new JButton("VIEW DATA");
        delete = new JButton("DELETE");
        insert.setBounds(100, 120, 100, 20);
        view.setBounds(250, 120, 100, 20);
        delete.setBounds(400, 120, 100, 20);
        add(insert);
        add(view);
        add(delete);

        result = new JLabel("OUTPUT");
        result.setBounds(300, 200, 400, 20);
        this.add(result);
        tbl = new JTextArea();
        tbl.setBounds(100, 240, 400, 300);
        this.add(tbl);

        // Button Action call
        insert.addActionListener(this);
        view.addActionListener(this);
        delete.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 600);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Buttons Activates");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root",
                    "AP36ag8381*");
            Statement st = conn.createStatement();
            if (e.getSource() == insert) {
                System.out.println("Insert Button Clicked");
                int id = Integer.parseInt(t1.getText());
                String name = t2.getText();
                int age = Integer.parseInt(t3.getText());
                String query = "INSERT INTO STUDENT VALUES(" + id + ",'" + name + "'," + age + ");";
                int r = st.executeUpdate(query);
                if (r == 1) {
                    System.out.println("Record Inserted");
                    result.setText("Inserted Record");
                } else {
                    System.out.println("Cant Insert Record");
                    result.setText("Cant Insert Record");
                }
            }

            if (e.getSource() == view) {

                String query = "SELECT * FROM STUDENT;";
                ResultSet rs = st.executeQuery(query);
                System.out.println("ID\tNAME\tAGE");
                String str = "";
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    int age = rs.getInt(3);
                    str = str + id + "\t" + name + "\t" + age + "\n";
                }
                System.out.println(str);
                tbl.setText(str);
            }

            if (e.getSource() == delete) {

            }

        } catch (ClassNotFoundException ex) {

            System.out.println(ex.getMessage());

        } catch (SQLException ex) {

            System.out.println("ERROR : " + ex.getMessage());

        }
    }

    public static void main(String[] args) {
        new ViewInsertDelete();
    }
}
