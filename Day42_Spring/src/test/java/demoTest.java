import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demoTest {
    @Test
    public void testAdd(){
        //1. 创建工厂
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2. 问工厂要对象
        UserService us = context.getBean(UserService.class);
        us.add();
    }

    @Test
    public void test02(){
        //1. 创建工厂
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2. 问工厂要对象
        UserService us = context.getBean(UserService.class);
        us.add();
        ((ClassPathXmlApplicationContext)context).close();
    }

}
