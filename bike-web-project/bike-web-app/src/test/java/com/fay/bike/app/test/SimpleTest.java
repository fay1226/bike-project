package com.fay.bike.app.test;

import com.fay.bike.app.BikeAppApplication;
import com.fay.bike.facade.user.facade.TbUserFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 简单测试
 * @author fanqingfeng
 * @date 2019/1/10 10:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BikeAppApplication.class)
public class SimpleTest {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private TbUserFacade tbUserFacade;

    @Test
    public void test() throws SQLException {
        System.out.println(this.dataSource);
        System.out.println(tbUserFacade.getUserById(2));
    }
}
