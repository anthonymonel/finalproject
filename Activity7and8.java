import java.awt.event.*;
import javax.swing.*;

public class Activity7and8_JOptionPane_Espijon {

    public static void main(String[] args) {
        JFrame f = new JFrame("Home");
        JButton b1 = new JButton("Register here");
        JLabel l1 = new JLabel("Welcome to my system");
        JLabel l2 = new JLabel("You need to register first");
        JFrame f2 = new JFrame("Registration");
        JTextField tf1 = new JTextField("");
        JTextField tf2 = new JTextField("");
        JLabel uname = new JLabel("Enter username:");
        JLabel upass = new JLabel("Enter password:");
        JButton b2 = new JButton("Proceed");
        JFrame f3 = new JFrame("Login");
        JTextField tf3 = new JTextField("");
        JTextField tf4 = new JTextField("");
        JLabel name = new JLabel("Enter username:");
        JLabel pass = new JLabel("Enter password:");
        JCheckBox cb1 = new JCheckBox("I agree with all your terms and conditions");
        JRadioButton r1 = new JRadioButton ("Change Password");
        JButton b3 = new JButton("Login");

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to register?", "Registration",JOptionPane.YES_NO_OPTION);
                if (result == 0) {
                    f2.setVisible(true); 
                    f.setVisible(false); 
                }
            }
        });
        
		final String[] registeredUsername = {""}; 
		final String[] registeredPassword = {""}; 
		class NewPass {
		    String newPassword; 
		}

		final NewPass newPass = new NewPass();
		
		b2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String usname = tf1.getText();
		        String uspass = tf2.getText();
		
		        if (usname.isEmpty() || uspass.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please fill in both username and password fields.", "Error", JOptionPane.ERROR_MESSAGE);
		        } else {
		
		            if (newPass.newPassword != null && !newPass.newPassword.isEmpty()) {
		                uspass = newPass.newPassword;
		            }
		
		            storeRegistrationInfo(usname, uspass, registeredUsername, registeredPassword);
		
		            int regcomplete = JOptionPane.showConfirmDialog(null, "Are you sure of the details?", "Question", JOptionPane.YES_NO_OPTION);
		            if (regcomplete == 0) {
		                JOptionPane.showMessageDialog(null, "Congrats! You may now proceed to Login");
		                f2.setVisible(false);
		                f3.setVisible(true);
		            } else {
		                tf1.setText("");
		                tf2.setText("");
		            }
		        }
		    }
		
		    private void storeRegistrationInfo(String usname, String uspass, String[] registeredUsername, String[] registeredPassword) {
		        registeredUsername[0] = usname;
		        registeredPassword[0] = uspass;
		    }
		});

		
		b3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (!cb1.isSelected()) {
		            JOptionPane.showMessageDialog(null, "Please check the terms and conditions first!", "Error", JOptionPane.ERROR_MESSAGE);
		        } else {
		            String enteredUsername = tf3.getText();
		            String enteredPassword = tf4.getText(); 
		
		            if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
		                JOptionPane.showMessageDialog(null, "Please fill in both username and password fields.", "Error", JOptionPane.ERROR_MESSAGE);
		            } else if (cb1.isSelected() && enteredUsername.equals(registeredUsername[0]) && 
		                (newPass.newPassword != null && enteredPassword.equals(newPass.newPassword))) { 
		                JOptionPane.showMessageDialog(null, "Congrats! Login Successfully");
		            } else if (cb1.isSelected() && enteredUsername.equals(registeredUsername[0]) && 
		                (newPass.newPassword == null || newPass.newPassword.isEmpty()) && enteredPassword.equals(registeredPassword[0])) {
		                JOptionPane.showMessageDialog(null, "Congrats! Login Successfully");
		            } else {
		                JOptionPane.showMessageDialog(null, "Wrong username and password!", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        }
		    }
		});


		r1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String newPasswordInput = JOptionPane.showInputDialog(null, "Enter your new password:", "Change Password", JOptionPane.INFORMATION_MESSAGE);
		
		        if (newPasswordInput != null) {
		            newPass.newPassword = newPasswordInput;
		            r1.setSelected(false); 
		            JOptionPane.showMessageDialog(null, "Congrats! Password has been changed!");
		        }
		    }
		});

        f.setLayout(null);
        f.setVisible(true);
        f2.setLayout(null);
        f2.setVisible(false);
		f3.setLayout(null);
        f3.setVisible(false);

        f.setBounds(650,200,400,400);
        l1.setBounds(120,5,250,100);
        l2.setBounds(120,180,250,100);
        b1.setBounds(120,250,150,50);
        
       	f2.setBounds(650,200,400,400);
       	tf1.setBounds(120,100,150,30);
       	tf2.setBounds(120,165,150,30);
       	uname.setBounds(10,100,150,30);
       	upass.setBounds(10,165,150,30);
       	b2.setBounds(150,250,100,30);
       	
      	f3.setBounds(650,200,400,400);
       	tf3.setBounds(120,100,150,30);
       	tf4.setBounds(120,165,150,30);
       	name.setBounds(10,100,150,30);
       	pass.setBounds(10,165,150,30);
       	b3.setBounds(150,300,100,30);
       	cb1.setBounds(80,210,300,30);
       	r1.setBounds(80,250,300,30);

        f.add(l1);
        f.add(l2);
        f.add(b1);
        
        f2.add(tf1);
        f2.add(tf2);
        f2.add(uname);
        f2.add(upass);
        f2.add(b2);
        
        f3.add(tf3);
        f3.add(tf4);
        f3.add(name);
        f3.add(pass);
        f3.add(b3); 
        f3.add(cb1);
        f3.add(r1);     
    }
}
