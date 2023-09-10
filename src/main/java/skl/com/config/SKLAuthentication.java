package skl.com.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import skl.com.dao.SKLUser;
import skl.com.dto.SKLUserDTO;
import skl.com.services.SKLUserService;

/**
 * a custom authentication provider for injection in GDMSecurity and its
 * filterChain
 *
 * @author Vincent
 *
 */
@Configuration
@AllArgsConstructor
@NoArgsConstructor
public class SKLAuthentication
		implements AuthenticationProvider
		, AuthenticationSuccessHandler
		, AuthenticationFailureHandler
		,LogoutHandler
		, LogoutSuccessHandler {

	/** CONTENT_TYPE_JSON */
	private static final String CONTENT_TYPE_JSON = "application/json";
	/** CONTENT_TYPE */
	@SuppressWarnings("unused")
	private static final String CONTENT_TYPE = "Content-Type";
	/** CHARACTER_ENCODING */
	private static final String CHARACTER_ENCODING = "UTF-8";

	/** collaboratorService */
	@Autowired
	private SKLUserService userSrv;
	/** passwordEncoder */
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	/**
	 * Authentication method
	 * this is here that you can catch the authentication and
	 * do the magic
	 */
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		// if a security context already exist
		if (SecurityContextHolder.getContext().getAuthentication() != null) {

			return SecurityContextHolder.getContext().getAuthentication();
		}
		if (auth ==null) {
			throw new BadCredentialsException("le contexte  d'authentification est null la session est peut-être terminée");
		}
		String username = (String) auth.getPrincipal();
		if (username == null) {
			throw new BadCredentialsException(" Username can't be null ");
		}
		SKLUser coll = (SKLUser) userSrv.loadUserByUsername(username);
		if (coll == null) {
			throw new BadCredentialsException("les informations de compte sont incorrectes");
		}
		if (!coll.isEnabled()) {
			throw new BadCredentialsException("le compte n'est pas activé");
		}
		String password = (String) auth.getCredentials();
		if (passwordEncoder.matches(password, coll.getPassword())) {
			UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(
				coll.getUsername(), coll.getPassword(), coll.getAuthorities());
			return userToken;
		}
		throw new BadCredentialsException("les informations de compte sont incorrectes");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	/**
	 *handler for authentication failure
	 */
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		response.setContentType(CONTENT_TYPE_JSON);
		response.setCharacterEncoding(CHARACTER_ENCODING);
		response.setStatus(401);
	}

	/**
	 * handler for authentication success
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String outprint = "";
		// we have to set respons parameters
		response.setContentType(CONTENT_TYPE_JSON);
		response.setCharacterEncoding(CHARACTER_ENCODING);
		try {
			// we get connected user an make a Data transfert Object of it
			SKLUserDTO collab = new SKLUserDTO(userSrv.getConnectedUser());
			// an place it in Json form in the outprint
			outprint = new ObjectMapper().writeValueAsString(collab);// this can create a json formated string of any object

		} catch (Exception e) {
			// we add an header , responses MUST have an header
			response.addHeader(" user not found ", "  there is no user ");
			outprint = " ";
			// setting status response
			response.setStatus(500);
		}
		// we add an header , responses MUST have an header
		// any response without header is considerer as an error by angular
		response.addHeader("user", outprint);
		// we put things in the body
		// this can only be made once
		// only one body
		response.getWriter().append(outprint);
		// and set status to accepted
		response.setStatus(200);
	}
	/**
	 * logout handling will set session's cookies life's to 0
	 *
	 */
	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		Cookie[] cookies = request.getCookies();
		// We search for springs security session cookie
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName() == "") {
					// and set its life to 0
					cookie.setMaxAge(0);
				}
			}
		}
	}

	/**
	 * will be called if authentication doesn't throw any error
	 *
	 * it form a correct http response
	 *
	 *
	 */
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		UserDetails user = new SKLUser();
		String principal = "";

		try {
			principal = (String) authentication.getPrincipal();
			// we get the connected collaborator
			user = this.userSrv.loadUserByUsername(principal);
			// we clear te security context
			SecurityContextHolder.clearContext();
			// if everything goes smoothly we set an header

			response.addHeader(" user logged out ", user.getUsername());
			// and a status
			response.setStatus(200);

		} catch (NullPointerException e) { // string conversion error

			response.addHeader(" Nullpointer error ", "  string convertion ");
			response.setStatus(418);

			throw new ServletException(e.getMessage());

		} catch (UsernameNotFoundException e) { // find by username errors
			response.addHeader(" user not found ", "  there is no user ");
			response.setStatus(418);

			throw new ServletException(e.getMessage());

		}catch (Exception e) { // everything else
			// if not
			response.addHeader(" la loi de murphy ", e.getMessage());
			// i'm a teapot
			response.setStatus(418);

			throw new ServletException(e.getMessage());

		}

	}



}
