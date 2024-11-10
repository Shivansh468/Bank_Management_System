package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class MiniStatement extends JFrame implements ActionListener{
    JButton back;
    
    MiniStatement(String pinnumber){
        
        
        setTitle("Mini Statement");
        setLayout(null);
        
        JLabel mini= new JLabel();
        mini.setBounds(20,180,400,195);
        add(mini);
        
        JLabel bank= new JLabel("Bank Statement");
        bank.setFont(new Font("Raleway", Font.BOLD, 18));
        bank.setBounds(120,20,200,30);
        add(bank);
        
        JLabel card= new JLabel();
        card.setBounds(20,120,300,20);
        add(card);
        
        JLabel bal = new JLabel();
        bal.setBounds(20, 400, 300, 25);
        add(bal);
        
        back = new JButton("Cancel");
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.addActionListener(this);
        back.setBounds(250,500,100,30);
        
        add(back);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pinnumber ='"+pinnumber+"' ");
            while (rs.next()){
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0,3) + "XXXX" + rs.getString("cardnumber").substring(7,10));
            }
            
        } catch (Exception e){
            System.out.println(e);
        }
        
        try{
            
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin ='"+pinnumber+"' ");
            while(rs.next()){
                mini.setText(mini.getText()+ "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
            }
            
        } catch (Exception e){
            System.out.println(e);
        
        }
        
        Conn c = new Conn();
        int balance=0;
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                while (rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                        
                } 
                bal.setText("Your current account balance is: " + balance);
                
            } catch (Exception e){
                    System.out.println(e);
                    
            }
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        
    }
    
    public static void main(String args[]){
        new MiniStatement("");
        
    }
    
}
