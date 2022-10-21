package com.StudentData.repository;

import org.springframework.data.repository.CrudRepository;

import com.StudentData.model.StudentData;

public interface StudentData_repository extends CrudRepository<StudentData, Integer> {
}
