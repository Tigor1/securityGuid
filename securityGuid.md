#Spring Security

The main strategy interface for authentication is AuthenticationManager, which has only one method:

```
public interface AuthenticationManager {

  Authentication authenticate(Authentication authentication)
    throws AuthenticationException;
}
```

An AuthenticationManager can do one of 3 things in its authenticate() method:
*   Return an Authentication (normally with authenticated=true) if it can verify that the input represents a valid principal.
*   Throw an AuthenticationException if it believes that the input represents an invalid principal.
*   Return null if it cannot decide.

AuthenticationException is a runtime exception. It is usually handled by an application in a generic way, depending on the 
style or purpose of the application. In other words, user code is not normally expected to catch and handle it. For example,
a web UI might render a page that says that the authentication failed, and a backend HTTP service might send a 401 response,
with or without a WWW-Authenticate header depending on the context.

The most commonly used implementation of AuthenticationManager is ProviderManager, which delegates to a chain of 
AuthenticationProvider instances. An AuthenticationProvider is a bit like an AuthenticationManager, but it has 
an extra method to allow the caller to query whether it supports a given Authentication type:

```
public interface AuthenticationProvider {

	Authentication authenticate(Authentication authentication)
			throws AuthenticationException;

	boolean supports(Class<?> authentication);
}
```