package test;

import com.system.Service.LogService;
import com.system.mapper.StudentMapper;
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
    private LogService logService;

    @Test
    public void testLog(){
        boolean loginResult = logService.login("admin", "123");
        System.out.println(loginResult);
    }

}
