package com.best.record.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.best.record.Services.*;
import com.best.record.model.StudentDetails;

@RestController

//permits angular for getting these services
@CrossOrigin(origins = "http://localhost:4200") 
public class studentDetailController {
	@Autowired
	private StudentServices studentServices;
    //
	@GetMapping(path = "/students")
	public List<StudentDetails> getStudentDetail() {

		return this.studentServices.studentAllDetail();
	}

	@PutMapping(path = "/student/{id}")
	public String updateStudent(@PathVariable Integer id, @RequestBody StudentDetails student) {
		return this.studentServices.update(id, student);

	}

	@DeleteMapping(path = "/student/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		return this.studentServices.deleteStu(id);

	}

	@PostMapping(path = "/student")
	public String saveStu(@RequestBody StudentDetails student) {
		student.setId(0);
		System.out.println(student);
		return this.studentServices.saveStudent(student);

	}

	@GetMapping(path = "/setOrder")
	public List<StudentDetails> getStudentOrderDetail() {
		List<StudentDetails> list = getStudentDetail().stream().sorted().collect(Collectors.toList());
		return list;
	}
}
