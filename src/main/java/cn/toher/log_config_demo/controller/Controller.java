package cn.toher.log_config_demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with Chenquan.
 * Description:
 * Date: 2018-06-13
 * Time: 10:45
 */
@RestController
@RequestMapping("/hello")
@Slf4j
public class Controller {

    @RequestMapping("test1")
    public String test1() {
//        日志级别从低到高分为：
//        trace < debug < info < warn < error < fatal
//        如果设置为 info ，则低于 info 的信息都不会输出
        log.debug("debug输出");
        log.warn("warn输出");
        log.error("error输出");
        log.info("info输出");
        return "hello world!!!";
    }
}
