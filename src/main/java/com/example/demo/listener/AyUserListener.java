package com.example.demo.listener;

import com.example.demo.model.AyUser;
import com.example.demo.service.AyUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

/**
 * 监听器
 * Created by Gavin on 2019/12/22.
 */
@WebListener
public class AyUserListener implements ServletContextListener {

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private AyUserService ayUserService;
    private static final String ALL_USER = "ALL_USER_LIST";

   // Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //查询数据库所有的用户
        List<AyUser> ayUserList = ayUserService.findAll();
        //清除缓存中的用户数据
        redisTemplate.delete(ALL_USER);
        //存放到redis缓存中
        redisTemplate.opsForList().leftPushAll(ALL_USER, ayUserList);
        //真实项目中需要注释掉
        //range(ALL_USER, 0, -1)取链表中的全部元素，0表示第一个，-1表示最后一个
        List<AyUser> queryUserList = redisTemplate.opsForList().range(ALL_USER, 0, -1);
        System.out.println("缓存中目前的用户数有：" + queryUserList.size() + " 人");
        System.out.println("ServletContext上下文初始化");
       /* logger.info("ServletContext上下文初始化");
        logger.info("缓存中目前的用户数有：" + queryUserList.size() + " 人");*/
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext上下文销毁");
       // logger.info("ServletContext上下文销毁");
    }
}

