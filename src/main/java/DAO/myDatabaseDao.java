package DAO;

import POJO.Student;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("myDao")
public class myDatabaseDao {

    @Getter
    @Setter
    @Autowired
    private JdbcTemplate jdbcTemplate;



    public Student getStudent(int studentID) {
        String query="Select * from mystudents where id=?";
        Student st1=jdbcTemplate.queryForObject(query,new BeanPropertyRowMapper<>(Student.class),studentID);
        return st1;
    }


}
