package fr.isedia.demo.gcp.trace;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class WorkController {

    @Value(value = "${service.two.url}")
    String serviceTwo;

    @Autowired
    RestTemplate restTemplate;

    private void meeting() {
        var result = restTemplate.getForObject(serviceTwo +"/meet", String.class);
        log.info(result);
    }


    @GetMapping("/")
    public String work() {
        // What is work? Meetings!
        // When you hit this URL, it'll call meetings() 5 times.
        // Each time will have a random delay.
        log.info("starting to work");
        for (int i = 0; i < 5; i++) {
            this.meeting();
        }
        log.info("finished!");
        return "finished work!";
    }


}
