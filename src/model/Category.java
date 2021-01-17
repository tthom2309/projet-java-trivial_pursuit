package model;

import java.awt.Color;

public enum Category {
	
	GEOGRAPHY(1,"Geography",new Color(0,153,203)),
	ENTERTAINMENT(2,"Entertainment",new Color(255,51,102)),
	HISTORY(3,"History",new Color(255,255,1)),
	BUSINESS(4,"Business",new Color(153,101,51)),
	SCIENCE_NATURE(5,"Science & nature",new Color(52,153,51)),
	SPORT_LEISURE(6,"Sport & leisure",new Color(255,102,0));
	
	private int id;
	private String description = "";
	private Color color;
    
	Category(int id,String description,Color color)
	{
		this.id=id;
		this.description = description;
		this.color=color;
	}
	
	public String toString()
	{
		return description;
	}
	
	public int getId()
	{
		return id;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	/**
	 * Return the question's category with the index 
	 * @param index
	 * @return category
	 */
	public static Category valueIndexOf(int index)
	{
		
		 for (Category value : values())
		 { 
	         int cate = value.getId(); 
	         if (cate == index+1) // +1 car dans la combobox les valeurs commencent à 0
	         { 
	              return value; 
	         } 
		 }
		 return null;
	}
}