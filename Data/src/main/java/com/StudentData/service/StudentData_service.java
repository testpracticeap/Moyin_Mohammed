package com.StudentData.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentData.model.StudentData;
import com.StudentData.repository.StudentData_repository;

@Service
public class StudentData_service {

	@Autowired
	StudentData_repository SD_r;

	// Getting all Student Data
	public List<StudentData> getAllstudents() {
		List<StudentData> SD = new ArrayList<StudentData>();
		SD_r.findAll().forEach(students -> SD.add(students));
		return SD;
	}

	// Getting Student Data by Id
	public StudentData getStudentId(int Id) {
		return SD_r.findById(Id).get();
	}

	// Saving the Student Data
	public void saveorUpdate(StudentData students) {
		SD_r.save(students);
	}

	// Updating the Student Data
	public void update(StudentData students, int studentId) {
		SD_r.save(students);
	}

	// Deleting the Student Data
	public void delete(int studentId) {
		SD_r.deleteById(studentId);
	}
}
