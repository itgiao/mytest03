import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demoTest {
    @Test
    public void addTest(){
        //创建工厂
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationConText.xml");
        //问工厂要对象
        UserService us= (UserService) context.getBean("us");
        //调用方法
        us.add();
    }
    @Test
    public  void  adTest01(){
        //创建工厂
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationConText.xml");
        //问工厂要对象
        UserService userService= (UserService) context.getBean("us01");
        //对象调用方法
        userService.add();
    }

    @Test
    public  void  addTest02(){
        //创建工厂
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationConText.xml");
        //文工厂要对象
        UserService userService = (UserService) context.getBean("us02");
        userService.add();
    }

    @Test
    public  void  addTest03(){
        //创建工厂
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationConText.xml");
        //问工厂要对象
        UserService userService = (UserService) context.getBean("us03");
        //调用方法
        userService.add();
    }
}
