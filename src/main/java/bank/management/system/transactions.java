package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class transactions extends JFrame implements ActionListener{
    
    JButton deposit, withdraw, fastcash, ministatement, pinchange, checkbalance, exit;
    String pinnumber;
    transactions(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        setTitle("Home Page");
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,900,900);
        add(label);
        
        JLabel text= new JLabel("Please select your Trasaction");
        text.setBounds(207,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD, 18));
        label.add(text);
        
        deposit = new JButton("Desposit");
        deposit.setFont(new Font("Raleway", Font.BOLD, 14));
        deposit.setBounds(150,415,150,30);
        deposit.addActionListener(this);
        label.add(deposit);
        
        withdraw = new JButton("Withdraw");
        withdraw.setFont(new Font("Raleway", Font.BOLD, 14));
        withdraw.setBounds(372,415,150,30);
        withdraw.addActionListener(this);
        label.add(withdraw);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setFont(new Font("Raleway", Font.BOLD, 14));
        fastcash.setBounds(150,450,150,30);
        fastcash.addActionListener(this);
        label.add(fastcash);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setFont(new Font("Raleway", Font.BOLD, 14));
        ministatement.setBounds(372,450,150,30);
        ministatement.addActionListener(this);
        label.add(ministatement);
        
        pinchange = new JButton("PIN Change");
        pinchange.setFont(new Font("Raleway", Font.BOLD, 14));
        pinchange.setBounds(150,485,150,30);
        pinchange.addActionListener(this);
        label.add(pinchange);
        
        checkbalance= new JButton("Balance Enquiry");
        checkbalance.setFont(new Font("Raleway", Font.BOLD, 14));
        checkbalance.setBounds(372,485,150,30);
        checkbalance.addActionListener(this);
        label.add(checkbalance);
        
        
        exit= new JButton("Exit");
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
            System.exit(0);
            
        } else if (ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
            
        
        } else if (ae.getSource()==withdraw){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
            
        
        }  else if (ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
            
        
        }   else if (ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
            
        
        }    else if (ae.getSource()==checkbalance){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
            
        
        } else if (ae.getSource()==ministatement){
            new MiniStatement(pinnumber).setVisible(true);
            
        
        }
    }
    
    
    public static void main (String args[]){
        new transactions("");
        
    }
}