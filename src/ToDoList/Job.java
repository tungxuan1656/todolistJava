package ToDoList;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class Job extends JFrame implements Comparable<Job>{

	private static final long serialVersionUID = 1L;
	private JPanel pnJob;
	// cac nut
	private JButton btnDone, btnDel, btnNotDone;
	// thong bao
	private JCheckBox cbNotify;
	// gio
	private JComboBox<String> cbbHFrom, cbbMFrom, cbbHTo, cbbMTo;
	
	private JComboBox<Icon> cbbColor;
	// ngay
	private JDateChooser fromDay, toDay;
	// noi dung cong viec
	private JTextArea textArea;
	// vi tri cong viec
	private int ID, tabIndex, status, indexLocation;

	// datetime nay lay tu combobox
	private DateTime fromDate, toDate;

	public DateTime getFromDate() {
		return fromDate;
	}

	public void setFromDate(DateTime fromDate) {
		this.fromDate = fromDate;
	}

	public DateTime getToDate() {
		return toDate;
	}

	public void setToDate(DateTime toDate) {
		this.toDate = toDate;
	}

	public int getIndexLocation() {
		return indexLocation;
	}

	public void setIndexLocation(int indexLocation) {
		this.indexLocation = indexLocation;
	}

	public JButton getBtnNotDone() {
		return btnNotDone;
	}

	public void setBtnNotDone(JButton btnNotDone) {
		this.btnNotDone = btnNotDone;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getTabIndex() {
		return tabIndex;
	}

	public void setTabIndex(int tabIndex) {
		this.tabIndex = tabIndex;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public JComboBox<Icon> getCbbColor() {
		return cbbColor;
	}

	public void setCbbColor(JComboBox<Icon> cbbColor) {
		this.cbbColor = cbbColor;
	}

	public JDateChooser getFromDay() {
		return fromDay;
	}

	public void setFromDay(JDateChooser fromDay) {
		this.fromDay = fromDay;
	}

	public JDateChooser getToDay() {
		return toDay;
	}

	public void setToDay(JDateChooser toDay) {
		this.toDay = toDay;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public Job() {
		Init();
	}

	private void Init() {
		pnJob = new JPanel();
		pnJob.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 205)));
		pnJob.setLayout(null);
		pnJob.setBackground(new Color(255, 255, 255));
		pnJob.setBounds(0, 0, 435, 120);
		add(pnJob);

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
		cbNotify.setBounds(325, 32, 85, 23);
		pnJob.add(cbNotify);

		JPanel pnFrom = new JPanel();
		pnFrom.setBackground(new Color(255, 255, 255));
		pnFrom.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnFrom.setBounds(5, 86, 195, 21);
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

		fromDay = new JDateChooser();
		fromDay.setBounds(104, 0, 91, 20);
		pnFrom.add(fromDay);

		JPanel pnTo = new JPanel();
		pnTo.setBackground(new Color(255, 255, 255));
		pnTo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnTo.setBounds(208, 86, 205, 21);
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

		toDay = new JDateChooser();
		toDay.setBounds(113, 0, 91, 20);
		pnTo.add(toDay);

		cbbColor = new JComboBox<Icon>();
		cbbColor.setModel(loadImage());
		cbbColor.setBounds(325, 58, 55, 23);
		pnJob.add(cbbColor);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 309, 77);
		pnJob.add(scrollPane);

		textArea = new JTextArea();
		textArea.setFont(new Font("Verdana", Font.PLAIN, 13));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea);

		btnNotDone = new JButton("");
		btnNotDone.setIcon(new ImageIcon(Job.class.getResource("/image/notdone.png")));
		btnNotDone.setToolTipText("Chưa xong");
		btnNotDone.setBounds(385, 5, 25, 25);
		pnJob.add(btnNotDone);

		btnDone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (status == 0) {
					Main.DoneJob(ID);
				}
			}
		});

		btnNotDone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (status == 1) {
					Main.NotDoneJob(ID);
				}
			}
		});

		btnDel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Main.DelJob(ID, status);
			}
		});

		fromDay.setDateFormatString("dd/MM/yyyy");
		toDay.setDateFormatString("dd/MM/yyyy");
	}

	private DefaultComboBoxModel<Icon> loadImage() {
		DefaultComboBoxModel<Icon> dm = new DefaultComboBoxModel<Icon>();
		dm.addElement(new ImageIcon(Job.class.getResource("/image/red.png")));
		dm.addElement(new ImageIcon(Job.class.getResource("/image/yellow.png")));
		dm.addElement(new ImageIcon(Job.class.getResource("/image/green.png")));
		dm.addElement(new ImageIcon(Job.class.getResource("/image/blue.png")));
		return dm;
	}
	
	boolean isInSameDay(String text1, String text2) {
		DateTime date1 = new DateTime();
		DateTime date2 = new DateTime();
		date1.SetDate(text1);
		date2.SetDate(text2);
		return date1.equalsDate(date2);
	}

	@Override
	public int compareTo(Job o) {
		if (indexLocation == o.getIndexLocation())
			return 0;
		else if (indexLocation > o.getIndexLocation()) 
			return 1;
		else 
			return -1;
	}
	
}
