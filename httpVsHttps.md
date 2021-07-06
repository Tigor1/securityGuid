HTTPS

In practice, however, your applications communicate only over HTTPS. There are several patterns to configure HTTPS in a system. 
In some cases, developers configure HTTPS at the application level; in others, they might use a service mesh or they could 
choose to set HTTPS at the infrastructure level. With Spring Boot, you can easily enable HTTPS at the application level.

In any of these configuration scenarios, you need a certificate signed by a certification authority (CA). Using this certificate, 
the client that calls the endpoint knows whether the response comes from the authentication server and that nobody intercepted 
the communication. You can buy such a certificate, but you have to renew it. If you only need to configure HTTPS to test your 
application, you can generate a self-signed certificate using a tool like OpenSSL. Let’s generate our self-signed certificate and 
then configure it in the project:

```
openssl req -newkey rsa:2048 -x509 -keyout key.pem -out cert.pem -days 365
```

After running the openssl command in a terminal, you’ll be asked for a password and details about your CA. Because it is only 
a self-signed certificate for a test, you can input any data there; just make sure to remember the password. The command 
outputs two files: key.pem (the private key) and cert.pem (a public certificate). In most cases, the certificate is the 
Public Key Cryptography Standards #12 (PKCS12). Less frequently, we use a Java KeyStore (JKS) format. Let’s continue our
example with a PKCS12 format. For an excellent discussion on cryptography, I recommend Real-World Cryptography by David 
Wong (Manning, 2020).

```
openssl pkcs12 -export -in cert.pem -inkey key.pem -out certificate.p12 -name "certificate"
```

The second command we use receives as input the two files generated by the first command and outputs the self-signed certificate. 
Mind that if you run these commands in a Bash shell on a Windows system, you might need to add winpty before it, as shown in 
the next code snippet:

```
winpty openssl req -newkey rsa:2048 -x509 -keyout key.pem -out cert.pem -days 365
winpty openssl pkcs12 -export -in cert.pem -inkey key.pem -out certificate.p12 -name "certificate"
```

Finally, having the self-signed certificate, you can configure HTTPS for your endpoints. Copy the certificate.p12 file into the 
resources folder of the Spring Boot project and add the following lines to your application.properties file:
```
server.ssl.key-store-type=PKCS12
server.ssl.key-store=classpath:certificate.p12
server.ssl.key-store-password=12345   <------------| The value of the password is the
                                                     one you specified when running
                                                     the second command to generate
                                                     the PKCS12 certificate file.
```

The password (in my case, “12345”) was requested in the prompt after running the command for generating the certificate. This 
is the reason why you don’t see it in the command. Now, let’s add a test endpoint to our application and then call it using HTTPS:

```
@RestController
public class HelloController {
 @GetMapping("/hello")
 public String hello() {
 return "Hello!";
 }
}
```

If you use a self-signed certificate, you should configure the tool you use to make the endpoint call so that it skips testing the
authenticity of the certificate. If the tool tests the authenticity of the certificate, it won’t recognize it as being authentic, 
and the call won’t work. With cURL, you can use the -k option to skip testing the authenticity of the certificate:

```
curl -k https://localhost:8080/hello!
```

Remember that even if you use HTTPS, the communication between components of
your system isn’t bulletproof. Many times, I’ve heard people say, “I’m not encrypting
this anymore, I use HTTPS!” While helpful in protecting communication, HTTPS is just
one of the bricks of the security wall of a system. Always treat the security of your
system with responsibility and take care of all the layers involved in it.