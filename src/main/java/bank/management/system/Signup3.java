package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Signup3 extends JFrame implements ActionListener{
    
    
    JRadioButton savingacc, fdacc, currentacc, salaryacc;
    JCheckBox atm, inbanking, mobanking, alerts, cbook, estatement;
    JButton submit, cancel;
    String formno;
    
    Signup3(String formno){
        this.formno=formno;
        
        setLayout(null);
        
        
        JLabel l1= new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(290,80,400,30);
        add(l1);
        
        JLabel type= new JLabel("Account Type: ");
        type.setFont(new Font("Raleway", Font.BOLD, 20));
        type.setBounds(100,140,160,30);
        add(type);
        
        savingacc= new JRadioButton("Savings Account");
        savingacc.setBounds(100,190,160,30);
        savingacc.setBackground(Color.white);
        add(savingacc);
        
        fdacc= new JRadioButton("Fixed Deposit");
        fdacc.setBounds(280,190,180,30);
        fdacc.setBackground(Color.white);
        add(fdacc);
        
        currentacc= new JRadioButton("Current Account");
        currentacc.setBounds(100,230,160,30);
        currentacc.setBackground(Color.white);
        add(currentacc);
       
        salaryacc= new JRadioButton("Salary Account");
        salaryacc.setBounds(280,230,180,30);
        salaryacc.setBackground(Color.white);
        add(salaryacc);
        
        ButtonGroup groupaccount = new ButtonGroup();
        
        groupaccount.add(savingacc);
        groupaccount.add(fdacc);
        groupaccount.add(currentacc);
        groupaccount.add(salaryacc);
        
        JLabel card= new JLabel("Card Number: ");
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        card.setBounds(100,300,160,30);
        add(card);
        
        JLabel number= new JLabel("XXXX-XXXX-XXXX-2005 ");
        number.setFont(new Font("Raleway", Font.BOLD, 20));
        number.setBounds(275,300,300,30);
        add(number);
        
        JLabel carddetails= new JLabel("(your 16 digit card number) ");
        carddetails.setFont(new Font("Raleway", Font.PLAIN,12));
        carddetails.setBounds(100,320,200,20);
        add(carddetails);
        
        JLabel pin= new JLabel("PIN Number: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100,350,160,30);
        add(pin);
        
        JLabel pnumber= new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 20));
        pnumber.setBounds(275,350,300,30);
        add(pnumber);
        
        JLabel pindetails= new JLabel("(your 4 digit PIN number) ");
        pindetails.setFont(new Font("Raleway", Font.PLAIN,12));
        pindetails.setBounds(100,370,200,20);
        add(pindetails);
        
        JLabel services= new JLabel("Services Required: ");
        services.setFont(new Font("Raleway", Font.BOLD, 20));
        services.setBounds(100,420,200,30);
        add(services);
        
        atm =new JCheckBox("ATM CARD");
        atm.setBackground(Color.WHITE);
        atm.setFont(new Font("Raleway", Font.PLAIN,18));
        atm.setBounds(95,460,200,30);
        add(atm);
        
        inbanking =new JCheckBox("INTERNET BANKING");
        inbanking.setBackground(Color.WHITE);
        inbanking.setFont(new Font("Raleway", Font.PLAIN,18));
        inbanking.setBounds(350,460,200,30);
        add(inbanking);
        
        mobanking =new JCheckBox("MOBILE BANKING");
        mobanking.setBackground(Color.WHITE);
        mobanking.setFont(new Font("Raleway", Font.PLAIN,18));
        mobanking.setBounds(95,540,200,30);
        add(mobanking);
        
        alerts =new JCheckBox("EMAILS & SMS ALERTS");
        alerts.setBackground(Color.WHITE);
        alerts.setFont(new Font("Raleway", Font.PLAIN,18));
        alerts.setBounds(95,500,250,30);
        add(alerts);
        
        cbook =new JCheckBox("CHECK BOOK");
        cbook.setBackground(Color.WHITE);
        cbook.setFont(new Font("Raleway", Font.PLAIN,18));
        cbook.setBounds(350,500,200,30);
        add(cbook);
        
        estatement =new JCheckBox("E-STATEMENT");
        estatement.setBackground(Color.WHITE);
        estatement.setFont(new Font("Raleway", Font.PLAIN,18));
        estatement.setBounds(350,540,200,30);
        add(estatement);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.BLACK);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(220,660,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420,660,100,30);
        cancel.addActionListener(this);
        add(cancel);
       
        
        getContentPane().setBackground(Color.DARK_GRAY);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String acctype = null;
            if (savingacc.isSelected()){
                acctype="Savings Account";
            } else if (fdacc.isSelected()){
                acctype="Fixed Deposit";
            } else if (currentacc.isSelected()){
                acctype="Current Account";
            } else if (salaryacc.isSelected()){
                acctype="Salary Account";
            } 
            
            Random random = new Random();
            String cardnumber = ""+Math.abs((random.nextLong() % 900L) + 5040900000L);
            
            String pinnumber = ""+Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility = "";
            if (atm.isSelected()){
                facility = facility + "ATM CARD";
            } else if (inbanking.isSelected()){
                facility = facility + "INTERNET BANKING";
            } else if (mobanking.isSelected()){
                facility = facility + "MOBILE BANKING";
            } else if (alerts.isSelected()){
                facility = facility + "EMAILS & SMS ALERTS";
            } else if (cbook.isSelected()){
                facility = facility + "CHECK BOOK";
            } else if (estatement.isSelected()){
                facility = facility + "E-STATEMENT";
            } 
                
            try{
                if (acctype.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is required");
                    
                }else {
                    Conn conn = new Conn();
                    String query1="insert into signup3 values('"+formno+"', '"+acctype+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
                    String query2="insert into login values('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')";
                    
                    
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number:" + cardnumber + "\n Pin:" + pinnumber);
                    
                }
                
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                    
                
                
            } catch(Exception e){
                System.out.println(e);
            }
                
                
                
        } else if (ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
            
            
        }
    }

    public static void main(String args[]){
        new Signup3("");
    }
}

