package ar.com.escuelita.chicken.base.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class Utilidad {

	public static final String DATE_TIME_FULL_FORMAT = "dd/MM/yyyy HH:mm:ss";
	
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
}
