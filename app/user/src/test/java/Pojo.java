import org.apache.shiro.authc.AuthenticationToken;

public class Pojo implements AuthenticationToken {

    private String principal;
    private String credentials;

    public Pojo(String principal, String credentials) {
        this.principal = principal;
        this.credentials = credentials;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }
}
