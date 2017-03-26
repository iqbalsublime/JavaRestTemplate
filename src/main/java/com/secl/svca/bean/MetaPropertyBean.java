package com.secl.svca.bean;



@SuppressWarnings("serial")
public class MetaPropertyBean  extends AbstractBean {
	
	private String description;
	private String valueJSON;
	private String operation;
	

	public String getValueJSON() {
		return valueJSON;
	}

	public void setValueJSON(String valueJSON) {
		this.valueJSON = valueJSON;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getOperation() {
		return operation;
	}

	@Override
	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String getOid() {
		return oid;
	}

	@Override
	public void setOid(String oid) {
		this.oid = oid;
	}

}
