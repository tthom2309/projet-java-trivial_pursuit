package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import exception.BirthdayGamerException;
import exception.EmailGamerException;
import utility.Encrypt;

/**
 * This class allows to create objects gamer wich contains informations about gamers.
 * The attribut StatGamer contains a set of informations against gamer's statistiques of game. 
 * The encrypt of the gamer's password is generated with as key the gamer's birthdate because it can't be changed.
 * @author Christophe Decroos
 *
 */
public class Gamer implements Serializable
{
	private static final long serialVersionUID = 1L;
	private static int nbGamer = 0;
	private String login;
	private String password;
	private String email;
	private String firstName;
	private String surName ;
	private String dateBirth;
	private StatGamer statg;
	
	
	/**
	 * 
	 * @param login
	 * @param password
	 * @param email
	 * @param firstName
	 * @param surName
	 * @param dateBirth
	 * @throws BirthdayGamerException
	 * @throws EmailGamerException 
	 */
	public Gamer(String login, String password, String email, String firstName, String surName, String dateBirth) throws BirthdayGamerException, EmailGamerException 
	{
		this.login = login;
		this.password = password;
		setEmail(email);
		this.firstName = firstName;
		this.surName = surName;
		setDateBirth(dateBirth);
		nbGamer++;
		statg = new StatGamer(nbGamer,nbGamer); // Le joueur sera placé en fin de classement, ce sera donc											  
											    // le dernier élément du classement par victoire et du classement par points.
	}
	
	public static int getNbGamer() 
	{
		return nbGamer;
	}
	
	public String getLogin()
	{
		return login;
	}
	
	public String getPasswordEncrypted() 
	{
		return password;
	}
	
	public String getPasswordDecrypted()
	{
		String passwordDecrypted = Encrypt.decryptionString(dateBirth, password);
		return passwordDecrypted;
	}
	
	public String getEmail()
	{
		return email;
	}

	public String getFirstName() 
	{
		return firstName;
	}
	
	public String getSurName() 
	{
		return surName;
	}
	
	public String getDateBirth() 
	{
		return dateBirth;
	}

	public StatGamer getStatg() 
	{
		return statg;
	}

	public static void setNbGamer(int nbUser)
	{
		Gamer.nbGamer = nbUser;
	}

	public void setLogin(String login) 
	{
		this.login = login;
	}

	public void setPassword(String password) 
	{
		this.password = Encrypt.encryptionString(dateBirth, password);
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public void setSurName(String surName)
	{
		this.surName = surName;
	}

	/**
	 * @author Romain V
	 * @param dateBirth
	 * @throws BirthdayGamerException 
	 */
	public void setDateBirth(String dateBirth) throws BirthdayGamerException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dateBirth = dateBirth.replaceAll("\\s", ""); //supprime tout les espaces dans la date	
        Date d = new Date();
        try 
        {
            d = sdf.parse(dateBirth); // transforme mon s en un format date complexe 
            String t = sdf.format(d); // retransforme la date complexe en un format simple
            if(t.compareTo(dateBirth) !=  0) // on compare les deux
                throw new BirthdayGamerException();
            else
                this.dateBirth = dateBirth;
        } 
        catch (Exception e) 
        {
        	throw new BirthdayGamerException();
                
        }
		
	}
	
	/**
	 * 
	 * @param email
	 * @author Romain V
	 * @throws EmailGamerException 
	 */
	public void setEmail(String email) throws EmailGamerException 
	{
		boolean verify = false;
		for(int i=0;i<email.length();i++)
			if(email.charAt(i) == '@')
				verify = true;
		
		if(verify)
			this.email = email;
		else
			throw new EmailGamerException();
	}
	

	public void setStatg(StatGamer statg) 
	{
		this.statg = statg;
	}

	public boolean equals(Object o)
	{
		if(o instanceof Gamer)
			return this.login.equals(((Gamer)o).getLogin());
		return false;
	}
	
	/**
	 * @author Romain V
	 * @param o
	 * @return
	 */
	public boolean equalsLogin(String log, String pass)
	{
		
		return this.login.equals(log) && this.password.equals(pass);
		
	}

	
	
	
	
	
	
	
	
	
	
	

}
