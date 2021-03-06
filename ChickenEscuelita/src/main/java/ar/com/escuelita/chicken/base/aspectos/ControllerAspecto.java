package ar.com.escuelita.chicken.base.aspectos;

import java.text.DecimalFormat;


import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.security.core.context.SecurityContextHolder;

import ar.com.escuelita.chicken.base.utils.Traza;

public class ControllerAspecto {

	public Object timeController(ProceedingJoinPoint joinPoint) throws Throwable {
		Traza.aspectoDebug(this.getClass(), "timeController", "Clase: " + joinPoint.getTarget().getClass().getSimpleName());
		Traza.aspectoDebug(this.getClass(), "timeController", "Metodo: " + joinPoint.getSignature().getName());
		Traza.aspectoDebug(this.getClass(), "timeController", "Antes de ejecutar...");
	
		String usuario = "";
		if (joinPoint != null && joinPoint.getArgs() != null) {
			if(SecurityContextHolder.getContext().getAuthentication() != null) {
				usuario = SecurityContextHolder.getContext().getAuthentication().getName();
			}
		}
	
		double startTime = System.nanoTime();
		//continue on the intercepted method
		Object object = joinPoint.proceed(); 
		double stopTime = System.nanoTime();
		double elapsedTime = (stopTime - startTime) / 1000000000.0;
		Traza.aspectoDebug(this.getClass(), "timeController", "Despues de ejecutar...");
		
		String metodo = joinPoint.getTarget().getClass().getSimpleName() + "." + joinPoint.getSignature().getName();
		String detalle = "Resultado: " + new DecimalFormat("#.########").format(elapsedTime);
		Traza.tiempo(this.getClass(), usuario, metodo , detalle);
		
		return object;
	}
}
