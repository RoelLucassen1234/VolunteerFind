package presentation;

import dal.HibernateConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VolunteerfinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(VolunteerfinderApplication.class, args);
        HibernateConfig.setupHibernate();
    }

}
