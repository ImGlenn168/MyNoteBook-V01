package com.java.mynotebookuser.controller;

import com.java.mynotebookuser.utils.RedisUtil;
import com.java.mynotebookuser.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RedisController implements RedisApi {

    private static final Logger log = LoggerFactory.getLogger(RedisController.class);

    public static final String REDIS_KEY = "test_key";


    public Result setStr() {
        boolean result = new RedisUtil().set(REDIS_KEY, "set Str");
        return Result.result(result);
    }

    public Result getStr() {
        Object o = new RedisUtil().get(REDIS_KEY);
        log.info("[Glenn-spring-boot-test][RedisController][getStr][o={}]", o);
        return Result.result(o);
    }

    public Result del() {
        boolean del = RedisUtil.del(REDIS_KEY);
        return Result.result(del);
    }

    public Result expire() {
        Boolean expire = new RedisUtil().expire(REDIS_KEY, 30l);
        return Result.result(expire);
    }

    @Override
    public Result lock() {
        return null;
    }

    @Override
    public Result lockV2() {
        return null;
    }

    @Override
    public Result unLock() {
        return null;
    }
}
