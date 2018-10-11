package ToDoList;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

public class DailyJob implements Comparable<DailyJob>{
	private static final long serialVersionUID = 1L;
	private JPanel pnJob;
	// cac nut
	private JButton btnDone, btnDel, btnNotDone;
	// thong bao
	private JCheckBox cbNotify;
	// gio
	private JComboBox<String> cbbHFrom, cbbMFrom, cbbHTo, cbbMTo;
	// noi dung cong viec
	private JTextArea textArea;
	// vi tri cong viec
	private int ID, status, indexLocation;
	

	// datetime nay lay tu combobox
	private DateTime date;
	
	
	private JMenuBar menuBar;
	private JMenu MnDayInWeek;
	private JCheckBoxMenuItem cbitMonday;
	private JCheckBoxMenuItem cbitTuesday;
	private JCheckBoxMenuItem cbitWednesday;
	private JCheckBoxMenuItem cbitThusday;
	private JCheckBoxMenuItem cbitFriday;
	private JCheckBoxMenuItem cbitSaturday;
	private JCheckBoxMenuItem cbitSunday;
	
	private List<JCheckBoxMenuItem> listcbday = new ArrayList<JCheckBoxMenuItem>();
	
	public List<JCheckBoxMenuItem> getListcbday() {
		return listcbday;
	}
	public void setListcbday(List<JCheckBoxMenuItem> listcbday) {
		this.listcbday = listcbday;
	}
	public JPanel getPnJob() {
		return pnJob;
	}
	public void setPnJob(JPanel pnJob) {
		this.pnJob = pnJob;
	}
	public JButton getBtnDone() {
		return btnDone;
	}
	public void setBtnDone(JButton btnDone) {
		this.btnDone = btnDone;
	}
	public JButton getBtnDel() {
		return btnDel;
	}
	public void setBtnDel(JButton btnDel) {
		this.btnDel = btnDel;
	}
	public JButton getBtnNotDone() {
		return btnNotDone;
	}
	public void setBtnNotDone(JButton btnNotDone) {
		this.btnNotDone = btnNotDone;
	}
	public JCheckBox getCbNotify() {
		return cbNotify;
	}
	public void setCbNotify(JCheckBox cbNotify) {
		this.cbNotify = cbNotify;
	}
	public JComboBox<String> getCbbHFrom() {
		return cbbHFrom;
	}
	public void setCbbHFrom(JComboBox<String> cbbHFrom) {
		this.cbbHFrom = cbbHFrom;
	}
	public JComboBox<String> getCbbMFrom() {
		return cbbMFrom;
	}
	public void setCbbMFrom(JComboBox<String> cbbMFrom) {
		this.cbbMFrom = cbbMFrom;
	}
	public JComboBox<String> getCbbHTo() {
		return cbbHTo;
	}
	public void setCbbHTo(JComboBox<String> cbbHTo) {
		this.cbbHTo = cbbHTo;
	}
	public JComboBox<String> getCbbMTo() {
		return cbbMTo;
	}
	public void setCbbMTo(JComboBox<String> cbbMTo) {
		this.cbbMTo = cbbMTo;
	}
	public JTextArea getTextArea() {
		return textArea;
	}
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIndexLocation() {
		return indexLocation;
	}
	public void setIndexLocation(int indexLocation) {
		this.indexLocation = indexLocation;
	}
	public DateTime getDate() {
		return date;
	}
	public void setDate(DateTime date) {
		this.date = date;
	}
	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}
	public JMenu getMnDayInWeek() {
		return MnDayInWeek;
	}
	public void setMnDayInWeek(JMenu mnDayInWeek) {
		MnDayInWeek = mnDayInWeek;
	}
	public JCheckBoxMenuItem getCbitMonday() {
		return cbitMonday;
	}
	public void setCbitMonday(JCheckBoxMenuItem cbitMonday) {
		this.cbitMonday = cbitMonday;
	}
	public JCheckBoxMenuItem getCbitTuesday() {
		return cbitTuesday;
	}
	public void setCbitTuesday(JCheckBoxMenuItem cbitTuesday) {
		this.cbitTuesday = cbitTuesday;
	}
	public JCheckBoxMenuItem getCbitWednesday() {
		return cbitWednesday;
	}
	public void setCbitWednesday(JCheckBoxMenuItem cbitWednesday) {
		this.cbitWednesday = cbitWednesday;
	}
	public JCheckBoxMenuItem getCbitThusday() {
		return cbitThusday;
	}
	public void setCbitThusday(JCheckBoxMenuItem cbitThusday) {
		this.cbitThusday = cbitThusday;
	}
	public JCheckBoxMenuItem getCbitFriday() {
		return cbitFriday;
	}
	public void setCbitFriday(JCheckBoxMenuItem cbitFriday) {
		this.cbitFriday = cbitFriday;
	}
	public JCheckBoxMenuItem getCbitSaturday() {
		return cbitSaturday;
	}
	public void setCbitSaturday(JCheckBoxMenuItem cbitSaturday) {
		this.cbitSaturday = cbitSaturday;
	}
	public JCheckBoxMenuItem getCbitSunday() {
		return cbitSunday;
	}
	public void setCbitSunday(JCheckBoxMenuItem cbitSunday) {
		this.cbitSunday = cbitSunday;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public DailyJob() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
	
		
		pnJob = new JPanel();
		pnJob.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 205)));
		pnJob.setLayout(null);
		pnJob.setBackground(new Color(255, 255, 255));
		pnJob.setBounds(5, 5, 435, 120);

		btnDone = new JButton("");
		btnDone.setIcon(new ImageIcon(Job.class.getResource("/image/done30px.png")));
		btnDone.setToolTipText("Đã xong");
		btnDone.setBounds(325, 5, 25, 25);
		pnJob.add(btnDone);

		btnDel = new JButton("");
		btnDel.setIcon(new ImageIcon(Job.class.getResource("/image/delete.png")));
		btnDel.setToolTipText("Xóa công việc");
		btnDel.setBounds(355, 5, 25, 25);
		pnJob.add(btnDel);

		cbNotify = new JCheckBox("Thông báo");
		cbNotify.setFont(new Font("Verdana", Font.PLAIN, 11));
		cbNotify.setBounds(325, 40, 85, 23);
		pnJob.add(cbNotify);

		JPanel pnFrom = new JPanel();
		pnFrom.setBackground(new Color(255, 255, 255));
		pnFrom.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnFrom.setBounds(5, 86, 104, 21);
		pnJob.add(pnFrom);
		pnFrom.setLayout(null);

		JLabel lbFrom = new JLabel("Từ :");
		lbFrom.setFont(new Font("Verdana", Font.PLAIN, 11));
		lbFrom.setBounds(0, 0, 25, 20);
		pnFrom.add(lbFrom);

		cbbHFrom = new JComboBox<String>();
		cbbHFrom.setModel(new DefaultComboBoxModel<String>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08",
				"09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		cbbHFrom.setBounds(26, 0, 38, 20);
		pnFrom.add(cbbHFrom);

		cbbMFrom = new JComboBox<String>();
		cbbMFrom.setModel(new DefaultComboBoxModel<String>(
				new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
						"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
						"31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
						"47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
		cbbMFrom.setBounds(65, 0, 38, 20);
		pnFrom.add(cbbMFrom);

		JPanel pnTo = new JPanel();
		pnTo.setBackground(new Color(255, 255, 255));
		pnTo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnTo.setBounds(120, 86, 112, 21);
		pnJob.add(pnTo);
		pnTo.setLayout(null);

		JLabel lbTo = new JLabel("Đến :");
		lbTo.setBounds(0, 0, 35, 20);
		lbTo.setFont(new Font("Verdana", Font.PLAIN, 11));
		pnTo.add(lbTo);

		cbbHTo = new JComboBox<String>();
		cbbHTo.setModel(new DefaultComboBoxModel<String>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08",
				"09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		cbbHTo.setBounds(35, 0, 38, 20);
		pnTo.add(cbbHTo);

		cbbMTo = new JComboBox<String>();
		cbbMTo.setModel(new DefaultComboBoxModel<String>(
				new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
						"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
						"31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
						"47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
		cbbMTo.setBounds(74, 0, 38, 20);
		pnTo.add(cbbMTo);

//		cbbColor = new JComboBox<Icon>();
//		cbbColor.setModel(loadImage());
//		cbbColor.setBounds(325, 58, 55, 23);
//		pnJob.add(cbbColor);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 309, 77);
		pnJob.add(scrollPane);

		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Verdana", Font.PLAIN, 13));
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);

		btnNotDone = new JButton("");
		btnNotDone.setIcon(new ImageIcon(Job.class.getResource("/image/notdone.png")));
		btnNotDone.setToolTipText("Chưa xong");
		btnNotDone.setBounds(385, 5, 25, 25);
		pnJob.add(btnNotDone);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(325, 75, 85, 23);
		pnJob.add(menuBar);
		
		MnDayInWeek = new JMenu("Áp dụng");
		menuBar.add(MnDayInWeek);
		
		cbitMonday = new JCheckBoxMenuItem("Thứ 2");
		cbitMonday.setSelected(true);
		MnDayInWeek.add(cbitMonday);
		
		cbitTuesday = new JCheckBoxMenuItem("Thứ 3");
		cbitTuesday.setSelected(true);
		MnDayInWeek.add(cbitTuesday);
		
		cbitWednesday = new JCheckBoxMenuItem("Thứ 4");
		cbitWednesday.setSelected(true);
		MnDayInWeek.add(cbitWednesday);
		
		cbitThusday = new JCheckBoxMenuItem("Thứ 5");
		cbitThusday.setSelected(true);
		MnDayInWeek.add(cbitThusday);
		
		cbitFriday = new JCheckBoxMenuItem("Thứ 6");
		cbitFriday.setSelected(true);
		MnDayInWeek.add(cbitFriday);
		
		cbitSaturday = new JCheckBoxMenuItem("Thứ 7");
		cbitSaturday.setSelected(true);
		MnDayInWeek.add(cbitSaturday);
		
		cbitSunday = new JCheckBoxMenuItem("Chủ nhật");
		cbitSunday.setSelected(true);
		MnDayInWeek.add(cbitSunday);
		

		btnDone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (status == 0) {
					Main.DoneDailyJob(ID);
				}
			}
		});

		btnNotDone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (status == 1) {
					Main.NotDoneDailyJob(ID);
				}
			}
		});

		btnDel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Main.DelDailyJob(ID, status);
			}
		});
		
		listcbday.add(cbitMonday);
		listcbday.add(cbitTuesday);
		listcbday.add(cbitWednesday);
		listcbday.add(cbitThusday);
		listcbday.add(cbitFriday);
		listcbday.add(cbitSaturday);
		listcbday.add(cbitSunday);
	}

	boolean IsTrueTime() {
		if (cbbHFrom.getSelectedIndex() > cbbHTo.getSelectedIndex()) return false;
		else if (cbbHFrom.getSelectedIndex() < cbbHTo.getSelectedIndex()) return true;
		
		if (cbbMFrom.getSelectedIndex() > cbbMTo.getSelectedIndex()) return false;
		else if (cbbMFrom.getSelectedIndex() < cbbMTo.getSelectedIndex()) return true;
		return true;
	}
	@Override
	public int compareTo(DailyJob arg0) {
		if (indexLocation == arg0.getIndexLocation())
			return 0;
		else if (indexLocation > arg0.getIndexLocation()) 
			return 1;
		else 
			return -1;
	}

}



	
