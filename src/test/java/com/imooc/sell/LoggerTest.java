package com.imooc.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class LoggerTest {

    @Test
    public void loggerTest01 () {
        log.error("error ....");
        log.warn("warn ....");
        log.info("info ....");
        log.debug("debug ....");
    }
}
