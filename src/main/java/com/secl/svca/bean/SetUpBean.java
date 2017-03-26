package com.secl.svca.bean;

import java.io.Serializable;
import java.util.Comparator;


@SuppressWarnings("serial")
public class SetUpBean implements Comparable<SetUpBean>, Serializable  {
	
	private String id;
	private String description;
	private double value;
	private String unit;
	private int sortOrder;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public String getUnit() {
		return unit;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public int getSortOrder() {
		return sortOrder;
	}
	
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Override
	public int compareTo(SetUpBean setUpBean) {
		return this.sortOrder > setUpBean.sortOrder ? 1 : (this.sortOrder < setUpBean.sortOrder ? -1 : 0);
	}
	
	public static Comparator<SetUpBean> SortOrderComparator = new Comparator<SetUpBean>() {
		public int compare(SetUpBean setUpBean1, SetUpBean setUpBean2) {
			return setUpBean1.compareTo(setUpBean2);
		}
	};
	
	
	
	

}
