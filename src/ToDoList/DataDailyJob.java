package ToDoList;

import java.io.Serializable;

public class DataDailyJob implements Serializable{

	private static final long serialVersionUID = 1L;

	// thong bao
	private boolean cbNotify;
	// gio
	private int cbbHFrom, cbbMFrom, cbbHTo, cbbMTo;
	// noi dung cong viec
	private String textArea;
	// vi tri cong viec
	private int ID, status, indexLocation;
	

	// datetime nay lay tu combobox
	
	private boolean cbitMonday;
	private boolean cbitTuesday;
	private boolean cbitWednesday;
	private boolean cbitThusday;
	private boolean cbitFriday;
	private boolean cbitSaturday;
	private boolean cbitSunday;
	public boolean isCbNotify() {
		return cbNotify;
	}
	public void setCbNotify(boolean cbNotify) {
		this.cbNotify = cbNotify;
	}
	public int getCbbHFrom() {
		return cbbHFrom;
	}
	public void setCbbHFrom(int cbbHFrom) {
		this.cbbHFrom = cbbHFrom;
	}
	public int getCbbMFrom() {
		return cbbMFrom;
	}
	public void setCbbMFrom(int cbbMFrom) {
		this.cbbMFrom = cbbMFrom;
	}
	public int getCbbHTo() {
		return cbbHTo;
	}
	public void setCbbHTo(int cbbHTo) {
		this.cbbHTo = cbbHTo;
	}
	public int getCbbMTo() {
		return cbbMTo;
	}
	public void setCbbMTo(int cbbMTo) {
		this.cbbMTo = cbbMTo;
	}
	public String getTextArea() {
		return textArea;
	}
	public void setTextArea(String textArea) {
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
	public boolean isCbitMonday() {
		return cbitMonday;
	}
	public void setCbitMonday(boolean cbitMonday) {
		this.cbitMonday = cbitMonday;
	}
	public boolean isCbitTuesday() {
		return cbitTuesday;
	}
	public void setCbitTuesday(boolean cbitTuesday) {
		this.cbitTuesday = cbitTuesday;
	}
	public boolean isCbitWednesday() {
		return cbitWednesday;
	}
	public void setCbitWednesday(boolean cbitWednesday) {
		this.cbitWednesday = cbitWednesday;
	}
	public boolean isCbitThusday() {
		return cbitThusday;
	}
	public void setCbitThusday(boolean cbitThusday) {
		this.cbitThusday = cbitThusday;
	}
	public boolean isCbitFriday() {
		return cbitFriday;
	}
	public void setCbitFriday(boolean cbitFriday) {
		this.cbitFriday = cbitFriday;
	}
	public boolean isCbitSaturday() {
		return cbitSaturday;
	}
	public void setCbitSaturday(boolean cbitSaturday) {
		this.cbitSaturday = cbitSaturday;
	}
	public boolean isCbitSunday() {
		return cbitSunday;
	}
	public void setCbitSunday(boolean cbitSunday) {
		this.cbitSunday = cbitSunday;
	}
	
	void setDataDailyJob(DailyJob j) {
		this.setCbbHFrom(j.getCbbHFrom().getSelectedIndex());
		this.setCbbHTo(j.getCbbHTo().getSelectedIndex());
		this.setCbbMFrom(j.getCbbMFrom().getSelectedIndex());
		this.setCbbMTo(j.getCbbMTo().getSelectedIndex());
		
		this.setCbitMonday(j.getCbitMonday().isSelected());
		this.setCbitTuesday(j.getCbitTuesday().isSelected());
		this.setCbitWednesday(j.getCbitWednesday().isSelected());
		this.setCbitThusday(j.getCbitThusday().isSelected());
		this.setCbitFriday(j.getCbitFriday().isSelected());
		this.setCbitSaturday(j.getCbitSaturday().isSelected());
		this.setCbitSunday(j.getCbitSunday().isSelected());
		
		this.setCbNotify(j.getCbNotify().isSelected());
		
		this.setID(j.getID());
		this.setIndexLocation(j.getIndexLocation());
		this.setStatus(j.getStatus());
		this.setTextArea(j.getTextArea().getText());
	}
}
