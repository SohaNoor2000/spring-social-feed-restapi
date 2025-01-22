package com.springboot.practice;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldInternationaizationController {

    private final MessageSource messageSource;

    public HelloWorldInternationaizationController(MessageSource messageSource){
        super();
        this.messageSource=messageSource;

    }

    @GetMapping(path = "/good-morning-Internationalization")
    public String getHelloWorld(){
        Locale locale=LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default message",locale);
    }
}
