package com.StudentData.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.StudentData.model.StudentData;
import com.StudentData.service.StudentData_service;

@RestController

public class StudentData_controller {

	@Autowired
	StudentData_service SD_s;

	@GetMapping("/StudentData")
	private List<StudentData> getAllStudents() {
		return SD_s.getAllstudents();
	}

	@PostMapping("/StudentData/create")
	private int saveStudent(@RequestBody StudentData Student) {
		SD_s.saveorUpdate(Student);
		return Student.getStudentId();
	}

	@GetMapping("/StudentData/{id}")
	private StudentData getStudentData(@PathVariable("StudentId") int stdId) {
		return SD_s.getStudentId(stdId);
	}

	@PutMapping("/StudentData/update")
	private StudentData updateStudent(@RequestBody StudentData student) {
		SD_s.saveorUpdate(student);
		return student;
	}

	@DeleteMapping("/StudentData/{id}")
	private void deleteStudent(@PathVariable("StudentId") int stdId) {
		SD_s.delete(stdId);
	}
}
