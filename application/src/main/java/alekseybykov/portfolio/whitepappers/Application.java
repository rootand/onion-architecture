//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers;

import alekseybykov.portfolio.whitepappers.config.database.DataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-08
 */
@SpringBootApplication(scanBasePackages = {"alekseybykov.portfolio.whitepappers"})
@EntityScan(basePackages = {"alekseybykov.portfolio.whitepappers.entities"})
@Import({DataSourceConfig.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}