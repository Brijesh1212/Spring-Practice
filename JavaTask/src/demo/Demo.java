package demo;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.IncorrectClaimException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MissingClaimException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.security.Key;

// We need a signing key, so we'll create one just for this example. Usually
// the key would be read from your application configuration instead.

public class Demo {
	
	
	
	public static void main(String[] args) {
		 Key key = MacProvider.generateKey();

		 String compactJws = Jwts.builder()
		  .setSubject("Joe")
		  .signWith(SignatureAlgorithm.HS512, key)
		  .compact();
		 try {
			    Jws<Claims> claims = Jwts.parser()
			        .requireSubject("Joe")
			        .setSigningKey(key)
			        .parseClaimsJws(compactJws);
			    System.out.println(claims.getBody());
			} catch (MissingClaimException e) {

				e.printStackTrace();
			    // we get here if the required claim is not present

			} catch (IncorrectClaimException e) {

				e.printStackTrace();
			    // we get here if the required claim has the wrong value

			}
	}


}
