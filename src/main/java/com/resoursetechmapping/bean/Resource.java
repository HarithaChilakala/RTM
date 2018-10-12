package com.resoursetechmapping.bean;

public class Resource  {
	private long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String listOfTechWorkedOn;
	private String certifications;
	private String projects;
	private String applicationWorkLoadType;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getListOfTechWorkedOn() {
		return listOfTechWorkedOn;
	}
	public void setListOfTechWorkedOn(String listOfTechWorkedOn) {
		this.listOfTechWorkedOn = listOfTechWorkedOn;
	}
	public String getCertification() {
		return certifications;
	}
	public void setCertification(String certifications) {
		this.certifications = certifications;
	}
	public String getProjects() {
		return projects;
	}
	public void setProjects(String projects) {
		this.projects = projects;
	}
	public String getApplicationWorkLoadType() {
		return applicationWorkLoadType;
	}
	public void setApplicationWorkLoadType(String applicationWorkLoadType) {
		this.applicationWorkLoadType = applicationWorkLoadType;
	}

	

}
