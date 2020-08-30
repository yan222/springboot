package cn.edu.ctbu.firstdata.service.impl;

import cn.edu.ctbu.firstdata.domain.Student;
import cn.edu.ctbu.firstdata.exception.REnum;
import cn.edu.ctbu.firstdata.exception.RException;
import cn.edu.ctbu.firstdata.repository.StudentRepository;
import cn.edu.ctbu.firstdata.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServicelmp implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Page<Student> getAll(Pageable pageable){
        return studentRepository.findAll(pageable);
    }

    public List<Student> findByName(String studentName) {
        return studentRepository.findByName(studentName);
    }

    public List<Student> findByNameLike(String studentName) {
        return studentRepository.findByNameLike(studentName);
    }

    public Student findById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> getStudentScoreLess(Integer score) {
        return studentRepository.getByStudentScoreLess(score);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    public void delete(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Page<Student> findBySex(Integer sex, Pageable pageable) {
        return studentRepository.findBySex(sex, pageable);
    }

    @Override
    public Student validUserNameAndPassword(String userName, String passWord) throws Exception{

        List<Student> students=studentRepository.findByNameAndPassword(userName,passWord);
        if(students.size()>0){
            return students.get(0);
        }
        else {
            throw new RException(REnum.LOGIN_ERR);
        }
    }

}
