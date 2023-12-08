package javaApplication;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class AdminPage {
	
	public JFrame frame02;
    JTextArea textArea = new JTextArea();

    public AdminPage()  {
        admin();
    }
    private void admin() {
        frame02 = new JFrame();
        frame02.setBounds(100, 100, 1000, 600);
        frame02.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame02.getContentPane().setLayout(null);
        Cursor cu=new Cursor(Cursor.HAND_CURSOR);
        
        JLabel u0 = new JLabel("Code:");
        u0.setFont(new Font("Arial", Font.BOLD, 12));
        u0.setForeground(Color.BLACK);
        u0.setBounds(710,10,100,50);
        frame02.getContentPane().add(u0);
        
        JLabel u = new JLabel("Book's Name:");
        u.setFont(new Font("Arial", Font.BOLD, 12));
        u.setForeground(Color.BLACK);
        u.setBounds(50,10,200,50);
        frame02.getContentPane().add(u);
        
        JLabel uAu = new JLabel("Author's Name:");
        uAu.setFont(new Font("Arial", Font.BOLD, 12));
        uAu.setForeground(Color.BLACK);
        uAu.setBounds(300,10,200,50);
        frame02.getContentPane().add(uAu);
        
        JLabel u1 = new JLabel("Price:");
        u1.setFont(new Font("Arial", Font.BOLD, 12));
        u1.setForeground(Color.BLACK);
        u1.setBounds(600,10,100,50);
        frame02.getContentPane().add(u1);
        
        JTextField af0=new JTextField();
        af0.setBounds(710,50,60,50);
        af0.setToolTipText("please add a code");
        af0.setColumns(10);
        frame02.getContentPane().add(af0);
        
        JTextField af1=new JTextField();
        af1.setBounds(50,50,200,50);
        af1.setToolTipText("please add a book");
        af1.setColumns(10);
        frame02.getContentPane().add(af1);
        
        JTextField afAu=new JTextField();
        afAu.setBounds(300,50,200,50);
        afAu.setToolTipText("please add Author name");
        afAu.setColumns(10);
        frame02.getContentPane().add(afAu);
        
        JTextField af2=new JTextField();
        af2.setBounds(600,50,100,50);
        af2.setToolTipText("please add price");
        af2.setColumns(10);
        frame02.getContentPane().add(af2);
        
        JButton logout = new JButton("LOGOUT");
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                BookShopManagementSystem window01 = new BookShopManagementSystem();
                window01.frame.setVisible(true);
                frame02.setVisible(false);
            }
        });

        logout.setBounds(800, 11, 90, 23);
        logout.setCursor(cu);
        frame02.getContentPane().add(logout);
        
        
        
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEnabled(false);
        textArea.setDisabledTextColor(Color.BLACK);
        textArea.setBounds(50,200, 900, 300);
        frame02.getContentPane().add(textArea);
        
        readRecordFromFile();
        
        JScrollPane scrollBar = new JScrollPane(textArea);
        scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollBar.setHorizontalScrollBarPolicy(
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        frame02.getContentPane().add(scrollBar);
        scrollBar.setBounds(50, 180, 800,300);
        
        JButton addButton=new JButton("add");
        addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String au=afAu.getText().toString();
                int c=Integer.valueOf(af0.getText().toString());
                String n=af1.getText().toString();
                double p=Double.valueOf(af2.getText().toString());
                Book b=new Book(c,n,p,au);
                String booksRecord = b.toString();
                writeRecordToFile(booksRecord);
                textArea.setText("");
                readRecordFromFile();
                af0.setText("");
                af1.setText("");
                af2.setText("");
                afAu.setText("");
            }
        
        });
        addButton.setBounds(50,110,100,50);
        addButton.setCursor(cu);
        frame02.getContentPane().add(addButton);
    }
    //write the record to csv file
    public void writeRecordToFile(String record) {
        try {
            FileWriter writer = new FileWriter("D://RecordsFile.txt", true);
            writer.write(record);// writing the record

            JOptionPane.showMessageDialog(frame02, "Book and price has been stored in csv file.");

            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public void readRecordFromFile(){
        try {
            Scanner sc = new Scanner(new File("D://RecordsFile.txt"));
            sc.useDelimiter(",");
            int j=0;
            while (sc.hasNext()) 
            {
                j++;
                textArea.append(sc.next()); 
                if(j==1){
                    textArea.append(". ");
                }
                if(j==2){
                    textArea.append("--");
                }
                if(j==3){
                    textArea.append("   ");
                    
                }
                if(j==4){
                    textArea.append("/=");
                }
                if(j==5){
                    j=0;
                }
            }
            sc.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

}
