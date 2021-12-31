package stepDefs;

import DAO.myDatabaseDao;
import POJO.Student;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import utils.jdbcConfig;

public class databaseStepDefs {
    ApplicationContext context=new AnnotationConfigApplicationContext(jdbcConfig.class);
    myDatabaseDao dao=context.getBean("myDao",myDatabaseDao.class);
    @Autowired
    public Student st;

    @Given("when user tries to get data for student id {int}")
    public void hitDatabase(int studentID){
        st=dao.getStudent(studentID);
    }
    @Then("user should be present in the database")
    public void checkUserPresent(){
        System.out.println(st);
        Assert.assertFalse(st==null);
    }
}

