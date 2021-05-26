import com.itheima.service.AccountService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class demoTest {

    @Autowired
    private AccountService accountServiceImpl;

    @Resource(name="proxyAccountService")
    private AccountService as;
    @Test
    public void testTransfer(){

        accountServiceImpl.transfer("张三","李四",200);
    }

    @Test
    public void test01(){
     as.transfer("张三","李四",100);
    }


}
