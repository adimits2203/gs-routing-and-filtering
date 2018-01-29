package hello;

import hello.filters.pre.SimpleErrorFilter;
import hello.filters.pre.SimplePostFilter;
import hello.filters.pre.SimplePreFilter1;
import hello.filters.pre.SimplePreFilter2;
import hello.filters.pre.SimpleRouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class GatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(GatewayApplication.class, args);
  }

  @Bean
  public SimplePreFilter1 simpleFilter() {
    return new SimplePreFilter1();
  }

  @Bean
  public SimplePreFilter2 simpleFilter2() {
    return new SimplePreFilter2();
  }

  @Bean
  public SimplePostFilter simplePostFilter() {
    return new SimplePostFilter();
  }

  @Bean
  public SimpleRouteFilter simpleRouteFilter() {
    return new SimpleRouteFilter();
  }

  @Bean
  public SimpleErrorFilter simpleErrorFilter() {
    return new SimpleErrorFilter();
  }

}
