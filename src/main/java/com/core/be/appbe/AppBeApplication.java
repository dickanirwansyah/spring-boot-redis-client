package com.core.be.appbe;

import com.alibaba.fastjson.JSON;
import com.core.be.appbe.common.util.CacheUtility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class AppBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppBeApplication.class, args);
	}
}

@Service
class TestRedis implements CommandLineRunner {

	@Autowired
	private CacheUtility cacheUtility;


	@Override
	public void run(String... args) throws Exception {
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setId(1l);
		loginResponse.setUsername("dickanirwansyah");
		loginResponse.setRole(Arrays.asList("admin", "user", "staff", "gudang"));
		cacheUtility.set("SESSION_ID", loginResponse.getUsername(), JSON.toJSONString(loginResponse), 100);
		System.out.println("your session : " + cacheUtility.get("SESSION_ID", loginResponse.getUsername()));
		cacheUtility.delete("SESSION_ID", loginResponse.getUsername());

	}
}

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
class LoginResponse {

	private Long id;
	private String username;
	private List<String> role;
}
