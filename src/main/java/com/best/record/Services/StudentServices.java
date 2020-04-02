package com.best.record.Services;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best.record.model.StudentDetails;
import com.best.record.repository.StudentRepository;


@Service
public class StudentServices {
@Autowired
private StudentRepository studentRepository;


public List<StudentDetails> studentAllDetail()
{     
	List<StudentDetails> list=null;

//	if(this.flag==false) {
//		list=((List<StudentDetails>) this.studentRepository.findAll())
//				.stream().sorted((w,sq)->sq.getFirstName().compareTo(w.getFirstName())).
//				collect(Collectors.toList());
//		this.flag=true;
//	}
//	else {
		list= ((List<StudentDetails>) this.studentRepository.findAll())
				.stream().sorted((w,sq)->sq.getFirstName().compareTo(w.getFirstName())).
				collect(Collectors.toList());
	
	
	return list;

}
public String update(Integer id,StudentDetails student) {
	
	if(this.studentRepository.existsById(id)) {
		StudentDetails s=this.studentRepository.save(student);
		if(s!=null) return "success";
		else return "unsccesses";
	}
	
	return "data not exist";
}

public String deleteStu(Integer id) {

if(this.studentRepository.existsById(id)) 
{
	this.studentRepository.deleteById(id);
	return "successeful delete";
}
	return "not deleted";
}

public String saveStudent(StudentDetails student) {

	 StudentDetails st=this.studentRepository.save(student);
	 if(st==null)  return "note save" ;
	 else 
	return "save data";
}
}
