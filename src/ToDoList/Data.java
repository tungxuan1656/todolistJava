package ToDoList;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable {
	
	private static final long serialVersionUID = 1L;
	// du lieu cac tab
	private List<String> nameTab;


	public List<String> getNameTab() {
		return nameTab;
	}

	public void setNameTab(List<String> nameTab) {
		this.nameTab = nameTab;
	}
	
	// du lieu cac tab
	private List<DataJob> listDataJob;
	
	public List<DataJob> getListDataJob() {
		return listDataJob;
	}

	public void setListDataJob(List<DataJob> listDataJob) {
		this.listDataJob = listDataJob;
	}

	// du lieu chieu cao cua panel done va doing trong cac tab
	private List<List<Integer>> listPreferredSize;

	public List<List<Integer>> getListPreferredSize() {
		return listPreferredSize;
	}

	public void setListPreferredSize(List<List<Integer>> listPreferredSize) {
		this.listPreferredSize = listPreferredSize;
	}
	
	// so id lon nhat chua duoc su dung
	private int ID;


	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	private String textNote;

	public String getTextNote() {
		return textNote;
	}

	public void setTextNote(String textNote) {
		this.textNote = textNote;
	}
	
	private List<DataDailyJob> listDataDailyJob;


	public List<DataDailyJob> getListDataDailyJob() {
		return listDataDailyJob;
	}

	public void setListDataDailyJob(List<DataDailyJob> listDataDailyJob) {
		this.listDataDailyJob = listDataDailyJob;
	}
	
	private DateTime date = new DateTime();


	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}
	
}
