package com.springboot.service;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author swy
 * @description: 监听rabbitmq
 * @date 2020/12/4 13:47
 */
@Service
public class BookService {

    @RabbitListener(queues = "hello.world")
    public void receive(Message message, Channel channel) {
        try {
//            int i = 1 / 0;
            JSONObject jsonObject = JSONObject.parseObject(new String(message.getBody()));
            if (!"200".equals(jsonObject.getString("code"))) {
                System.out.println("消息不正确,无法接收");
                return;
            }
        }catch (Exception e){
            System.out.println("发生异常，消息落库");
            return;
        }

        System.out.println("监听到hello.world队列中消息为：" + new String(message.getBody()));
    }

    @RabbitListener(queues = "hello.java")
    public void receive1(Message message) {
        JSONObject jsonObject = JSONObject.parseObject(new String(message.getBody()));
        if (!"200".equals(jsonObject.getString("code"))) {
            System.out.println("消息不正确,无法接收");
            return;
        }
        System.out.println("监听到hello.java队列中消息为：" + new String(message.getBody()));
    }

    @RabbitListener(queues = "bye.java")
    public void receive2(Message message) {
        JSONObject jsonObject = JSONObject.parseObject(new String(message.getBody()));
        if (!"200".equals(jsonObject.getString("code"))) {
            System.out.println("消息不正确,无法接收");
            return;
        }
        System.out.println("监听到bye.java队列中消息为：" + new String(message.getBody()));
    }

    @RabbitListener(queues = "bye.world")
    public void receive3(Message message) {
        JSONObject jsonObject = JSONObject.parseObject(new String(message.getBody()));
        if (!"200".equals(jsonObject.getString("code"))) {
            System.out.println("消息不正确,无法接收");
            return;
        }
        System.out.println("监听到bye.java队列中消息为：" + new String(message.getBody()));
    }
}
