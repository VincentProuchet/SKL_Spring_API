package skl.com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;
import skl.com.constant.SKLRoutes;
import skl.com.constant.SKLVars;
import skl.com.services.SKLUserService;

/**
 * Security Configuration this is where we declare
 *
 * @Beans related to security and how the spring security will accept or reject
 *        request
 * @author Vincent
 */
@Configuration
@AllArgsConstructor
public class SKLSecurityConfig {

	/**
	 * authProvider logoutHandler
	 */
	@Autowired
	private SKLAuthentication authProvider;

	/** userService */
	@Autowired
	SKLUserService userService;

    /**
     * configuration spring security
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    SecurityFilterChain springSecurityfilterChain(HttpSecurity http) throws Exception {

		http.csrf((c) -> {
			/** @TODO à changer pour une API déployée */
			c.disable();
		});
		// login
		http.authenticationManager(authProvider);
		http.authenticationProvider(authProvider);
		http.formLogin((flc) -> {
			flc.loginProcessingUrl(SKLRoutes.LOGIN);
			flc.failureHandler(authProvider);
			flc.successHandler(authProvider);
		});
		http.logout((lout) -> {
			lout.logoutUrl(SKLRoutes.LOGOUT);
			lout.addLogoutHandler(authProvider);
			lout.logoutSuccessHandler(authProvider);
			lout.logoutSuccessUrl(SKLRoutes.LOBBY);
			lout.clearAuthentication(true);
			lout.invalidateHttpSession(true);
			lout.deleteCookies(SKLVars.SESSION_SESSION_COOKIE_NAME);
			lout.permitAll();
		});
		// sesion
		http.sessionManagement((s) -> {
			s.maximumSessions(1);
			s.sessionAuthenticationFailureHandler(authProvider);
		});
		// cookies
		http.rememberMe(rmc -> {
			rmc.alwaysRemember(true);
			rmc.useSecureCookie(true);
			rmc.authenticationSuccessHandler(authProvider);
			rmc.rememberMeCookieDomain("SKLDomain");
			rmc.rememberMeCookieName(SKLVars.SESSION_SESSION_COOKIE_NAME);
			rmc.tokenValiditySeconds(SKLVars.TOKEN_LIFE);

		});
		return http.build();
	}

	/**
	 * this is where we configure the method and path that can be accessed from
	 * outside the first commit will open everything its head is Security OpenAll
	 *
	 * @return
	 */
	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		System.err.println("webignoring");
		return (web) -> web.ignoring();
	}
}
