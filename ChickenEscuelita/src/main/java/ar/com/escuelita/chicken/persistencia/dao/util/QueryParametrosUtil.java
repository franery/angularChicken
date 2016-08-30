package ar.com.escuelita.chicken.persistencia.dao.util;

import java.util.ArrayList;
import java.util.Collection;

public class QueryParametrosUtil {
	String sql;
	Collection<Object> valores = new ArrayList<Object>();
	
	public QueryParametrosUtil () {
	}
	
	public QueryParametrosUtil (String hsql) {
		this.sql = hsql;
	}

	public String getSql() {
		return sql;
	}
	
	public String formatHQLtoJPQL() {
		StringBuffer buffer = new StringBuffer(sql);
		int start=0;
		int order=1;
		while ((start=buffer.indexOf("?", start+1)) > 0) {
			buffer.insert(start+1, order);
			order++;
		}
		
		return buffer.toString();
	}

	public void setSql(String query) {
		this.sql = query;
	}

	public Object[] getArrayValores() {
		if (valores.size() > 0)
			return valores.toArray();
		else
			return null;
	}

	public void addParametro(Object valorCampo) {
		this.valores.add(valorCampo);
	}
}
