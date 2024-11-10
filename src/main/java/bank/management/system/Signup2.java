package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener{
    
    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, income, eq, occupation;
    String formno;
    
    Signup2(String formno){
        this.formno=formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM PAGE.2");
        
       
        JLabel additonaldetails= new JLabel("Page 2: Additional Details");
        additonaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additonaldetails.setBounds(290,80,400,30);
        add(additonaldetails);
        
        JLabel name= new JLabel("Religion: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valreligion[]={"Hindu","Muslim", "Cristian", "Sikh", "Athiest", "Other"};
        religion= new JComboBox(valreligion);
        religion.setBounds(300,140,400,30);
        add(religion);
       
        JLabel cat= new JLabel("Category: ");
        cat.setFont(new Font("Raleway", Font.BOLD, 20));
        cat.setBounds(100,190,200,30);
        add(cat);
        
        String valcategory[]={"General","OBC", "SC","ST", "Other"};
        category= new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        add(category);
       
        JLabel in= new JLabel("Income: ");
        in.setFont(new Font("Raleway", Font.BOLD, 20));
        in.setBounds(100,240,200,30);
        add(in);
       
        String valincome[]={"null","<1,50,000", " 1,50,000-2,50,000"," 2,50,000-5,00,000", ">5,00,000"};
        income= new JComboBox(valincome);
        income.setBounds(300,240,400,30);
        add(income);
        
        JLabel edu= new JLabel("Educational ");
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        edu.setBounds(100,290,200,30);
        add(edu);
        
        JLabel qual= new JLabel("Qualification: ");
        qual.setFont(new Font("Raleway", Font.BOLD, 20));
        qual.setBounds(100,315,200,30);
        add(qual);
        
        String valeq[]={"Non-Graduate","Graduate", "Post-Graduate","Doctrate"};
        eq= new JComboBox(valeq);
        eq.setBounds(300,300,400,30);
        add(eq);
        
        JLabel occ= new JLabel("Occupation: ");
        occ.setFont(new Font("Raleway", Font.BOLD, 20));
        occ.setBounds(100,365,200,30);
        add(occ);
        
        String valoccupation[]={"Private Sector","Public Sector", "Self Employed","Student", "Unemployed"};
        occupation= new JComboBox(valoccupation);
        occupation.setBounds(300,365,400,30);
        add(occupation);
        
        JLabel PAN= new JLabel("PAN card no: ");
        PAN.setFont(new Font("Raleway", Font.BOLD, 20));
        PAN.setBounds(100,415,200,30);
        add(PAN);
        
        pan=new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300,415,400,30);
        add(pan);
        
        JLabel aadharcard= new JLabel("Aadhar card no: ");
        aadharcard.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharcard.setBounds(100,465,200,30);
        add(aadharcard);
        
        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300,465,400,30);
        add(aadhar);
        
        JLabel sc= new JLabel("Senior Citizen: ");
        sc.setFont(new Font("Raleway", Font.BOLD, 20));
        sc.setBounds(100,515,200,30);
        add(sc);
        
        syes= new JRadioButton("Yes");
        syes.setBounds(300,515,100,30);
        syes.setBackground(Color.white);
        add(syes);
        
        sno= new JRadioButton("No");
        sno.setBounds(450,515,120,30);
        sno.setBackground(Color.white);
        add(sno);
        
        JLabel EA= new JLabel("Existing Acc: ");
        EA.setFont(new Font("Raleway", Font.BOLD, 20));
        EA.setBounds(100,565,200,30);
        add(EA);
        
        eyes= new JRadioButton("Yes");
        eyes.setBounds(300,565,100,30);
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno= new JRadioButton("No");
        eno.setBounds(450,565,120,30);
        eno.setBackground(Color.white);
        add(eno);
        
        next=new JButton("Next");
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.DARK_GRAY);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String rel=(String) religion.getSelectedItem();
        String cat=(String) category.getSelectedItem();
        String in=(String) income.getSelectedItem();
        String education=(String) eq.getSelectedItem();
        String occ=(String) occupation.getSelectedItem();
        String seniorcitizen= null;
        if (syes.isSelected()){
            seniorcitizen="Yes";
        }else if (sno.isSelected()){
            seniorcitizen="No";
        }
        String EA= null;
        if (eyes.isSelected()){
            seniorcitizen="Yes";
        }else if (eno.isSelected()){
            seniorcitizen="No";
        }
        String span=pan.getText();
        String saadhar=aadhar.getText();
        
        try {
            Conn c= new Conn();
            String query="insert into signup2 values('"+formno+"','"+rel+"','"+cat+"','"+in+"','"+education+"','"+occ+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+EA+"')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new Signup3(formno).setVisible(true);
           
            
        } catch (Exception e) {
            System.out.println(e);
            
        }
        
        
    }
    public static void main(String args[]){
        new Signup2("");
    }
}

