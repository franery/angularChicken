package ar.com.escuelita.chicken.presentacion.seguridad;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class CustomAuthenticationDetailsHandler 
	implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> {
    
	@Override
    public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
        System.out.println("WebAuth");
		return new CustomWebAuthenticationDetails(context);
    }
//	
//	public MultiTypeCaptchaService getCaptchaService() {
//		return captchaService;
//	}
//
//	public void setCaptchaService(MultiTypeCaptchaService captchaService) {
//		this.captchaService = captchaService;
//	}
}
