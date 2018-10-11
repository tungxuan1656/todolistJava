package ToDoList;

import java.awt.Color;
import java.awt.Dimension;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	// co ban cua chuong trinh
	static ConstValue cst = new ConstValue();
	static Home home = new Home();
	static NewTab newtab = new NewTab();
	static EditTab edittab = new EditTab();
	static IconSystem iconsystemtray = new IconSystem();
	static About huongdan = new About();

	// chua cac tab
	static List<JPanel> listtab = new ArrayList<JPanel>();

	// chua 2 panel cua moi tab
	static List<List<JPanel>> listpn = new ArrayList<List<JPanel>>();

	// chua tat cac cac job
	static List<Job> listalljob = new ArrayList<Job>();

	// chua job theo tung trang thai cua tung tab, tung panel trong tab
	static List<List<List<Job>>> listjob = new ArrayList<List<List<Job>>>();

	// list job co thong bao
	static List<Job> listjobnotify = new ArrayList<Job>();
	static List<DailyJob> listdailyjobnotify = new ArrayList<DailyJob>();

	static List<List<DailyJob>> dailyjob = new ArrayList<List<DailyJob>>();

	// bien kiem soat tat cac cac job, moi job 1 ID khac nhau.
	static int ID = 0;

	// tao ra nhom cong viec moi
	static void AddTab(String text) {
		// panel tabbed
		if (text.equals(""))
			return;
		JPanel pn1 = new JPanel();
		pn1.setLayout(null);

		// scrollpane chua job chua xong
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(0, 0, 435, 557);
		pn1.add(scrollPane1);
		scrollPane1.getVerticalScrollBar().setUnitIncrement(20);

		listpn.add(new ArrayList<JPanel>());
		listjob.add(new ArrayList<List<Job>>());

		// panel chua job chua xong
		JPanel subpn1 = new JPanel();
		subpn1.setBackground(new Color(255, 255, 255));
		subpn1.setLayout(null);
		scrollPane1.setViewportView(subpn1);
		subpn1.setPreferredSize(new Dimension(435, 0));

		listpn.get(listpn.size() - 1).add(subpn1);
		listjob.get(listjob.size() - 1).add(new ArrayList<Job>());

		// scrollpane chua job da xong
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(440, 0, 435, 557);
		pn1.add(scrollPane2);
		scrollPane2.getVerticalScrollBar().setUnitIncrement(20);

		// panel chua job da xong
		JPanel subpn2 = new JPanel();
		subpn2.setBackground(new Color(255, 255, 255));
		subpn2.setLayout(null);
		scrollPane2.setViewportView(subpn2);
		subpn2.setPreferredSize(new Dimension(435, 0));

		listpn.get(listpn.size() - 1).add(subpn2);
		listjob.get(listjob.size() - 1).add(new ArrayList<Job>());

		// them panel tabbed vao tabbed
		home.tabbedPane.addTab(text, new ImageIcon(Home.class.getResource("/image/calendar20px.png")), pn1, null);
		// them vao cac tab
		listtab.add(pn1);
		// dat la tab dang duoc chon
		home.tabbedPane.setSelectedComponent(pn1);
	}

	static void AddTabFirst() {
		AddTab("Việc hằng ngày");
		AddTab("Việc trong ngày");
		AddTab("Việc trong tuần");
		AddTab("Việc trong tháng");

		home.tabbedPane.setSelectedIndex(0);
	}

	// sua lai ten tab
	static void EditTab(String text) {
		int i = home.tabbedPane.getSelectedIndex();
		home.tabbedPane.setTitleAt(i, text);
	}

	// xoa 1 tab cong viec
	static void DelTab() {
		int i = home.tabbedPane.getSelectedIndex();

		List<Job> ch1 = listjob.get(i).get(0); // list cong viec chua xong
		List<Job> ch2 = listjob.get(i).get(1); // list cong viec da xong

		while (!ch1.isEmpty()) {
			listalljob.remove(ch1.get(0));
			ch1.remove(0);
		}

		while (!ch2.isEmpty()) {
			listalljob.remove(ch2.get(0));
			ch2.remove(0);
		}

		listjob.get(i).remove(0);
		listjob.get(i).remove(0);
		listjob.remove(i);

		listpn.get(i).remove(0);
		listpn.get(i).remove(0);
		listpn.remove(i);

		home.tabbedPane.remove(i);
		listtab.remove(i);
	}

	// tao job moi vao tab, mac dinh la job chua xong
	static void AddJob() {
		int i = home.tabbedPane.getSelectedIndex();
		Job newjob = new Job();
		newjob.getBtnNotDone().setEnabled(false);
		listalljob.add(newjob); // them vao listalljob

		// dat cac gia tri ban dau
		newjob.setTabIndex(i);
		newjob.setIndexLocation(0);
		newjob.getCbbColor().setSelectedIndex(3);
		newjob.getCbNotify().setSelected(false);

		newjob.getCbbHFrom().setSelectedIndex(0);
		newjob.getCbbMFrom().setSelectedIndex(0);
		newjob.getCbbHTo().setSelectedIndex(23);
		newjob.getCbbMTo().setSelectedIndex(59);

		newjob.setID(ID);
		ID++; // moi job la 1 ID moi
		newjob.setStatus(0);

		JPanel pn1 = listpn.get(i).get(0); // panel cong viec chua xong
		List<Job> ch1 = listjob.get(i).get(0); // list cac viec chua xong cua
												// tab
		// dat vi tri cho cong viec moi
		SetPreferredSize("+", pn1, ch1, 0); // day cac viec ben duoi xuong de co
		// cho them viev moi vao dau
		newjob.getPnJob().setLocation(0, 5);
		// them vao
		pn1.add(newjob.getPnJob());
		ch1.add(0, newjob);
	}

	// danh dau la da xong
	static void DoneJob(int ID) {
		int i = home.tabbedPane.getSelectedIndex(); // lay tab dang duoc su dung

		List<Job> ch1 = listjob.get(i).get(0); // list cong viec chua xong
		List<Job> ch2 = listjob.get(i).get(1); // list cong viec da xong

		JPanel pn1 = listpn.get(i).get(0); // panel cua cong viec chua xong
		JPanel pn2 = listpn.get(i).get(1); // panel cua cong viec da xong

		Job jobcantim = null;
		int index = 0;

		// tim trong cong viec chua xong cai job co ID kia
		for (Job j : ch1) {
			if (j.getID() == ID) {
				jobcantim = j;
				j.setStatus(1); // dat lai la da xong
				j.getBtnDone().setEnabled(false);
				j.getBtnNotDone().setEnabled(true);
				index = j.getIndexLocation();
				break;
			}
		}
		// sau khi tim xong
		SetPreferredSize("-", pn1, ch1, index); // day vi tri dang sau index len
		SetPreferredSize("+", pn2, ch2, 0); // day tat ca job ben phai xuong
		// lay job can tim day sang ben phai
		ch1.remove(index);
		ch2.add(0, jobcantim);
		pn1.remove(jobcantim.getPnJob());
		pn2.add(jobcantim.getPnJob());
		jobcantim.getPnJob().setLocation(0, 5);
		jobcantim.setIndexLocation(0);
	}

	// danh dau job la chua xong.
	static void NotDoneJob(int ID) {
		int i = home.tabbedPane.getSelectedIndex(); // lay tab dang duoc su dung

		List<Job> ch1 = listjob.get(i).get(0); // list cong viec chua xong
		List<Job> ch2 = listjob.get(i).get(1); // list cong viec da xong

		JPanel pn1 = listpn.get(i).get(0); // panel cua cong viec chua xong
		JPanel pn2 = listpn.get(i).get(1); // panel cua cong viec da xong

		Job jobcantim = null;
		int index = 0;

		// tim trong cong viec da xong cai job co ID kia
		for (Job j : ch2) {
			if (j.getID() == ID) {
				jobcantim = j;
				j.setStatus(0); // dat lai la chua xong
				j.getBtnDone().setEnabled(true);
				j.getBtnNotDone().setEnabled(false);
				index = j.getIndexLocation();
				break;
			}
		}
		// sau khi tim xong
		SetPreferredSize("-", pn2, ch2, index); // day vi tri dang sau index len
		SetPreferredSize("+", pn1, ch1, 0); // day tat ca job ben trai xuong
		// lay job can tim day sang ben trai
		ch2.remove(index);
		ch1.add(0, jobcantim);
		pn2.remove(jobcantim.getPnJob());
		pn1.add(jobcantim.getPnJob());
		jobcantim.getPnJob().setLocation(0, 5);
		jobcantim.setIndexLocation(0);
	}

	static void DelJob(int ID, int status) {
		int i = home.tabbedPane.getSelectedIndex(); // lay tab dang duoc su dung

		List<Job> ch = listjob.get(i).get(status); // list cong viec

		JPanel pn = listpn.get(i).get(status); // lay panel

		Job jobcantim = null;
		int index = 0;

		// tim trong cong viec da xong cai job co ID kia
		for (Job j : ch) {
			if (j.getID() == ID) {
				jobcantim = j;
				index = j.getIndexLocation();
				break;
			}
		}

		SetPreferredSize("-", pn, ch, index);
		ch.remove(index);
		pn.remove(jobcantim.getPnJob());
		listalljob.remove(jobcantim);
	}

	// dat lai kich co cua panel pn, sua lai location cua cac job trong
	// listalljob
	static void SetPreferredSize(String text, JPanel pn, List<Job> listjob, int index) {
		if (text.equals("+")) { // neu la tang size cua panel len thi lui xuong
								// bat dau tu vi tri index
			for (Job j : listjob) {
				if (j.getIndexLocation() < index)
					continue;
				j.getPnJob().setLocation(0, j.getPnJob().getLocation().y + 130);
				j.setIndexLocation(j.getIndexLocation() + 1);
			}
			pn.setPreferredSize(new Dimension(435, pn.getPreferredSize().height + 130));
		} else if (text.equals("-")) { // neu la giam size cua panel thi tat ca
										// job dang sau index day len tren
			for (Job j : listjob) {
				if (j.getIndexLocation() < index)
					continue;
				j.getPnJob().setLocation(0, j.getPnJob().getLocation().y - 130);
				j.setIndexLocation(j.getIndexLocation() - 1);
			}
			pn.setPreferredSize(new Dimension(435, pn.getPreferredSize().height - 130));
		}
	}

	// xoa het comp trong Panel
	static void ClearTab(List<List<JPanel>> listpn) {
		JPanel pn;
		for (int x = 1; x < 4; x++) {
			for (int y = 0; y < 2; y++) {
				pn = listpn.get(x).get(y);
				pn.removeAll();
				pn.setPreferredSize(new Dimension(435, 0));
			}
		}
	}

	// hien cong viec trong ngay duoc chon
	static void ShowJobDay(DateTime date) {
		List<Job> ch = listalljob;

		for (Job j : ch) {
			// kiem tra dinh dang thoi gian co dung
			if (!j.getFromDate().isTrueDate(j.getToDate()))
				continue;

			// kiem tra ngay
			if (!j.getFromDate().equalsDate(j.getToDate()))
				continue; // khong trong cung 1 ngay thi next
			if (!j.getFromDate().equalsDate(date))
				continue; // khong giong ngay truyen vao -> next

			// tao doi tuong moi
			JobOnlyShow newjob = new JobOnlyShow(j);

			newjob.getTime().setText(j.getFromDate().getHour() + ":" + j.getFromDate().getMinute() + " => "
					+ j.getToDate().getHour() + ":" + j.getToDate().getMinute() + " . Ngày " + j.getFromDate().getDay()
					+ "/" + j.getFromDate().getMonth() + "/" + j.getFromDate().getYear());

			JPanel temp = listpn.get(1).get(newjob.getStatus());
			newjob.getPnJobOS().setLocation(0, temp.getPreferredSize().height);
			temp.setPreferredSize(new Dimension(435, temp.getPreferredSize().height + 130));
			temp.add(newjob.getPnJobOS());
		}
	}

	// cong viec trong tuan duoc chon
	static void ShowJobWeek(DateTime date) {
		// lay duoc tuan
		TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();

		int week = LocalDate.of(date.getYear(), date.getMonth(), date.getDay()).get(woy);

		int weekFrom = 0, weekTo = 0;
		List<Job> ch = listalljob;
		for (Job j : ch) {

			// kiem tra dinh dang thoi gian co dung
			if (!j.getFromDate().isTrueDate(j.getToDate()))
				continue;

			if (j.getFromDate().getYear() != j.getToDate().getYear())
				continue;
			if (j.getFromDate().getYear() != date.getYear())
				continue;

			weekFrom = LocalDate.of(j.getFromDate().getYear(), j.getFromDate().getMonth(), j.getFromDate().getDay())
					.get(woy);
			weekTo = LocalDate.of(j.getToDate().getYear(), j.getToDate().getMonth(), j.getToDate().getDay()).get(woy);

			// System.out.println(weekFrom + " " + weekTo);
			if (weekFrom != weekTo)
				continue; // khong cung 1 tuan
			if (weekFrom != week)
				continue; //

			// tao doi tuong job moi, doi tuong chi hien thi ko sua chua
			JobOnlyShow newjob = new JobOnlyShow(j);

			newjob.getTime().setText(j.getFromDate().getHour() + ":" + j.getFromDate().getMinute() + " . Ngày "
					+ j.getFromDate().getDay() + "/" + j.getFromDate().getMonth() + "/" + j.getFromDate().getYear()
					+ " => " + j.getToDate().getHour() + ":" + j.getToDate().getMinute() + " . Ngày "
					+ j.getToDate().getDay() + "/" + j.getToDate().getMonth() + "/" + j.getToDate().getYear());

			// them vao panel, tab
			JPanel temp = listpn.get(2).get(newjob.getStatus());
			newjob.getPnJobOS().setLocation(0, temp.getPreferredSize().height);
			temp.setPreferredSize(new Dimension(435, temp.getPreferredSize().height + 130));
			temp.add(newjob.getPnJobOS());
		}
	}

	// cong viec trong thang
	static void ShowJobMonth(DateTime date) {
		List<Job> ch = listalljob;

		for (Job j : ch) {

			// kiem tra dinh dang thoi gian co dung
			if (!j.getFromDate().isTrueDate(j.getToDate()))
				continue;

			// kiem tra nam
			if (j.getFromDate().getYear() != j.getToDate().getYear())
				continue;
			if (j.getFromDate().getYear() != date.getYear())
				continue;

			// kiem tra thang
			if (j.getFromDate().getMonth() != j.getToDate().getMonth())
				continue;

			if (j.getFromDate().getMonth() != date.getMonth())
				continue;
			
			
			// them job moi (chi show)
			JobOnlyShow newjob = new JobOnlyShow(j);

			newjob.getTime().setText(j.getFromDate().getHour() + ":" + j.getFromDate().getMinute() + " . Ngày "
					+ j.getFromDate().getDay() + "/" + j.getFromDate().getMonth() + "/" + j.getFromDate().getYear()
					+ " => " + j.getToDate().getHour() + ":" + j.getToDate().getMinute() + " . Ngày "
					+ j.getToDate().getDay() + "/" + j.getToDate().getMonth() + "/" + j.getToDate().getYear());

			// them vao tab, panel
			JPanel temp = listpn.get(3).get(newjob.getStatus());
			newjob.getPnJobOS().setLocation(0, temp.getPreferredSize().height);
			temp.setPreferredSize(new Dimension(435, temp.getPreferredSize().height + 130));
			temp.add(newjob.getPnJobOS());

		}
	}

	// kiem tra ve mat thoi gian cua cac job
	static void CheckJob() {
		for (Job j : listalljob) {
			if (!j.getFromDate().isTrueDate(j.getToDate()))
				JOptionPane.showMessageDialog(null,
						"Thời gian không đúng!\nTại công việc: " + j.getTextArea().getText(), "Thông Báo",
						JOptionPane.WARNING_MESSAGE);
		}
		for (DailyJob j : dailyjob.get(0)) {
			if (!j.IsTrueTime()) {
				JOptionPane.showMessageDialog(null,
						"Thời gian không đúng!\nTại công việc: " + j.getTextArea().getText(), "Thông Báo",
						JOptionPane.WARNING_MESSAGE);
			}
		}
		for (DailyJob j : dailyjob.get(1)) {
			if (!j.IsTrueTime()) {
				JOptionPane.showMessageDialog(null,
						"Thời gian không đúng!\nTại công việc: " + j.getTextArea().getText(), "Thông Báo",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	static void SetNotify() {
		DateTime today = new DateTime();
		LocalDate now = LocalDate.now();
		today.setDay(now.getDayOfMonth());
		today.setMonth(now.getMonthValue());
		today.setYear(now.getYear());

		int dayofweek = now.getDayOfWeek().getValue();

		listjobnotify.removeAll(listjobnotify);

		for (Job j : listalljob) {
			if (!j.getCbNotify().isSelected())
				continue;

			if (!j.getFromDate().equalsDate(today))
				continue;

			if (j.getStatus() == 1)
				continue;

			listjobnotify.add(j);
		}

		listdailyjobnotify.removeAll(listdailyjobnotify);

		for (int x = 0; x < 2; x++) {
			for (DailyJob j : dailyjob.get(x)) {
				if (!j.getCbNotify().isSelected())
					continue;

				if (!j.getListcbday().get(dayofweek).isSelected())
					continue;

				if (j.getStatus() == 1)
					continue;

				listdailyjobnotify.add(j);
			}
		}
	}

	static void RegisterStartup() {
		String value = "\"javaw -jar " + System.getProperty("user.dir") + "\\Lap-Lich.jar\"";
		try {
			WinRegistry.writeStringValue(WinRegistry.HKEY_CURRENT_USER,
					"Software\\Microsoft\\Windows\\CurrentVersion\\Run", "Lap Lich", value);
		} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	// Bo sung daily Job
	static {
		dailyjob.add(new ArrayList<DailyJob>());
		dailyjob.add(new ArrayList<DailyJob>());
	}

	static void AddDailyJob() {
		int i = home.tabbedPane.getSelectedIndex();
		DailyJob newdj = new DailyJob();
		newdj.getBtnNotDone().setEnabled(false);

		// dat cac gia tri ban dau
		newdj.setIndexLocation(0);
		newdj.getCbNotify().setSelected(false);

		newdj.getCbbHFrom().setSelectedIndex(0);
		newdj.getCbbMFrom().setSelectedIndex(0);
		newdj.getCbbHTo().setSelectedIndex(23);
		newdj.getCbbMTo().setSelectedIndex(59);

		newdj.setID(ID);
		ID++; // moi job la 1 ID moi
		newdj.setStatus(0);

		JPanel pn1 = listpn.get(i).get(0); // panel cong viec chua xong

		// dat vi tri cho cong viec moi
		SetPreferredSize2("+", pn1, dailyjob.get(0), 0); // day cac viec ben
															// duoi xuong de co
		// cho them viev moi vao dau
		newdj.getPnJob().setLocation(0, 5);
		// them vao
		pn1.add(newdj.getPnJob());
		dailyjob.get(0).add(0, newdj); // them vao dailyjob
	}

	static void DoneDailyJob(int ID) {
		int i = home.tabbedPane.getSelectedIndex(); // lay tab dang duoc su dung

		JPanel pn1 = listpn.get(i).get(0); // panel cua cong viec chua xong
		JPanel pn2 = listpn.get(i).get(1); // panel cua cong viec da xong

		List<DailyJob> ch1 = dailyjob.get(0);
		List<DailyJob> ch2 = dailyjob.get(1);

		DailyJob dj = null;
		int index = 0;

		// tim trong cong viec chua xong cai job co ID kia
		for (DailyJob j : ch1) {
			if (j.getID() == ID) {
				dj = j;
				j.setStatus(1); // dat lai la da xong
				j.getBtnDone().setEnabled(false);
				j.getBtnNotDone().setEnabled(true);
				index = j.getIndexLocation();
				break;
			}
		}
		// sau khi tim xong
		SetPreferredSize2("-", pn1, ch1, index); // day vi tri dang sau index
													// len
		SetPreferredSize2("+", pn2, ch2, 0); // day tat ca job ben phai xuong
		// lay job can tim day sang ben phai
		ch1.remove(dj);
		ch2.add(0, dj);
		pn1.remove(dj.getPnJob());
		pn2.add(dj.getPnJob());
		dj.getPnJob().setLocation(0, 5);
		dj.setIndexLocation(0);
	}

	static void NotDoneDailyJob(int ID) {
		int i = home.tabbedPane.getSelectedIndex(); // lay tab dang duoc su dung

		List<DailyJob> ch1 = dailyjob.get(0); // list cong viec chua xong
		List<DailyJob> ch2 = dailyjob.get(1); // list cong viec da xong

		JPanel pn1 = listpn.get(i).get(0); // panel cua cong viec chua xong
		JPanel pn2 = listpn.get(i).get(1); // panel cua cong viec da xong

		DailyJob dj = null;
		int index = 0;

		// tim trong cong viec da xong cai job co ID kia
		for (DailyJob j : ch2) {
			if (j.getID() == ID) {
				dj = j;
				j.setStatus(0); // dat lai la chua xong
				j.getBtnDone().setEnabled(true);
				j.getBtnNotDone().setEnabled(false);
				index = j.getIndexLocation();
				break;
			}
		}
		// sau khi tim xong
		SetPreferredSize2("-", pn2, ch2, index); // day vi tri dang sau index
													// len
		SetPreferredSize2("+", pn1, ch1, 0); // day tat ca job ben trai xuong
		// lay job can tim day sang ben trai
		ch2.remove(index);
		ch1.add(0, dj);
		pn2.remove(dj.getPnJob());
		pn1.add(dj.getPnJob());
		dj.getPnJob().setLocation(0, 5);
		dj.setIndexLocation(0);
	}

	static void DelDailyJob(int ID, int status) {
		int i = home.tabbedPane.getSelectedIndex(); // lay tab dang duoc su dung

		List<DailyJob> ch = dailyjob.get(status); // list cong viec

		JPanel pn = listpn.get(i).get(status); // lay panel

		DailyJob dj = null;
		int index = 0;

		// tim trong cong viec da xong cai job co ID kia
		for (DailyJob j : ch) {
			if (j.getID() == ID) {
				dj = j;
				index = j.getIndexLocation();
				break;
			}
		}

		SetPreferredSize2("-", pn, ch, index);
		ch.remove(dj);
		pn.remove(dj.getPnJob());
	}

	static void SetPreferredSize2(String text, JPanel pn, List<DailyJob> dailyjob, int index) {
		if (text.equals("+")) { // neu la tang size cua panel len thi lui xuong
			// bat dau tu vi tri index
			for (DailyJob j : dailyjob) {
				if (j.getIndexLocation() < index)
					continue;
				j.getPnJob().setLocation(0, j.getPnJob().getLocation().y + 130);
				j.setIndexLocation(j.getIndexLocation() + 1);
			}
			pn.setPreferredSize(new Dimension(435, pn.getPreferredSize().height + 130));
		} else if (text.equals("-")) { // neu la giam size cua panel thi tat ca
			// job dang sau index day len tren
			for (DailyJob j : dailyjob) {
				if (j.getIndexLocation() < index)
					continue;
				j.getPnJob().setLocation(0, j.getPnJob().getLocation().y - 130);
				j.setIndexLocation(j.getIndexLocation() - 1);
			}
			pn.setPreferredSize(new Dimension(435, pn.getPreferredSize().height - 130));
		}
	}

	// save vao file

	static Data data = new Data();

	static {
		data.setListDataJob(new ArrayList<DataJob>());
		data.setListDataDailyJob(new ArrayList<DataDailyJob>());
		data.setListPreferredSize(new ArrayList<List<Integer>>());
		data.setNameTab(new ArrayList<String>());
	}

	static void Save() {
		
		// luu lai ngay save
		LocalDateTime now = LocalDateTime.now();
		data.getDate().setDay(now.getDayOfMonth());
		data.getDate().setMonth(now.getMonthValue());
		data.getDate().setYear(now.getYear());

		// save id
		data.setID(ID + 1);

		// save du lieu cac tab

		for (int count = 0; count < listtab.size(); count++) {
			data.getNameTab().add(home.tabbedPane.getTitleAt(count));
		}

		// save du lieu chieu cao cac panel trong cac tab

		for (int x = 0; x < listpn.size(); x++) {
			data.getListPreferredSize().add(new ArrayList<Integer>());
			for (int y = 0; y < listpn.get(x).size(); y++) {
				data.getListPreferredSize().get(x).add(listpn.get(x).get(y).getPreferredSize().height);
				// System.out.println(listpn.get(x).get(y).getPreferredSize().height);
			}
		}

		// save du lieu cua note TextArea
		data.setTextNote(home.textNote.getText());

		// save du lieu cac job

		for (Job j : listalljob) {

			DataJob newdatajob = new DataJob();

			newdatajob.setNotify(j.getCbNotify().isSelected());

			newdatajob.setIndexColor(j.getCbbColor().getSelectedIndex());

			newdatajob.setID(j.getID());

			newdatajob.setTabIndex(j.getTabIndex());

			newdatajob.setStatus(j.getStatus());

			newdatajob.setIndexLocation(j.getIndexLocation());

			newdatajob.setTextarea(j.getTextArea().getText());

			DateTime temp = new DateTime();
			temp.SetDateTime(((JTextField) j.getFromDay().getDateEditor().getUiComponent()).getText(),
					j.getCbbHFrom().getSelectedIndex(), j.getCbbMFrom().getSelectedIndex());
			newdatajob.setFromDate(temp);
			j.setFromDate(temp);

			DateTime temp2 = new DateTime();
			temp2.SetDateTime(((JTextField) j.getToDay().getDateEditor().getUiComponent()).getText(),
					j.getCbbHTo().getSelectedIndex(), j.getCbbMTo().getSelectedIndex());
			newdatajob.setToDate(temp2);
			j.setToDate(temp2);

			data.getListDataJob().add(newdatajob);
		}

		// save dailyjob

		for (int x = 0; x < 2; x++) {
			for (DailyJob j : dailyjob.get(x)) {
				DataDailyJob datadj = new DataDailyJob();
				datadj.setDataDailyJob(j);

				data.getListDataDailyJob().add(datadj);
				// System.out.println(datadj.getIndexLocation());
			}
			// System.out.println();
		}

		// viet vao file
		try (FileOutputStream fos = new FileOutputStream("data");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(data);
		} catch (IOException i) {
			i.printStackTrace();
		}

		// cua so load khi save
		new ProgressMonitor();
	}

	static void Load() {
		Data data = null;

		// lay len
		try (FileInputStream fis = new FileInputStream("data"); ObjectInputStream ois = new ObjectInputStream(fis);) {
			data = (Data) ois.readObject();
		} catch (Exception e) { // neu khong lay duoc du lieu thi khoi chay mac
								// dinh
			AddTabFirst();
			return;
		}

		try {
			// load tab
			for (String text : data.getNameTab()) {
				AddTab(text);
			}

			// load ID
			ID = data.getID();
			if (ID == 1000000000)
				ID = 0; // reset bo dem ID

			// load PreferredSize;
			for (int x = 0; x < listpn.size(); x++) {
				for (int y = 0; y < listpn.get(x).size(); y++) {
					listpn.get(x).get(y)
							.setPreferredSize(new Dimension(435, data.getListPreferredSize().get(x).get(y)));
				}
			}

			// load note
			home.textNote.setText(data.getTextNote());

			// load job
			for (DataJob dj : data.getListDataJob()) {
				LoadJob(dj);
			}

			// sort listjob theo vi tri trong tab, phuc vu cho cai deoo gi quen
			// me roi, tom lai no lien quan den done va not done, del nua
			for (int x = 0; x < listjob.size(); x++) {
				for (int y = 0; y < listjob.get(x).size(); y++) {
					Collections.sort(listjob.get(x).get(y));
				}
			}

			// load dailyjob
			for (DataDailyJob dj : data.getListDataDailyJob()) {
				// System.out.println("a");
				LoadDailyJob(dj);
			}

			for (int x = 0; x < 2; x++) {
				Collections.sort(dailyjob.get(x));
			}
			
//			LocalDateTime now = LocalDateTime.of(2018, 8, 5, 2, 3);
			LocalDateTime now = LocalDateTime.now();
			
			if (data.getDate().getDay() != now.getDayOfMonth() || data.getDate().getMonth()!= now.getMonthValue() || data.getDate().getYear() != now.getYear()) {
				
				for (int x = 0; x<dailyjob.get(1).size(); x++) {
					DailyJob j = dailyjob.get(1).get(x);

					home.tabbedPane.setSelectedIndex(0);
					AddDailyJob();
					DailyJob newdj = dailyjob.get(0).get(0);
					
//					newdj.setID(j.getID());
//					newdj.setStatus(j.getStatus());
//					newdj.setIndexLocation(j.getIndexLocation());
					newdj.getTextArea().setText(j.getTextArea().getText());

					newdj.getCbbHFrom().setSelectedIndex(j.getCbbHFrom().getSelectedIndex());
					newdj.getCbbMFrom().setSelectedIndex(j.getCbbMFrom().getSelectedIndex());
					newdj.getCbbHTo().setSelectedIndex(j.getCbbHTo().getSelectedIndex());
					newdj.getCbbMTo().setSelectedIndex(j.getCbbMTo().getSelectedIndex());

					newdj.getCbitMonday().setSelected(j.getCbitMonday().isSelected());
					newdj.getCbitTuesday().setSelected(j.getCbitTuesday().isSelected());
					newdj.getCbitWednesday().setSelected(j.getCbitWednesday().isSelected());
					newdj.getCbitThusday().setSelected(j.getCbitThusday().isSelected());
					newdj.getCbitFriday().setSelected(j.getCbitFriday().isSelected());
					newdj.getCbitSaturday().setSelected(j.getCbitSaturday().isSelected());
					newdj.getCbitSunday().setSelected(j.getCbitSunday().isSelected());

					newdj.getCbNotify().setSelected(j.getCbNotify().isSelected());
				}
				listpn.get(0).get(1).removeAll();
				listpn.get(0).get(1).setPreferredSize(new Dimension(435,0));
				dailyjob.get(1).removeAll(dailyjob.get(1));
				
			}

		} catch (Exception e) {

		}
	}

	static void LoadJob(DataJob dj) {
		// set cac thuoc tinh cho job
		Job j = new Job();
		j.setID(dj.getID());

		j.getCbbColor().setSelectedIndex(dj.getIndexColor());

		j.getCbbHFrom().setSelectedIndex(dj.getFromDate().getHour());
		j.getCbbMFrom().setSelectedIndex(dj.getFromDate().getMinute());
		j.getCbbHTo().setSelectedIndex(dj.getToDate().getHour());
		j.getCbbMTo().setSelectedIndex(dj.getToDate().getMinute());

		j.getCbNotify().setSelected(dj.isNotify());

		j.setIndexLocation(dj.getIndexLocation());

		j.setTabIndex(dj.getTabIndex());

		j.setStatus(dj.getStatus());
		if (dj.getStatus() == 0) {
			j.getBtnNotDone().setEnabled(false);
		} else
			j.getBtnDone().setEnabled(false);

		j.getTextArea().setText(dj.getTextarea());

		if (dj.getFromDate().getDay() != 0 && dj.getFromDate().getMonth() != 0 && dj.getFromDate().getYear() != 0) {
			((JTextField) j.getFromDay().getDateEditor().getUiComponent()).setText(
					dj.getFromDate().getDay() + "/" + dj.getFromDate().getMonth() + "/" + dj.getFromDate().getYear());
		}
		if (dj.getToDate().getDay() != 0 && dj.getToDate().getMonth() != 0 && dj.getToDate().getYear() != 0) {
			((JTextField) j.getToDay().getDateEditor().getUiComponent()).setText(
					dj.getToDate().getDay() + "/" + dj.getToDate().getMonth() + "/" + dj.getToDate().getYear());
		}

		j.setFromDate(dj.getFromDate());
		j.setToDate(dj.getToDate());

		// set location cho panel bao job
		j.getPnJob().setLocation(0, 5 + dj.getIndexLocation() * 130);

		// them vao cac list de xu ly
		listpn.get(dj.getTabIndex()).get(dj.getStatus()).add(j.getPnJob());
		listalljob.add(j);
		listjob.get(dj.getTabIndex()).get(dj.getStatus()).add(j);
	}

	static void LoadDailyJob(DataDailyJob dj) {
		DailyJob newdj = new DailyJob();

		newdj.setID(dj.getID());
		newdj.setStatus(dj.getStatus());
		newdj.setIndexLocation(dj.getIndexLocation());
		newdj.getTextArea().setText(dj.getTextArea());

		newdj.getCbbHFrom().setSelectedIndex(dj.getCbbHFrom());
		newdj.getCbbMFrom().setSelectedIndex(dj.getCbbMFrom());
		newdj.getCbbHTo().setSelectedIndex(dj.getCbbHTo());
		newdj.getCbbMTo().setSelectedIndex(dj.getCbbMTo());

		newdj.getCbitMonday().setSelected(dj.isCbitMonday());
		newdj.getCbitTuesday().setSelected(dj.isCbitTuesday());
		newdj.getCbitWednesday().setSelected(dj.isCbitWednesday());
		newdj.getCbitThusday().setSelected(dj.isCbitThusday());
		newdj.getCbitFriday().setSelected(dj.isCbitFriday());
		newdj.getCbitSaturday().setSelected(dj.isCbitSaturday());
		newdj.getCbitSunday().setSelected(dj.isCbitSunday());

		newdj.getCbNotify().setSelected(dj.isCbNotify());

		newdj.getPnJob().setLocation(0, 5 + dj.getIndexLocation() * 130);

		dailyjob.get(newdj.getStatus()).add(newdj);
		listpn.get(0).get(newdj.getStatus()).add(newdj.getPnJob());
	}

	public static void main(String[] args) {
		home.setVisible(true);
		// lay du lieu len
		Load();
		// set cong viec trong ngay hom nay luon
		DateTime date = new DateTime();
		LocalDate now = LocalDate.now();
		date.setDay(now.getDayOfMonth());
		date.setMonth(now.getMonthValue());
		date.setYear(now.getYear());

		Main.CheckJob();
		Main.ClearTab(Main.listpn);
		ShowJobDay(date);
		ShowJobWeek(date);
		ShowJobMonth(date);
		home.tabbedPane.setSelectedIndex(0);
		// chon tab dau tien lam mac dinh

		iconsystemtray.createAndShowGUI();
		Thread thread = new Thread(new Timmer());
		thread.start();

		// chay trong project se bao warning, nhung khi xuat ra file jar voi ten
		// la Lap-Lich.jar thi moi tao key duoc
		// neu muon sua ten khi xuat ra thi sua ben trong ham RegisterStartup()
		 RegisterStartup();

	}
}
