package geometry;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DlgStackSort extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldRadius;
	private JTextField textFieldX;
	private JTextField textFieldY;
	private int checkOne, checkTwo, checkThree;
	private boolean flag = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgStackSort dialog = new DlgStackSort();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setResizable(false);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgStackSort() {
		setTitle("Circle");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{120, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{63, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXcoordinate = new JLabel("X coordinate:");
			lblXcoordinate.setFont(new Font("Tahoma", Font.BOLD, 12));
			GridBagConstraints gbc_lblXcoordinate = new GridBagConstraints();
			gbc_lblXcoordinate.anchor = GridBagConstraints.EAST;
			gbc_lblXcoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblXcoordinate.gridx = 1;
			gbc_lblXcoordinate.gridy = 1;
			contentPanel.add(lblXcoordinate, gbc_lblXcoordinate);
		}
		{
			textFieldX = new JTextField();
			textFieldX.addKeyListener(new KeyAdapter() {
				  @Override
				    public void keyTyped(KeyEvent e) {
				        char typedChar = e.getKeyChar();

				        
				        if (!Character.isDigit(typedChar) && typedChar != KeyEvent.VK_BACK_SPACE) {
				            e.consume(); 
				        }
				    }
			});
			GridBagConstraints gbc_textFieldX = new GridBagConstraints();
			gbc_textFieldX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldX.gridx = 2;
			gbc_textFieldX.gridy = 1;
			contentPanel.add(textFieldX, gbc_textFieldX);
			textFieldX.setColumns(10);
		}
		{
			JLabel lblYcoordinate = new JLabel("Y coordinate:");
			lblYcoordinate.setFont(new Font("Tahoma", Font.BOLD, 12));
			GridBagConstraints gbc_lblYcoordinate = new GridBagConstraints();
			gbc_lblYcoordinate.anchor = GridBagConstraints.EAST;
			gbc_lblYcoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblYcoordinate.gridx = 1;
			gbc_lblYcoordinate.gridy = 2;
			contentPanel.add(lblYcoordinate, gbc_lblYcoordinate);
		}
		{
			textFieldY = new JTextField();
			textFieldY.addKeyListener(new KeyAdapter() {
				  @Override
				    public void keyTyped(KeyEvent e) {
				        char typedChar = e.getKeyChar();

				        
				        if (!Character.isDigit(typedChar) && typedChar != KeyEvent.VK_BACK_SPACE) {
				            e.consume(); 
				        }
				    }
			});
			GridBagConstraints gbc_textFieldY = new GridBagConstraints();
			gbc_textFieldY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldY.gridx = 2;
			gbc_textFieldY.gridy = 2;
			contentPanel.add(textFieldY, gbc_textFieldY);
			textFieldY.setColumns(10);
		}
		{
			JLabel lblRadius = new JLabel("Radius:");
			lblRadius.setFont(new Font("Tahoma", Font.BOLD, 12));
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.anchor = GridBagConstraints.EAST;
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 1;
			gbc_lblRadius.gridy = 3;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			textFieldRadius = new JTextField();
			textFieldRadius.addKeyListener(new KeyAdapter() {
				  @Override
				    public void keyTyped(KeyEvent e) {
				        char typedChar = e.getKeyChar();

				        
				        if (!Character.isDigit(typedChar) && typedChar != KeyEvent.VK_BACK_SPACE) {
				            e.consume(); 
				        }
				    }
			});
			GridBagConstraints gbc_textFieldRadius = new GridBagConstraints();
			gbc_textFieldRadius.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldRadius.gridx = 2;
			gbc_textFieldRadius.gridy = 3;
			contentPanel.add(textFieldRadius, gbc_textFieldRadius);
			textFieldRadius.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					 try{
						checkOne = Integer.parseInt(getTextFieldX().getText());
						checkTwo = Integer.parseInt(getTextFieldY().getText());
						checkThree = Integer.parseInt(getTextFieldRadius().getText());
					
						if(checkOne >= 0 && checkTwo >= 0 && checkThree >=0) {
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
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

	}
	
	public JTextField getTextFieldRadius() {
		return textFieldRadius;
	}

	public JTextField getTextFieldX() {
		return textFieldX;
	}

	public JTextField getTextFieldY() {
		return textFieldY;
	}

	public boolean isflag() {
		return flag;
	}

	public void setflag(boolean flag) {
		this.flag = flag;
	}
	public int getCheck_one() {
		return checkOne;
	}

	public int getCheck_two() {
		return checkTwo;
	}

	public int getCheck_three() {
		return checkThree;
	}


}