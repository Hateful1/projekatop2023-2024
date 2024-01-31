package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
	
	private Point startPoint;
	private Point endPoint;
	private Color currentColor = Color.BLACK;
	
	public double length() {
		 return startPoint.distance(endPoint);
	}
	
	
	@Override
	public String toString() {
		return "(" + this.getStartPoint().getX() + "," + this.getStartPoint().getY() + 
				") --> (" + this.getEndPoint().getX() + "," + this.getEndPoint().getY()+")";
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Line) {
			Line temp = (Line) obj;
			if(startPoint.equals(temp.startPoint) && endPoint.equals(temp.endPoint)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean contains(int x,int y) {
		return this.startPoint.distance(new Point(x,y)) + this.endPoint.distance(new Point(x,y)) 
		- length() <= 2;
	}
	
	public boolean contains(Point P) {
		return this.startPoint.distance(P) + this.endPoint.distance(P) - length() <= 2;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(currentColor);
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		g.setColor(Color.BLACK);
		if(this.isSelected() == true)
		{
			g.setColor(Color.BLUE);
			g.drawRect(this.getStartPoint().getX() - 3,this.getStartPoint().getY() - 3, 6, 6);
			g.drawRect(this.getEndPoint().getX() - 3,this.getEndPoint().getY() - 3, 6, 6);
			g.setColor(Color.BLACK);
		}
	}
	
	@Override
	public void moveTo(int x, int y) {
		
	}

	@Override
	public void moveBy(int byX, int byY) {
		startPoint.moveBy(byX, byY);
		endPoint.moveBy(byX, byY);
	}
	
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Line) {
			return (int)(length() - ((Line)obj).length());
		}
		return 0;
	}

	
	//Konstruktori
	
	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint,endPoint);
		this.selected = selected;
	}
	
	
	public Point getStartPoint() {
		return startPoint;
	}
	
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
		
	}
	
	public Point getEndPoint() {
		return endPoint;
		
	}
	
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}


	public Color getCurrentColor() {
		return currentColor;
	}


	public void setCurrentColor(Color currentColor) {
		this.currentColor = currentColor;
	}


	
}
