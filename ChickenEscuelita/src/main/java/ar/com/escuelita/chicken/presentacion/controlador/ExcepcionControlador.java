package ar.com.escuelita.chicken.presentacion.controlador;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import ar.com.escuelita.chicken.base.constantes.Constantes;
import ar.com.escuelita.chicken.base.excepciones.Excepcion;
import ar.com.escuelita.chicken.base.utils.Utilidad;

@ControllerAdvice
public class ExcepcionControlador {

	private ModelAndView errorModelAndView(Exception ex, HttpServletRequest request, HttpServletResponse response) {
		Excepcion e = new Excepcion(ex);
		Constantes.CHICKEN_LOG.error("Controlador: {}; Error: {}",getClass(),e.getMessage());
		
		ModelAndView mv = new ModelAndView(Constantes.PRINCIPAL_VIEW);
		mv.addObject("pageToLoad", Constantes.EXCEPCION_VIEW);
		request.setAttribute("errorSpecified", ex.getMessage());
		request.setAttribute("error", Utilidad.stackTraceToString(ex));
		request.setAttribute("errorFechaHora", Utilidad.formatDateAndTimeFull(new Date()));
		
		//Unicamente para ajax
		if (Utilidad.isAjax(request)) {
			response.setStatus(HttpStatus.CONFLICT.value()); //error 409
			return handleJsonExcepcion(ex, request, response);
		}
		
		return mv;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
		return errorModelAndView(ex, request, response);
	}

	private ModelAndView handleJsonExcepcion(Exception ex, HttpServletRequest request, HttpServletResponse response) {
		Map<String,String> bigMap = new HashMap<String, String>();
		bigMap.put("titulo", "Este es un titulo de error ajax");
		if (ex != null) {
			bigMap.put("errorSpecified", ex.getMessage());
		}
		MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
		return new ModelAndView(jsonView, bigMap);
    }
}
