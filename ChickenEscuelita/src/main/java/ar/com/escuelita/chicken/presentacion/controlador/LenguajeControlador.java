package ar.com.escuelita.chicken.presentacion.controlador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class LenguajeControlador extends Controlador{


	@RequestMapping(value = "/cambioLenguaje")
	public ModelAndView changeLang(@RequestParam("urlRequest") String  urlRequest, @RequestParam("languageRequest") String languageRequest, HttpServletRequest request, HttpServletResponse response) {
		if (languageRequest != "") { 
			LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
			localeResolver.setLocale(request, response, StringUtils.parseLocaleString(languageRequest)); 
		}
		String[] spliteado = urlRequest.split("/");
		String str = spliteado[spliteado.length - 1];
		return new ModelAndView("redirect:/"+str);
	}
}
