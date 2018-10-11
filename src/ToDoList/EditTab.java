package ToDoList;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EditTab extends JFrame {
	
	private JPanel contentPane;

	private static final long serialVersionUID = 1L;

	public EditTab() {
		setResizable(false);

		setBounds((int)(Main.cst.width - 440)/2, (int)(Main.cst.height-211)/2, 377, 147);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int keycode = e.getKeyCode();
				if (keycode == KeyEvent.VK_ESCAPE){
					Close();
				}
				if (keycode == KeyEvent.VK_ENTER) {
					Main.EditTab(textField.getText());
					textField.setText("");
					Close();
				}
			}
		});
		textField.setFont(new Font("Verdana", Font.PLAIN, 14));
		textField.setBounds(29, 38, 318, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lbNameTab = new JLabel("T\u00EAn m\u1EDBi");
		lbNameTab.setFont(new Font("Verdana", Font.PLAIN, 13));
		lbNameTab.setBounds(29, 0, 318, 39);
		contentPane.add(lbNameTab);
		
		JButton btnOK = new JButton("OK");
		btnOK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Main.EditTab(textField.getText());
				textField.setText("");
				textField.requestFocusInWindow();
				Close();
			}
		});
		btnOK.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnOK.setBounds(199, 78, 61, 29);
		contentPane.add(btnOK);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Close();
			}
		});
		btnCancel.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnCancel.setBounds(270, 78, 77, 29);
		contentPane.add(btnCancel);
	}
	void Close() { 
	    this.setVisible(false);
	}
}
