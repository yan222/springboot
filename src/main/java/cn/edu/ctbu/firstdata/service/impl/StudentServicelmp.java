package cn.edu.ctbu.firstdata.service.impl;

import cn.edu.ctbu.firstdata.domain.Student;
import cn.edu.ctbu.firstdata.repository.StudentRepository;
import cn.edu.ctbu.firstdata.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServicelmp implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll(){
        return studentRepository.findAll();
    }
    public List<Student> findByName(String studentName){
        return studentRepository.findByName(studentName);
    }
    public List<Student> findByNameLike(String studentName){
        return studentRepository.findByNameLike(studentName);
    }
    public Student findById(Integer id){
        return studentRepository.findById(id).orElse(null);
    }
    public List<Student> getStudentScoreLess(Integer score){
        return studentRepository.getByStudentScoreLess(score);
    }

    public Student save(Student student){
        return studentRepository.save(student);
    }

    public void delete(Integer id){
         studentRepository.deleteById(id);
    }

    public void delete(Student student){
         studentRepository.delete(student);
    }
}
