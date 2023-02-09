package com.demo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.entities.Student;
import com.demo.repositories.StudentRepository;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	StudentRepository studentrepo;
	@Test
	void saveOneStudent() {
		Student s= new Student();
		s.setName("sri");
		s.setCourse("civil");
		s.setFee(3000);
		studentrepo.save(s);
	}
	@Test
	void deleteOneStudent() {
		studentrepo.deleteById(9L);
	}
	@Test
	void ReadOneStudent() {
		Optional<Student> findById = studentrepo.findById(4L);
		Student student = findById.get();
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getCourse());
		System.out.println(student.getFee());
	}
	@Test
	void updateOneStudent() {
		Student s= new Student();
		s.setId(3);
		s.setName("lalu");
		s.setCourse("civil");
		s.setFee(1000);
		studentrepo.save(s);	
	}
	@Test
	void getAllStudent() {
		Iterable<Student> all = studentrepo.findAll();
		for (Student s : all) {
			System.out.println(s.getFee());
		}
	}
	
	
		//@Test
//	void getAllStudent() {
//		Iterable<Student> findAll = studentrepo.findAll();
//		for (Student s : findAll) {
//		
//			System.out.println(s.getId()+" "+s.getName()+" "+s.getCourse()+" "+s.getFee());
//		}
		
//		
//	@Test
//		void getAllStudent() {
//			Iterable<Student> findAll = studentrepo.findAll();
//			findAll.forEach((s)->{
//			
//				System.out.println(s.getId()+" "+s.getName()+" "+s.getCourse()+" "+s.getFee());
//			});
//	}

//
}
