package geometry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

public class DlgDonut extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldOuter;
	private JTextField textFieldInner;
	private int checkX,checkY,checkInner,checkOuter;
	public static Color currentDFillColor= null;
	public static Color currentDBorderColor = null;
	public static Color previusDFillColor=null;
	public static Color previusDBorderColor = null;
	public static Color selectedDBorderColor;
	public static Color selectedDFillColor;
	private boolean flag;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
		setTitle("Donut");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{95, 95, 90, 0};
		gbl_contentPanel.rowHeights = new int[]{25, 25, 25, 5, 25, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel_4 = new JLabel("Center:");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 0;
			gbc_lblNewLabel_4.gridy = 2;
			contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			JLabel lblX = new JLabel("X coordinate:");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.anchor = GridBagConstraints.EAST;
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.gridx = 1;
			gbc_lblX.gridy = 2;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			textFieldX = new JTextField();
			GridBagConstraints gbc_textFieldX = new GridBagConstraints();
			gbc_textFieldX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldX.gridx = 2;
			gbc_textFieldX.gridy = 2;
			contentPanel.add(textFieldX, gbc_textFieldX);
			textFieldX.setColumns(10);
			textFieldX.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char typedChar = e.getKeyChar();
					
					if(!Character.isDigit(typedChar) && typedChar!=KeyEvent.VK_BACK_SPACE)
					{
						e.consume();
					}

				}
			});
		}
		{
			JLabel lblY = new JLabel("Y coordinate:");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.anchor = GridBagConstraints.EAST;
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 1;
			gbc_lblY.gridy = 3;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			textFieldY = new JTextField();
			GridBagConstraints gbc_textFieldY = new GridBagConstraints();
			gbc_textFieldY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldY.gridx = 2;
			gbc_textFieldY.gridy = 3;
			contentPanel.add(textFieldY, gbc_textFieldY);
			textFieldY.setColumns(10);
			textFieldY.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char typedChar = e.getKeyChar();
					
					if(!Character.isDigit(typedChar) && typedChar!=KeyEvent.VK_BACK_SPACE)
					{
						e.consume();
					}

				}
			});
		}
		{
			JLabel lblOuter = new JLabel("Outer radius:");
			GridBagConstraints gbc_lblOuter = new GridBagConstraints();
			gbc_lblOuter.anchor = GridBagConstraints.EAST;
			gbc_lblOuter.insets = new Insets(0, 0, 5, 5);
			gbc_lblOuter.gridx = 1;
			gbc_lblOuter.gridy = 4;
			contentPanel.add(lblOuter, gbc_lblOuter);
		}
		{
			textFieldOuter = new JTextField();
			GridBagConstraints gbc_textFieldOuter = new GridBagConstraints();
			gbc_textFieldOuter.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldOuter.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldOuter.gridx = 2;
			gbc_textFieldOuter.gridy = 4;
			contentPanel.add(textFieldOuter, gbc_textFieldOuter);
			textFieldOuter.setColumns(10);
			textFieldOuter.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char typedChar = e.getKeyChar();
					
					if(!Character.isDigit(typedChar) && typedChar!=KeyEvent.VK_BACK_SPACE) {
						e.consume();
					}
;
				}
			});
		}
		{
			JLabel lblInner = new JLabel("Inner Radius:");
			GridBagConstraints gbc_lblInner = new GridBagConstraints();
			gbc_lblInner.anchor = GridBagConstraints.EAST;
			gbc_lblInner.insets = new Insets(0, 0, 0, 5);
			gbc_lblInner.gridx = 1;
			gbc_lblInner.gridy = 5;
			contentPanel.add(lblInner, gbc_lblInner);
		}
		{
			textFieldInner = new JTextField();
			GridBagConstraints gbc_textFieldInner = new GridBagConstraints();
			gbc_textFieldInner.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldInner.gridx = 2;
			gbc_textFieldInner.gridy = 5;
			contentPanel.add(textFieldInner, gbc_textFieldInner);
			textFieldInner.setColumns(10);
			textFieldInner.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char typedChar = e.getKeyChar();
					
					if(!Character.isDigit(typedChar) && typedChar!=KeyEvent.VK_BACK_SPACE) {
						e.consume();
					}
;
				}
			});
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnBorderColor = new JButton("Border Color");
				buttonPane.add(btnBorderColor);
				btnBorderColor.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						 previusDBorderColor = currentDBorderColor;
						
						
						 selectedDBorderColor = JColorChooser.showDialog(null, "Choose Circle Border Color", Color.WHITE);
						
						if(selectedDBorderColor != null) {
							currentDBorderColor = selectedDBorderColor;
						}else {
							currentDBorderColor = previusDBorderColor;
						}
					}
				});
			}
			{
				JButton btnFillColor = new JButton("Fill Color");
				buttonPane.add(btnFillColor);
				btnFillColor.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						 previusDFillColor = currentDFillColor;
						
						selectedDFillColor = JColorChooser.showDialog(null, "Choose Circle Fill Color",  Color.WHITE);
						
						if(selectedDFillColor != null) {
							currentDFillColor = selectedDFillColor;
						}else {
							currentDFillColor = previusDFillColor;
						}
					}
				});
			}
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try 
						{
						checkX = Integer.parseInt(getTextFieldX().getText());
						checkY = Integer.parseInt(getTextFieldY().getText());
						checkInner = Integer.parseInt(getTextFieldInner().getText());
						checkOuter = Integer.parseInt(getTextFieldOuter().getText());
						
						
							if(checkX <= 420 && checkY <= 190 && checkInner <= 100 && checkOuter <= 100) {
								flag=true;
								PnlDrawing.setORadiusIRadius(checkOuter, checkInner);
								dispose();
								
							}else {
								showErrorMessage("Input can't be bigger for X (0 - 342) and for Y (0-196), also values for the Radius MUST be inside (0-100)!");
							}
						}
					 	catch (NumberFormatException ex) {
							showErrorMessage("Wrong input. Try again!");
						}
						
						
					}

					private void showErrorMessage(String message) {
						// TODO Auto-generated method stub
						JOptionPane.showMessageDialog(null, message,"incorrect input",JOptionPane.ERROR_MESSAGE);	
					}
				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
						
					}
				});
			}
		}
	}

	public JTextField getTextFieldX() {
		return textFieldX;
	}

	public void setTextFieldX(JTextField textFieldX) {
		this.textFieldX = textFieldX;
	}

	public JTextField getTextFieldY() {
		return textFieldY;
	}

	public void setTextFieldY(JTextField textFieldY) {
		this.textFieldY = textFieldY;
	}

	public JTextField getTextFieldOuter() {
		return textFieldOuter;
	}

	public void setTextFieldOuter(JTextField textFieldOuter) {
		this.textFieldOuter = textFieldOuter;
	}

	public JTextField getTextFieldInner() {
		return textFieldInner;
	}

	public void setTextFieldInner(JTextField textFieldInner) {
		this.textFieldInner = textFieldInner;
	}

	public int getCheckX() {
		return checkX;
	}

	public void setCheckX(int checkX) {
		this.checkX = checkX;
	}

	public int getCheckY() {
		return checkY;
	}

	public void setCheckY(int checkY) {
		this.checkY = checkY;
	}

	public int getCheckInner() {
		return checkInner;
	}

	public void setCheckInner(int checkInner) {
		this.checkInner = checkInner;
	}

	public int getcheckOuter() {
		return checkOuter;
	}

	public void setcheckOuter(int checkOuter) {
		checkOuter = checkOuter;
	}

	public int getCheckOuter() {
		return checkOuter;
	}

	public void setCheckOuter(int checkOuter) {
		this.checkOuter = checkOuter;
	}

	public static Color getCurrentDFillColor() {
		return currentDFillColor;
	}

	public static void setCurrentDFillColor(Color currentDFillColor) {
		DlgDonut.currentDFillColor = currentDFillColor;
	}

	public static Color getCurrentDBorderColor() {
		return currentDBorderColor;
	}

	public static void setCurrentDBorderColor(Color currentDBorderColor) {
		DlgDonut.currentDBorderColor = currentDBorderColor;
	}

	public static Color getPreviusDFillColor() {
		return previusDFillColor;
	}

	public static void setPreviusDFillColor(Color previusDFillColor) {
		DlgDonut.previusDFillColor = previusDFillColor;
	}

	public static Color getPreviusDBorderColor() {
		return previusDBorderColor;
	}

	public static void setPreviusDBorderColor(Color previusDBorderColor) {
		DlgDonut.previusDBorderColor = previusDBorderColor;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
