package test;

import com.system.entity.Page;
import com.system.service.LogService;
import com.system.mapper.StudentMapper;
import com.system.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//指定当前类是spring和junit整合的一个类
@RunWith(SpringJUnit4ClassRunner.class)
//读取配置文件
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class TestMain {

    //测试查询所有
    @Autowired
    private StudentMapper mapper;

//    @Test
//    public void testFindEmps(){
//        List<Student> students = mapper.selectStudent();
//        for (Student student : students) {
//            System.out.println(student);
//        }
//    }

    @Autowired
    private LogService logService;

    @Test
    public void testLog(){
        boolean loginResult = logService.login("admin", "123");
        System.out.println(loginResult);
    }

    @Autowired
    private StudentService studentService;

    @Test
    public void testStudent(){
        int total = studentService.getPageTotal(2);
        System.out.println(total);
        System.out.println(studentService.selectByPage(new Page(2,total,2)));
    }

}
