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
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DlgCircle extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldRadius;
	private int checkX,checkY,checkRadius;
	public static Color currentFillColor =  Color.WHITE;;
	public static Color currentBorderColor = Color.BLACK;
	public static Color previusBorderColor = null;
	public static Color previusFillColor = null;
	public static Color selectedFillColor;
	public static Color selectedBorderColor;
	private boolean flag;
			
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setTitle("Circle");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{95, 95, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{25, 25, 25, 25, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel_3 = new JLabel("Center:");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 0;
			gbc_lblNewLabel_3.gridy = 2;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			JLabel lblCenterX = new JLabel("X coordinate:");
			GridBagConstraints gbc_lblCenterX = new GridBagConstraints();
			gbc_lblCenterX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterX.anchor = GridBagConstraints.EAST;
			gbc_lblCenterX.gridx = 1;
			gbc_lblCenterX.gridy = 2;
			contentPanel.add(lblCenterX, gbc_lblCenterX);
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
					if(!Character.isDigit(typedChar) && typedChar != KeyEvent.VK_BACK_SPACE)
					{
						e.consume();
					}
				}
			});
		}
		{
			JLabel lblCenterY = new JLabel("Y coordinate:");
			GridBagConstraints gbc_lblCenterY = new GridBagConstraints();
			gbc_lblCenterY.anchor = GridBagConstraints.EAST;
			gbc_lblCenterY.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterY.gridx = 1;
			gbc_lblCenterY.gridy = 3;
			contentPanel.add(lblCenterY, gbc_lblCenterY);
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
			JLabel lblRadius = new JLabel("Radius:");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.anchor = GridBagConstraints.EAST;
			gbc_lblRadius.insets = new Insets(0, 0, 0, 5);
			gbc_lblRadius.gridx = 1;
			gbc_lblRadius.gridy = 4;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			textFieldRadius = new JTextField();
			GridBagConstraints gbc_textFieldRadius = new GridBagConstraints();
			gbc_textFieldRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldRadius.gridx = 2;
			gbc_textFieldRadius.gridy = 4;
			contentPanel.add(textFieldRadius, gbc_textFieldRadius);
			textFieldRadius.setColumns(10);
			textFieldRadius.addKeyListener(new KeyAdapter() {
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
						 previusBorderColor = currentBorderColor;
						
						
						 selectedBorderColor = JColorChooser.showDialog(null, "Choose Circle Border Color", Color.WHITE);
						
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
						
						 selectedFillColor = JColorChooser.showDialog(null, "Choose Circle Fill Color", Color.WHITE);
						
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
						try 
						{
						checkX = Integer.parseInt(getTextFieldX().getText());
						checkY = Integer.parseInt(getTextFieldY().getText());
						checkRadius = Integer.parseInt(getTextFieldRadius().getText());
						
						
							if(checkX <= 420 && checkY <= 190 && checkRadius <= 100) {
								
								flag=true;
								
								PnlDrawing.setRadius(checkRadius);
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

	public JTextField getTextFieldRadius() {
		return textFieldRadius;
	}

	public void setTextFieldRadius(JTextField textFieldRadius) {
		this.textFieldRadius = textFieldRadius;
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

	public int getCheckRadius() {
		return checkRadius;
	}

	public void setCheckRadius(int checkRadius) {
		this.checkRadius = checkRadius;
	}

	public static Color getCurrentFillColor() {
		return currentFillColor;
	}

	public static void setCurrentFillColor(Color currentFillColor) {
		DlgCircle.currentFillColor = currentFillColor;
	}

	public static Color getCurrentBorderColor() {
		return currentBorderColor;
	}

	public static void setCurrentBorderColor(Color currentBorderColor) {
		DlgCircle.currentBorderColor = currentBorderColor;
	}

	public static Color getPreviusBorderColor() {
		return previusBorderColor;
	}

	public static void setPreviusBorderColor(Color previusBorderColor) {
		DlgCircle.previusBorderColor = previusBorderColor;
	}

	public static Color getPreviusFillColor() {
		return previusFillColor;
	}

	public static void setPreviusFillColor(Color previusFillColor) {
		DlgCircle.previusFillColor = previusFillColor;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
