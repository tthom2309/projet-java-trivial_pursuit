package model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import utility.Serialisation;
import exception.BirthdayGamerException;
import exception.EmailGamerException;

/**
 * This class allows to stock the object Administrator and all the object Gamer for the purpose of
 * to can save it into a XML File.
 * @author Christophe Decroos
 */
public class ManageUsers extends Observable implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Administrator admin;
	private List<Gamer> users;
	private static ManageUsers instance = null;
	
	private ManageUsers()
	{
		//admin = Administrator.getInstance();
		users = new ArrayList<Gamer>();
	}
	
	/**
	 * This method allows to create single instance of ManageUsers (Pattern Singleton).
	 * @author Christophe Decroos
	 * @return ManageUsers
	 */
	public static ManageUsers getInstance()
	{
		if(instance == null)
			instance = Serialisation.retrieveManageUsers(new File("Data/sauve.xml"));
		return instance;
	}
	
	public Administrator getAdmin()
	{
		
		if(admin == null)
			admin = Administrator.getInstance();
		return admin;
	}

	public List<Gamer> getUsers() 
	{
		List<Gamer> l = new ArrayList<Gamer>();
		
		for(Gamer gamer : users)
		{
			Gamer g = null;
			try {
				g = new Gamer(gamer.getLogin(), gamer.getPasswordEncrypted(), gamer.getEmail(), gamer.getFirstName(), gamer.getSurName(), gamer.getDateBirth());
			} catch (BirthdayGamerException | EmailGamerException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			l.add(g);
		}
		
		return l;	
	}
	
	public Gamer getGamer(int index)
	{
		return users.get(index);
	}

	/**
	 * This method allows to add a Gamer at the List of Gamer. If the List contains already Gamer,
	 * the method return false.
	 * @author Christophe Decroos
	 * @param gamer
	 * @return boolean
	 */
	public boolean addGamer(Gamer gamer)
	{
		if(!users.contains(gamer))
		return users.add(gamer);
		return false;
	}
	
	/**
	 * This method allows to remove a Gamer from the List of Gamer. If the List doesn't contains Gamer,
	 * the method return false.
	 * @author Christophe Decroos
	 * @param gamer
	 * @return boolean
	 */
	public boolean removeGamer(Gamer gamer)
	{
		return users.remove(gamer);
	}
	
	/**
	 * This method allows to replace a Gamer in the List by another. The method return the previously Gamer,
	 * and if it isn't exist, the method return null.
	 * @author Christophe Decroos
	 * @param oldGamer
	 * @param newGamer
	 * @return Gamer
	 */
	public Gamer setGamer(Gamer oldGamer, Gamer newGamer)
	{
		int index = users.indexOf(oldGamer);
		return users.set(index, newGamer);
	}
	
	/**
	 * This method allows to verify that the List of Gamer contains a Gamer with have got the value
	 * of login in its attribut login. If the List doesn't contain a Gamer with this condition, the method return false.
	 * @param login
	 * @return boolean
	 */
	public boolean contains(String login)
	{	
		for(Gamer gamer : users)
		{
			if(gamer.getLogin().equals(login))		
				return true;
			
		}
		return false;
	}
	
	
	public boolean testLoginInfos(String login, String password)
	{
		for(Gamer gamer : users)
			if( gamer.equalsLogin(login, password))
				return true;
		return false;
	}
	
	public int nbGamer()
	{
		return users.size();
	}
	
	
	public Gamer getGamerByLog(String login)
	{
		for(Gamer gamer : users)
		{
			if(gamer.getLogin().equals(login))		
				return gamer;
			
		}
		return null;
		
	}


	
	
}
