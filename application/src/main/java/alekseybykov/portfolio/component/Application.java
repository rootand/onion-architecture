package alekseybykov.portfolio.component;

import alekseybykov.portfolio.component.config.database.DataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-08-09
 */
@SpringBootApplication(scanBasePackages = {"alekseybykov.portfolio.component"})
@EntityScan(basePackages = {"alekseybykov.portfolio.component.entities"})
@Import({DataSourceConfig.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}