package view;


import java.io.File;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import utility.Serialisation;
import model.Administrator;
import model.Gamer;
import model.ManageUsers;

public class PanelLogin extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	private boolean isValide;
	private JTextField jtLog;
	private JPasswordField jPass;
	
	private ManageUsers listUsers;
	
	private Gamer player;
	
	public PanelLogin()
	{
		
		this.add(new JLabel("Login :"));
		this.add(getJtLog());
		this.add(new JLabel("Password :"));
		this.add(getjPass());
		
		
		
		
	}
	
	
	public ManageUsers getListUsers() 
	{
		if(listUsers == null)
			listUsers = Serialisation.retrieveManageUsers(new File("Data/sauve.XML"));
		return listUsers;
	}
	
	
	
	
	public void setPlayer(Gamer player)
	{
		this.player = player;;
	}
	
	public Gamer getPlayer()
	{
		return player;
	}


	public JTextField getJtLog() 
	{
		if(jtLog == null)
			jtLog = new JTextField(10);
		return jtLog;
	}


	public JPasswordField getjPass()
	{
		if(jPass == null)
			jPass = new JPasswordField(10);
		return jPass;
	}


	public int isVerifyLoginAdmin()
	{
		// 0 si false, 1 si true, 2 si Admin
		
		String[] options = {"OK", "Cancel"};
		int option = 0;
		Administrator admin = Administrator.getInstance();
		int verification = 0;
		Gamer playerVerified;
		
		
		while((!isValide) && option == 0) // boucle tant qu'on ne clique pas sur cancel ou tant que le mdp et login sont incorrects
		{
			option = JOptionPane.showOptionDialog(null, this, "Log in", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			
			if(option == 0) // Si option = OK
			{
				
				//on test les utilisateurs avec le mot de passe et le login envoyé
				if(getListUsers().testLoginInfos(jtLog.getText(),new String(jPass.getPassword())))
				{
					isValide = true;
					verification = 1;
					playerVerified = listUsers.getGamerByLog(jtLog.getText());
					setPlayer(playerVerified);
				}
				else if(admin.getLogin().equals(jtLog.getText())  && admin.getPasswordDecrypted().equals(new String(jPass.getPassword())))
				{
					
					isValide = true;	
					verification = 2;
					
				}
				else
				{	
					JOptionPane.showMessageDialog(null, "Wrong login or password, please try again", "Pas de création", JOptionPane.ERROR_MESSAGE);
					//on vide les champs de connection
					jPass.setText("");
					jtLog.setText("");
					
					
				}
			}
		   
		}
		
		return verification;

		
		
	}


}



