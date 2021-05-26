import com.itheima.dao.UserDao;
import com.itheima.factory.BeanFactory;
import com.itheima.service.UserService;
import org.junit.Test;

public class TestUserServiceImpl {
    @Test
    public void add() throws Exception {
        System.out.println("调用啦service实现类的方法");
        UserDao userDao =(UserDao) BeanFactory.getBean("ud");
        userDao.add();
    }

    @Test
    public  void  add01() throws Exception {
        UserService userService= (UserService) BeanFactory.getBean("us");
        userService.add();

    }
}

