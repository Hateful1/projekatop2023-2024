package geometry;

import java.awt.Graphics;
import java.awt.Color;

public class Rectangle extends Shape {
	
	private Point upperLeft;
	private int width;
	private int height;
	private Color rectangleFillColor = Color.WHITE;
	private Color rectangleBorderColor = Color.BLACK;
	
	

	
	public int area() {
		int area = width*height;
		return area;
	}
	
	public int circumference() {
		int circumference = 2*width+2*height;
		return circumference;
	}
	
	@Override
	public String toString() {
		return "Upper left point:(" + this.getUpperLeft().getX() + "," 
				+ this.getUpperLeft().getY() + "), width = <" + this.getWidth() 
					+ ">, height = <" + this.getHeight() + ">";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Rectangle){
			Rectangle temp = (Rectangle) obj;
			if(this.width == temp.width && this.height == temp.height ) {
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean contains(int x,int y) {
		return (this.upperLeft.getX() <= x && this.upperLeft.getX() + this.width >= x && 
				this.upperLeft.getY() <= y && this.upperLeft.getY() + this.height >= y);
	}
	
	public boolean contains(Point p) {
		return (this.upperLeft.getX() <= p.getX() && this.upperLeft.getX() + this.width >= p.getX() && 
				this.upperLeft.getY() <= p.getY() && this.upperLeft.getY() + this.height >= p.getY());
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(rectangleFillColor);
		g.fillRect(upperLeft.getX(), upperLeft.getY(), width, height);
		g.setColor(rectangleBorderColor);
		g.drawRect(upperLeft.getX(), upperLeft.getY(), width, height);
		g.setColor(Color.BLACK);
		if(this.isSelected() == true)
		{
			g.setColor(Color.BLUE);
			g.drawRect(upperLeft.getX() - 3, upperLeft.getY() - 3, 6, 6);
			g.drawRect(upperLeft.getX() - 3 + this.getWidth(), upperLeft.getY() - 3, 6, 6);
			g.drawRect(upperLeft.getX() - 3, upperLeft.getY() + this.getHeight() - 3, 6, 6);
			g.drawRect(upperLeft.getX() + this.getWidth() - 3, upperLeft.getY() + this.getHeight() - 3, 6, 6);
			g.setColor(Color.BLACK);
		}
	}
	
	
	@Override
	public void moveTo(int x, int y) {
		upperLeft.moveTo(x, y);
		
		
	}

	@Override
	public void moveBy(int byX, int byY) {
		upperLeft.moveBy(byX, byY);
		
	}
	
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Rectangle) {
			return area() - ((Rectangle)obj).area();
		}
			
		
		return 0;
	}
	
	
	//Konstruktori
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeft,int width,int height) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
		
	}
	
	public Rectangle(Point upperLeft, int width,int height,boolean selected) {
		this(upperLeft,width,height);
		this.selected = selected;
	}
	public Point getUpperLeft() {
		return upperLeft;
	}
	
	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}
	
	public int getWidth() {
		return width;
		
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}

	public Color getRectangleFillColor() {
		return rectangleFillColor;
	}

	public void setRectangleFillColor(Color rectangleFillColor) {
		this.rectangleFillColor = rectangleFillColor;
	}

	public Color getRectangleBorderColor() {
		return rectangleBorderColor;
	}

	public void setRectangleBorderColor(Color rectangleBorderColor) {
		this.rectangleBorderColor = rectangleBorderColor;
	}

	public void setHeight(int height) {
		this.height = height;
	}



	
}
