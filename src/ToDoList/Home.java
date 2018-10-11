package ToDoList;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.toedter.calendar.JCalendar;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JToolBar;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTabbedPane tabbedPane;
	JTextArea textNote;
	JCalendar calendar;

	public Home() {
		setResizable(false);
		// WebLookAndFeel.install();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setTitle("LẬP LỊCH");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/image/calendar.png")));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds((int) (Main.cst.width - 1210) / 2, (int) (Main.cst.height - 685) / 2, 1210, 685);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnJob = new JPanel();
		pnJob.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnJob.setBackground(new Color(255, 249, 249));
		pnJob.setBounds(1, 1, 902, 652);
		contentPane.add(pnJob);
		pnJob.setLayout(null);

		JPanel pnMenu = new JPanel();
		pnMenu.setBackground(new Color(255, 250, 205));
		pnMenu.setBounds(1, 1, 899, 39);
		pnJob.add(pnMenu);
		pnMenu.setLayout(null);

		JPanel pnContent = new JPanel();
		pnContent.setBackground(new Color(255, 255, 240));
		pnContent.setBounds(1, 40, 899, 610);
		pnJob.add(pnContent);
		pnContent.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setToolTipText("");
		tabbedPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tabbedPane.setBackground(SystemColor.controlHighlight);
		tabbedPane.setBounds(8, 8, 884, 595);
		pnContent.add(tabbedPane);

		JPanel pnNewTab = new JPanel();
		pnNewTab.setForeground(new Color(175, 238, 238));
		pnNewTab.setBackground(new Color(0, 128, 0));
		pnNewTab.setBounds(3, 36, 120, 3);
		pnMenu.add(pnNewTab);
		pnNewTab.setLayout(null);

		JButton btnNewTab = new JButton("Tab mới");
		btnNewTab.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNewTab.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewTab.setBackground(new Color(240, 240, 240));
		btnNewTab.setBounds(3, 5, 120, 26);
		pnMenu.add(btnNewTab);
		btnNewTab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnNewTab.setBackground(new Color(220, 20, 60));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pnNewTab.setBackground(new Color(0, 128, 0));
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Main.newtab.setVisible(true);
			}
		});
		btnNewTab.setForeground(Color.BLACK);
		btnNewTab.setIcon(new ImageIcon(Home.class.getResource("/image/new30px.png")));
		btnNewTab.setToolTipText("Tạo bảng công việc mới");

		JPanel pnEdit = new JPanel();
		pnEdit.setForeground(new Color(175, 238, 238));
		pnEdit.setLayout(null);
		pnEdit.setBackground(new Color(0, 128, 0));
		pnEdit.setBounds(126, 36, 120, 3);
		pnMenu.add(pnEdit);

		JButton btnEdit = new JButton("Sửa tab");
		btnEdit.setHorizontalAlignment(SwingConstants.LEFT);
		btnEdit.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnEdit.setToolTipText("Sửa bảng hoặc công việc");
		btnEdit.setBounds(126, 5, 120, 26);
		pnMenu.add(btnEdit);
		btnEdit.setIcon(new ImageIcon(Home.class.getResource("/image/repair20px.png")));

		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnEdit.setBackground(new Color(220, 20, 60));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pnEdit.setBackground(new Color(0, 128, 0));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tabbedPane.getSelectedIndex();
				if (i == 0 || i == 1 || i == 2 || i==3) {
					JOptionPane.showMessageDialog(null, "Không thể Edit tab này!", "Thông Báo",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				Main.edittab.setVisible(true);
			}
		});

		JPanel pnDel = new JPanel();
		pnDel.setForeground(new Color(175, 238, 238));
		pnDel.setLayout(null);
		pnDel.setBackground(new Color(0, 128, 0));
		pnDel.setBounds(249, 36, 120, 3);
		pnMenu.add(pnDel);

		JButton btnDel = new JButton("Xóa tab");
		btnDel.setHorizontalAlignment(SwingConstants.LEFT);
		btnDel.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnDel.setToolTipText("Xóa bảng");
		btnDel.setBounds(249, 5, 120, 26);
		pnMenu.add(btnDel);
		btnDel.setIcon(new ImageIcon(Home.class.getResource("/image/delete.png")));

		btnDel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnDel.setBackground(new Color(220, 20, 60));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pnDel.setBackground(new Color(0, 128, 0));
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = tabbedPane.getSelectedIndex();
				if (i == 0 || i == 1 || i == 2 || i==3) {
					JOptionPane.showMessageDialog(null, "Không thể Xóa tab này!", "Thông Báo",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				Main.DelTab();
			}
		});

		JPanel pnNewJob = new JPanel();
		pnNewJob.setForeground(new Color(175, 238, 238));
		pnNewJob.setLayout(null);
		pnNewJob.setBackground(new Color(0, 128, 0));
		pnNewJob.setBounds(372, 36, 120, 3);
		pnMenu.add(pnNewJob);

		JButton btnNewJob = new JButton("Thêm việc");
		btnNewJob.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNewJob.setToolTipText("Thêm công việc");
		btnNewJob.setBounds(372, 5, 120, 26);
		pnMenu.add(btnNewJob);
		btnNewJob.setIcon(new ImageIcon(Home.class.getResource("/image/newdo20.png")));

		btnNewJob.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnNewJob.setBackground(new Color(220, 20, 60));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pnNewJob.setBackground(new Color(0, 128, 0));
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = tabbedPane.getSelectedIndex();
				if (i == 1 || i == 2 || i==3) {
					JOptionPane.showMessageDialog(null, "Trước hết hãy tạo Tab mới hoặc chọn 1 tab khác!", "Thông Báo",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (i!=0) {
					Main.AddJob();
				}
				else Main.AddDailyJob();
			}
		});


		JPanel pnAbout = new JPanel();
		pnAbout.setForeground(new Color(175, 238, 238));
		pnAbout.setLayout(null);
		pnAbout.setBackground(new Color(0, 128, 0));
		pnAbout.setBounds(770, 36, 120, 3);
		pnMenu.add(pnAbout);

		JButton btnAbout = new JButton("Hướng dẫn");
		btnAbout.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnAbout.setIcon(new ImageIcon(Home.class.getResource("/image/info3.png")));
		btnAbout.setToolTipText("Hướng dẫn");
		btnAbout.setBounds(763, 5, 127, 26);
		pnMenu.add(btnAbout);

		btnAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnAbout.setBackground(new Color(220, 20, 60));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pnAbout.setBackground(new Color(0, 128, 0));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// huong dan su dung
				Main.huongdan.setVisible(true);
			}
		});

		JPanel pnRegular = new JPanel();
		pnRegular.setBackground(new Color(0, 128, 0));
		pnRegular.setBounds(0, 36, 900, 3);
		pnMenu.add(pnRegular);

		JPanel pnDate = new JPanel();
		pnDate.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnDate.setBounds(903, 1, 300, 236);
		contentPane.add(pnDate);
		pnDate.setLayout(null);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.setIcon(new ImageIcon(Home.class.getResource("/image/save15px.png")));
		btnUpdate.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Main.Save(); // luu lai vao data
				Main.CheckJob(); // kiem tra dinh dang ngay thang cac job
				Main.ClearTab(Main.listpn); // clear panel chua job 3 tab dau
				Main.SetNotify(); // set job notify
				
				// dat ngay thang nhan duoc
				DateTime date = new DateTime();
				date.setDay(calendar.getDayChooser().getDay());
				// cai month bi clg ma no chay tu 0->11
				date.setMonth(calendar.getMonthChooser().getMonth()+1);
				date.setYear(calendar.getYearChooser().getYear());
				// goi ham show job
				Main.ShowJobDay(date);
				Main.ShowJobWeek(date);
				Main.ShowJobMonth(date);
				
			}
		});
		btnUpdate.setBounds(5, 200, 290, 33);
		pnDate.add(btnUpdate);

		calendar = new JCalendar();
		calendar.setBounds(5, 30, 290, 170);
		pnDate.add(calendar);

		JLabel lbCalendar = new JLabel("CALENDAR");
		lbCalendar.setBackground(Color.WHITE);
		lbCalendar.setHorizontalAlignment(SwingConstants.CENTER);
		lbCalendar.setFont(new Font("Verdana", Font.PLAIN, 13));
		lbCalendar.setBounds(0, 0, 300, 30);
		pnDate.add(lbCalendar);

		JPanel pnNote = new JPanel();
		pnNote.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnNote.setBounds(903, 238, 300, 415);
		contentPane.add(pnNote);
		pnNote.setLayout(null);

		JLabel lbNote = new JLabel("NOTE");
		lbNote.setFont(new Font("Verdana", Font.PLAIN, 13));
		lbNote.setHorizontalAlignment(SwingConstants.CENTER);
		lbNote.setBounds(0, 0, 100, 30);
		pnNote.add(lbNote);

		JPanel pnNoteContent = new JPanel();
		pnNoteContent.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnNoteContent.setBounds(0, 30, 300, 385);
		pnNote.add(pnNoteContent);
		pnNoteContent.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 299, 385);
		pnNoteContent.add(scrollPane);
		
		textNote = new JTextArea();
		textNote.setText(" - ");
		textNote.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int keycode = e.getKeyCode();
				if (keycode == KeyEvent.VK_ENTER) {
					textNote.setText(textNote.getText() + "\n - ");
				}
			}
		});
		textNote.setFont(new Font("Verdana", Font.PLAIN, 13));
		textNote.setLineWrap(true);
		scrollPane.setViewportView(textNote);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(110, 3, 100, 24);
		pnNote.add(toolBar);
		
		JCheckBox cbTA = new JCheckBox("Word Wrap");
		cbTA.setHorizontalAlignment(SwingConstants.CENTER);
		cbTA.setToolTipText("Các dòng có trong tầm nhìn");
		cbTA.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				if (cbTA.isSelected()) textNote.setLineWrap(true);
				else textNote.setLineWrap(false);
			}
		});
		cbTA.setSelected(true);
		cbTA.setFont(new Font("Verdana", Font.PLAIN, 11));
		toolBar.add(cbTA);
		
		JButton btnClear = new JButton("Xóa hết");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textNote.setText(" - ");
			}
		});
		btnClear.setToolTipText("Xóa hết chữ");
		btnClear.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnClear.setBounds(215, 3, 80, 24);
		pnNote.add(btnClear);
	}
}
