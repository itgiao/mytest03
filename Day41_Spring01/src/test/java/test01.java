import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test01 {
    @Test
    public void testAdd(){
        //创建工厂指定工厂要解读这个application文件
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        //问工厂要对象
        UserDao userDao= (UserDao) context.getBean("ud");
        System.out.println(userDao);
        //调用方法
        userDao.add();
        //关闭工厂,实际应用中一般不关闭
        context.close();
    }
    @Test
    public void testAdd01(){

        //UserService userService = new UserServiceImpl();

        //1. 创建工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2. 问工厂要对象
        UserService us = (UserService) context.getBean("us");

        //3. 调用方法
        us.add();

    }
}
