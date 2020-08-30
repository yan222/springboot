package cn.edu.ctbu.firstdata.repository;

import cn.edu.ctbu.firstdata.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository <Student,Integer> {

    public List<Student> findByName (String name);
    public List<Student> findByNameLike (String name);

    @Query("select o from tb_student o where o.score< ?1")
    public List<Student> getByStudentScoreLess(Integer score);

 //   public Page<Student> findAll(Pageable pageable);

    public Page<Student> findBySex(Integer sex,Pageable pageable);

    public List<Student> findByNameAndPassword(String name,String password);
}
