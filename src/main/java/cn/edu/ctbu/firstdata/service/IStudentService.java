package cn.edu.ctbu.firstdata.service;

import cn.edu.ctbu.firstdata.domain.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    public List<Student> getAll();

    public List<Student> findByName(String name);

    public List<Student> findByNameLike(String name);

    public Student findById (Integer id);

    public List<Student> getStudentScoreLess(Integer score);

    public Student save(Student student);

    public void delete(Integer id);

    public void delete(Student student);
}
