package cn.toher.log_config_demo;

import cn.toher.log_config_demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LogConfigDemoApplicationTests {


	@Autowired
	private RestTemplate restTemplate;

//	@Test
//	public void contextLoads() {
//	}
	@Test
	public void restTemplateTest1() {
		int id = 1;
		String name = "zhihao.miao";
		String username = restTemplate.getForEntity("http://localhost:8080/restTemplate/getNameById?id={1}&name={2}",String.class,new Object[]{id,name}).getBody();
		log.info(username);
	}


	@Test
	public void restTemplateTest2() {
		Map<String,Object> params = new HashMap<>();
		params.put("id",1);
		params.put("name","chenuan");
		User user = restTemplate.getForEntity("http://localhost:8080/restTemplate/getUserById?id={id}&name={name}",User.class,params).getBody();
		log.info(user.toString());
	}

	@Test
	public void restTemplateTest3() {

//		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//		HttpClient httpClient = HttpClientBuilder.create()
//				.setRedirectStrategy(new LaxRedirectStrategy())
//				.build();
//		factory.setHttpClient(httpClient);
//		restTemplate.setRequestFactory(factory);RestTemplate的转发请求301，302问题

		User user = new User();
		user.setId(1);
		List<String> menulist = restTemplate.postForEntity("http://localhost:8080/restTemplate/queryLoginPrivilegeByUser",user,List.class).getBody();
		menulist.stream().forEach(System.out::println);
	}

	@Test
	public void restTemplateTest4() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic YWRjMjlhOGQ2ZGJjOTc1NDphNTAzNjRjMjdiZjA0NTMxYmE0MDk4N2M1NjgwZjBhMw==");
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		MultiValueMap<String, Object> parammap = new LinkedMultiValueMap<>();
		parammap.add("id",1);
		parammap.add("name","chenuan");

//		HttpEntity<Map> entity = new HttpEntity<>(parammap,headers);

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		String result = restTemplate.postForEntity("http://localhost:8080/restTemplate/queryUserPrivilegeById",entity,String.class).getBody();
		log.info(result);

	}





}
