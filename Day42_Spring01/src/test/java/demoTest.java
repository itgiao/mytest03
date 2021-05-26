import com.itheima.bean.Account;
import com.itheima.config.AppConfig;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = AppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class demoTest {

    @Autowired
    private AccountService accountService;

    @Test
    public  void Test01() throws Exception {
        Account account=new Account();
        account.setName("李白");
        account.setMoney(10);
        int add = accountService.add(account);
        System.out.println("add = " + add);
    }

}
