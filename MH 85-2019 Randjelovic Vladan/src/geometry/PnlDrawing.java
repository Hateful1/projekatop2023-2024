package geometry;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.util.Iterator;

public class PnlDrawing extends JPanel {
	
	private ArrayList<Shape> selectedShapes = new ArrayList<Shape>();
	public static ArrayList<Shape> shapeList = new ArrayList<Shape>();
	public static Shape selectedShape;
	private Point point,p1,p2;
	private Line l1;
	private Rectangle r1;
	private Circle c1;
	public static int radius;
	public static int width, height;
	public static int outerRadius,innerRadius;
	public static Donut d1;
	
	int pointCounter;
	public PnlDrawing() {
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(DrawingApp.getSelection()=="Draw") {
					
					if("Point".equals(DrawingApp.getDrawThisShape())) {
						point = new Point(e.getX(), e.getY());
						DlgPoint.setCurrentColor(Color.BLACK);
						shapeList.add(point);
						repaint();
					}
					if("Line".equals(DrawingApp.getDrawThisShape())) {
						
						if(pointCounter == 0)
						{
							 p1 = new Point(e.getX(), e.getY());
						}
						if(pointCounter == 1) {
							 p2 = new Point(e.getX(),e.getY());
							 l1 = new Line(p1,p2);
							 DlgLine.setCurrentColor(Color.BLACK);
							 shapeList.add(l1);
						}
						pointCounter++;
						if(pointCounter == 2)
						{
							pointCounter = 0;
							repaint();
						}
					}
					if("Rectangle".equals(DrawingApp.getDrawThisShape())) {
						
						DlgRectangle drec = new DlgRectangle();
						
						drec.getTextFieldX().setText(Integer.toString(e.getX()));
						drec.getTextFieldY().setText(Integer.toString(e.getY()));
						drec.getTextFieldX().setEditable(false);
						drec.getTextFieldY().setEditable(false);
						DlgRectangle.setCurrentBorderColor(Color.BLACK);
						DlgRectangle.setCurrentFillColor(Color.WHITE);
						drec.setVisible(true);

						if(drec.isFlag()) {
							r1 = new Rectangle(new Point(e.getX(),e.getY()),width,height);
							r1.setRectangleFillColor(DlgRectangle.getCurrentFillColor());
							r1.setRectangleBorderColor(DlgRectangle.getCurrentBorderColor());
							shapeList.add(r1);
							drec.setFlag(false);
							repaint();
						}
						
					
						
						
					}
					if("Circle".equals(DrawingApp.getDrawThisShape())) {
						DlgCircle dcirc = new DlgCircle();
						dcirc.getTextFieldX().setText(Integer.toString(e.getX()));
						dcirc.getTextFieldY().setText(Integer.toString(e.getY()));
						dcirc.getTextFieldX().setEditable(false);	
						dcirc.getTextFieldY().setEditable(false);
						DlgCircle.setCurrentBorderColor(Color.BLACK);
						DlgCircle.setCurrentFillColor(Color.WHITE);
						dcirc.setVisible(true);
						System.out.println("1"+dcirc.isFlag());
						
						if(dcirc.isFlag()) {
							System.out.println("2"+dcirc.isFlag());
							c1 = new Circle(new Point(e.getX(),e.getY()),radius);
							c1.setCurrentBorderColor(DlgCircle.getCurrentBorderColor());
							c1.setCurrentFillColor(DlgCircle.getCurrentFillColor());
							shapeList.add(c1);
						   dcirc.setFlag(false);
							repaint();
							
						}
						
						}
					if("Donut".equals(DrawingApp.getDrawThisShape())) {
						DlgDonut ddnt = new DlgDonut();
						ddnt.getTextFieldX().setText(Integer.toString(e.getX()));
						ddnt.getTextFieldY().setText(Integer.toString(e.getY()));
						ddnt.getTextFieldX().setEditable(false);	
						ddnt.getTextFieldY().setEditable(false);
						DlgDonut.setCurrentDBorderColor(Color.BLACK);
						DlgDonut.setCurrentDFillColor(Color.WHITE);
						ddnt.setVisible(true);
						if(ddnt.isFlag())
						{
							d1 = new Donut(new Point(e.getX(), e.getY()), outerRadius, innerRadius);
							d1.setCurrentDBorderColor(DlgDonut.getCurrentDBorderColor());
							d1.setCurrentDFillColor(DlgDonut.getCurrentDFillColor());
							shapeList.add(d1);
							
							repaint();
						}
						
					}
						
				}
				if(DrawingApp.getSelection() == "Select")
				{
					selection(e.getX(), e.getY());
					repaint();
				}
				
				
			}
			
		});
			
		
}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		for(Shape shapes : shapeList)
		{
			shapes.draw(g);
		}
	}
	
	public void selection(int x, int y) {
	    selectedShapes.clear();
	    selectedShape = null;

	    for (Shape s : shapeList) {
	    	s.setSelected(false);
	        if (s.contains(x, y)) {
	            selectedShapes.add(s);
	        
	        } else {
	            s.setSelected(false);
	        }
	    }

	   
	    if (selectedShapes.size() == 1) {
	    	selectedShapes.get(0).setSelected(true);
	        selectedShape = selectedShapes.get(0);
	    }
	    if (selectedShapes.size() > 1)
	    {
	    	selectedShapes.get(selectedShapes.size()-1).setSelected(true);
	    	selectedShape = selectedShapes.get(selectedShapes.size()-1);
	    }
	}
	
	public static void setSelected(Shape selectedShape) {
		PnlDrawing.selectedShape = selectedShape;
	}
	public ArrayList<Shape> getSelectedShapes() {
		return selectedShapes;
	}
	public void setSelectedShapes(ArrayList<Shape> selectedShapes) {
		this.selectedShapes = selectedShapes;
	}
	public static ArrayList<Shape> getShapeList() {
		return shapeList;
	}
	public static void setShapeList(ArrayList<Shape> shapeList) {
		PnlDrawing.shapeList = shapeList;
	}
	public static Shape getSelectedShape() {
		return selectedShape;
	}
	
	public static void setSelectedShape(Shape selectedShape) {
		PnlDrawing.selectedShape = selectedShape;
	}
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}




	
	public static void setRadius(int radiuss)
	{
		radius = radiuss;
	}

	public static void setWidthHeight(int widthh, int heightt) {
		width = widthh;
		height = heightt;
	}

	public static int getOuterRadius() {
		return outerRadius;
	}

	public static void setOuterRadius(int outerRadius) {
		PnlDrawing.outerRadius = outerRadius;
	}



	public static void setORadiusIRadius(int checkOuter, int checkInner) {
		// TODO Auto-generated method stub
		innerRadius = checkInner;
		outerRadius = checkOuter;
	}
}
