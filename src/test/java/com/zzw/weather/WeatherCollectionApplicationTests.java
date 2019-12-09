package com.zzw.weather;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
// 用于模拟数据进行测试。模拟发送请求，判断返回参数是否符合要求
@AutoConfigureMockMvc
public class WeatherCollectionApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testHello() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders // 模拟发送request请求
				// 发送get请求
				.get("/hello")
				// 设置接收的返回值类型
				.accept(MediaType.APPLICATION_JSON))
				// 添加验证规则，验证执行结果是否正确
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello World")));
	}

}
