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
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class DlgRectangle extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldWidth;
	private JTextField textFieldHeight;
	private int checkWidth,checkHeight,checkX,checkY;
	public static Color currentFillColor = null;
	public static Color currentBorderColor = null;
	public static Color previusFillColor = null;
	public static Color previusBorderColor = null;
	public static Color selectedFillColor;
	public static Color selectedBorderColor;
	public boolean red;
	private boolean flag;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		setTitle("Rectangle");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{90, 90, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{25, 25, 25, 25, 25, 25, 25, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Upper Left:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 2;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblUpperX = new JLabel("X coordinate:");
			GridBagConstraints gbc_lblUpperX = new GridBagConstraints();
			gbc_lblUpperX.anchor = GridBagConstraints.EAST;
			gbc_lblUpperX.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpperX.gridx = 1;
			gbc_lblUpperX.gridy = 2;
			contentPanel.add(lblUpperX, gbc_lblUpperX);
		}
		{
			textFieldX = new JTextField();
			GridBagConstraints gbc_textFieldX = new GridBagConstraints();
			gbc_textFieldX.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldX.gridx = 2;
			gbc_textFieldX.gridy = 2;
			contentPanel.add(textFieldX, gbc_textFieldX);
			textFieldX.setColumns(10);
			textFieldX.addKeyListener(new KeyAdapter(){
				@Override
				public void keyTyped(KeyEvent e) {
					char typedChar = e.getKeyChar();
					if(!Character.isDigit(typedChar) && typedChar != KeyEvent.VK_BACK_SPACE) {
						e.consume();
					}
				}
				
			});
			
		}
		{
			JLabel lblUpperY = new JLabel("Y coordinate:");
			GridBagConstraints gbc_lblUpperY = new GridBagConstraints();
			gbc_lblUpperY.anchor = GridBagConstraints.EAST;
			gbc_lblUpperY.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpperY.gridx = 1;
			gbc_lblUpperY.gridy = 3;
			contentPanel.add(lblUpperY, gbc_lblUpperY);
		}
		{
			textFieldY = new JTextField();
			GridBagConstraints gbc_textFieldY = new GridBagConstraints();
			gbc_textFieldY.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldY.gridx = 2;
			gbc_textFieldY.gridy = 3;
			contentPanel.add(textFieldY, gbc_textFieldY);
			textFieldY.setColumns(10);
			textFieldY.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char typedChar = e.getKeyChar();
					if(!Character.isDigit(typedChar) && typedChar != KeyEvent.VK_BACK_SPACE) {
						e.consume();
					}
				}
			});
		}
		{
			JLabel lblWidth = new JLabel("Width:");
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.anchor = GridBagConstraints.EAST;
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.gridx = 1;
			gbc_lblWidth.gridy = 5;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			textFieldWidth = new JTextField();
			GridBagConstraints gbc_textFieldWidth = new GridBagConstraints();
			gbc_textFieldWidth.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldWidth.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldWidth.gridx = 2;
			gbc_textFieldWidth.gridy = 5;
			contentPanel.add(textFieldWidth, gbc_textFieldWidth);
			textFieldWidth.setColumns(10);
			textFieldWidth.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char typedChar = e.getKeyChar();
					if(!Character.isDigit(typedChar) && typedChar != KeyEvent.VK_BACK_SPACE) {
						e.consume();
					}
					
				}
			});
		}
		{
			JLabel lblHeight = new JLabel("Height:");
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.anchor = GridBagConstraints.EAST;
			gbc_lblHeight.insets = new Insets(0, 0, 0, 5);
			gbc_lblHeight.gridx = 1;
			gbc_lblHeight.gridy = 6;
			contentPanel.add(lblHeight, gbc_lblHeight);
		}
		{
			textFieldHeight = new JTextField();
			GridBagConstraints gbc_textFieldHeight = new GridBagConstraints();
			gbc_textFieldHeight.insets = new Insets(0, 0, 0, 5);
			gbc_textFieldHeight.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldHeight.gridx = 2;
			gbc_textFieldHeight.gridy = 6;
			contentPanel.add(textFieldHeight, gbc_textFieldHeight);
			textFieldHeight.setColumns(10);
			textFieldHeight.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char typedChar = e.getKeyChar();
					
					if(!Character.isDigit(typedChar) && typedChar != KeyEvent.VK_BACK_SPACE) {
						e.consume();
					}
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
					
						 previusBorderColor = currentBorderColor;
						
						 selectedBorderColor = JColorChooser.showDialog(null, "Choose rectangle border color", Color.WHITE);
					
						if(selectedBorderColor != null) {
							currentBorderColor = selectedBorderColor;
							
						}else {
							currentBorderColor = previusBorderColor;
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
					
						 previusFillColor = currentFillColor;
						
						 selectedFillColor = JColorChooser.showDialog(null, "Choose rectangle fill color", Color.WHITE);
					
						if(selectedFillColor != null) {
							currentFillColor = selectedFillColor;
							
						}else {
							currentFillColor = previusFillColor;
						}
					}
				});
			}
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						
					 try{
						checkX = Integer.parseInt(getTextFieldX().getText());
						checkY = Integer.parseInt(getTextFieldY().getText());
						checkWidth = Integer.parseInt(getTextFieldWidth().getText());
						checkHeight = Integer.parseInt(getTextFieldHeight().getText());
						
						if(checkX <= 420 && checkY <= 190 && checkWidth <= 100 && checkHeight <=100) {
							
							flag=true;
							
							PnlDrawing.setWidthHeight(checkWidth, checkHeight);
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
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addMouseListener(new MouseAdapter(){
				
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

	public JTextField getTextFieldWidth() {
		return textFieldWidth;
	}

	public void setTextFieldWidth(JTextField textFieldWidth) {
		this.textFieldWidth = textFieldWidth;
	}

	public JTextField getTextFieldHeight() {
		return textFieldHeight;
	}

	public void setTextFieldHeight(JTextField textFieldHeight) {
		this.textFieldHeight = textFieldHeight;
	}

	public int getCheckWidth() {
		return checkWidth;
	}

	public void setCheckWidth(int checkWidth) {
		this.checkWidth = checkWidth;
	}

	public int getCheckHeight() {
		return checkHeight;
	}

	public void setCheckHeight(int checkHeight) {
		this.checkHeight = checkHeight;
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

	public static Color getCurrentFillColor() {
		return currentFillColor;
	}

	public static void setCurrentFillColor(Color currentFillColor) {
		DlgRectangle.currentFillColor = currentFillColor;
	}

	public static Color getCurrentBorderColor() {
		return currentBorderColor;
	}

	public static void setCurrentBorderColor(Color currentBorderColor) {
		DlgRectangle.currentBorderColor = currentBorderColor;
	}

	public static Color getPreviusFillColor() {
		return previusFillColor;
	}

	public static void setPreviusFillColor(Color previusFillColor) {
		DlgRectangle.previusFillColor = previusFillColor;
	}

	public static Color getPreviusBorderColor() {
		return previusBorderColor;
	}

	public static void setPreviusBorderColor(Color previusBorderColor) {
		DlgRectangle.previusBorderColor = previusBorderColor;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean isRed() {
		return red;
	}

	public void setRed(boolean red) {
		this.red = red;
	}

}
