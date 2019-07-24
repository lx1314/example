package com.lgj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages= {"com.lgj"})
@MapperScan(basePackages= {"com.lgj.mapper"})
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);        
 
    }
}
