package add;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Category;
import model.Dice;
import model.Question;
import model.Stack;
import test.Explorateur;
import utility.Serialisation;


public class StackTest 
{
	private Stack stack;
	private Question q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,q13,q14,q15,q16,q17,q18;
	private List<Question> listQuestion;
	
	@Before
	public void setUp() throws Exception
	{
		stack = Stack.getInstance();
		listQuestion=(List<Question>)Explorateur.getField(stack,"listQuestion");
		
		q1=new Question("Decroos Christophe","In what hemisphere is located the  tropic of Cancer?",Category.GEOGRAPHY);
		q2=new Question("Decroos Christophe","Usually, when can you watch the Australian open ?",Category.ENTERTAINMENT);
		q3=new Question("Decroos Christophe","Where Jesus was born ?",Category.HISTORY);
		q4=new Question("Decroos Christophe","Who is the « father » of the cummunism",Category.BUSINESS);
		q5=new Question("Decroos Christophe","How many are there planet into the solar system ?",Category.SCIENCE_NATURE);
		q6=new Question("Decroos Christophe","How many times Eddy Mercks won « Le tour de France » ?",Category.SPORT_LEISURE);
		q7=new Question("Decroos Christophe","How measure the Earth's circumference ?",Category.GEOGRAPHY);
		q8=new Question("Decroos Christophe","In wich planet Darth Vader was born ?",Category.ENTERTAINMENT);
		q9=new Question("Decroos Christophe","Who was the president of USA during the Second World War ?",Category.HISTORY);
		q10=new Question("Decroos Christophe","What’s the income of a shareholder ?",Category.BUSINESS);
		q11=new Question("Decroos Christophe","What is the nearest star of the sun ?",Category.SCIENCE_NATURE);
		q12=new Question("Decroos Christophe","Wich football club won the most time the football cup of Belgium ?",Category.SPORT_LEISURE);
		q13=new Question("Decroos Christophe","What is the capital city of Kenya?",Category.GEOGRAPHY);
		q14=new Question("Decroos Christophe","In wich game can you pull the black ball ?",Category.ENTERTAINMENT);
		q15=new Question("Decroos Christophe","Who was the last king of France ?",Category.HISTORY);
		q16=new Question("Decroos Christophe","What is the element that isn’t a primary need ?",Category.BUSINESS);
		q17=new Question("Decroos Christophe","What is the lowest temperature that can exist ?", Category.SCIENCE_NATURE);
		q18=new Question("Decroos Christophe","What is the nationality of stanislas wawrinka ?",Category.SPORT_LEISURE);
	}

	@After
	public void tearDown() throws Exception 
	{
		q1=null;q2=null;q3=null;q4=null;q5=null;q6=null;q7=null;q8=null;q9=null;
		q10=null;q11=null;q12=null;q13=null;q14=null;q15=null;q16=null;q17=null;q18=null;
		
		// Les 3 instructions suivantes permettent de tester n'importe quel Singleton grâce à l'introspection.
		Field instance = Stack.class.getDeclaredField("instance");// On récupère l'attribut "instance".
		// que l'on place dans un objet "Field".
		instance.setAccessible(true); // On rend l'objet "Field" accessible.
		instance.set(null, null);// On donne la valeur null à l'attribut "instance".
		stack = null; // On donne la valeur null au référent de l'instance.
	}
	
	@Test
	public void testGetInstance()
	{
		assertTrue(Stack.getInstance()==stack);
	}
	
	@Test
	public void testAddQuestion()
	{
		stack.addQuestion(q1);
		assertTrue(listQuestion.contains(q1));
	}
	
	@Test
	public void testRemoveQuestionObj()
	{
		listQuestion.add(q1);listQuestion.add(q2);
		stack.removeQuestion(q2);
		assertTrue(!listQuestion.contains(q2));
	}
	
	@Test
	public void testRemoveQuestionInd()
	{
		listQuestion.add(q1);listQuestion.add(q2);
		stack.removeQuestion(1);
		assertTrue(!listQuestion.contains(q2));
	}
	
	@Test
	public void testGetQuestion()
	{
		listQuestion.add(q1);listQuestion.add(q2);
		assertTrue(stack.getQuestion(0)==q1);
	}
	
	@Test
	public void testNbrQuestion()
	{
		listQuestion.add(q1);listQuestion.add(q2);
		assertTrue(listQuestion.size()==stack.nombreQuestion());
	}
	
	@Test
	public void getRandomQuestionByCat()
	{
		listQuestion.add(q1);listQuestion.add(q2);listQuestion.add(q3);
		listQuestion.add(q4);listQuestion.add(q5);listQuestion.add(q6);
		listQuestion.add(q7);listQuestion.add(q8);listQuestion.add(q9);
		listQuestion.add(q10);listQuestion.add(q11);listQuestion.add(q12);
		listQuestion.add(q13);listQuestion.add(q14);listQuestion.add(q15);
		listQuestion.add(q16);listQuestion.add(q17);listQuestion.add(q18);
		
		Question q = stack.getRandomQuestionByCat(Category.GEOGRAPHY);
		
		assertTrue(q.getCategory()==Category.GEOGRAPHY);
	}



	@Test
	public void testReplaceQuestion()
	{
		listQuestion.add(q1);
		stack.replaceQuestion(q1,q2);
		assertFalse(listQuestion.contains(q1));
		assertTrue(listQuestion.contains(q2));
	}
	
	@Test
	public void testMixQuestion()
	{
		listQuestion.add(q1);listQuestion.add(q2);listQuestion.add(q3);listQuestion.add(q4);listQuestion.add(q5);listQuestion.add(q6);
		List<Question> list = new ArrayList<Question>();
		list.add(q1);list.add(q2);list.add(q3);list.add(q4);list.add(q5);list.add(q6);
		stack.mixQuestion();
		assertTrue(!listQuestion.equals(list));
	}
	
	@Test
	public void testGetListQuestion()
	{
		listQuestion.add(q1);listQuestion.add(q2);listQuestion.add(q3);
		listQuestion.add(q4);listQuestion.add(q5);listQuestion.add(q6);
		listQuestion.add(q7);listQuestion.add(q8);listQuestion.add(q9);
		listQuestion.add(q10);listQuestion.add(q11);listQuestion.add(q12);
		listQuestion.add(q13);listQuestion.add(q14);listQuestion.add(q15);
		listQuestion.add(q16);listQuestion.add(q17);listQuestion.add(q18);
		
		assertTrue(listQuestion.equals(stack.getListQuestion()));
	}
	
	@Test
	public void testgetQuestionCategory()
	{
		listQuestion.add(q1);listQuestion.add(q2);listQuestion.add(q3);
		listQuestion.add(q4);listQuestion.add(q5);listQuestion.add(q6);
		listQuestion.add(q7);listQuestion.add(q8);listQuestion.add(q9);
		listQuestion.add(q10);listQuestion.add(q11);listQuestion.add(q12);
		listQuestion.add(q13);listQuestion.add(q14);listQuestion.add(q15);
		listQuestion.add(q16);listQuestion.add(q17);listQuestion.add(q18);
		
		List<Question> list = new ArrayList<Question>();
		list.add(q1);list.add(q7);list.add(q13);
		
		assertTrue(stack.getListQuestionCategory(Category.GEOGRAPHY).equals(list));
	}
	
	@Test
	public void TestMixQuestion()
	{
		listQuestion.add(q1);listQuestion.add(q2);listQuestion.add(q3);
		listQuestion.add(q4);listQuestion.add(q5);listQuestion.add(q6);
		listQuestion.add(q7);listQuestion.add(q8);listQuestion.add(q9);
		listQuestion.add(q10);listQuestion.add(q11);listQuestion.add(q12);
		listQuestion.add(q13);listQuestion.add(q14);listQuestion.add(q15);
		listQuestion.add(q16);listQuestion.add(q17);listQuestion.add(q18);
		
		List<Question> l = listQuestion;
		stack.mixQuestion();
		
		assertTrue(listQuestion.equals(l));
	}
	
	
}
