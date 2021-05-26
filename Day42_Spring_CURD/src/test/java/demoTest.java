import com.itheima.bean.Account;
import com.itheima.service.AccountService;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class demoTest {

    @Autowired
    private AccountService accountService;


    @Test
    public  void test01() throws Exception {
        Account account=new Account();
        account.setName("张飞");
        account.setMoney(987);
        int add = accountService.add(account);
        System.out.println(add);
    }

    @Test
    public void test02() throws Exception{
        Account account = accountService.findById(1);
        account.setMoney(111);
        int update = accountService.update(account);
        System.out.println(update);

    }
    @Test
    public void test03() throws Exception {
        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
    }
}
