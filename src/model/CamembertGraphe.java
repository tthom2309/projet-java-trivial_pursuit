package model;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Arc2D;

public class CamembertGraphe
{
	private Color color;
	private Shape arc;
	private float degree;
	
	public CamembertGraphe(float degree, Color color)
	{
		this.degree = degree;
		this.color = color;
		this.arc = new Arc2D.Float(1, 1, 100, 100,degree, 60f, Arc2D.PIE);
		
	}

	public Color getColor()
	{
		return color;
	}

	public Shape getArc()
	{
		return arc;
	}

	public float getDegree() 
	{
		return degree;
	}
	
	

}
