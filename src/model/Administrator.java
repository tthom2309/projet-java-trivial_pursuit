package model;

import java.io.Serializable;

import utility.Encrypt;

/**
 * This class allows to create an object wich contains the root's login and the root's password
 * Attribut LOGIN contains the administrator's login, it can be changed.  
 * The encrypt of the root's password is generated with as key the root's login because it can't be changed.
 * @author Christophe Decroos
 */
public class Administrator implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	public static final String LOGIN = "admin";
	private static Administrator instance = null;
	
	private Administrator()
	{
		login = LOGIN;
		setPassword("helha");
	}
	
	/**
	 * This method allows to create single instance of Administrator (Pattern Singleton).
	 * @author Christophe Decroos
	 * @return Administrator
	 */
	public static Administrator getInstance()
	{
		if(instance == null)
			instance = new Administrator();
		return instance;
	}

	public String getLogin()
	{
		return login;
	}

	public String getPasswordDecrypted() 
	{
		String passwordDecrypted = Encrypt.decryptionString(login, password);
		return passwordDecrypted;
	}
	
	public String getPasswordEnCrypted()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = Encrypt.encryptionString(login, password);
	}
	
	
}
