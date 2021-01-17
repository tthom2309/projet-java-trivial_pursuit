package utility;

import java.io.File;

import model.Administrator;
import model.Category;
import model.Gamer;
import model.ManageUsers;
import model.Question;
import model.Stack;

public class MainSerialisationJSon {

	public static void main(String[] args) {
		
		Stack stack = Stack.getInstance();
		Question q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,q13,q14,q15,q16,q17,q18,q19,
		q20,q21,q22,q23,q24,q25,q26,q27,q28,q29,q30,q31,q32,q33,q34,q35,q36,
		q37,q38,q39,q40,q41,q42,q43,q44,q45,q46,q47,q48,q49,q50,q51,q52,q53,q54;
		
		q1 = new Question("Decroos", "In what hemisphere is the tropic of Cancer located?", Category.GEOGRAPHY);
		q1.addChoice("The northern hemisphere", true);
		q1.addChoice("The southern hemisphere", false);
		q1.addChoice("The western hemisphere", false);
		q1.addChoice("The eastern hemisphere", false);
		
		q2 = new Question("Decroos", "Usually, when can you watch the Australian open", Category.ENTERTAINMENT);
		q2.addChoice("In December", false);
		q2.addChoice("In January", true);
		q2.addChoice("In February", false);
		q2.addChoice("In March", false);
		
		q3 = new Question("Decroos", "Where was Jesus born?", Category.HISTORY);
		q3.addChoice("In Nazareth", false);
		q3.addChoice("In Bethlehem", true);
		q3.addChoice("In Jerusalem", false);
		q3.addChoice("In Samaria", false);
		
		q4 = new Question("Decroos","Who is the the father of the Communism?" , Category.BUSINESS);
		q4.addChoice("Jesus", false);
		q4.addChoice("Marx", true);
		q4.addChoice("Keynes", false);
		q4.addChoice("Smith", false);
		
		q5 = new Question("Decroos", "How many planets are there in the Solar System?", Category.SCIENCE_NATURE);
		q5.addChoice("7", false);
		q5.addChoice("8", true);
		q5.addChoice("9", false);
		q5.addChoice("10", false);
		
		q6 = new Question("Decroos", "How many times did Eddy Mercks win \"Le Tour de France\"?", Category.SPORT_LEISURE);
		q6.addChoice("4 times", false);
		q6.addChoice("5 times", true);
		q6.addChoice("6 times", false);
		q6.addChoice("7 times", false);
		
		q7 = new Question("Decroos", "What's the Earth's circumference?", Category.GEOGRAPHY);
		q7.addChoice("10 000 km", false);
		q7.addChoice("20 000 km", false);
		q7.addChoice("30 000 km", false);
		q7.addChoice("40 000 km", true);
		
		q8 = new Question("Decroos", "In which planet was Darth Vader born on?", Category.ENTERTAINMENT);
		q8.addChoice("The Earth", false);
		q8.addChoice("Coruscant", false);
		q8.addChoice("Tatooine", true);
		q8.addChoice("Dantooine", false);
		
		q9 = new Question("Decroos", "Who was the president of the USA during the Second World War?", Category.HISTORY);
		q9.addChoice("Franklin Roosevelt", true);
		q9.addChoice("John Kennedy", false);
		q9.addChoice("Thomas Wilson", false);
		q9.addChoice("Herbert Hoover", false);
		
		q10 = new Question("Decroos", "What's the income of a shareholder?", Category.BUSINESS);
		q10.addChoice("A salary", false);
		q10.addChoice("A bond", false);
		q10.addChoice("A private income", false);
		q10.addChoice("A stock dividend", true);
		
		q11 = new Question("Decroos", "What is the nearest star of the sun?", Category.SCIENCE_NATURE);
		q11.addChoice("Proxima Centauri", true);
		q11.addChoice("Sirius", false);
		q11.addChoice("A private income", false);
		q11.addChoice("Vega", false);
		q11.addChoice("Procyon", false);
		
		q12 = new Question("Decroos", "Which football club won the most often the football cup og Belgium?", Category.SPORT_LEISURE);
		q12.addChoice("RSC Anderlecht", false);
		q12.addChoice("Club Brugge", true);
		q12.addChoice("Standard Liège", false);
		q12.addChoice("KRC Genk", false);
		
		q13 = new Question("Decroos", "What is the capital city of Kenya", Category.GEOGRAPHY);
		q13.addChoice("Juba", false);
		q13.addChoice("Nairobi", true);
		q13.addChoice("Mogadishu", false);
		q13.addChoice("Dodoma", false);
		
		q14 = new Question("Decroos", "In which TV can you pull a black ball?", Category.ENTERTAINMENT);
		q14.addChoice("Motus", true);
		q14.addChoice("The price is right", false);
		q14.addChoice("Money Drop",false);
		q14.addChoice("Who wants to be a millionnaire", false);
		
		q15 = new Question("Decroos", "Who was the last king of France?", Category.HISTORY);
		q15.addChoice("Napoleon I", false);
		q15.addChoice("Louis XVI", false);
		q15.addChoice("Charles X", false);
		q15.addChoice("Louis Philippe I", true);
		
		q16 = new Question("Decroos", "What element insn't a primary need?", Category.BUSINESS);
		q16.addChoice("Drinking", false);
		q16.addChoice("Eating", false);
		q16.addChoice("Playing with the Playstation", true);
		q16.addChoice("Getting dressed", false);
		
		q17 = new Question("Decroos", "What is the lowest possible temperature?", Category.SCIENCE_NATURE);
		q17.addChoice("-173,15°C", false);
		q17.addChoice("-273,15°C", true);
		q17.addChoice("-373,15°C", false);
		q17.addChoice("-473,15°C", false);
		
		q18 = new Question("Decroos", "What is the nationality of Stanislas Wawrinka?", Category.SPORT_LEISURE);
		q18.addChoice("Russian", false);
		q18.addChoice("Belarussian", false);
		q18.addChoice("Swiss", true);
		q18.addChoice("Bulgarian", false);
		
		q19 = new Question("Rochez Adrien", "What's the name of the river in london ?", Category.GEOGRAPHY);
		q19.addChoice("River plate", false);
		q19.addChoice("River woods", false);
		q19.addChoice("River Thames", true);
		q19.addChoice("River lake", false);
		
		q20 = new Question("Rochez Adrien", "What's the capital of Belarus ?", Category.GEOGRAPHY);
		q20.addChoice("Kiev", false);
		q20.addChoice("Moscow", false);
		q20.addChoice("Minsk", true);
		q20.addChoice("Riga", false);
		
		q21 = new Question("Rochez Adrien", "How many states are there in usa ?", Category.GEOGRAPHY);
		q21.addChoice("52", false);
		q21.addChoice("51", false);
		q21.addChoice("50", true);
		q21.addChoice("54", false);
		
		q22 = new Question("Rochez Adrien", "Who is the main actor in the patriot ?", Category.ENTERTAINMENT);
		q22.addChoice("Edward Norton", false);
		q22.addChoice("Robert Redford", false);
		q22.addChoice("Mel Gibson", true);
		q22.addChoice("Russel Crowe", false);
		
		q23 = new Question("Rochez Adrien", "Who is the main actor in fight club ?", Category.ENTERTAINMENT);
		q23.addChoice("Brad Pitt", false);
		q23.addChoice("Tyler Durden", false);
		q23.addChoice("Edward Norton", true);
		q23.addChoice("Russel Crowe", false);
		
		q24 = new Question("Rochez Adrien", "Who is the author of harry potter story ?", Category.ENTERTAINMENT);
		q24.addChoice("Peter Anderson", false);
		q24.addChoice("Jack Sparrow", false);
		q24.addChoice("J.K.Rowlings", true);
		q24.addChoice("Hagrid", false);
		
		q25 = new Question("Rochez Adrien", "Who is the most successful sniper in history ?", Category.HISTORY);
		q25.addChoice("Vasily Zaytsev", false);
		q25.addChoice("King Kong", false);
		q25.addChoice("Simo Häyhä", true);
		q25.addChoice("Major Koenig", false);
		
		q26 = new Question("Rochez Adrien", "What the biggest tank battle in history ?", Category.HISTORY);
		q26.addChoice("Leningrad", false);
		q26.addChoice("Stalingrad", false);
		q26.addChoice("Kursk", true);
		q26.addChoice("Kiev", false);
		
		q27 = new Question("Rochez Adrien", "Who is the general in the afrika korps ? ", Category.HISTORY);
		q27.addChoice("Heydrich", false);
		q27.addChoice("Montgomery", false);
		q27.addChoice("Romel", true);
		q27.addChoice("Goeiring", false);
		
		q28 = new Question("Rochez Adrien", "Who is the ceo of microsoft ?  ", Category.BUSINESS);
		q28.addChoice("Steve Jobs", false);
		q28.addChoice("Satya Nadella", true);
		q28.addChoice("Steve Balmer", false);
		q28.addChoice("Bill gates", false);
		
		q29 = new Question("Rochez Adrien", "Which company made the witcher series ?  ", Category.BUSINESS);
		q29.addChoice("Blizzard", false);
		q29.addChoice("CD Projekt", true);
		q29.addChoice("Activision", false);
		q29.addChoice("Telltale", false);
		
		q30 = new Question("Rochez Adrien", "Which company made the iphone ?  ", Category.BUSINESS);
		q30.addChoice("Samsung", false);
		q30.addChoice("Apple", true);
		q30.addChoice("Nokia", false);
		q30.addChoice("Microsoft", false);
		
		q31 = new Question("Rochez Adrien", "What's the most powerful androgen ?", Category.SCIENCE_NATURE);
		q31.addChoice("Growth Hormone", false);
		q31.addChoice("Dihydrotestosterone", true);
		q31.addChoice("Testosterone", false);
		q31.addChoice("Insulin", false);
		
		q32 = new Question("Rochez Adrien", "How many adult teeth should an adult have?", Category.SCIENCE_NATURE);
		q32.addChoice("30", false);
		q32.addChoice("32", true);
		q32.addChoice("28", false);
		q32.addChoice("34", false);
		
		q33 = new Question("Rochez Adrien", "What vitamin is called the sunshine vitamin ?", Category.SCIENCE_NATURE);
		q33.addChoice("Vitamin A", false);
		q33.addChoice("Vitamin D", true);
		q33.addChoice("Vitamin C", false);
		q33.addChoice("Vitamin E", false);
		
		q34 = new Question("Rochez Adrien", "What town does the Cowboys play for ?", Category.SPORT_LEISURE);
		q34.addChoice("Los Angeles", false);
		q34.addChoice("Dallas", true);
		q34.addChoice("Miami", false);
		q34.addChoice("Boston", false);
		
		q35 = new Question("Rochez Adrien", "What country does Didier Drogba play for? ", Category.SPORT_LEISURE);
		q35.addChoice("Cameroun", false);
		q35.addChoice("Ivory Coast", true);
		q35.addChoice("France", false);
		q35.addChoice("Russia", false);
		
		q36 = new Question("Rochez Adrien", "Which country won the last world cup ?", Category.SPORT_LEISURE);
		q36.addChoice("Belgium", false);
		q36.addChoice("Germany", true);
		q36.addChoice("Brazil", false);
		q36.addChoice("Argentina", false);
		
		
		q37 = new Question("Verhelle", "What are the Dolomites located?", Category.GEOGRAPHY);
		q37.addChoice("Italy", true);
		q37.addChoice("Spain", false);
		q37.addChoice("The USA", false);
		q37.addChoice("Fance", false);
		
		q38 = new Question("Verhelle", "Who sang 'My Way' ?", Category.ENTERTAINMENT);
		q38.addChoice("Franck Sinatra", true);
		q38.addChoice("Mickael Jackson", false);
		q38.addChoice("Queen", false);
		q38.addChoice("Elvis Presley", false);
		
		q39 = new Question("Verhelle", "What was Adolf Hitler's religion ?", Category.HISTORY);
		q39.addChoice("Judaism", false);
		q39.addChoice("Catholicism", true);
		q39.addChoice("Atheism", false);
		q39.addChoice("Islam", false);
		
		q40 = new Question("Verhelle","Who is the CEO of Apple in 2015?" , Category.BUSINESS);
		q40.addChoice("Steeve Jobs", false);
		q40.addChoice("Tom Cook", true);
		q40.addChoice("Steve Wozniak", false);
		q40.addChoice("Ronald Wayne", false);
		
		q41 = new Question("Verhelle", "Who invented the electric light bulb ?", Category.SCIENCE_NATURE);
		q41.addChoice("Albert Einstein", false);
		q41.addChoice("Thomas Edison", true);
		q41.addChoice("Alexander Graham Bell", false);
		q41.addChoice("Auguste and Louis Lumière", false);
		
		q42 = new Question("Verhelle", "Wich is the most spoken language ?", Category.SPORT_LEISURE);
		q42.addChoice("English", false);
		q42.addChoice("Chinese", true);
		q42.addChoice("French", false);
		q42.addChoice("Japonese", false);
		
		q43 = new Question("Verhelle", "How many states are there in the USA ?", Category.GEOGRAPHY);
		q43.addChoice("49", false);
		q43.addChoice("55", false);
		q43.addChoice("45", false);
		q43.addChoice("50", true);
		
		q44 = new Question("Verhelle", "What year did Elvis Presley die ?", Category.ENTERTAINMENT);
		q44.addChoice("1968",false);
		q44.addChoice("1972", false);
		q44.addChoice("1977", true);
		q44.addChoice("1975", false);
		
		q45 = new Question("Verhelle", "What's the real name of Siddartha Gautama ?", Category.HISTORY);
		q45.addChoice("Buddha", true);
		q45.addChoice("", false);
		q45.addChoice("", false);
		q45.addChoice("", false);
		
		q46 = new Question("Verhelle", "In 2015, How Much Money Does Bill Gates Have ?", Category.BUSINESS);
		q46.addChoice("US$103 billion", false);
		q46.addChoice("US$122 billion", false);
		q46.addChoice("US$89 billion", false);
		q46.addChoice("US$79 billion", true);
		
		q47 = new Question("Verhelle", "Which is the only mammal that can't jump?", Category.SCIENCE_NATURE);
		q47.addChoice("Elephant", true);
		q47.addChoice("Bear", false);
		q47.addChoice("Walrus", false);
		q47.addChoice("Dog", false);
		
		
		q48 = new Question("Verhelle", "How many players are there in a volleyball team ?", Category.SPORT_LEISURE);
		q48.addChoice("7", false);
		q48.addChoice("6", true);
		q48.addChoice("5", false);
		q48.addChoice("4", false);
		
		q49 = new Question("Verhelle", "Which country has the largest area ?", Category.GEOGRAPHY);
		q49.addChoice("Australia", false);
		q49.addChoice("Brazil", true);
		q49.addChoice("India", false);
		q49.addChoice("Spain", false);
		
		q50 = new Question("Verhelle", "In whitch city is Hollywood located ?", Category.ENTERTAINMENT);
		q50.addChoice("Los Angeles", true);
		q50.addChoice("New York", false);
		q50.addChoice("Miami",false);
		q50.addChoice("San Francisco", false);
		
		q51 = new Question("Verhelle", "When did the first man go into space ?", Category.HISTORY);
		q51.addChoice("1965", false);
		q51.addChoice("1971", false);
		q51.addChoice("1960", false);
		q51.addChoice("1961", true);
		
		q52 = new Question("Verhelle", "Who is the second founder of Microsoft with Bill Gates", Category.BUSINESS);
		q52.addChoice("John W. Thompson", false);
		q52.addChoice("Steeve Jobs", false);
		q52.addChoice("Paul Alleen", true);
		q52.addChoice("Satya Nadella ", false);
		
		q53 = new Question("Verhelle", "What's the softest rock", Category.SCIENCE_NATURE);
		q53.addChoice("diamond", false);
		q53.addChoice("Talc", true);
		q53.addChoice("Brick", false);
		q53.addChoice("Calcite", false);
		
		q54 = new Question("Verhelle", "How long is a round in boxing ?", Category.SPORT_LEISURE);
		q54.addChoice("2 minutes", false);
		q54.addChoice("2 minutes 30s", false);
		q54.addChoice("3 minutes", true);
		q54.addChoice("4 minutes", false);
		
		
		
		
		
		stack.addQuestion(q1);
		stack.addQuestion(q2);
		stack.addQuestion(q3);
		stack.addQuestion(q4);
		stack.addQuestion(q5);
		stack.addQuestion(q6);
		stack.addQuestion(q7);
		stack.addQuestion(q8);
		stack.addQuestion(q9);
		stack.addQuestion(q10);
		stack.addQuestion(q11);
		stack.addQuestion(q12);
		stack.addQuestion(q13);
		stack.addQuestion(q14);
		stack.addQuestion(q15);
		stack.addQuestion(q16);
		stack.addQuestion(q17);
		stack.addQuestion(q18);
		stack.addQuestion(q19);
		stack.addQuestion(q20);
		stack.addQuestion(q21);
		stack.addQuestion(q22);
		stack.addQuestion(q23);
		stack.addQuestion(q24);
		stack.addQuestion(q25);
		stack.addQuestion(q26);
		stack.addQuestion(q27);
		stack.addQuestion(q28);
		stack.addQuestion(q29);
		stack.addQuestion(q30);
		stack.addQuestion(q31);
		stack.addQuestion(q32);
		stack.addQuestion(q33);
		stack.addQuestion(q34);
		stack.addQuestion(q35);
		stack.addQuestion(q36);
		stack.addQuestion(q37);
		stack.addQuestion(q38);
		stack.addQuestion(q39);
		stack.addQuestion(q40);
		stack.addQuestion(q41);
		stack.addQuestion(q42);
		stack.addQuestion(q43);
		stack.addQuestion(q44);
		stack.addQuestion(q45);
		stack.addQuestion(q46);
		stack.addQuestion(q47);
		stack.addQuestion(q48);
		stack.addQuestion(q49);
		stack.addQuestion(q50);
		stack.addQuestion(q51);
		stack.addQuestion(q52);
		stack.addQuestion(q53);
		stack.addQuestion(q54);
		
		
		
		Serialisation.saveStack("groupe07.json", stack);
		
		
		
		

	}

}
