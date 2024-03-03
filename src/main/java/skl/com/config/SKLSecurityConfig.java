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
 * Security Configuration this is where we declare *
 * @Beans related to security and how the spring security will accept or reject
 *        request
 */
@Configuration
@AllArgsConstructor
public class SKLSecurityConfig {

	@Autowired
	private SKLAuthentication authProvider;
	@Autowired
	SKLUserService userService;

	@Bean
    SecurityFilterChain springSecurityfilterChain(HttpSecurity http) throws Exception {

		http.csrf((csrf) -> {
			/** @TODO à changer pour une API déployée */
			csrf.disable();
		});
		// login
		http.authenticationManager(authProvider);
		http.authenticationProvider(authProvider);
		http.formLogin((formLogin) -> {
			formLogin.loginProcessingUrl(SKLRoutes.LOGIN);
			formLogin.failureHandler(authProvider);
			formLogin.successHandler(authProvider);
		});
		http.logout((logout) -> {
			logout.logoutUrl(SKLRoutes.LOGOUT);
			logout.addLogoutHandler(authProvider);
			logout.logoutSuccessHandler(authProvider);
			logout.logoutSuccessUrl(SKLRoutes.LOBBY);
			logout.clearAuthentication(true);
			logout.invalidateHttpSession(true);
			logout.deleteCookies(SKLVars.SESSION_SESSION_COOKIE_NAME);
		});
		// session
		http.sessionManagement((sessionManagement) -> {
			sessionManagement.maximumSessions(1);
			sessionManagement.sessionAuthenticationFailureHandler(authProvider);
		});
		// cookies
		http.rememberMe(rememberMe -> {
			rememberMe.alwaysRemember(true);
			rememberMe.useSecureCookie(true);
			rememberMe.authenticationSuccessHandler(authProvider);
			rememberMe.rememberMeCookieDomain("SKLDomain");
			rememberMe.rememberMeCookieName(SKLVars.SESSION_SESSION_COOKIE_NAME);
			rememberMe.tokenValiditySeconds(SKLVars.TOKEN_LIFE);

		});
		return http.build();
	}
	
	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring();
	}
}
