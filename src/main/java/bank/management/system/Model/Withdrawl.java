package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField withamount;
    JButton with, back;
    String pinnumber;
            
    Withdrawl(String pinnumber) {
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        setTitle("Withdrawl Page");
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,900,900);
        add(label);
        
        JLabel amountwith= new JLabel("Enter the amount you want to withdraw: ");
        amountwith.setFont(new Font("Raleway", Font.BOLD, 16));
        amountwith.setForeground(Color.WHITE);
        amountwith.setBounds(164,350,500,30);
        label.add(amountwith);
        
        withamount =new JTextField();
        withamount.setFont(new Font("Raleway", Font.BOLD, 14));
        withamount.setBounds(160,415,300,30);
        label.add(withamount);
        
        with = new JButton("Withdraw");
        with.setFont(new Font("Raleway", Font.BOLD, 14));
        with.setBounds(372,485,150,30);
        with.addActionListener(this);
        label.add(with);
        
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
        if (ae.getSource()==with){
            String witham= withamount.getText();
            Date date = new Date();
            if (witham.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            } else {
                try {
                    Conn conn= new Conn();
                    String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+witham+"') ";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+witham+" Debited from your account Successfully");
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
        new Withdrawl("");
        
    }
}

