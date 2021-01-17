package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;







import model.*;
import exception.*;
import utility.Serialisation;
import utility.SpringUtilities;

public class PanelJoueur extends JPanel
{
	
	
	private static final long serialVersionUID = 1L;
	private PanelNewPlayer panelNewPlayer;
	private PanelJoueurEntry panelJoueurEntry;
	private PanelButton panelButton;
	private CardLayout cl;
	private ManageUsers listUsers;
	
	public PanelJoueur()
	{
		this.setLayout(new BorderLayout());
		
		
		this.add(getPanelJoueurEntry(), BorderLayout.NORTH);
		this.add(getPanelNewPlayer(),BorderLayout.CENTER);
		this.add(getPanelButton(), BorderLayout.SOUTH);
				
		
				
	}
			

	public PanelButton getPanelButton()
	{
		if(panelButton == null)
			panelButton = new PanelButton();
		return panelButton;
	}

	



	public CardLayout getCl() 
	{
		if(cl == null)
			cl = new CardLayout();
		return cl;
			
	}
	
	
	public PanelNewPlayer getPanelNewPlayer() 
	{
		if(panelNewPlayer == null)
		{
			panelNewPlayer = new PanelNewPlayer();
			
		}
		return panelNewPlayer;
	}


	public PanelJoueurEntry getPanelJoueurEntry()
	{
		if(panelJoueurEntry == null)
			panelJoueurEntry = new PanelJoueurEntry();
		return panelJoueurEntry;
	}


	public ManageUsers getListUsers() 
	{
		if(listUsers == null)
			listUsers = Serialisation.retrieveManageUsers(new File("Data/sauve.XML"));
		return listUsers;
	}


	


	

	

}



class PanelButton extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton jbValider, jbAnnuler;
	
	public PanelButton()
	{
		
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.add(getJbAnnuler());
		this.add(getJbValider());
		
		
	}

	public JButton getJbValider() 
	{
		if(jbValider == null)
		{
			jbValider = new JButton("Enter");
			jbValider.addActionListener(this);
			
			
		}
		return jbValider;
	}

	public JButton getJbAnnuler()
	{
		if(jbAnnuler == null)
		{
			jbAnnuler = new JButton("Cancel");
			jbAnnuler.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
				{
					PanelCartes pc = (PanelCartes)SwingUtilities.getAncestorOfClass(PanelCartes.class,PanelButton.this);
					pc.getCl().show(pc, "Start");
					
				}
				
			});
		}
		
		return jbAnnuler;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// Permet de verifier toutes les entrées du formulaire
		
		PanelJoueur pj = (PanelJoueur)SwingUtilities.getAncestorOfClass(PanelJoueur.class,PanelButton.this);
		
		//on selectionne le panneau du formulaire et on lance la verification
		
		
		try
		{
			Gamer player = pj.getPanelNewPlayer().verifyFormAndGetIt();
			
			//on recupere le manageUsers et on y ajoute le nouveau joueur
			pj.getListUsers().addGamer(player);
			
			// on enregistre cette liste
			Serialisation.saveManageUsers(pj.getListUsers(), new File("Data/sauve.XML")); 
			
			
			//ensuite on affiche le panneau de jeu
			PanelCartes pc = (PanelCartes)SwingUtilities.getAncestorOfClass(PanelCartes.class,PanelButton.this);
			pc.getCl().show(pc,"Game");
			
			
			
		} catch (BirthdayGamerException | EmailGamerException| FieldEmptyException | PlayerExistsAlreadyException e1) 
		{
			
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Pas de création", JOptionPane.ERROR_MESSAGE);
		}
		
		
		
			
		
		
		
	}
	
}


class PanelJoueurEntry extends JPanel implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	private JRadioButton jrNewPlayer, jrExistsPlayer;
	
	
	
	
	public PanelJoueurEntry()
	{
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createTitledBorder("Player"));
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(getJrNewPlayer());
		bg.add(getJrExistsPlayer());
		this.add(getJrNewPlayer());
		this.add(getJrExistsPlayer());
		
		
		
		
		
	}
	

	public JRadioButton getJrNewPlayer()
	{
		if(jrNewPlayer == null)
		{
			jrNewPlayer = new JRadioButton("New Player",true);
			jrNewPlayer.setBackground(Color.WHITE);
			jrNewPlayer.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(jrNewPlayer.isEnabled());
					{
						// on affiche le formulaire et on active le bouton valider
						PanelJoueur pj = (PanelJoueur)SwingUtilities.getAncestorOfClass(PanelJoueur.class,PanelJoueurEntry.this);
						pj.getPanelNewPlayer().setVisible(true);
						pj.getPanelButton().getJbValider().setEnabled(true);
						
					}
						
					
				}
				
			});
		}
		return jrNewPlayer;
	}

	public JRadioButton getJrExistsPlayer()
	{
		if(jrExistsPlayer == null)
		{
			jrExistsPlayer = new JRadioButton("Log In", false);
			jrExistsPlayer.setBackground(Color.WHITE);
			jrExistsPlayer.addActionListener(this);
			
		}
		return jrExistsPlayer;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(jrExistsPlayer.isEnabled());
		{
			//on recupere le panelJoueur
			
			PanelJoueur pj = (PanelJoueur)SwingUtilities.getAncestorOfClass(PanelJoueur.class,PanelJoueurEntry.this);
			pj.getPanelNewPlayer().setVisible(false); 
			
			//on desactive le bouton valider, il ne sert pas dans ce cas
			pj.getPanelButton().getJbValider().setEnabled(false);
			
			
			//creation du panel login
			
			PanelLogin panelLogin = new PanelLogin();
			int option = panelLogin.isVerifyLoginAdmin();
			
			if (option == 1 || option == 2) // si la connection est validée alors on ouvre la page de jeu
			{
				
				Window fenetre = (Window)SwingUtilities.getAncestorOfClass(Window.class, PanelJoueurEntry.this);
				fenetre.getPanelCartes().getCl().show(fenetre.getPanelCartes(), "Game");
			}
					
			
		}
		
		
	}
	
	
}


class PanelNewPlayer extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField jtLogin, jtMail, jtFirstName, jtSurName, jtBirthday;
	private JPasswordField jtPass;
	
	
	public PanelNewPlayer()
	{
		this.setBorder(BorderFactory.createTitledBorder("Registry"));
		this.setBackground(Color.WHITE);
		this.setLayout(new SpringLayout());
		String[] label = {"Login", "Password", "E-mail", "First Name", "Last Name", "Birthday"};
		JTextField[] field = {getJtLogin(), getJtPass(), getJtMail(), getJtFirstName(), getJtSurName(), getJtBirthday()};
		
		for(int i=0;i<label.length;i++)
		{
			this.add(new JLabel(label[i], JLabel.TRAILING));
			this.add(field[i]);
			field[i].setMaximumSize(field[i].getPreferredSize());
			
		}
		SpringUtilities.makeCompactGrid(this,label.length,2,15,15,15,15);	

	
	}
	
	public Gamer verifyFormAndGetIt() throws BirthdayGamerException, EmailGamerException, FieldEmptyException, PlayerExistsAlreadyException
	{
		Gamer player = null;
		PanelJoueur pj = (PanelJoueur)SwingUtilities.getAncestorOfClass(PanelJoueur.class,PanelNewPlayer.this);
		
		//on verifie qu'aucun champ n'est nul
		if(!(jtLogin.getText().length() == 0 || new String(jtPass.getPassword()).length() == 0 || jtFirstName.getText().length() == 0 || jtMail.getText().length() == 0 || jtSurName.getText().length() == 0 || jtBirthday.getText().length() == 0))
		{	
			
			//on cree le nouveau joueur, on voit si une exception se propage ou si le joueur est créé
			player = new Gamer(jtLogin.getText(), new String(jtPass.getPassword()), jtMail.getText(), jtFirstName.getText(), jtSurName.getText(),jtBirthday.getText());
			
		}
		else
		{
			//cas où un des champs est vide
			throw new FieldEmptyException();
			
		}
		
		
		//Ensuite si on est ici, le joueur est créé il faut ensuite verifier qu'il n'existe pas déjà pour le login
		if(pj.getListUsers().contains(jtLogin.getText()))
		{
			jtLogin.setText(""); //on efface le login et le password
			jtPass.setText("");
			throw new PlayerExistsAlreadyException();
		}
		return player;
		
	}
	
	
	
	public JTextField getJtLogin() 
	{
		if(jtLogin == null)
		{
			jtLogin = new JTextField();
			jtLogin.setPreferredSize(new Dimension(200,20));
		}
		return jtLogin;
	}

	public JPasswordField getJtPass()
	{
		if(jtPass == null)
			jtPass = new JPasswordField();
		return jtPass;
	}

	public JTextField getJtMail() 
	{
		if(jtMail == null)
			jtMail = new JTextField();
		return jtMail;
	}

	public JTextField getJtFirstName()
	{
		if(jtFirstName == null)
			jtFirstName = new JTextField();
		return jtFirstName;
	}

	public JTextField getJtSurName()
	{
		if(jtSurName == null)
			jtSurName = new JTextField();
		return jtSurName;
	}

	public JTextField getJtBirthday()
	{
		if(jtBirthday == null)
			jtBirthday = new JTextField("x x / x x / x x x x");
		return jtBirthday;
	}

	
	
}
