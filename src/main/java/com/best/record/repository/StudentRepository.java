package com.best.record.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.best.record.model.StudentDetails;
@Repository
public interface StudentRepository extends  CrudRepository<StudentDetails,Integer> {

	

	

	

}
