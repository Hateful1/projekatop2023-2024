package geometry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JTextField;

public class DlgPoint extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	public static Color currentColor = null;
	public static Color previusColor = null;
	public static Color selectedColor;

	private int checkX, checkY;
	private boolean flag;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPoint dialog = new DlgPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPoint() {
		setTitle("Point");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{95, 95, 90, 0};
		gbl_contentPanel.rowHeights = new int[]{25, 25, 25, 25, 10, 25, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
	
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
			GridBagConstraints gbc_textFieldSX = new GridBagConstraints();
			gbc_textFieldSX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldSX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldSX.gridx = 2;
			gbc_textFieldSX.gridy = 2;
			contentPanel.add(textFieldX, gbc_textFieldSX);
			textFieldX.setColumns(10);
			textFieldX.addKeyListener(new KeyAdapter() {
			    @Override
			    public void keyTyped(KeyEvent e) {
			        char typedChar = e.getKeyChar();

			        
			        if (!Character.isDigit(typedChar) && typedChar != KeyEvent.VK_BACK_SPACE) {
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

			        
			        if (!Character.isDigit(typedChar) && typedChar != KeyEvent.VK_BACK_SPACE) {
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
				JButton btnColor = new JButton("Color");
				buttonPane.add(btnColor);
				btnColor.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					
						 previusColor = currentColor;
						
						 selectedColor = JColorChooser.showDialog(null, "choose the color", Color.WHITE);
					
						if(selectedColor != null) {
							currentColor = selectedColor;
							
						}else {
							currentColor = previusColor;
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
						
						try {
							checkX = Integer.parseInt(getTextFieldX().getText());
							checkY = Integer.parseInt(getTextFieldY().getText());
							
							if(checkX <= 420 && checkY <= 190) {
								flag=true;
								dispose();
								
								
							}else {
								showErrorMessage("Input can't be bigger for X (0 - 420) and for Y (0 - 190)!");
							}
							
						}catch (NumberFormatException ex) {
							showErrorMessage("Wrong input, try again!");
						}
							
						
					}

					private void showErrorMessage(String message) {
						// TODO Auto-generated method stub
						JOptionPane.showMessageDialog(null, message,"Incorrect input", JOptionPane.ERROR_MESSAGE);
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

	public static Color getCurrentColor() {
		return currentColor;
	}

	public static void setCurrentColor(Color currentColor) {
		DlgPoint.currentColor = currentColor;
	}

	public static Color getPreviusColor() {
		return previusColor;
	}

	public static void setPreviusColor(Color previusColor) {
		DlgPoint.previusColor = previusColor;
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

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public static Color getSelectedColor() {
		return selectedColor;
	}

	public static void setSelectedColor(Color selectedColor) {
		DlgPoint.selectedColor = selectedColor;
	}

	

}
