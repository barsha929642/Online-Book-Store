//Barsha Talukdar
//Tashdid Al Nahian
//Farhana Islam


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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;


public class BookShopManagementSystem {
	
	public JFrame frame;
    public JFrame frame01,frame03;
    JTextArea textArea01 = new JTextArea();
    JTextArea textArea02 = new JTextArea();
    public double sum=0,ad=0,ad1=0;
    

    public BookShopManagementSystem() {
        initialize();
    }

    private void initialize() {
    	copyFileClean();
        copyMainFile();
        Cursor cu=new Cursor(Cursor.HAND_CURSOR);
        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel heading = new JLabel("Online Book Store");
        heading.setFont(new Font("Cooper Black", Font.BOLD, 30));
        heading.setForeground(Color.BLUE);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setBounds(350, 20, 300, 25);
        frame.getContentPane().add(heading);
        
        JButton login = new JButton("ADMIN LOGIN");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Login l=new Login();
                l.frame01.setVisible(true);
                frame.setVisible(false);
            }
        });

        login.setBounds(800, 11, 150, 25);
        login.setCursor(cu);
        frame.getContentPane().add(login);
        
        textArea01.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea01.setLineWrap(true);
        textArea01.setWrapStyleWord(true);
        textArea01.setEnabled(false);
        textArea01.setDisabledTextColor(Color.BLACK);
        textArea01.setBounds(50,100, 900, 300);
        frame.getContentPane().add(textArea01);
        
        readRecordFromFile();
        
        JScrollPane scrollBar = new JScrollPane(textArea01);
        scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollBar.setHorizontalScrollBarPolicy(
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        frame.getContentPane().add(scrollBar);
        scrollBar.setBounds(50, 100, 900,300);
        
        JLabel u = new JLabel("Choose the number of book:");
        u.setFont(new Font("Arial", Font.BOLD, 12));
        u.setForeground(Color.BLACK);
        u.setBounds(50,400,200,50);
        frame.getContentPane().add(u);
        
        JTextField a1=new JTextField();
        a1.setBounds(50,450,100,50);
        a1.setToolTipText("Enter the no of book");
        a1.setColumns(10);
        frame.getContentPane().add(a1);
        
        JButton add = new JButton("add");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (a1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please add a code of book");

                } 
                
                else {
                    
                    String n = a1.getText().toString();
                    int count = Integer.valueOf(n);
                    readRecordFromFileInfoForAddButton(count);
                    if(ad1==0){
                        
                        JOptionPane.showMessageDialog(null, "Incorrect code");
                    }
                    a1.setText("");
                }
            }
        });
        add.setBounds(150, 450, 100, 50);
        add.setCursor(cu);
        frame.getContentPane().add(add);
        
        JButton request = new JButton("request");
        request.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RequestFrame r=new RequestFrame();
                r.frame04.setVisible(true);
            }
        });
        request.setBounds(260, 450, 100, 50);
        request.setCursor(cu);
        frame.getContentPane().add(request);
        
        
        JButton Done = new JButton("Done");
        Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ad!=0){
                    ad=0;
                    ad1=0;
                    frame03 = new JFrame();
                    frame03.setBounds(100, 100, 1000, 600);
                    frame03.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame03.getContentPane().setLayout(null);
                    frame03.setVisible(true);
                    
                    textArea02.setFont(new Font("Serif", Font.ITALIC, 16));
                    textArea02.setLineWrap(true);
                    textArea02.setWrapStyleWord(true);
                    textArea02.setEnabled(false);
                    textArea02.setDisabledTextColor(Color.BLACK);
                    textArea02.setBounds(50,50, 800, 300);
                    readRecordFromFile02();
                    frame03.getContentPane().add(textArea02);
                    
                    JLabel u0 = new JLabel("Name:");
                    u0.setFont(new Font("Arial", Font.BOLD, 12));
                    u0.setForeground(Color.BLACK);
                    u0.setBounds(50, 360, 100, 50);
                    frame03.getContentPane().add(u0);
                    
                    JLabel u1 = new JLabel("Address:");
                    u1.setFont(new Font("Arial", Font.BOLD, 12));
                    u1.setForeground(Color.BLACK);
                    u1.setBounds(50, 420, 100, 50);
                    frame03.getContentPane().add(u1);
                    
                    JLabel u2 = new JLabel("Phone no:");
                    u2.setFont(new Font("Arial", Font.BOLD, 12));
                    u2.setForeground(Color.BLACK);
                    u2.setBounds(50, 480, 100, 50);
                    frame03.getContentPane().add(u2);
                    
                    JTextField af0 = new JTextField();
                    af0.setBounds(160, 360, 500, 50);
                    af0.setToolTipText("Please enter your name");
                    af0.setColumns(10);
                    frame03.getContentPane().add(af0);
                    
                    JTextField af1 = new JTextField();
                    af1.setBounds(160, 420, 500, 50);
                    af1.setToolTipText("Please enter your address");
                    af1.setColumns(10);
                    frame03.getContentPane().add(af1);
                    
                    JTextField af2 = new JTextField();
                    af2.setBounds(160, 480, 500, 50);
                    af2.setToolTipText("Please enter your phone no");
                    af2.setColumns(10);
                    frame03.getContentPane().add(af2);
                    
                    JButton submit = new JButton("Submit");
                    submit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (af0.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, "Please enter your name");

                            }
                            else if (af1.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, "Please enter your address");

                            }
                            else if (af2.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, "Please enter your phone no");

                            }
                            else {
                                String n0 = af0.getText().toString();
                                String n1 = af1.getText().toString();
                                int n2 = Integer.valueOf(af2.getText().toString());
                                Customer cu=new Customer(n0,n1,n2);
                                String r=cu.toString();
                                writeRecordToFileForCustomer(r);
                                String r1=textArea02.getText();
                                writeRecordToFileForCustomer(r1);
                                af0.setText("");
                                af1.setText("");
                                af2.setText("");
                                textArea02.setText("");
                                frame03.setVisible(false);
                                JOptionPane.showMessageDialog(null, "Submission Completed");
                                methodForSubmit();
                                textArea01.setText("");
                                
                                copyFileClean();
                                copyMainFile();
                                readRecordFromFile();
                            }
                        }
                    });
                    submit.setBounds(800, 480, 100, 50);
                    submit.setCursor(cu);
                    frame03.getContentPane().add(submit);
                    
                    JButton cancel = new JButton("Cancel");
                    cancel.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            copyFileClean();
                            copyMainFile();
                            try {
                                FileWriter writer = new FileWriter("D://sellRecordsFile.txt", false);
                                writer.write("");
                                writer.close();
                            } catch (IOException ex) {
                                System.out.println(ex);
                            }
                            try {
                                FileWriter writer = new FileWriter("D://RecordsFile01.txt", false);
                                writer.write("");
                                writer.close();
                            } catch (IOException ex) {
                                System.out.println(ex);
                            }
                            textArea02.setText("");
                            frame03.setVisible(false);
                        }

                    });
                    cancel.setBounds(690, 480, 100, 50);
                    cancel.setCursor(cu);
                    frame03.getContentPane().add(cancel);
                    
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please a add book");

                }
            }
        });
        Done.setBounds(800, 450, 100, 50);
        Done.setCursor(cu);
        frame.getContentPane().add(Done);
        
    }
    
    private void readRecordFromFile() {
        try {
            Scanner sc = new Scanner(new File("D://RecordsFile.txt"));
            sc.useDelimiter(",");
            int j=0;
            while (sc.hasNext()) 
            {
                j++;
                textArea01.append(sc.next());  
                if(j==1){
                    textArea01.append(". ");
                }
                if(j==2){
                    textArea01.append("--");
                }
                if(j==3){
                    textArea01.append("   ");
                    
                }
                if(j==4){
                    textArea01.append("/=");
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
    int n1 = 0;
    String s1;
    double d1;
    String au1;
    private void readRecordFromFileInfoForAddButton(int n) {
        
        try {
            Scanner sc = new Scanner(new File("D://RecordsFile.txt"));
            sc.useDelimiter(",");
            
            while (sc.hasNext())  
            {
                try{
                    n1=Integer.parseInt(sc.next());
                }catch(Exception ex){
                    n1=0;
                }
                
                if(n==n1){
                   
                    s1=sc.next();
                    au1=sc.next();
                    d1=sc.nextDouble();
                    
                    sum+=d1;
                    ad++;
                    ad1++;
                    writeRecordToFileforadd();
                    writeRecordToFile();
                    
                    
                }
            }
           
            sc.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
    public void writeRecordToFileforadd() {
        Book b = new Book(n1, s1, d1,au1);
        String record = b.toString();
        
        try {
            FileWriter writer = new FileWriter("D://sellRecordsFile.txt", true);
            writer.write(record);
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public void writeRecordToFile() {
        Book b = new Book(n1, s1, d1,au1);
        String record = b.toString();
        
       
        try {
            Scanner sc = new Scanner(new File("D://CopyOfRecord.txt"));
            sc.useDelimiter(",");
            int n2 =0;
            String s2;
            String au2;
            double d2;
            while (sc.hasNext()) 
            {
                try{
                    n2=Integer.parseInt(sc.next());
                }catch(Exception ex){
                    n2=0;
                }
                
                
                if(n2!=0){
                    s2=sc.next();
                    au2=sc.next();
                    
                    d2=sc.nextDouble();
                    
                    Book b1=new Book(n2,s2,d2,au2);
                    String Record = b1.toString();
                    if(!record.equals(Record)){
                        writeRecordToFile01(Record);
                    }
                    
                }
            }
           
            sc.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        
        try {
            FileWriter writer = new FileWriter("D://CopyOfRecord.txt", false);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        
        try {
            Scanner sc = new Scanner(new File("D://RecordsFile01.txt"));
            sc.useDelimiter(",");
            int n3 =0;
            String s3;
            String au3;
            double d3;
            while (sc.hasNext())  
            {
                try{
                    n3=Integer.parseInt(sc.next());
                }catch(Exception ex){
                    n3=0;
                }
                
                
                if(n3!=0){
                    s3=sc.next();
                    au3=sc.next();
                    d3=sc.nextDouble();
                    
                    Book b2=new Book(n3,s3,d3,au3);
                    String Record = b2.toString();
                    
                    copyFile(Record);
                    
                    
                }
            }
           
            sc.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        
        
        
        try {
            FileWriter writer = new FileWriter("D://RecordsFile01.txt", false);
            writer.write("");// writing the record
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        
        
    }
    public void readRecordFromFile02(){
        try {
            Scanner sc = new Scanner(new File("D://sellRecordsFile.txt"));
            sc.useDelimiter(",");   
            int j=0;
            while (sc.hasNext())  
            {
                j++;
                textArea02.append(sc.next());  
                if(j==1){
                    textArea02.append(". ");
                }
                if(j==2){
                    textArea02.append("--");
                }
                if(j==3){
                    textArea02.append("   ");
                    
                }
                if(j==4){
                    textArea02.append("/=");
                }
                if(j==5){
                    j=0;
                }
            }
            sc.close();
            textArea02.append("\nTotal = "+sum+" Taka only");
            sum=0;

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        
        try {
            FileWriter writer = new FileWriter("D://sellRecordsFile.txt",false);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        
        
    }
    public void writeRecordToFile01(String record) {
        try {
            FileWriter writer = new FileWriter("D://RecordsFile01.txt",true);
            writer.write(record);// writing the record
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public void writeRecordToMainFile(String record) {
        try {
            FileWriter writer = new FileWriter("D://RecordsFile.txt", true);
            writer.write(record);


            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public void writeRecordToFileForCustomer(String record) {
        try {
            FileWriter writer = new FileWriter("D://CustomerRecordsFile.txt",true);
            writer.write(record);
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public void methodForSubmit(){
       
        try {
            FileWriter writer = new FileWriter("D://RecordsFile.txt", false);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        
        try {
            Scanner sc = new Scanner(new File("D://CopyOfRecord.txt"));
            sc.useDelimiter(",");
            int n3 =0;
            String s3;
            String au3;
            double d3;
            while (sc.hasNext())   
            {
                try{
                    n3=Integer.parseInt(sc.next());
                }catch(Exception ex){
                    n3=0;
                }
                
                
                if(n3!=0){
                    s3=sc.next();
                    au3=sc.next();
                    
                    d3=sc.nextDouble();
                    
                    Book b2=new Book(n3,s3,d3,au3);
                    String Record = b2.toString();
                    
                    writeRecordToMainFile(Record);
                    
                    
                }
            }
           
            sc.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        
      
    }
    public void copyMainFile(){
        try {
            Scanner sc = new Scanner(new File("D://RecordsFile.txt"));
            sc.useDelimiter(",");
            int n2 =0;
            String s2;
            String au2;
            double d2;
            while (sc.hasNext())
            {
                try{
                    n2=Integer.parseInt(sc.next());
                }catch(Exception ex){
                    n2=0;
                }
                
                
                if(n2!=0){
                    s2=sc.next();
                    au2=sc.next();
                    d2=sc.nextDouble();
                    
                    Book b1 = new Book(n2, s2, d2,au2);
                    String Record = b1.toString();

                    copyFile(Record);

                }
            }

            sc.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
    public void copyFile(String record) {
        try {
            FileWriter writer = new FileWriter("D://CopyOfRecord.txt",true);
            writer.write(record);
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public void copyFileClean() {
        try {
            FileWriter writer = new FileWriter("D://CopyOfRecord.txt",false);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }


}
