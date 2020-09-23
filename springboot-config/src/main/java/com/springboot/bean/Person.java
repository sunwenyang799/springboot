package com.springboot.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author swy
 * @description: bean
 * @date 2020/9/23 13:22
 */

/**
 * 将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties :告诉springboot将本类中的所有属性和配置文件中的配置进行绑定
 * prefix = "person 配置文件中的哪个下面的属性进行一一映射
 * @Component 只有是这个容器中的组件，才能使用容器提供的 @ConfigurationProperties功能
 */
/**
 * @ConfigurationProperties和@Value的区别
 *                       @ConfigurationProperties          @Value
 *功能                   批量注入配置文件中的属性             一个一个指定
 * 松散绑定(松散语法)         支持                            不支持
 * SpEL(#{10*2})              不支持                          支持
 *JSR303校验                  支持                            不支持
 * 复杂类型封装               支持                            不支持
 *
 * 松散绑定：配置文件中的person.last-name和person.lastName都可以进行绑定
 *JSR303校验：依赖：spring-boot-starter-validation  需要校验的类上加@Validated注解,在属性上加校验
 * 复杂类型的封装：无法获取到值,报错     @Value("${person.maps}")
 *                                      private Map<String, Object> maps;
 *
 * 总结：如果只是需要获取配置文件中某项值，用@Value
 *       如果专门编写javaBean来和配置文件进行映射,使用  @ConfigurationProperties
 */
@Component
@ConfigurationProperties(prefix = "person")
@Validated
@PropertySource(value = "classpath:person.properties")//指定读取配置文件路径
public class Person {

//    @Value("${person.last-name}")
//    @Email
    private String lastName;
//    @Value("#{20+2}")
    private Integer age;
//    @Value("true")
    private Boolean boss;
    private Date birthday;

//    @Value("${person.maps}")
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;

    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birthday=" + birthday +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}
