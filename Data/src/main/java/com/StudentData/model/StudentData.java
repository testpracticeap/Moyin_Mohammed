package com.StudentData.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class StudentData {

	@Id
	@Column
	private int StudentId;
	@Column
	private String StudentName;
	@Column
	private String StudentClass;
	@Column
	private String StudentMarks;

	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int studentId) {
		this.StudentId = studentId;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		this.StudentName = studentName;
	}

	public String getStudentClass() {
		return StudentClass;
	}

	public void setStudentClass(String studentClass) {
		this.StudentClass = studentClass;
	}

	public String getStudentMarks() {
		return StudentMarks;
	}

	public void setStudentMarks(String studentMarks) {
		this.StudentMarks = studentMarks;
	}

}
