package test;

import com.system.entity.Page;
import com.system.service.UserloginService;
import com.system.mapper.StudentMapper;
import com.system.service.StudentService;
//import com.system.util.DateFormer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//ָ����ǰ����spring��junit���ϵ�һ����
@RunWith(SpringJUnit4ClassRunner.class)
//��ȡ�����ļ�
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class TestMain {

    //���Բ�ѯ����
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
    private UserloginService userLoginService;

    @Test
    public void testLog(){
        boolean loginResult = userLoginService.login("admin", "123");
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

    @Autowired
    StudentMapper studentMapper;

    @Test
    public void testDate(){
        System.out.println(studentMapper.selectByPrimaryKey(999));
    }

    @Test
    public void testsearch(){
        System.out.println(studentMapper.getSearchTotal("С"));
    }

    @Test
    public void testsearch2(){
        Page page = new Page(2,3,10);
        page.calPageIndex();
        System.out.println(studentMapper.searchByPage("С",page));
    }

}
