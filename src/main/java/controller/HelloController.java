package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController {

        @GetMapping("/hello")
        public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
            return String.format("Hello %s!", name);
        }
//        @PostMapping("/hello")
//        public String testPost(@RequestBody String value){
//            System.out.println("value = " + value);
//            return value;
//        }

    @PostMapping("/hello")
    public String testPost(@RequestBody String value) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // json -> java object   : deSerialize
            Person person = objectMapper.readValue(value, Person.class);
            System.out.println("person = " + person);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("value=" + value);
        return value;  // json
    }

}
