package com.ccb.testcenter.athena.dataprocess.entity;

public class Group {

	private String name;
	private int times;
	private int start;
	private int current;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}
	
	public int getStart() {
		return start;
	}
	
	public int getCurrent() {
		return current;
	}

	public void increase() {
		this.current++;
	}
	
	public Group(String name, int times, int start, int current) {
		super();
		this.name = name;
		this.times = times;
		this.start = start;
		this.current = current;
	}

	public boolean isEnd() {
		return current == times;
	}
}
