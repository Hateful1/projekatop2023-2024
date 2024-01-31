package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {
	
	private int innerRadius;
	private Color currentDFillColor = Color.WHITE;
	private Color currentDBorderColor = Color.BLACK;

	@Override
	public double area() {
		return super.area() - (innerRadius*innerRadius*Math.PI);
	}
	
	@Override
	public String toString() {
		return "(" + this.getCenter().getX() + "," + this.getCenter().getY()+"), radius = "+ this.getRadius() + ", inner radius = " + this.innerRadius; 
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Donut) {
			Donut temp = (Donut) obj;
			if(this.getCenter().getX() == temp.getCenter().getX() && this.getCenter().getY() == temp.getCenter().getY() && this.getRadius() == temp.getRadius() && this.innerRadius == temp.innerRadius) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean contains(int x, int y) {
		return super.contains(x,y) && super.center.distance(new Point(x,y)) >= innerRadius;
	}
	
	@Override
	public boolean contains(Point p) {
		return contains(p.getX(),p.getY());
	}
	
	@Override
	public void draw(Graphics g) {
		super.setCurrentFillColor(currentDFillColor);
		super.draw(g);
		super.setCurrentBorderColor(currentDBorderColor);
		super.draw(g);
		g.setColor(Color.WHITE);
		g.fillOval(getCenter().getX() - innerRadius, getCenter().getY() -  innerRadius, innerRadius*2, innerRadius*2);
		g.setColor(currentDBorderColor);
		g.drawOval(getCenter().getX( )- innerRadius, getCenter().getY() -  innerRadius, innerRadius*2, innerRadius*2);
		if(this.isSelected() == true)
		{
			g.setColor(Color.BLUE);
			
			g.drawRect(this.getCenter().getX() - 3,this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - (int)(this.getRadius()) - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + (int)(this.getRadius()) - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3 - (int)(this.getRadius()), this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3 + (int)(this.getRadius()), this.getCenter().getY() - 3, 6, 6);
			
			
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - (int)(this.getInnerRadius()) - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + (int)(this.getInnerRadius()) - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3 - (int)(this.getInnerRadius()), this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3 + (int)(this.getInnerRadius()), this.getCenter().getY() - 3, 6, 6);
			g.setColor(Color.BLACK);
		}
	}
	
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Donut) {
			return (int)(area() - ((Donut)obj).area());
		}
		return 0;
	}
	
	//Konstruktori
	
	public Donut() {
		
	}
	public Donut(Point center, int radisu, int innerRadius) {
		super(center,radisu);
		this.innerRadius = innerRadius;
	}
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center,radius,innerRadius);
		this.selected = selected;
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}

	public Color getCurrentDFillColor() {
		return currentDFillColor;
	}

	public void setCurrentDFillColor(Color currentDFillColor) {
		this.currentDFillColor = currentDFillColor;
	}

	public Color getCurrentDBorderColor() {
		return currentDBorderColor;
	}

	public void setCurrentDBorderColor(Color currentDBorderColor) {
		this.currentDBorderColor = currentDBorderColor;
	}
}
