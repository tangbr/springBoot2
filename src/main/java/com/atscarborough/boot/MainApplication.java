
package com.atscarborough.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 主程序类
 * @SpringBootApplication：这是一个springboot应用
 */
//@SpringBootApplication
    @SpringBootConfiguration
    @EnableAutoConfiguration
    @ComponentScan("com.atscarborough.boot")
public class MainApplication {
    public static void main(String[] args) {
//1、返回我们IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //2、 查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name: names){
            System.out.println(name);
        }
        //3、 从容器中获取组件

    }
}
