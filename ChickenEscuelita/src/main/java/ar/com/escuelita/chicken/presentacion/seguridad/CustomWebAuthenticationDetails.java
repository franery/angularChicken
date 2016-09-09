package ar.com.escuelita.chicken.presentacion.seguridad;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;


@SuppressWarnings("serial")
public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {
	
	private boolean captchaPassed;

	public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        System.out.println("CustomWeb");
    }

	public boolean isCaptchaPassed() {
		return captchaPassed;
	}

	
}
