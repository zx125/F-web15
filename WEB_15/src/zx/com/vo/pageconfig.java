package zx.com.vo;

import java.util.ArrayList;
import java.util.List;

public class pageconfig<T> {
	private List<T> list=new ArrayList<T>();
	private int allpage;
	private int thispage;
	private int alldata;
	private int thisdata;
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getAllpage() {
		return allpage;
	}
	public void setAllpage(int allpage) {
		this.allpage = allpage;
	}
	public int getThispage() {
		return thispage;
	}
	public void setThispage(int thispage) {
		this.thispage = thispage;
	}
	@Override
	public String toString() {
		return "pageconfig [list=" + list + ", allpage=" + allpage + ", thispage=" + thispage + ", alldata=" + alldata
				+ ", thisdata=" + thisdata + "]";
	}
	public int getAlldata() {
		return alldata;
	}
	public void setAlldata(int alldata) {
		this.alldata = alldata;
	}
	public int getThisdata() {
		return thisdata;
	}
	public void setThisdata(int thisdata) {
		this.thisdata = thisdata;
	}
}
