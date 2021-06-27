package test;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.system.entity.Page;
import com.system.entity.Selectedcourse;
import com.system.mapper.UserloginMapper;
import com.system.service.CourseService;
import com.system.service.SelectedcourseService;
import com.system.service.UserloginService;
import com.system.mapper.StudentMapper;
import com.system.service.StudentService;
//import com.system.util.DateFormer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.ResponseStatus;

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
        System.out.println(studentMapper.getSearchTotal("小"));
    }

    @Test
    public void testsearch2(){
        Page page = new Page(2,3,10);
        page.calPageIndex();
        System.out.println(studentMapper.searchByPage("小",page));
    }

    @Autowired
    private UserloginService userloginService;

    @Autowired
    private UserloginMapper userloginMapper;

    @Test
    public void testreset(){
        System.out.println(userLoginService.reset(14));
    }

    @Autowired
    private CourseService courseService;

    @Test
    public void selectbyteacherid(){
        System.out.println(courseService.selectByTeacherId(1001));
    }

    @Autowired
    private SelectedcourseService selectedcourseService;

    @Test
    public void selectStudentByCourseId(){
        System.out.println(selectedcourseService.selectStudentByCourseId(1));
    }

    @Test
    public void updateSelective(){
        Selectedcourse selectedcourse = new Selectedcourse();
        selectedcourse.setCourseid(1);
        selectedcourse.setStudentid(10002);
        selectedcourse.setMark(100);
        System.out.println(selectedcourseService.updateSelective(selectedcourse));
    }

    @Test
    public void selectall(){
        System.out.println(courseService.selectByStudentIdAll(10003));
        System.out.println(courseService.selectByStudentIdSelected(10003));
        System.out.println(courseService.selectByStudentIdDone(10003));
    }

    @Test
    public void select(){
        System.out.println(selectedcourseService.unselect(10006,7));
    }
}
