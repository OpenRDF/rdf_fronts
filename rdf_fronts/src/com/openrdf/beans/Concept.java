package com.openrdf.beans;

public class Concept {

	private String cnName;
	private String enName;
	private String source;
	private String nodeID;
	private String bday;
	
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getNodeID() {
		return nodeID;
	}
	public void setNodeID(String nodeID) {
		this.nodeID = nodeID;
	}
	public String getBday() {
		return bday;
	}
	public void setBday(String bday) {
		this.bday = bday;
	}
	public Concept(String cnName, String enName, String source, String nodeID,
			String bday) {
		super();
		this.cnName = cnName;
		this.enName = enName;
		this.source = source;
		this.nodeID = nodeID;
		this.bday = bday;
	}
	public Concept() {
		super();
	}
	
}
