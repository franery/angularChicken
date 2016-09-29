package ar.com.escuelita.chicken.base.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import ar.com.escuelita.chicken.base.constantes.Constantes;

public class Utilidad {

	public static final String DATE_TIME_FULL_FORMAT = "dd/MM/yyyy HH:mm:ss";
	
    private static final String DATE_PATTERN = "dd/MM/yyyy";

	private static final Date JAVA_START_DATE = new Date(0);
    
    public static StringBuilder stackTraceToString( Exception e) {
        StringBuilder s = new StringBuilder();
        s.append(e+"<br>");
        for (StackTraceElement stackTraceEl : e.getStackTrace()) {
            s.append("	at: "+stackTraceEl.toString()+"<br>");
        }
        return s;
    }
    
	public static String formatDateAndTimeFull(final Date date) {
       if (date == null) {
           return null;
       }
       SimpleDateFormat dateFormatAll = new SimpleDateFormat(Utilidad.DATE_TIME_FULL_FORMAT);
       return dateFormatAll.format(date);
   	}
	
	public static boolean isAjax(HttpServletRequest request) {
		return request != null && "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
	}

    /**
     * Calcula la diferencia
     * @param start
     * @param end
     * @return
     * @throws ParseException
     */
    public static Date differenceBetweenDates(Date start, Date end)
        throws ParseException {
    	
    	SimpleDateFormat sdfOnlyDate = new SimpleDateFormat(DATE_PATTERN);
        Long correctionFactor = sdfOnlyDate.parse(sdfOnlyDate.format(JAVA_START_DATE)).getTime();
        Long diff = end.getTime() - start.getTime() + correctionFactor;
        Date difference = new Date(diff);
        return difference;
    }
    
    public static String getUsuarioSesion(HttpServletRequest httpServletRequest) {
		if ((!(httpServletRequest.getSession().getAttribute(Constantes.LOGIN_USERNAME) == null))
				&& (httpServletRequest.getSession().getAttribute(Constantes.LOGIN_USERNAME) instanceof String)
				&& (!((String)httpServletRequest.getSession().getAttribute(Constantes.LOGIN_USERNAME) == null))) 
		{
			
			return (String) httpServletRequest.getSession().getAttribute(Constantes.LOGIN_USERNAME);
		}
		
		return "";
	}
}