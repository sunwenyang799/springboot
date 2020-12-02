package com.springboot;

import com.springboot.entity.Employee;
import com.springboot.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@SpringBootTest
class SpringbootCacheApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void testStringRedisTemplate(){
//        stringRedisTemplate.opsForValue().append("value","hello");
//        String value = stringRedisTemplate.opsForValue().get("value");
//        System.out.println(value);
        
//        stringRedisTemplate.opsForList().leftPush("list","1");
//        stringRedisTemplate.opsForList().leftPush("list","2");
//        List<String> list = stringRedisTemplate.opsForList().range("list", 0, 1000);
//        System.out.println(list);
        
//        stringRedisTemplate.opsForSet().add("set","1","2","3","1","3");
//        Set<String> set = stringRedisTemplate.opsForSet().members("set");
//        System.out.println(set);

//        stringRedisTemplate.opsForZSet().add("zset","1",1);
//        stringRedisTemplate.opsForZSet().add("zset","2",2);
//        stringRedisTemplate.opsForZSet().add("zset","1",3);
//        Set<String> zset = stringRedisTemplate.opsForZSet().range("zset", 0, 200);
//        System.out.println(zset);

        stringRedisTemplate.opsForValue().set("emp",employeeMapper.getEmpById(1).toString());
        String emp = stringRedisTemplate.opsForValue().get("emp");
        System.out.println(emp);

    }
    
    @Test
    public void testRedisTemplate(){
//        redisTemplate.opsForValue().append("value1","aaa");
//        String value1 = (String) redisTemplate.opsForValue().get("value1");
//        System.out.println(value1);
//        redisTemplate.opsForList().leftPush("list1","aaa");
//        redisTemplate.opsForList().leftPush("list1","bbb");
//        List list1 = redisTemplate.opsForList().range("list1", 0, 3);
//        System.out.println(list1);
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Employee>(Employee.class));
        redisTemplate.opsForValue().set("emp",employeeMapper.getEmpById(1));
        Employee emp = (Employee) redisTemplate.opsForValue().get("emp");
        System.out.println(emp);
    }

    @Test
    void contextLoads() {
        Employee emp = employeeMapper.getEmpById(1);
        System.out.println(emp);
    }

}
