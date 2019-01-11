package com.fay.bike.backend.controller;

import com.fay.bike.base.vo.Result;
import com.fay.bike.facade.user.dto.User;
import com.fay.bike.facade.user.facade.TbUserFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Test
 * @author fanqingfeng
 * @date 2019/1/9 16:41
 */
@Slf4j
@RestController
public class TestController {

    @Resource
    private TbUserFacade tbUserFacade;

    @GetMapping("/test")
    public Result<String> test() {
        User user = tbUserFacade.getUserById(2);
        log.info("user = {}", user);
        return new Result<String>().success("成功");
    }
}
