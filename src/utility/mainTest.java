package utility;

import java.util.Iterator;

import exception.IndexNegativeException;
import exception.IndexTooHighException;
import model.Category;
import model.IteratorQuestion;
import model.Piece;
import model.Question;
import model.Stack;

public class mainTest {

	public static void main(String[] args) {
//		Question quest = new Question("Rochez Adrien",Category.Bussiness,"Quel est l'économie de la russie ?");
//		quest.addChoice("Moscou",true);
//		System.out.println(quest.getChoices().containsKey("Moscou"));
//		TreeMap<String,Boolean>choice = new TreeMap<String,Boolean>();
		
		Question quest1 = new Question("Christophe", "Quelle est la capitale de la Belgique?", Category.GEOGRAPHY);
		
			quest1.addChoice("Moscou", true);
			quest1.addChoice("Moscou2", false);
			quest1.addChoice("Moscou3", false);
			quest1.addChoice("Moscou4", false);
			
			Question quest2 = new Question("Christophe", "Quelle est la capitale de la Russie?", Category.GEOGRAPHY);
			
			quest2.addChoice("Moscou", true);
			quest2.addChoice("Moscou2", false);
			quest2.addChoice("Moscou3", false);
			quest2.addChoice("Moscou4", false);
			
			Question quest3 = new Question("Tintin", "question",Category.BUSINESS);
				quest3.addChoice("choice1", true);
				quest3.addChoice("choice2", false);
				quest3.addChoice("choice3", false);
				quest3.addChoice("choice4", false);
				
				
			
			
			
			Stack st1 = Stack.getInstance();
			st1.addQuestion(quest1);
			st1.addQuestion(quest2);
			st1.addQuestion(quest3);
	
//			while(it.hasNext()){
//				System.out.println(it.next());
//			}
			
			Question qu;
			IteratorQuestion it2 = st1.researchCategory(Category.GEOGRAPHY);
			while(it2.hasNext()){
				qu = it2.next();
				if(qu!=null){
					System.out.println(qu);
				}
				}
			
			IteratorQuestion it3 = st1.researchAuthor("Christophe");
			while(it3.hasNext()){
				qu = it3.next();
				if(qu!=null){
					System.out.println(qu);
				}
			}
				
			
			
		
//			Serialisation.saveStack("file.json", st1);
//			
//			
//
//	
//		
//	System.out.println(st1.getListQuestion());
//	System.out.println(st1.getListQuestionCategory(Category.BUSINESS));
//	
//	Piece piece = new Piece(0);
//	piece.addCategoryCheese(Category.BUSINESS);
//	System.out.println(piece.getCheese());
		

	
	Stack stack = Serialisation.retrieveStack("groupe07.json");
	
	System.out.println("coucou003\n"+stack.getListQuestion().get(0));
	
	}

}
