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

public class DlgLine extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldSX;
	private JTextField textFieldSY;
	public static Color currentColor = null;
	private JTextField textFieldEX;
	private JTextField textFieldEY;
	public static Color previusColor = null;
	public static Color selectedColor;
	private int checkSX, checkSY,checkEX,checkEY;
	private boolean flag;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLine() {
		setTitle("Line");
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
			JLabel lblStartingPoint = new JLabel("Starting Point:");
			GridBagConstraints gbc_lblStartingPoint = new GridBagConstraints();
			gbc_lblStartingPoint.anchor = GridBagConstraints.EAST;
			gbc_lblStartingPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartingPoint.gridx = 0;
			gbc_lblStartingPoint.gridy = 2;
			contentPanel.add(lblStartingPoint, gbc_lblStartingPoint);
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
			textFieldSX = new JTextField();
			GridBagConstraints gbc_textFieldSX = new GridBagConstraints();
			gbc_textFieldSX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldSX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldSX.gridx = 2;
			gbc_textFieldSX.gridy = 2;
			contentPanel.add(textFieldSX, gbc_textFieldSX);
			textFieldSX.setColumns(10);
			textFieldSX.addKeyListener(new KeyAdapter() {
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
			textFieldSY = new JTextField();
			GridBagConstraints gbc_textFieldSY = new GridBagConstraints();
			gbc_textFieldSY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldSY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldSY.gridx = 2;
			gbc_textFieldSY.gridy = 3;
			contentPanel.add(textFieldSY, gbc_textFieldSY);
			textFieldSY.setColumns(10);
			textFieldSY.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char typedChar = e.getKeyChar();
					if(!Character.isDigit(typedChar) && typedChar != KeyEvent.VK_BACK_SPACE) {
					e.consume();
					}
				}
			});
			{
				JLabel lblNewLabel = new JLabel("End Point:");
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.gridx = 0;
				gbc_lblNewLabel.gridy = 5;
				contentPanel.add(lblNewLabel, gbc_lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("X coordinate:");
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_1.gridx = 1;
				gbc_lblNewLabel_1.gridy = 5;
				contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
			}
			{
				textFieldEX = new JTextField();
				GridBagConstraints gbc_textFieldEX = new GridBagConstraints();
				gbc_textFieldEX.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldEX.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldEX.gridx = 2;
				gbc_textFieldEX.gridy = 5;
				contentPanel.add(textFieldEX, gbc_textFieldEX);
				textFieldEX.setColumns(10);
				textFieldEX.addKeyListener(new KeyAdapter() {
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
				JLabel lblNewLabel_2 = new JLabel("Y coordinate:");
				GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
				gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
				gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_2.gridx = 1;
				gbc_lblNewLabel_2.gridy = 6;
				contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
			}
			{
				textFieldEY = new JTextField();
				GridBagConstraints gbc_textFieldEY = new GridBagConstraints();
				gbc_textFieldEY.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldEY.gridx = 2;
				gbc_textFieldEY.gridy = 6;
				contentPanel.add(textFieldEY, gbc_textFieldEY);
				textFieldEY.setColumns(10);
			}
			textFieldEY.addKeyListener(new KeyAdapter() {
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
					 try{
						checkSX = Integer.parseInt(getTextFieldSX().getText());
						checkSY = Integer.parseInt(getTextFieldSY().getText());
						checkEX = Integer.parseInt(getTextFieldEX().getText());
						checkEY = Integer.parseInt(getTextFieldEY().getText());
						if(checkSX <= 420 && checkSY <= 190 && checkEX <= 420 && checkEY <= 190) {
							flag=true;
							dispose();
							
						} else {
							showErrorMessage("Input can't be bigger for X (0 - 342) and for Y (0-196)!");
						}
					 }catch (NumberFormatException ex) {
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

	public JTextField getTextFieldSX() {
		return textFieldSX;
	}

	public void setTextFieldSX(JTextField textFieldSX) {
		this.textFieldSX = textFieldSX;
	}

	public JTextField getTextFieldSY() {
		return textFieldSY;
	}

	public void setTextFieldSY(JTextField textFieldSY) {
		this.textFieldSY = textFieldSY;
	}

	public static Color getCurrentColor() {
		return currentColor;
	}

	public static void setCurrentColor(Color currentColor) {
		DlgLine.currentColor = currentColor;
	}

	public JTextField getTextFieldEX() {
		return textFieldEX;
	}

	public void setTextFieldEX(JTextField textFieldEX) {
		this.textFieldEX = textFieldEX;
	}

	public JTextField getTextFieldEY() {
		return textFieldEY;
	}

	public void setTextFieldEY(JTextField textFieldEY) {
		this.textFieldEY = textFieldEY;
	}

	public static Color getPreviusColor() {
		return previusColor;
	}

	public static void setPreviusColor(Color previusColor) {
		DlgLine.previusColor = previusColor;
	}

	public int getCheckSX() {
		return checkSX;
	}

	public void setCheckSX(int checkSX) {
		this.checkSX = checkSX;
	}

	public int getCheckSY() {
		return checkSY;
	}

	public void setCheckSY(int checkSY) {
		this.checkSY = checkSY;
	}

	public int getCheckEX() {
		return checkEX;
	}

	public void setCheckEX(int checkEX) {
		this.checkEX = checkEX;
	}

	public int getCheckEY() {
		return checkEY;
	}

	public void setCheckEY(int checkEY) {
		this.checkEY = checkEY;
	}

	public static Color getSelectedColor() {
		return selectedColor;
	}

	public static void setSelectedColor(Color selectedColor) {
		DlgLine.selectedColor = selectedColor;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}



}
