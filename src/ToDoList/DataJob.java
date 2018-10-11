package ToDoList;

import java.io.Serializable;

public class DataJob implements Serializable{

	private static final long serialVersionUID = 1L;

	// du lieu cac job
	private boolean notify;
	
	private int indexColor;
	
	private int ID, tabIndex, status, indexLocation;
	
	private DateTime fromDate, toDate;
	
	private String textarea;
	
	public String getTextarea() {
		return textarea;
	}

	public void setTextarea(String textarea) {
		this.textarea = textarea;
	}

	public boolean isNotify() {
		return notify;
	}

	public void setNotify(boolean notify) {
		this.notify = notify;
	}
	
	public int getIndexColor() {
		return indexColor;
	}

	public void setIndexColor(int indexColor) {
		this.indexColor = indexColor;
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

	public int getIndexLocation() {
		return indexLocation;
	}

	public void setIndexLocation(int indexLocation) {
		this.indexLocation = indexLocation;
	}

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
}
