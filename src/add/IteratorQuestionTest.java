package add;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Category;
import model.IteratorQuestion;
import model.Question;

import org.junit.After;
import org.junit.Before;

import org.junit.Test;

import exception.IndexNegativeException;
import exception.IndexTooHighException;
import test.Explorateur;
// TODO Peut être à compléter avec l'introspection...
public class IteratorQuestionTest 
{
	private IteratorQuestion it;
	private List<Question> list;
	
	
	@Before
	public void setUp() throws Exception 
	{
		List<Question> listQ = new ArrayList<Question>();
		
		listQ.add(new Question("Decroos Christophe","In what hemisphere is located the  tropic of Cancer?",Category.GEOGRAPHY));
		listQ.add(new Question("Decroos Christophe","Usually, when can you watch the Australian open ?",Category.ENTERTAINMENT));
		listQ.add(new Question("Decroos Christophe","Where Jesus was born ?",Category.HISTORY));
		listQ.add(new Question("Decroos Christophe","Who is the « father » of the cummunism",Category.BUSINESS));
		listQ.add(new Question("Decroos Christophe","How many are there planet into the solar system ?",Category.SCIENCE_NATURE));
		listQ.add(new Question("Decroos Christophe","How many times Eddy Mercks won « Le tour de France » ?",Category.SPORT_LEISURE));
		listQ.add(new Question("Decroos Christophe","How measure the Earth's circumference ?",Category.GEOGRAPHY));
		listQ.add(new Question("Decroos Christophe","In wich planet Darth Vader was born ?",Category.ENTERTAINMENT));
		listQ.add(new Question("Decroos Christophe","Who was the president of USA during the Second World War ?",Category.HISTORY));
		listQ.add(new Question("Decroos Christophe","What’s the income of a shareholder ?",Category.BUSINESS));
		listQ.add(new Question("Decroos Christophe","What is the nearest star of the sun ?",Category.SCIENCE_NATURE));
		listQ.add(new Question("Decroos Christophe","Wich football club won the most time the football cup of Belgium ?",Category.SPORT_LEISURE));
		listQ.add(new Question("Decroos Christophe","What is the capital city of Kenya?",Category.GEOGRAPHY));
		listQ.add(new Question("Decroos Christophe","In wich game can you pull the black ball ?",Category.ENTERTAINMENT));
		listQ.add(new Question("Decroos Christophe","Who was the last king of France ?",Category.HISTORY));
		listQ.add(new Question("Decroos Christophe","What is the element that isn’t a primary need ?",Category.BUSINESS));
		listQ.add(new Question("Decroos Christophe","What is the lowest temperature that can exist ?", Category.SCIENCE_NATURE));
		listQ.add(new Question("Decroos Christophe","What is the nationality of stanislas wawrinka ?",Category.SPORT_LEISURE));
		
		it = new IteratorQuestion(listQ);
		list=(List<Question>)Explorateur.getField(it,"list");
	}

	@After
	public void tearDown() throws Exception 
	{
		it = null;
		list = null;
	}

	@Test
	public void testgetItem() 
	{
		assertTrue(list.get(0).equals(it.getItem()));
	}
	
	@Test
	public void testHasNext() 
	{
		assertTrue(it.hasNext());
	}
	
	@Test
	public void testHasPrevious() 
	{
		assertTrue(it.hasPrevious());
	}
	
	@Test
	public void testNext()
	{
		assertTrue(it.next().equals(list.get(0)));
	}
	
	@Test
	public void testPrevious()
	{
		assertTrue(it.previous().equals(list.get(0)));
	}
	
	@Test
	public void testIteratorOrdreCroissant()
	{
		List<Question> listQ = new ArrayList<Question>();
		
		while(it.hasNext())
		{
			listQ.add(it.next());
		}
		
		assertTrue(listQ.equals(list));
	}
	
	@Test
	public void testIteratorOrdreDecroissant()
	{
		List<Question> listQ = new ArrayList<Question>();
		
		try {
			it.setIndex(list.size()-1);
		} catch (IndexNegativeException e) {
			e.printStackTrace();
		} catch (IndexTooHighException e) {
			e.printStackTrace();
		}
		
		while(it.hasPrevious())
		{
			listQ.add(it.previous());
		}
		
		Collections.reverse(listQ);
		assertTrue(listQ.equals(list));
	}

	
}
