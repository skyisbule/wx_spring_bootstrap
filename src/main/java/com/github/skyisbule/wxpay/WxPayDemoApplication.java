package com.github.skyisbule.wxpay;

import cn.hutool.http.HttpRequest;
import com.github.skyisbule.wxpay.auth.AuthKeyCheck;
import com.github.skyisbule.wxpay.thread.CloseThread;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableSwagger2Doc
@EnableTransactionManagement
@MapperScan("com.github.skyisbule.wxpay.dao")
@SpringBootApplication
public class WxPayDemoApplication extends SpringBootServletInitializer {
  public static void main(String[] args) {
    SpringApplication.run(WxPayDemoApplication.class, args);
    //do check
      String result = HttpRequest.post("http://127.0.0.1/authCheck/init")
              .execute()
              .body();
      new CloseThread().start();
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(WxPayDemoApplication.class);
  }
}
