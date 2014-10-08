package cn.edu.xjtu.manage.business;

public class Cluster {
	public Cluster() {
		super();
	}
	int id;
	String interval;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInterval() {
		return interval;
	}
	public void setInterval(String interval) {
		this.interval = interval;
	}

	public Cluster(int id, String interval) {
		super();
		this.id=id;
		this.interval=interval;
		
	}

}
