package learning.springbootnew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MyFirstApi {
    public static void main(String[] args) {
        SpringApplication.run(MyFirstApi.class, args);



    }

    @RestController
    public class HelloController {

        //Default mapping is GET
        @RequestMapping("/hello")
        public String sayHi() {
            return "hi";
        }

    }

}





