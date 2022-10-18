import javax.naming.*;
import javax.naming.directory.*;

import java.util.Hashtable;
/**
 * Demonstrates how to create an initial context to an LDAP server
 * using an LDAPS URL.
 *
 * usage: java LdapTest <LDAP-URL> <BIND-DN> <BIND-PASSWORD>
 */
class LdapBind {
    public static void main(String[] args) {

        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");

        if (args.length != 3) {
            System.out.println("Usage: java -jar ldap-bind-test.jar <LDAP-URL> <BIND-DN> <BIND-PASSWORD>");
            System.out.println("Where LDAP-URL should be something like: ldap://youradhostname:389");
            System.exit(-1);
        }

        String ldapUrl = args[0];
        String bindDn = args[1];
        String bindPassword = args[2];

        System.out.println("LDAP URL: " + ldapUrl);
        System.out.println("BIND DN: " + bindDn);
        System.out.println("BIND PASSWORD: " + bindPassword);

        env.put(Context.PROVIDER_URL, ldapUrl);

        // Authenticate as bindDn user and bindPassword
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, bindDn);
        env.put(Context.SECURITY_CREDENTIALS, bindPassword);

        try {
            // Create initial context
            DirContext ctx = new InitialDirContext(env);
            System.out.println("The LDAP bind was successful.");
            // Close the context when we're done
            ctx.close();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
