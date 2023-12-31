package skl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
/**
 * main du squelette d'API Spring security
 * ne doit normalement pas être utilisé puisque vous êtes censés inclure
 * le code du squelette dans votre propre projet. *
 * @author VincentProuchet
 */
@SpringBootApplication
@EnableMethodSecurity(securedEnabled = true)
public class SklApiSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SklApiSpringSecurityApplication.class, args);
	}

}
