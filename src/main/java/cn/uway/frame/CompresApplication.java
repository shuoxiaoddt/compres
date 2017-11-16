package cn.uway.frame;

import cn.uway.frame.util.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CompresApplication {

	public static void main(String[] args) {
		ApplicationContext app = SpringApplication.run(CompresApplication.class, args);
		SpringContextUtil.setApplicationContext(app);
	}
}
