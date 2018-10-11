package ToDoList;

import java.awt.Dimension;
import java.awt.Toolkit;

public class ConstValue {
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public double width = screenSize.getWidth();
	public double height = screenSize.getHeight();
}
