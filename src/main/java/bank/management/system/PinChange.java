package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;



public class PinChange extends JFrame implements ActionListener {
    
    JPasswordField newpin, renewpin;
    JButton back, change;
    String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,900,900);
        add(label);
        
        JLabel text= new JLabel("CHANGE YOUR PIN:");
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(164,300,500,30);
        label.add(text);
        
        JLabel pintext= new JLabel("New PIN");
        pintext.setFont(new Font("Raleway", Font.BOLD, 16));
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(164,360,500,30);
        label.add(pintext);
        
        newpin =new JPasswordField();
        newpin.setFont(new Font("Raleway", Font.BOLD, 14));
        newpin.setBounds(160,390,150,30);
        label.add(newpin);
        
        JLabel repintext= new JLabel("Re-enter your PIN");
        repintext.setFont(new Font("Raleway", Font.BOLD, 16));
        repintext.setForeground(Color.WHITE);
        repintext.setBounds(164,435,500,30);
        label.add(repintext);
        
        renewpin =new JPasswordField();
        renewpin.setFont(new Font("Raleway", Font.BOLD, 14));
        renewpin.setBounds(160,465,150,30);
        label.add(renewpin);
        
        change = new JButton("Change");
        change.setFont(new Font("Raleway", Font.BOLD, 14));
        change.setBounds(372,485,150,30);
        change.addActionListener(this);
        label.add(change);
        
        back = new JButton("Back");
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.setBounds(372,520,150,30);
        back.addActionListener(this);
        label.add(back);
        
        setMaxLengthWithFilter(4, newpin, renewpin);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
       if (ae.getSource()==change){
            try{
            String npin = newpin.getText();
            String rpin = renewpin.getText();
            
                if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Your pin does not match");
                return;
               
                }
                
                if (npin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter New Pin");
                
                } else if (rpin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Re-enter your Pin");
                
                }
                
                Conn conn = new Conn();
                String query1= "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query2= "update login set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
                String query3= "update signup3 set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null,"Pin Changed Successfully");
                setVisible(false);
                new transactions(rpin).setVisible(true);
                
            
            } catch (Exception e){
                System.out.println(e);
            
        
            }
       } else if (ae.getSource()==back){
           setVisible(false);
           new transactions(pinnumber).setVisible(true);
       }
               
    }
    
    public static void setMaxLengthWithFilter(int maxLength, JTextField... fields) {
        for (JTextField field : fields) {
            PlainDocument doc = (PlainDocument) field.getDocument();
            doc.setDocumentFilter(new DocumentFilter() {
                @Override
                public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                    if (fb.getDocument().getLength() + text.length() <= maxLength) {
                        super.insertString(fb, offset, text, attr);  // Allow text insertion if length is within the limit
                    }
                }

                @Override
                public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                    if (fb.getDocument().getLength() + text.length() - length <= maxLength) {
                        super.replace(fb, offset, length, text, attrs);  // Allow text replacement if length is within the limit
                    }
                }
            });
        }
    }
    
    public static void main(String srgs[]){
        new PinChange("").setVisible(true);
        
    }
    
}
