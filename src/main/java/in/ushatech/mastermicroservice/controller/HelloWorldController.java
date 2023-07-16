package in.ushatech.mastermicroservice.controller;

import in.ushatech.mastermicroservice.domain.HelloWorldBean;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController
{
    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

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
    @RequestMapping(method = RequestMethod.GET,path = "/hello-world-i18n")
    public String sayHelloInternationalizated()
    {
        Locale locale= LocaleContextHolder.getLocale();
        String message = messageSource.getMessage("good.morning.message",null,"Hello World",locale);
        return message;
    }
}
