package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class Question implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String author;
	private String statement;
	private Category category;
	private HashMap<String,Boolean>choices;
	
	public Question(String author,String statement,Category category)
	{
		this.author = author;
		this.statement = statement;
		this.category = category;
		this.choices = new HashMap<String,Boolean>(4);
	}
	
	/**
	 * Methode which allows to add a choice of answer for the question.
	 * @author Rochez Adrien
	 * @param String
	 * @param boolean
	 * @return boolean
	 */
	
	public Boolean addChoice(String choice,boolean result)
	{
		if(result==true && choices.containsValue(true))
			return false;
		
		return choices.put(choice,result);
	}
	
	/**
	 * Methode wich allows to delete a choice of answer for the question
	 * @param String - statement of the question
	 */
	
	public boolean removeChoice(String text)
	{
		return choices.remove(text);
	}
	
	/**
	 * Méthode qui vérifie qu'il existe une réponse correcte et qu'il n'y en a pas trop pour la question
	 * @return boolean
	 */
	
	public boolean verify()
	{
		int i=0; // Nombre de réponse vraie
		for(boolean a : choices.values())
		{
			if(a==true)
			{
				i++;
			}
		}
		switch(i)
		{
		case 1:
			return true;
		default:
			return false;
		}
	}
	
	public boolean equals(Object o)
	{
		if(o instanceof Question)
		{
			Question q = (Question)o;
			return this.statement.equals(q.statement);
		}
		return false;
	}

	public String getAuthor() {
		return author;
	}
	
	public String getStatement() {
		return statement;
	}
	
	public Category getCategory(){
		return category;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setStatement(String statement) {
		this.statement = statement;
	}
	
	public void setCategory(Category category){
		this.category = category;
	}
	
	public void setChoices(HashMap<String, Boolean> choices) {
		this.choices = choices;
	}
	
	public HashMap<String, Boolean> getChoices() 
	{
		HashMap<String, Boolean> map = new HashMap<String,Boolean>(4);
		
		Set<Entry<String,Boolean>> entrees = choices.entrySet();
		
		for(Entry<String, Boolean> e : entrees){
		 map.put(new String(e.getKey()), new Boolean(e.getValue()));
		}
		
		return map;
	}
	
	public String toString()
	{
		String tmp;
		int i=0;
		tmp = "    {\n";
		tmp += "      \"author\": \"" + author + "\",\n";
		tmp += "      \"statement\": \"" + statement + "\",\n";
		tmp += "      \"category\": \"" + category + "\",\n";
		tmp += "      \"choices\": {\n";
		
		Set<Entry<String,Boolean>> entrees = choices.entrySet();
		
		for(Entry<String, Boolean> e : entrees){
			
			i++;
			tmp += "      \"" + e.getKey() + "\": " + e.getValue();
			
			if(choices.size()!=i){
				tmp += ",";
			}
			tmp += "\n";
		}
		
		tmp += "      }\n";
		tmp += "    },";
		
		return tmp;
	}
	
}

