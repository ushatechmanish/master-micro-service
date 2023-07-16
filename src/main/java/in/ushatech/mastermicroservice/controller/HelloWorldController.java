package in.ushatech.mastermicroservice.controller;

import in.ushatech.mastermicroservice.domain.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController
{

    @RequestMapping(method = RequestMethod.GET,path = "/hello-world")
    public String sayHello()
    {
        return "Hello World";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/hello-world-bean")
    public HelloWorldBean sayHelloBean()
    {
        return new HelloWorldBean("Hello World");
    }

    @RequestMapping(method = RequestMethod.GET,path = "/hello-world/path-variable/{name}")
    public HelloWorldBean sayHelloBean(@PathVariable String name)
    {
        return new HelloWorldBean(String.format("Hello World %s",name));
    }
}
