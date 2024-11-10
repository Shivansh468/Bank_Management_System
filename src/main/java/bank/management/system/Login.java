package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.text.*;
import bank.management.system.Signup1;


public class Login extends JFrame implements ActionListener{
    JButton Login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setLayout(null);
        
        setTitle("AUTOMATED TELLER MACHINE");
     
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/logo1-2.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel text= new JLabel("Welcome to ATM");
        text.setFont(new Font("osward", Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel cardno = new JLabel("Card No");
        cardno.setFont(new Font("Raleway", Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);
        
        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,230,30);
        add(cardTextField);
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);
        
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        add(pinTextField);
        
        Login=new JButton("SIGN IN");
        Login.setBounds(300,300,100,30);
        Login.setBackground(Color.WHITE);
        Login.setForeground(Color.BLACK);
        Login.addActionListener(this);
        add(Login);
        
        clear= new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.WHITE);
        clear.setForeground(Color.BLACK);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("SIGN UP");
        signup.setBounds(340,350,150,30);
        signup.setBackground(Color.WHITE);
        signup.setForeground(Color.BLACK);
        signup.addActionListener(this);
        add(signup);
        
        pinTextField.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
                if (str == null) return;
                if ((getLength() + str.length()) <= 4) {
                    super.insertString(offset, str, a);
                }
            }
        });
        
        
        getContentPane().setBackground(Color.darkGray);
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if (ae.getSource()== Login){
            Conn conn=new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"'and pinnumber = '"+pinnumber+"'";
            try{
                ResultSet rs =conn.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new transactions(pinnumber).setVisible(true);
                    
                } else {
                    JOptionPane.showMessageDialog(null,"incorrect pin or card number");
                }
              
                
            } catch (Exception e){
                System.out.println(e);
            }

        }else if (ae.getSource()==signup){
            setVisible(false);
            new Signup1().setVisible(true);
        }
    }
    public static void main(String args[]){
        new Login();
    }
}
