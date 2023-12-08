package javaApplication;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RequestFrame {
	
public JFrame frame04;
    
    public RequestFrame() {
        initialize();
    }
    private void initialize() {
        Cursor cu=new Cursor(Cursor.HAND_CURSOR);
        frame04 = new JFrame();
        frame04.setBounds(100, 100, 1000, 600);
        frame04.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame04.getContentPane().setLayout(null);
        

        JLabel u0 = new JLabel("Book Name:");
        u0.setFont(new Font("Arial", Font.BOLD, 12));
        u0.setForeground(Color.BLACK);
        u0.setBounds(50, 50, 100, 50);
        frame04.getContentPane().add(u0);

        JLabel u1 = new JLabel("Author Name:");
        u1.setFont(new Font("Arial", Font.BOLD, 12));
        u1.setForeground(Color.BLACK);
        u1.setBounds(50, 150, 100, 50);
        frame04.getContentPane().add(u1);

        JLabel u2 = new JLabel("Phone no:");
        u2.setFont(new Font("Arial", Font.BOLD, 12));
        u2.setForeground(Color.BLACK);
        u2.setBounds(50, 250, 100, 50);
        frame04.getContentPane().add(u2);

        JTextField af0 = new JTextField();
        af0.setBounds(160, 50, 500, 50);
        af0.setToolTipText("please enter book name");
        af0.setColumns(10);
        frame04.getContentPane().add(af0);

        JTextField af1 = new JTextField();
        af1.setBounds(160, 150, 500, 50);
        af1.setToolTipText("please enter Author name");
        af1.setColumns(10);
        frame04.getContentPane().add(af1);

        JTextField af2 = new JTextField();
        af2.setBounds(160, 250, 500, 50);
        af2.setToolTipText("please enter your phone no");
        af2.setColumns(10);
        frame04.getContentPane().add(af2);
        
        JButton submit = new JButton("Submit");
                    submit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (af0.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, "please enter book name");

                            }
                            else if (af1.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, "please enter author name");

                            }
                            else if (af2.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, "please enter your phone no");

                            }
                            else {
                                String n0 = af0.getText().toString();
                                String n1 = af1.getText().toString();
                                int n2 = Integer.valueOf(af2.getText().toString());
                                Request cu=new Request(n0,n1,n2);
                                String r=cu.toString();
                                writeRecordToFileForRequest(r);
       
                                af0.setText("");
                                af1.setText("");
                                af2.setText("");
           
                                frame04.setVisible(false);
                                JOptionPane.showMessageDialog(null, "Submission Completed");
                                
                            }
                        }
                    });
                    submit.setBounds(800, 480, 100, 50);
                    submit.setCursor(cu);
                    frame04.getContentPane().add(submit);
                    
                    JButton cancel = new JButton("Cancel");
                    cancel.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            af0.setText("");
                            af1.setText("");
                            af2.setText("");
                            frame04.setVisible(false);
                        }

                    });
                    cancel.setBounds(690, 480, 100, 50);
                    cancel.setCursor(cu);
                    frame04.getContentPane().add(cancel);
    }
    public void writeRecordToFileForRequest(String record) {
        try {
            FileWriter writer = new FileWriter("D://RequestRecordsFile.txt",true);
            writer.write(record);
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
	
}
