package com.masai.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.model.Student;
import com.masai.model.StudentDTO;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	
	//public List<Student> findByName(String name);
	
	
	//@Query("from Student where name=?1")
//	@Query("select s from Student s where s.name=:nm")
//	public List<Student> getStudentsByName(@Param("nm") String name);
	
	@Query("select s from Student s where s.name=?1")
	public List<Student> getStudentsByName(String name);
	
	
	@Query("select s.address from Student s where s.roll=?1")
	public String getStudentAddressByRoll(Integer roll);
	
	@Query("select s.marks from Student s where s.roll=?1")
	public Integer getStudentMarksByRoll(Integer roll);
	
	
	@Query("select s.name,s.marks from Student s where s.roll=?1")
	public String getStudentNameAndMarksByRoll(Integer roll);
	//here the columns will come as a comma seperated String
	
	
	@Query("select name,marks from Student")
	public List<String> getAllStudentNameAndMarks();
	
	
	@Query("select new com.masai.model.StudentDTO(name, marks) from Student")
	public List<StudentDTO> getStudentNameAndMarks();
	//here the columns will come as a comma seperated String

	
	
	
}

