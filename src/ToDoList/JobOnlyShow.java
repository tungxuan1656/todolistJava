package ToDoList;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class JobOnlyShow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel pnJobOS;
	private JTextField time;
	private JCheckBox cbNotify;
	private JComboBox<Icon> cbbColor;
	private JScrollPane scrollpane1;
	private JTextArea textJob;
	private int status;
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public JobOnlyShow(Job j) {
		Init();
		textJob.setText(j.getTextArea().getText());
		
		cbNotify.setSelected(j.getCbNotify().isSelected());
		cbbColor.setSelectedIndex(j.getCbbColor().getSelectedIndex());
		status = j.getStatus();
		
		textJob.setEditable(false);
		textJob.setWrapStyleWord(true);
		textJob.setLineWrap(true);
		
		time.setEditable(false);
	}
	
	void Init() {
		pnJobOS = new JPanel();
		pnJobOS.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 205)));
		pnJobOS.setBackground(Color.WHITE);
		pnJobOS.setBounds(0, 143, 435, 120);
		add(pnJobOS);
		pnJobOS.setLayout(null);
		
		time = new JTextField();
		time.setBounds(5, 86, 309, 25);
		time.setFont(new Font("Verdana", Font.PLAIN, 11));
		pnJobOS.add(time);
		time.setColumns(10);
		
		cbNotify = new JCheckBox("Thông báo");
		cbNotify.setSelected(true);
		cbNotify.setFont(new Font("Verdana", Font.PLAIN, 11));
		cbNotify.setEnabled(false);
		cbNotify.setBounds(325, 15, 85, 23);
		pnJobOS.add(cbNotify);
		
		cbbColor = new JComboBox<Icon>();
		cbbColor.setModel(loadImage());
		cbbColor.setEnabled(false);
		cbbColor.setBounds(325, 50, 55, 23);
		pnJobOS.add(cbbColor);
		
		scrollpane1 = new JScrollPane();
		scrollpane1.setBounds(5, 5, 309, 77);
		pnJobOS.add(scrollpane1);
		
		textJob = new JTextArea();
		textJob.setLineWrap(true);
		textJob.setFont(new Font("Verdana", Font.PLAIN, 13));
		scrollpane1.setViewportView(textJob);
	}
	
	public JPanel getPnJobOS() {
		return pnJobOS;
	}

	public void setPnJobOS(JPanel pnJobOS) {
		this.pnJobOS = pnJobOS;
	}

	public JTextField getTime() {
		return time;
	}

	public void setTime(JTextField time) {
		this.time = time;
	}

	public JCheckBox getCbNotify() {
		return cbNotify;
	}

	public void setCbNotify(JCheckBox cbNotify) {
		this.cbNotify = cbNotify;
	}

	public JComboBox<Icon> getCbbColor() {
		return cbbColor;
	}

	public void setCbbColor(JComboBox<Icon> cbbColor) {
		this.cbbColor = cbbColor;
	}

	public JScrollPane getScrollpane1() {
		return scrollpane1;
	}

	public void setScrollpane1(JScrollPane scrollpane1) {
		this.scrollpane1 = scrollpane1;
	}
	
	public JTextArea getTextJob() {
		return textJob;
	}

	public void setTextJob(JTextArea textJob) {
		this.textJob = textJob;
	}

	private DefaultComboBoxModel<Icon> loadImage() {
		DefaultComboBoxModel<Icon> dm = new DefaultComboBoxModel<Icon>();
		dm.addElement(new ImageIcon(Home.class.getResource("/image/red.png")));
		dm.addElement(new ImageIcon(Home.class.getResource("/image/yellow.png")));
		dm.addElement(new ImageIcon(Home.class.getResource("/image/green.png")));
		dm.addElement(new ImageIcon(Home.class.getResource("/image/blue.png")));
		return dm;
	}
}
