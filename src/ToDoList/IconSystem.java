package ToDoList;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

public class IconSystem {
    
	private TrayIcon trayIcon;
	
    public TrayIcon getTrayIcon() {
		return trayIcon;
	}

	public void setTrayIcon(TrayIcon trayIcon) {
		this.trayIcon = trayIcon;
	}
	
	private boolean isNotify;


	public boolean isNotify() {
		return isNotify;
	}

	public void setNotify(boolean isNotify) {
		this.isNotify = isNotify;
	}

	void createAndShowGUI() {
    	
    	try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
        //Check the SystemTray support
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        final PopupMenu popup = new PopupMenu();
        trayIcon =
                new TrayIcon(createImage("/image/calendar.png", "Lập Lịch"));
        final SystemTray tray = SystemTray.getSystemTray();
        
        // Create a popup menu components
        MenuItem home = new MenuItem("Home");
        CheckboxMenuItem cbNotify = new CheckboxMenuItem("Thông báo");
        cbNotify.setState(true);
        MenuItem exitItem = new MenuItem("Exit");
        
        isNotify = true;
        
        //Add components to popup menu
        popup.add(home);
        popup.addSeparator();
        popup.add(cbNotify);
        popup.addSeparator();
        popup.add(exitItem);
        
        trayIcon.setPopupMenu(popup);
        
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }
        
        trayIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.home.setVisible(true);
            }
        });
        
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.home.setVisible(true);
            }
        });
        
        cbNotify.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int cb1Id = e.getStateChange();
                if (cb1Id == ItemEvent.SELECTED){
                    // co thong bao
                	isNotify = true;
                } else {
                    // khong thong bao
                	isNotify = false;
                }
            }
        });
        
        
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });
    }
    
    //Obtain the image URL
    protected static Image createImage(String path, String description) {
        URL imageURL = IconSystem.class.getResource(path);
        
        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
}