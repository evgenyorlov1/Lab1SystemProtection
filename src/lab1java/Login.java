/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;


public class Login {
    
    private static JFrame frame;
    
    public Login() {
	frame = new JFrame("Login");
	frame.setSize(300, 140);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
	frame.add(panel);
	placeComponents(panel);

        frame.setVisible(true);        
        frame.setResizable(false);
    }        
        
    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

	JLabel userLabel = new JLabel("User");
	userLabel.setBounds(10, 10, 80, 25);
	panel.add(userLabel);

	JTextField userText = new JTextField(20);
	userText.setBounds(100, 10, 160, 25);
	panel.add(userText);

	JLabel passwordLabel = new JLabel("Password");
	passwordLabel.setBounds(10, 40, 80, 25);
	panel.add(passwordLabel);

	JPasswordField passwordText = new JPasswordField(20);
	passwordText.setBounds(100, 40, 160, 25);
	panel.add(passwordText);

	JButton loginButton = new JButton("login");
	loginButton.setBounds(10, 80, 80, 25);
	panel.add(loginButton);
        
        loginButton.addActionListener(new ActionListener() {                        

            @Override
            public void actionPerformed(ActionEvent e) {
                
                String user;
                char[] password;
                boolean check = false;                
                
                user = userText.getText();
                password = passwordText.getPassword();                                
                
                FileOutput file = new FileOutput();
                ArrayList<String[]> users = new ArrayList();                
                users = file.getCSV();                
                String[] User = new String[4];
                
                for(int i=0; i<users.size(); i++) {                    
                    if(((String)users.get(i)[0]).equals(user) && ((String)users.get(i)[1]).equals(String.valueOf(password))) {
                        check = true;
                        User[0] = users.get(i)[0];
                        User[1] = users.get(i)[1];
                        User[2] = users.get(i)[2];
                        User[3] = users.get(i)[3];
                        break;
                    }                                            
                }
                                                
                if (check) {                    
                    if(User[0].equals("ADMIN")){
                        new AdminGui();
                        frame.setVisible(false);
                        frame.dispose();
                    }
                    else {
                        if(User[2].equals("-")) {
                            new UserGui(User);
                            frame.setVisible(false);
                            frame.dispose();
                        }
                        else {
                            userText.setText("");
                            passwordText.setText("");
                            JOptionPane.showMessageDialog(null, "User is blocked");                    
                        }
                    }                    
                }
                else {
                    userText.setText("");
                    passwordText.setText("");
                    JOptionPane.showMessageDialog(null, "Incorrect login information");                    
                }
            }
        });
				
    }

}