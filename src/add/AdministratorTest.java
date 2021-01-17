package add;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import model.Administrator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AdministratorTest
{
	Administrator admin;

	@Before
	public void setUp() throws Exception
	{
		admin = Administrator.getInstance();
	}

	@After
	public void tearDown() throws Exception
	{
		// Les 3 instructions suivantes permettent de tester n'importe quel Singleton grâce à l'introspection.
		Field instance = Administrator.class.getDeclaredField("instance");// On récupère l'attribut "instance".
		// que l'on place dans un objet "Field".
		instance.setAccessible(true); // On rend l'objet "Field" accessible.
		instance.set(null, null);// On donne la valeur null à l'attribut "instance".
		admin = null; // On donne la valeur null au référent de l'instance.
	}

	@Test
	public void testGetInstance() 
	{
		assertTrue(admin == Administrator.getInstance());
	}
	
}
