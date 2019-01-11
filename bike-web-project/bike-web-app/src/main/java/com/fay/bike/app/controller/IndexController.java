package com.fay.bike.app.controller;

import com.alibaba.fastjson.JSONObject;
import com.fay.bike.app.configuration.RedisResource;
import com.fay.bike.app.vo.IndexVo;
import com.fay.bike.base.vo.Result;
import com.fay.bike.facade.user.dto.User;
import com.fay.bike.facade.user.facade.TbUserFacade;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页Controller
 * @author fanqingfeng
 * @date 2018/11/5 17:48
 */
@Slf4j
@RestController
public class IndexController {

    @Resource
    private TbUserFacade tbUserFacade;

    @Resource
    private RedisResource redis;

    @GetMapping("/user/{id}")
    public Result<User> getUser(@PathVariable("id") Integer id) {
        Preconditions.checkArgument(id != null, "参数异常");
        User user = tbUserFacade.getUserById(id);
        log.info("user = {}", user);
        redis.set("say", "hello");
        redis.set("user", user);
        log.info("say = {}", redis.get("say"));
        log.info("user = {}", redis.get("user"));
        redis.set("2", "2222222", 10);
        return new Result<User>().success(user);
    }

    @GetMapping("/index")
    public Result<IndexVo> index(@RequestParam(value = "msg", defaultValue = "hello") String message) {
        IndexVo indexVo = new IndexVo();
        indexVo.setAge(18);
        indexVo.setName("Fay");
        log.info("indexVo = {}", indexVo);
        return new Result<IndexVo>().success(indexVo, message);
    }

    @GetMapping("/list")
    public Result<List> list() {
        List<IndexVo> list = Lists.newArrayList();
        IndexVo indexVo = new IndexVo();
        indexVo.setAge(18);
        indexVo.setName("Fay");
        list.add(indexVo);
        log.info("list = {}", JSONObject.toJSONString(list));
        return new Result<List>().success(list);
    }

    @GetMapping("/redis")
    public Result<Map<String, Object>> redis() {
        Result<Map<String, Object>> result = new Result<>();
        redis.set("1", 11111);
        redis.set("3", "3333333");
        redis.del("3");
        redis.set("4", "4444444");
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("1", redis.get("1"));
        log.info("map = {}", map);
        map.put("2", redis.get("2"));
        map.put("3", redis.get("3"));
        map.put("4", redis.get("4"));
        log.info("map = {}", map);
        return result.success(map);
    }

    @GetMapping("/log")
    public Result<String> log() {
        log.error("error日志测试");
        log.warn("warn日志测试");
        log.info("info日志测试");
        return new Result<String>().success("success");
    }

}
