package com.best.record.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_details")
public class StudentDetails implements Comparable<StudentDetails> {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
@Column(name="first_name")
private String firstName;
@Column(name = "last_name")
private String lastName;
@Column(name = "city_name")
private String cityName;
public StudentDetails(String firstName, String lastName, String cityName) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.cityName = cityName;
}
public StudentDetails() {}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getCityName() {
	return cityName;
}
public void setCityName(String cityName) {
	this.cityName = cityName;
}
@Override
public String toString() {
	return "StudentDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", cityName=" + cityName
			+ "]";
}
@Override
public int compareTo(StudentDetails arg0) {
	Integer id1=arg0.id;
	Integer id2=this.id;
	return id2.compareTo(id1);
}

}
