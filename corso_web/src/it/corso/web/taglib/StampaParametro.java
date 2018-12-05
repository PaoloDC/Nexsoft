package it.corso.web.taglib;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class StampaParametro extends TagSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public int doEndTag() throws JspException {
		try {

			HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
			JspWriter out = pageContext.getOut();
			if (null != req.getParameter("utente")) {

				out.println("Ciao " + req.getParameter("utente"));

			} else {
				out.println("Clicca qui per accedere!");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.doEndTag();
	}

	private static final Map<String, String> myMap;
    static
    {
        myMap = new HashMap<String, String>();
        myMap.put("a", "b");
        myMap.put("c", "d");
    }
    
	
}
