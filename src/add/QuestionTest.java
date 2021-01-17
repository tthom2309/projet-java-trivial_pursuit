package add;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.Explorateur;
import model.Category;
import model.Question;

public class QuestionTest {
	private HashMap<String,Boolean>choices;
	private Question quest;
	private String answer;
	private String answer2;
	private String answer3;
	private String answer4;
	
	@Before
	public void setUp() throws Exception 
	{
		quest = new Question("Rochez Adrien","What is the capital city of Russia?",Category.GEOGRAPHY);
		choices = (HashMap<String, Boolean>)Explorateur.getField(quest, "choices");
		answer = "Moscow";
		answer2 = "Kiev";
		answer3 = "Sochi";
		answer4 = "Saint Petersburg";
	}

	@After
	public void tearDown() throws Exception 
	{
		quest = null;
		choices = null;
		answer = null;
		answer2 = null;
	}

	@Test
	public void testAddChoice() 
	{
		quest.addChoice(answer,true);
		assertTrue(choices.containsKey(answer));
		quest.addChoice(answer2,false);
		assertTrue(choices.containsKey(answer2));
		assertFalse(quest.addChoice(answer,true));// Ajout d'un doublon
		
	}

	@Test
	public void testRemoveChoice() 
	{
		choices.put(answer,true);
		quest.removeChoice(answer);
		assertFalse(choices.containsKey(answer));
	}

	@Test
	public void testVerify() 
	{
		assertFalse(quest.verify());
		choices.put(answer,true);
		choices.put(answer2,false);
		assertTrue(quest.verify());
		choices.put("Donesk",true); // Ajout de deux bonnes réponses
		assertFalse(quest.verify());
	}
	
	@Test
	public void testGetChoices()
	{
		choices.put(answer, true);
		choices.put(answer2, false);
		choices.put(answer3, false);
		choices.put(answer4, false);
		
		assertTrue(quest.getChoices().entrySet().containsAll(choices.entrySet()));
		// On place les deux map dans un set grâce à la méthode entrySet
		// Cela permet ensuite de comparer leursd éléments grâce à la méthode entrySet
	}
	
	@Test
	public void testEquals()
	{
		assertTrue(!new Question("Decroos Christophe", "What time is it?", Category.GEOGRAPHY).equals(quest));
	}
	
	

}

