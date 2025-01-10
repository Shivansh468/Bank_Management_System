package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Deposit extends JFrame implements ActionListener{
    
    JTextField depamount;
    JButton depo, back;
    String pinnumber;
            
    Deposit(String pinnumber) {
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        setTitle("Deposit Page");
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,900,900);
        add(label);
        
        JLabel amountdep= new JLabel("Enter the amount you want to deposit: ");
        amountdep.setFont(new Font("Raleway", Font.BOLD, 16));
        amountdep.setForeground(Color.WHITE);
        amountdep.setBounds(164,350,500,30);
        label.add(amountdep);
        
        depamount =new JTextField();
        depamount.setFont(new Font("Raleway", Font.BOLD, 14));
        depamount.setBounds(160,415,300,30);
        label.add(depamount);
        
        depo = new JButton("Deposit");
        depo.setFont(new Font("Raleway", Font.BOLD, 14));
        depo.setBounds(372,485,150,30);
        depo.addActionListener(this);
        label.add(depo);
        
        back = new JButton("Back");
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.setBounds(372,520,150,30);
        back.addActionListener(this);
        label.add(back);
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==depo){
            String depam= depamount.getText();
            Date date = new Date();
            if (depam.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            } else {
                try {
                    Conn conn= new Conn();
                    String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+depam+"') ";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+depam+" Deposited into your account Successfully");
                    setVisible(false);
                    new transactions(pinnumber).setVisible(true);
                
                } catch (Exception e){
                    System.out.println(e);
                }
                
            }
            
        } else if (ae.getSource()==back){
            setVisible(false);
            new transactions(pinnumber).setVisible(true);
        
        }
        
    }
    public static void main(String args[]){
        new Deposit("");
        
    }
}
