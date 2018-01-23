package org.wing.dissertation.utils;

import javax.servlet.http.HttpServletResponse;

public class Return {
    public static void resp(HttpServletResponse response,String alert,String address)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<script>alert('"+alert+"'); window.location='"+address+"' ;window.close();</script>");
        response.getWriter().flush();
    }
}
