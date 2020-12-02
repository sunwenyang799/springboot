package com.springboot.autoconfiguration;

/**
 * @author swy
 * @description:
 * @date 2020/11/26 17:05
 */
public class HelloService {

    private HelloProperties helloProperties;

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String say(String name){
        return helloProperties.getFirstName() +"对"+ name + "说"+helloProperties.getLastName();
    }
}
