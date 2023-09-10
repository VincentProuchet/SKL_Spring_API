package skl.com.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class SKLUser_Test {
	
	public static class values{
		public static String firstname = "firstname" ; 
		public static String stupidFirstname = "      FriStnomE   " ; 
		public static String specialCharFirstname = "firstname&   " ;
		public static String numberFirstname = "firstname1" ;
		public static String lastname = "lastname" ;
		public static String email = "patate@vapeur.com" ;
		public static String username = "patatore" ;
		public static String login = "thebigone" ;
		public static String password = "1111" ;
		
		public static LocalDateTime password_creation = LocalDateTime.now();
		public static LocalDateTime account_creation = LocalDateTime.now();
	}
	
	/**
	 * test des valeurs de base de l'objet
	 */
	@Test
	public void BaseValues() {
		
		SKLUser user = new SKLUser();
		assertEquals(0, user.getId());
		assertNull(user.getFirstName());
		assertNull(user.getLastName());
		assertNull(user.getEmail());
		assertNull(user.getUsername());
		assertNull(user.getLogin());
		assertNull(user.getPassword());
		assertNull(user.getAccountCreation());
		assertNull(user.getPasswordCreation());
		assertNull(user.getAuthorities());
		
		assertTrue(user.isAccountNonExpired());
		assertTrue(user.isCredentialsNonExpired());
		assertTrue(user.isAccountNonLocked());
		assertFalse(user.isEnabled());		
		}
@Test
public void setValues() {
	// on teste d'abord que les valeurs sont bien par défaut
	SKLUser user = new SKLUser();
	
	assertNull(user.getLastName());
	assertNull(user.getEmail());
	assertNull(user.getUsername());
	assertNull(user.getLogin());
	assertNull(user.getPassword());
	assertNull(user.getAccountCreation());
	assertNull(user.getPasswordCreation());
	assertNull(user.getAuthorities());
	
	assertTrue(user.isAccountNonExpired());
	assertTrue(user.isCredentialsNonExpired());
	assertTrue(user.isAccountNonLocked());
	assertFalse(user.isEnabled());
	// puis on change ces valeurs
	
	
	user.setLastName(values.lastname);
	user.setEmail(values.email);
	user.setUsername(values.username);
	user.setLogin(values.login);
	user.setPassword(values.password);
	user.setAccountCreation(values.account_creation);
	user.setPasswordCreation(values.password_creation);
	
	user.setCredentialExpired(true);
	user.setExpired(true);
	user.setLocked(true);
	user.setCredentialExpired(true);
	user.setEnabled(true);
	
	// puis on les teste
	assertEquals(values.lastname, user.getLastName());
	assertEquals(values.email,  user.getEmail());
	assertEquals(values.username, user.getUsername());
	assertEquals(values.login, user.getLogin());
	assertEquals(values.password, user.getPassword());
	assertEquals(values.account_creation, user.getAccountCreation());
	assertEquals(values.password_creation, user.getPasswordCreation());
	assertEquals(null, user.getAuthorities());
	
	assertFalse(user.isAccountNonExpired());
	assertFalse(user.isCredentialsNonExpired());
	assertFalse(user.isAccountNonLocked());
	assertTrue(user.isEnabled());
	

}
@Test
public void Id() {
	SKLUser user = new SKLUser();
	assertNotEquals(Integer.MAX_VALUE, user.getId());
	assertNotEquals(Integer.MIN_VALUE, user.getId());
	assertNotEquals(-1, user.getId());
	assertEquals(0, user.getId());
	
	user.setId(Integer.MAX_VALUE);
	assertNotEquals(0, user.getId());
	assertNotEquals(Integer.MIN_VALUE, user.getId());
	assertEquals(Integer.MAX_VALUE, user.getId());
	
	user.setId(Integer.MIN_VALUE);
	assertNotEquals(0, user.getId());
	assertNotEquals(Integer.MAX_VALUE, user.getId());
	assertEquals(Integer.MIN_VALUE, user.getId());
}
@Test
public void firstname() {
	SKLUser user = new SKLUser();
	assertNull(user.getFirstName());
	assertNotEquals(values.firstname,user.getFirstName());
	assertNotEquals(values.firstname,user.getFirstName());
	
	user.setFirstName(values.firstname);
	assertEquals(values.firstname,user.getFirstName());
	
}

}
