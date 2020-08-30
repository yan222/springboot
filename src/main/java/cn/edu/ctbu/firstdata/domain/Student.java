package cn.edu.ctbu.firstdata.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity(name = "tb_student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    /*学生id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /*学生姓名*/
    @NotNull
    @Size(min=2,max=50,message = "名称应当在2-50字符之间")
    private String name;

    /*学生成绩*/

    private Integer score;

    /*性别*/
    private Integer sex;

    /*密码*/
    private String password;

    /*生日*/
    //@JsonFormat(locale = "zh",timezone = "GMT+8",pattern = "yyyy年MM月dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthday;

    /*头像*/
    private String avatar;

}
