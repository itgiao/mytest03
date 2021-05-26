import com.itheima.bean.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class demoTest {

    @Test
    public void test01() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountService) context.getBean("accountService");
        Account account = new Account();
        account.setName("王五");
        account.setMoney(999);
        int row = accountService.add(account);
        System.out.println("row = " + row);

    }

    @Test
    public void test02() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountService) context.getBean("accountService");
        Account account = accountService.findById(4);
        account.setName("aa");
        int update = accountService.update(account);
        System.out.println("update = " + update);
    }

    @Test
    public void test03() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountService) context.getBean("accountService");
        int delete = accountService.delete(4);
        System.out.println("delete = " + delete);

    }

    @Test
    public void test04() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountService) context.getBean("accountService");
        List<Account> all = accountService.findAll();
        System.out.println(all);

    }
}