package geometry;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ButtonGroup group = new ButtonGroup();
	private static String drawThisShape;
	public static String selection;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingApp frame = new DrawingApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DrawingApp() {
		setTitle("Paint Vladan Randjelovic MH85/2019");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCenter = new PnlDrawing();
		panelCenter.setBackground(Color.WHITE);
		contentPane.add(panelCenter, BorderLayout.CENTER);
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		GridBagLayout gbl_panelNorth = new GridBagLayout();
		gbl_panelNorth.columnWidths = new int[]{80, 80, 80, 80, 80, 0};
		gbl_panelNorth.rowHeights = new int[]{0, 0, 0};
		gbl_panelNorth.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelNorth.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelNorth.setLayout(gbl_panelNorth);
		
		JButton btnDraw = new JButton("Draw");
		GridBagConstraints gbc_btnDraw = new GridBagConstraints();
		gbc_btnDraw.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDraw.insets = new Insets(0, 0, 5, 5);
		gbc_btnDraw.gridx = 1;
		gbc_btnDraw.gridy = 0;
		panelNorth.add(btnDraw, gbc_btnDraw);
		btnDraw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DrawingApp.setSelection("Draw");
			}
		});
		
		JButton btnSelect = new JButton("Select");
		GridBagConstraints gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSelect.insets = new Insets(0, 0, 5, 5);
		gbc_btnSelect.gridx = 2;
		gbc_btnSelect.gridy = 0;
		panelNorth.add(btnSelect, gbc_btnSelect);
		btnSelect.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				DrawingApp.setSelection("Select");
		}
	});
		
		JButton btnModify = new JButton("Modify");
		GridBagConstraints gbc_btnModify = new GridBagConstraints();
		gbc_btnModify.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModify.insets = new Insets(0, 0, 5, 5);
		gbc_btnModify.gridx = 3;
		gbc_btnModify.gridy = 0;
		panelNorth.add(btnModify, gbc_btnModify);
		btnModify.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Shape selectedShape = PnlDrawing.getSelectedShape();
					if(selectedShape != null)
					{
						if(selectedShape instanceof Point) {
							Point temp = (Point) selectedShape;
							DlgPoint drp = new DlgPoint();
							drp.getTextFieldX().setText(Integer.toString(temp.getX()));
							drp.getTextFieldY().setText(Integer.toString(temp.getY()));
							drp.setVisible(true);
							if(drp.isFlag())
							{
								temp.setX(Integer.parseInt(drp.getTextFieldX().getText()));
								temp.setY(Integer.parseInt(drp.getTextFieldY().getText()));
								temp.setPointColor(DlgPoint.getCurrentColor());
								((Point) selectedShape).moveTo(temp.getX(), temp.getY());
								((Point) selectedShape).setPointColor(temp.getPointColor());
								drp.setFlag(false);
								panelCenter.repaint();
							}
							
						}
						else if(selectedShape instanceof Line)
						{
							Line temp = (Line) selectedShape;
							DlgLine drl = new DlgLine();
							drl.getTextFieldSX().setText(Integer.toString(temp.getStartPoint().getX()));
							drl.getTextFieldSY().setText(Integer.toString(temp.getStartPoint().getY()));
							drl.getTextFieldEX().setText(Integer.toString(temp.getEndPoint().getX()));
							drl.getTextFieldEY().setText(Integer.toString(temp.getEndPoint().getY()));
							drl.setVisible(true);
							if(drl.isFlag())
							{
								temp.setStartPoint(new Point(drl.getCheckSX(), drl.getCheckSY()));
								temp.setEndPoint(new Point(drl.getCheckEX(), drl.getCheckEY()));
								temp.setCurrentColor(DlgLine.getSelectedColor());
								((Line) selectedShape).setStartPoint(temp.getStartPoint());
								((Line) selectedShape).setEndPoint(temp.getEndPoint());
								((Line) selectedShape).setCurrentColor(temp.getCurrentColor());
								drl.setFlag(false);
								panelCenter.repaint();
							}
						}
						else if(selectedShape instanceof Rectangle)
						{
							Rectangle temp = (Rectangle) selectedShape;
							DlgRectangle drwr = new DlgRectangle();
							drwr.getTextFieldX().setText(Integer.toString(temp.getUpperLeft().getX()));
							drwr.getTextFieldY().setText(Integer.toString(temp.getUpperLeft().getY()));
							drwr.getTextFieldWidth().setText(Integer.toString(temp.getWidth()));
							drwr.getTextFieldHeight().setText(Integer.toString(temp.getHeight()));
							drwr.setVisible(true);
							if(drwr.isFlag())
							{
								temp.getUpperLeft().setX(drwr.getCheckX());
								temp.getUpperLeft().setY(drwr.getCheckX());
								temp.setWidth(drwr.getCheckWidth());
								temp.setHeight(drwr.getCheckHeight());
								temp.setRectangleBorderColor(DlgRectangle.getCurrentBorderColor());
								temp.setRectangleFillColor(DlgRectangle.getCurrentFillColor());
								((Rectangle) selectedShape).getUpperLeft().moveTo(temp.getUpperLeft().getX(), temp.getUpperLeft().getY());
								((Rectangle) selectedShape).setWidth(temp.getWidth());
								((Rectangle) selectedShape).setHeight(temp.getHeight());
								((Rectangle) selectedShape).setRectangleBorderColor(temp.getRectangleBorderColor());
								((Rectangle) selectedShape).setRectangleFillColor(temp.getRectangleFillColor());
								drwr.setFlag(false);
								panelCenter.repaint();
							}
						}
						else if(selectedShape instanceof Donut)
						{
							Donut temp = (Donut) selectedShape;
							DlgDonut drdr = new DlgDonut();
							drdr.getTextFieldX().setText(Integer.toString(temp.getCenter().getX()));
							drdr.getTextFieldY().setText(Integer.toString(temp.getCenter().getY()));
							drdr.getTextFieldOuter().setText(Integer.toString(temp.getRadius()));
							drdr.getTextFieldInner().setText(Integer.toString(temp.getInnerRadius()));
							drdr.setVisible(true);
							if(drdr.isFlag())
							{
								temp.getCenter().moveTo(drdr.getCheckX(), drdr.getCheckY());
								try
								{
									temp.setRadius(drdr.getCheckOuter());
								}
								catch(Exception ex)
								{
									System.out.println(ex.getMessage());
								}
								temp.setInnerRadius(drdr.getCheckInner());
								temp.setCurrentDBorderColor(DlgDonut.getCurrentDBorderColor());
								temp.setCurrentDFillColor(DlgDonut.getCurrentDFillColor());
								((Donut) selectedShape).setCenter(temp.getCenter());
								try
								{
									((Donut) selectedShape).setRadius(temp.getRadius());
								}
								catch(Exception ex)
								{
									System.out.println(ex.getMessage());
								}
								((Donut) selectedShape).setInnerRadius(temp.getInnerRadius());
								((Donut) selectedShape).setCurrentDBorderColor(temp.getCurrentDBorderColor());
								((Donut) selectedShape).setCurrentDFillColor(temp.getCurrentDFillColor());
								drdr.setFlag(false);
								panelCenter.repaint();
							}
						}
						else if(selectedShape instanceof Circle)
						{
							Circle temp = (Circle) selectedShape;
							DlgCircle drcr = new DlgCircle();
							drcr.getTextFieldX().setText(Integer.toString(temp.getCenter().getX()));
							drcr.getTextFieldY().setText(Integer.toString(temp.getCenter().getY()));
							drcr.getTextFieldRadius().setText(Integer.toString(temp.getRadius()));
							drcr.setVisible(true);
							if(drcr.isFlag())
							{
								temp.getCenter().moveTo(drcr.getCheckX(), drcr.getCheckY());
								try
								{
									temp.setRadius(drcr.getCheckRadius());
								}
								catch(Exception ex)
								{
									System.out.println(ex.getMessage());
								}
								temp.setCurrentBorderColor(DlgCircle.getCurrentBorderColor());
								temp.setCurrentFillColor(DlgCircle.getCurrentFillColor());
								((Circle) selectedShape).setCenter(temp.getCenter());
								try
								{
									((Circle) selectedShape).setRadius(temp.getRadius());
								}
								catch(Exception ex)
								{
									System.out.println(ex.getMessage());
								}
								((Circle) selectedShape).setCurrentBorderColor(temp.getCurrentBorderColor());
								((Circle) selectedShape).setCurrentFillColor(temp.getCurrentFillColor());
								drcr.setFlag(false);
								panelCenter.repaint();
							}
						}
						
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "You must select shape!", "WARNING!", JOptionPane.WARNING_MESSAGE);
					}

				}
		});
		
		JButton btnRemove = new JButton("Remove");
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRemove.insets = new Insets(0, 0, 5, 0);
		gbc_btnRemove.gridx = 4;
		gbc_btnRemove.gridy = 0;
		panelNorth.add(btnRemove, gbc_btnRemove);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(PnlDrawing.getSelectedShape() != null)
				{
					int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove selected shape?", "Remove", JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.YES_OPTION)
					{
						PnlDrawing.getShapeList().remove(PnlDrawing.getSelectedShape());
						PnlDrawing.setSelectedShape(null);
						panelCenter.repaint();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You must select shape!", "WARNING!", JOptionPane.WARNING_MESSAGE);
				}
			}
		
			
				
	});
		
		JToggleButton tglbtnPoint = new JToggleButton("Point");
		GridBagConstraints gbc_tglbtnPoint = new GridBagConstraints();
		gbc_tglbtnPoint.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnPoint.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnPoint.gridx = 0;
		gbc_tglbtnPoint.gridy = 1;
		panelNorth.add(tglbtnPoint, gbc_tglbtnPoint);
		group.add(tglbtnPoint);
		tglbtnPoint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DrawingApp.setDrawThisShape("Point");
			}
			
		});
		
		JToggleButton tglbtnLine = new JToggleButton("Line");
		GridBagConstraints gbc_tglbtnLine = new GridBagConstraints();
		gbc_tglbtnLine.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnLine.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnLine.gridx = 1;
		gbc_tglbtnLine.gridy = 1;
		panelNorth.add(tglbtnLine, gbc_tglbtnLine);
		group.add(tglbtnLine);
		tglbtnLine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DrawingApp.setDrawThisShape("Line");
			}
			
		});
		
		JToggleButton tglbtnRectangel = new JToggleButton("Rectangle");
		GridBagConstraints gbc_tglbtnRectangel = new GridBagConstraints();
		gbc_tglbtnRectangel.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnRectangel.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnRectangel.gridx = 2;
		gbc_tglbtnRectangel.gridy = 1;
		panelNorth.add(tglbtnRectangel, gbc_tglbtnRectangel);
		
		tglbtnRectangel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DrawingApp.setDrawThisShape("Rectangle");
			}
			
		});
		group.add(tglbtnRectangel);
		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		GridBagConstraints gbc_tglbtnCircle = new GridBagConstraints();
		gbc_tglbtnCircle.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnCircle.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnCircle.gridx = 3;
		gbc_tglbtnCircle.gridy = 1;
		panelNorth.add(tglbtnCircle, gbc_tglbtnCircle);
		group.add(tglbtnCircle);
		 tglbtnCircle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DrawingApp.setDrawThisShape("Circle");
			}
			
		});
		
		JToggleButton tglbtnDonut = new JToggleButton("Donut");
		GridBagConstraints gbc_tglbtnDonut = new GridBagConstraints();
		gbc_tglbtnDonut.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnDonut.gridx = 4;
		gbc_tglbtnDonut.gridy = 1;
		panelNorth.add(tglbtnDonut, gbc_tglbtnDonut);
		group.add(tglbtnDonut);
		tglbtnDonut.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					DrawingApp.setDrawThisShape("Donut");
				}
				
			});
		
		
		
}

	public static String getDrawThisShape() {
		return drawThisShape;
	}

	public static void setDrawThisShape(String drawThisShape) {
		DrawingApp.drawThisShape = drawThisShape;
	}

	public static String getSelection() {
		return selection;
	}

	public static void setSelection(String selection) {
		DrawingApp.selection = selection;
	}
}
