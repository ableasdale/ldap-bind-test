# LDAP Binding Test

Example use:

```bash
java -jar ldap-bind-test.jar ldap://your-ad-hostname:389 <aduser@realm> <aduser-password>
```
Your AD Username for binding can be confirmed by opening "Active Directory Users and Computers", navigating to your user and using the Account tab to get the full login name:

![Example User](src/main/resources/example-ldap-user.png)