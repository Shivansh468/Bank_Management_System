package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit, withdraw, fastcash, ministatement, pinchange, checkbalance, exit;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        setTitle("Fast Cash");
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,900,900);
        add(label);
        
        JLabel text= new JLabel("Please Choose Withdrawl Amount");
        text.setBounds(180,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD, 18));
        label.add(text);
        
        deposit = new JButton("Rs 100");
        deposit.setFont(new Font("Raleway", Font.BOLD, 14));
        deposit.setBounds(150,415,150,30);
        deposit.addActionListener(this);
        label.add(deposit);
        
        withdraw = new JButton("Rs 500");
        withdraw.setFont(new Font("Raleway", Font.BOLD, 14));
        withdraw.setBounds(372,415,150,30);
        withdraw.addActionListener(this);
        label.add(withdraw);
        
        fastcash = new JButton("Rs 1000");
        fastcash.setFont(new Font("Raleway", Font.BOLD, 14));
        fastcash.setBounds(150,450,150,30);
        fastcash.addActionListener(this);
        label.add(fastcash);
        
        ministatement = new JButton("Rs 2000");
        ministatement.setFont(new Font("Raleway", Font.BOLD, 14));
        ministatement.setBounds(372,450,150,30);
        ministatement.addActionListener(this);
        label.add(ministatement);
        
        pinchange = new JButton("Rs 5000");
        pinchange.setFont(new Font("Raleway", Font.BOLD, 14));
        pinchange.setBounds(150,485,150,30);
        pinchange.addActionListener(this);
        label.add(pinchange);
        
        checkbalance= new JButton("Rs 10000");
        checkbalance.setFont(new Font("Raleway", Font.BOLD, 14));
        checkbalance.setBounds(372,485,150,30);
        checkbalance.addActionListener(this);
        label.add(checkbalance);
        
        
        exit= new JButton("Back");
        exit.setFont(new Font("Raleway", Font.BOLD, 14));
        exit.setBounds(372,520,150,30);
        exit.addActionListener(this);
        label.add(exit);
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
     
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==exit){
            setVisible(false);
            new transactions(pinnumber).setVisible(true);
            
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance=0;
                while (rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                        
                    
                } 
                
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)){
                     
                    
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                
                }
                
                Date date= new Date();
                String query = "insert into bank values ('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited from your account Successfully");
                
                setVisible(false);
                new transactions(pinnumber).setVisible(true);
                
            } catch (Exception e){
                System.out.println(e);
                
            }
            
        } 
    }
    
    
    public static void main (String args[]){
        new FastCash("");
        
    }
}