package com.springboot.autoconfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author swy
 * @description:
 * @date 2020/11/26 17:08
 */
@ConfigurationProperties("my.hello")
public class HelloProperties {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
