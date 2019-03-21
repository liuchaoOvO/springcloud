package lc; /**
 * @author liuchaoOvO on 2019/3/15
 */
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("lc.dao")
@EnableEurekaClient
@EnableCircuitBreaker
public class HystrixProviderApplication
{

    public static void main(String[] args) {

        SpringApplication.run(HystrixProviderApplication.class, args);
    }

}
