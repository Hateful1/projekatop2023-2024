package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {
	private int x;
	private int y;
	private Color pointColor = Color.BLACK;
	
	public double distance(Point p) {
		int dX = this.x - p.x;
		int dY = this.y - p.y;
		double distance = Math.sqrt(dX*dX + dY*dY);
		return distance;
		
	}
	
	@Override
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point temp = (Point) obj;
			if(this.x == temp.x && this.y == temp.y) {
				return true;
				
			}
		}
		return false;
	}
	@Override
	public boolean contains(int x, int y) {
		return distance(new Point(x, y)) <= 2 ;
	}

	
	
	
	@Override
	public void draw(Graphics g) {
		
		g.drawLine(x+2, y, x-2, y);
		g.drawLine(x, y+2, x, y-2);
		g.setColor(Color.BLACK);
		if(this.isSelected() == true)
		{
			g.setColor(Color.BLUE);
			g.drawRect(this.getX() - 3,this.getY() - 3, 6, 6);
			g.setColor(Color.BLACK);
		}
	}
	
	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
		
	}

	@Override
	public void moveBy(int byX, int byY) {
		this.x += x;
		this.y += y;
		
	}
	
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Point) {
			return (int)(distance(new Point(0,0)) - ((Point)obj).distance(new Point(0,0)));
		}
		return 0;
	}
	
	
	//Konstruktori
	
	public Point() {
		
	}
		
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public Point(int x, int y, boolean selected) {
		this(x,y);
		this.selected = selected;
	}
	
	public int getX() { 
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
		
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public Color getPointColor() {
		return pointColor;
	}

	public void setPointColor(Color pointColor) {
		this.pointColor = pointColor;
	}



	
}
