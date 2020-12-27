package com.springboot;

import com.springboot.bean.Book;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootTest
class SpringbootAmqpApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    /**
     * 单播(点对点)
     */
    @Test
    void contextLoads() {
//         Message 需要自己构造一个。定义消息头和消息体
//        rabbitTemplate.send("exchange", "routingKey", "message");

//        object默认当成消息体，只要传入要发送的对象，自动序列化给rabbitmq
//        rabbitTemplate.convertAndSend("exchange", "routingKey", "object");

//         存放字符串
//        rabbitTemplate.convertAndSend("my.direct","bye.world","hello");

//       存放map
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        map.put("msg", Arrays.asList("hello", true));
//        rabbitTemplate.convertAndSend("my.direct","bye.world","hello");
//        rabbitTemplate.convertAndSend("my.direct", "hello.java", map);

//        存放实体
//        rabbitTemplate.convertAndSend("my.direct","bye.java",new Book("aaa","bbb"));

        rabbitTemplate.convertAndSend("my.direct","hello.world","hello");

    }

    /**
     * 接收消息
     */
    @Test
    void receiveMsg() {
//        取字符串
//        Object o = rabbitTemplate.receiveAndConvert("bye.world");

//        取map
//        Object o = rabbitTemplate.receiveAndConvert("hello.java");

        Object o = rabbitTemplate.receiveAndConvert("hello.world");

//        取实体
//        Object o = rabbitTemplate.receiveAndConvert("bye.java");

        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 广播(fanout)
     */
    @Test
    void testFanout() {
        //fanout为当前exchange(交换器)所有队列发送消息，不需要routingKey(路由键)
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("data",new Book("aaa","bbb"));
        concurrentHashMap.put("code","200");
        concurrentHashMap.put("mes","成功");
        ConcurrentHashMap concurrentHashMap1 = new ConcurrentHashMap();
        concurrentHashMap1.put("data",new Book("ccc","ddd"));
        concurrentHashMap1.put("code","500");
        concurrentHashMap1.put("mes","成功");
        rabbitTemplate.convertAndSend("my.fanout","",concurrentHashMap);
        rabbitTemplate.convertAndSend("my.fanout","",concurrentHashMap1);
//        rabbitTemplate.convertAndSend("my.fanout","","hello");
    }

    /**
     *  广播(topic)
     */
    @Test
    void testTopic(){
        rabbitTemplate.convertAndSend("my.topic","hello.#",new Book("aaa","bbb"));
    }

    /**
     * 测试amqpadmin
     */
    @Test
    void testAmqpAdmin(){
        //创建一个Exchange 类型是direct，持久化为true，不自动删除
//        amqpAdmin.declareExchange(new DirectExchange("adqpadmin.exchange",true,false));

        //创建一个queue，持久化为true
//        amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));

        //将amqpadmin.queue绑定到adqpadmin.exchange
//        amqpAdmin.declareBinding(new Binding("amqpadmin.queue",Binding.DestinationType.QUEUE,"adqpadmin.exchange","amqpadmin.queue",null));

        //删除exchange  adqpadmin.exchange
//        amqpAdmin.deleteExchange("adqpadmin.exchange");

        //将amqpadmin.queue取消绑定到adqpadmin.exchange
//        amqpAdmin.removeBinding(new Binding("amqpadmin.queue",Binding.DestinationType.QUEUE,"adqpadmin.exchange","amqpadmin.queue",null));

        //删除queue amqpadmin.queue
        amqpAdmin.deleteQueue("amqpadmin.queue");

    }
}
