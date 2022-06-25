
package com.atscarborough.boot;

import ch.qos.logback.core.db.DBHelper;
import com.atscarborough.boot.bean.Pet;
import com.atscarborough.boot.bean.User;
import com.atscarborough.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.cache.interceptor.CacheAspectSupport;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 主程序类
 * @SpringBootApplication：这是一个springboot应用
 */
@SpringBootApplication
/*    @SpringBootConfiguration
    @EnableAutoConfiguration
    @ComponentScan("com.atscarborough.boot")*/
public class MainApplication {
    public static void main(String[] args) {
//1、返回我们IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //2、 查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name: names){
            System.out.println(name);
        }

        int beanDefinitionCount = run.getBeanDefinitionCount();
        System.out.println(beanDefinitionCount);

        System.out.println("==========="+run.getBeanNamesForType(CacheAspectSupport.class).length);

        //3、 从容器中获取组件

        String[] beanNamesForType1 = run.getBeanNamesForType(WebMvcProperties.class);
        System.out.println("==========="+beanNamesForType1.length);


      /*  Pet tom01 =run.getBean("tom",Pet.class);
        Pet tom02 =run.getBean("tom",Pet.class);
        System.out.println("组件：  " + (tom01 == tom02));
        //4、com.atscarborough.boot.config.MyConfig$$EnhancerBySpringCGLIB$$8efa31fc@6b350309
        MyConfig bean = run.getBean((MyConfig.class));
        System.out.println(bean);
        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
        //保持组件单实例
        User user = bean.user01();
        User user1 = bean.user01();
        System.out.println("组件：  " + (user == user1));

        User user01 = run.getBean("user01", User.class);
        Pet tom = run.getBean("tom", Pet.class);
        System.out.println("用户的宠物：   "+(user01.getPet() == tom));

        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        System.out.println("==========");
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

        DBHelper bean1 = run.getBean(DBHelper.class);
        System.out.println(bean1);*/

        System.out.println("容器中Tom组件：   "+run.containsBean("tom"));

        System.out.println("容器中user01组件：   "+run.containsBean("user01"));

        System.out.println("容器中haha组件：   "+run.containsBean("haha"));

        System.out.println("容器中hehe组件：   "+run.containsBean("hehe"));
    }
}
