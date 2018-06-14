package cn.toher.log_config_demo.controller;

import cn.toher.log_config_demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with Chenquan.
 * Description:
 * Date: 2018-06-14
 * Time: 10:26
 */
@RestController
@RequestMapping("/restTemplate")
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getbaidu")
    public String getHello() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://www.baidu.com", String.class);
        String body = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpHeaders headers = responseEntity.getHeaders();
        StringBuffer result = new StringBuffer();
        result.append("responseEntity.getBody()：").append(body).append("<hr>")
                .append("responseEntity.getStatusCode()：").append(statusCode).append("<hr>")
                .append("responseEntity.getStatusCodeValue()：").append(statusCodeValue).append("<hr>")
                .append("responseEntity.getHeaders()：").append(headers).append("<hr>");
        return result.toString();
    }

    //    设置请求
    @GetMapping("/getNameById")
    public String getNameById(@RequestParam int id, @RequestParam String name) {
        if (1 == id && "zhihao.miao".equals(name)) {
            return "name=" + name + ",age=" + 27;
        } else {
            return "name=" + name;
        }
    }

    @GetMapping("/getUserById")
    public User getUserById(@RequestParam int id,@RequestParam String name){
        User user = new User();

        if(id == 1 && "zhihao.miao".equals(name)){
            user.setId(1);
            user.setUsername("zhihao.miao");
            user.setAge(27);
        }

        if(id ==2 && "zhangsan".equals(name)){
            user.setId(2);
            user.setUsername("zhangsan");
            user.setAge(24);
        }

        return user;
    }


    @PostMapping("/queryLoginPrivilegeByUser")
    public List<String> queryLoginPrivilegeByUser(@RequestBody User user){
        int id = user.getId();

        if(id ==1 ){
            return Arrays.asList("台账查询,用户设置".split(","));
        }else{
            return Arrays.asList("购物车设置,积分后台查询".split(","));
        }
    }


    @PostMapping("/queryUserPrivilegeById")
    public String queryUserPrivilegeById(@RequestParam int id,@RequestParam String name){
        if(1 ==id){
            return "user is "+name;
        }
        return "user is not exist";
    }

}
