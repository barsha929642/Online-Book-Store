package javaApplication;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login {
	
	public JFrame frame01;

    public Login() {
        loginpart();
    }
    private void loginpart() {
        frame01 = new JFrame();
        frame01.setBounds(100, 100, 1000, 600);
        frame01.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame01.getContentPane().setLayout(null);
        
        JLabel u = new JLabel("Username:");
        u.setFont(new Font("Arial", Font.BOLD, 20));
        u.setForeground(Color.BLACK);
        u.setBounds(50,50,150,50);
        frame01.getContentPane().add(u);
        
        JTextField f1=new JTextField();
        f1.setBounds(170,50,200,50);
        f1.setToolTipText("Please enter your Username");
        frame01.getContentPane().add(f1);
        
        JLabel p=new JLabel("Password:");
        p.setFont(new Font("Arial", Font.BOLD, 20));
        p.setForeground(Color.BLACK);
        p.setBounds(50,110,150,50);
        frame01.getContentPane().add(p);
        
        JPasswordField p1=new JPasswordField();
        p1.setBounds(170,110,200,50);
        p1.setToolTipText("Please enter your Password");
        frame01.getContentPane().add(p1);
        
        Cursor cu=new Cursor(Cursor.HAND_CURSOR);
        JButton b1=new JButton("Login");
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               String u=f1.getText();
               String u1=p1.getText();
               if(u.equals("barsha") && u1.equals("100")){
                    AdminPage a=new AdminPage();
                    a.frame02.setVisible(true);
                    f1.setText("");
                    p1.setText("");
                    frame01.setVisible(false);
                    
               }
               else if(u.equals("") && u1.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter your Username and Password");

               }
               else{
                   JOptionPane.showMessageDialog(null,"Wrong username and password");
                   f1.setText("");
                   p1.setText("");
               }
            }
        
        });
        b1.setBounds(50,200,80,50);
        b1.setCursor(cu);
        frame01.getContentPane().add(b1);
        
        JButton b2=new JButton("Clear");
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                f1.setText("");
                p1.setText("");
            }
        
        });
        b2.setBounds(140,200,80,50);
        b2.setCursor(cu);
        frame01.getContentPane().add(b2);
    }

}
