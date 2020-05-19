import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class ShiroTest {

    private DefaultSecurityManager manager;

    @Before
    public void init() {
        manager = new DefaultSecurityManager();
        manager.setRealm(new RealmA());
    }

    @Test
    public void test01() {
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("li", "123456");
        subject.login(token);
    }
}
