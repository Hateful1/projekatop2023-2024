package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {

		protected Point center;
		private int radius;
		private Color currentFillColor = Color.WHITE;
		private Color currentBorderColor = Color.BLACK;
		
		
		public double area() {
			return radius*radius*Math.PI;
			
		}
		public double circumference() {
			return 2*radius*Math.PI;
		}
		
		@Override
		public String toString() {
			return "Center:(" + this.getCenter().getX()+ "," + this.getCenter().getY() + 
					"), radius =" + this.radius;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Circle) {
				Circle temp = (Circle) obj;
				if(this.radius == temp.radius) {
					return true;
				}
				
			}
			return false;
			
		}
		@Override
		public boolean contains(int x, int y) {
			return this.center.distance(new Point(x,y)) <= this.radius;
		}
		
		public boolean contains(Point p) {
			return this.center.distance(p) <= this.radius;
					
		}
		@Override
		public void draw(Graphics g) {
			g.setColor(currentFillColor);
			g.fillOval(center.getX() - radius, center.getY() - radius, 2*radius, 2*radius);
			g.setColor(currentBorderColor);
			g.drawOval(center.getX() - radius, center.getY() - radius, 2*radius, 2*radius);
			g.setColor(Color.BLACK);
			if(this.isSelected() == true)
			{
				g.setColor(Color.BLUE);
				g.drawRect(this.getCenter().getX() - 3,this.getCenter().getY() - 3, 6, 6);
				g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - (int)(this.getRadius()) - 3, 6, 6);
				g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + (int)(this.getRadius()) - 3, 6, 6);
				g.drawRect(this.getCenter().getX() - 3 - (int)(this.getRadius()), this.getCenter().getY() - 3, 6, 6);
				g.drawRect(this.getCenter().getX() - 3 + (int)(this.getRadius()), this.getCenter().getY() - 3, 6, 6);
				g.setColor(Color.BLACK);
			}
		}
		
		
		
		@Override
		public void moveTo(int x, int y) {
			center.moveTo(x, y);
			
		}
		@Override
		public void moveBy(int byX, int byY) {
			center.moveBy(byX, byY);
			
		}
		
		@Override
		public int compareTo(Object obj) {
			if(obj instanceof Circle) {
				return (int)(area() - ((Circle)obj).area());
			}
			return 0;
		}
		
		
		//Konstruktori
		
		public Circle() {  
	
		}
		
		public Circle(Point center, int radius) {
			this.center = center;
			this.radius = radius;
		}
		
		public Circle(Point center, int radius,boolean selected) {
			this(center,radius);
			this.selected = selected;
		}
		
		public Point getCenter() {
			return center;
		}
		public void setCenter(Point center) {
			this.center = center;
		}
		public int getRadius() {
			return radius;
		}
		public void setRadius(int radius) {
			this.radius = radius;
		}
		public Color getCurrentFillColor() {
			return currentFillColor;
		}
		public void setCurrentFillColor(Color currentFillColor) {
			this.currentFillColor = currentFillColor;
		}
		public Color getCurrentBorderColor() {
			return currentBorderColor;
		}
		public void setCurrentBorderColor(Color currentBorderColor) {
			this.currentBorderColor = currentBorderColor;
		}
		
		
}
