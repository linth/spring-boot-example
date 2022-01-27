// package com.example.springarchitecture.Dao;

// import java.util.Collection;
// import java.util.List;
// import java.util.Optional;

// import com.example.springarchitecture.Entity.Student;
// import com.example.springarchitecture.repository.StudentRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;

// /**
//  * Data Access Object (Dao): 資料存取物件 
//  */
// @Component
// public class StudentDao {
//     @Autowired
//     private StudentRepository repository;
    
//     public void save(Student student) {
//         repository.save(student);
//     }
    
//     public List<Student> getStudents() {
//         return repository.findAll();
//     }

//     public void delete(String id) {
//         repository.deleteById(id);
//     }

//     public Student updateStudentById(String id, Student student) {
//         Optional<Student> findStudentQuery = repository.findById(id);
//         Student studentData = findStudentQuery.get();
//         studentData.setId(student.getId());
//         studentData.setName(student.getName());
//         studentData.setAge(student.getAge());
//         studentData.setBirDate(student.getBirDate());
//         return repository.save(studentData);
//     }
// }
