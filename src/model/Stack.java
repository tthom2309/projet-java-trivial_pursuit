package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import utility.Serialisation;

public class Stack extends Observable implements Serializable 
{
	
	private static final long serialVersionUID = 1L;
	private static Stack instance = null;
	private List<Question>listQuestion;
	
	private Stack()
	{
		listQuestion =new ArrayList<Question>();
	}
	/*
	 * Le constructeur est private pour être sûr qu'aucune classe externe n'y ai acces
	 */
	
	/**
	 * This method allows to create single instance of Stack (Pattern Singleton).
	 * @author Christophe Decroos
	 * @return Stack
	 */
	public static Stack getInstance()
	{
		if (instance == null) 
				instance = Serialisation.retrieveStack("Data/question.json");
		return instance;
	}
	
	/**
	 * Method wich allows to add a Question in the Stack
	 * @author Adrien Rochez
	 * @param q
	 * @return
	 */
	
	public void addQuestion(Question q)
	{
		if(!listQuestion.contains(q))
			listQuestion.add(q);
		notifie();
		
			
		
	}
	
	/**
	 * Method wich allows to remove a Question in the Stack
	 * @author Adrien Rochez
	 * @param q
	 * @return
	 */
	public void removeQuestion(Question q)
	{
		listQuestion.remove(q);
		notifie();
	}
	
	/**
	 * Method wich allows to replace a Question by another in the Stack
	 * @author Adrien Rochez
	 * @param oldQuestion
	 * @param newQuestion
	 * @return
	 */
	public void replaceQuestion(Question oldQuestion , Question newQuestion) 
	{
		listQuestion.set(listQuestion.indexOf(oldQuestion), newQuestion);
		notifie();
	}
	
	public List<Question> getListQuestion() 
	{
		
		List<Question> list = new ArrayList<Question>();
		
		int i = 1;
		for(Question q : listQuestion)
		{
			
			list.add(new Question(q.getAuthor(),q.getStatement(),q.getCategory()));
			list.get(list.indexOf(q)).setChoices(q.getChoices());
			System.out.println(i + q.getStatement());
			i++;
		}
		
		return list;
	}
	
	/**
	 * Method which allows to retrieve a List of Question as the Category in argument
	 * @author Christophe Decroos
	 * @param cat
	 * @return List<Question>
	 */
	public List<Question> getListQuestionCategory(Category cat)
	{
		List<Question> list = new ArrayList<Question>();
		
		for(Question q : listQuestion)
		{
			if(q.getCategory()==cat)
			{
				list.add(new Question(q.getAuthor(),q.getStatement(),q.getCategory()));
				list.get(list.indexOf(q)).setChoices(q.getChoices());
			}
		}
		
		return list;
	}
	
	/**
	 *@author Christophe Decroos
	 * Method that allows to mix the elements of the List of Question.
	 */
	public void mixQuestion(){
		Collections.shuffle(listQuestion);
	}
	
	public String toString(){
		String tmp = "{\n";
		tmp += "  \"questions\": [\n";
		

		Iterator<Question> it = listQuestion.listIterator();
		
		while(it.hasNext()){
			tmp += it.next().toString();
		}
		tmp += "  },";
		return tmp;
	}
	
	/**
	 * @author Christophe Decroos
	 * @param catCond
	 * @return IteratorQuestion
	 * Method that allows to create an iterator to browse the List of Question.
	 * The objects Question concerned in the List are those wich contains in their attribut category the value of catCond.
	 */
	public IteratorQuestion researchCategory(Category catCond)
	{
		return new IteratorQuestionCategory(listQuestion, catCond);
	}
	
	/**
	 * @author Christophe Decroos
	 * @param authorCond
	 * @return IteratorQuestion
	 * Method that allows to create an iterator to browse the List of Question.
	 * The objects Question concerned in the List are those wich contains in their attribut author the value of authorCond.
	 */
	public IteratorQuestion researchAuthor(String authorCond)
	{
		return new IteratorQuestionAuthor(listQuestion, authorCond);
	}
	
	/**
	 * @author Christophe Decroos
	 * @return IteratorQuestion
	 * Method that allows to create an iterator to browse the List of Question.
	 */
	public IteratorQuestion iterator() {
		return new IteratorQuestion(listQuestion);
	}

	public void removeQuestion(int i) {
		listQuestion.remove(i);
		
	}

	public int nombreQuestion() {
		return listQuestion.size();
	}
	
	public Question getQuestion(int index)
	{
		return listQuestion.get(index);
	}
	
	public Question getRandomQuestionByCat(Category cat){
		for(Question q: listQuestion){
			if(q!= null)
			{
				if(q.getCategory().equals(cat))
				{
				
					return q;
				}
			}
		}
		
		Stack.getInstance().mixQuestion();
		return getRandomQuestionByCat(cat);
	}
}
