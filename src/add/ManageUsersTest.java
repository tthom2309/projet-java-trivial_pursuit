package add;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.List;

import model.Administrator;
import model.Dice;
import model.Gamer;
import model.ManageUsers;
import model.Question;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.Explorateur;

public class ManageUsersTest
{
	Administrator admin;
	Gamer gamer1,gamer2,gamer3;
	ManageUsers manageUsers;
	List<Gamer> users;

	@Before
	public void setUp() throws Exception 
	{
		admin = Administrator.getInstance();
		gamer1 = new Gamer("toto01", "helha01", "toto01@student.helha.be", "Reporter", "Tintin", "28/04/1998");
		gamer2 = new Gamer("toto02", "helha02", "toto02@student.helha.be", "Haddock", "Archibald", "21/04/1969");
		gamer3 = new Gamer("toto03", "helha03", "toto03@student.helha.be", "Tournesol", "Tryphon", "30/04/1975");
		manageUsers = ManageUsers.getInstance();
		users = (List<Gamer>)Explorateur.getField(manageUsers,"users");
	}

	@After
	public void tearDown() throws Exception 
	{
		// Les 3 instructions suivantes permettent de tester n'importe quel Singleton grâce à l'introspection.
		Field instance = ManageUsers.class.getDeclaredField("instance");// On récupère l'attribut "instance".
		// que l'on place dans un objet "Field".
		instance.setAccessible(true); // On rend l'objet "Field" accessible.
		instance.set(null, null);// On donne la valeur null à l'attribut "instance".
		manageUsers = null; // On donne la valeur null au référent de l'instance.
	}

	@Test
	public void testGetInstance() 
	{
		assertTrue(manageUsers == ManageUsers.getInstance());
	}
	
	@Test
	public void testGetUsers()
	{
		users.add(gamer1);users.add(gamer2);users.add(gamer3);
		assertTrue(users.equals(manageUsers.getUsers()));
	}
	
	@Test
	public void testAddGamer()
	{
		manageUsers.addGamer(gamer1);
		assertTrue(users.contains(gamer1));
	}
	
	@Test
	public void testRemoveGamer()
	{
		users.add(gamer1);users.add(gamer2);
		manageUsers.removeGamer(gamer1);
		assertTrue(!users.contains(gamer1) && users.contains(gamer2));
	}
	
	@Test
	public void testSetGamer()
	{
		users.add(gamer1);users.add(gamer2);
		manageUsers.setGamer(gamer1, gamer3);
		assertTrue(users.contains(gamer2) && users.contains(gamer3) && !users.contains(gamer1));
	}
	
	@Test
	public void testContains()
	{
		users.add(gamer1);
		assertTrue(manageUsers.contains("toto01") && !manageUsers.contains("toto02"));
	}
	
	@Test
	public void testTestLoginInfos()
	{
		users.add(gamer1);
		assertTrue(manageUsers.testLoginInfos(gamer1.getLogin(), gamer1.getPasswordEncrypted()));
	}
	
	@Test
	public void testTestNbGamer()
	{
		users.add(gamer1);users.add(gamer2);
		assertTrue(manageUsers.nbGamer()==users.size());
	}
	
	@Test
	public void testGetGamerByLog()
	{
		users.add(gamer1);users.add(gamer2);
		assertTrue(gamer2 == manageUsers.getGamer(1));
	}

}
