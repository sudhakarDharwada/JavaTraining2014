package com.listners;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
  
public class SessionTime implements HttpSessionListener{  
    ServletContext ctx=null;  
    //static int total=0,current=0;  
      
    public void sessionCreated(HttpSessionEvent e) {  
    
    	HttpSession session = e.getSession();
    	
    
    	/*System.out.printf("Session ID %s created at %s%n", e.getSession().getId(), new Date());
    	System.out.println("At http session listner...");
    	System.out.println("checking session max inactive time " +session.getMaxInactiveInterval());
    	if(session.getMaxInactiveInterval() == 10){
    		System.out.println("Session is invalidated.....");
    		session.invalidate();
    	}
    	*/

    	
    	 HttpSession session1 = e.getSession();
         System.out.print(/*getTime() +*/ " (session) Created:");
         System.out.println("ID=" + session1.getId() + " MaxInactiveInterval=" + session1.getMaxInactiveInterval());
    	
   /* ctx=e.getSession().getServletContext();  
    ctx.setAttribute("totalusers", total);  
    ctx.setAttribute("currentusers", current);  
   */   
    }  
  
    public void sessionDestroyed(HttpSessionEvent e) {  
   /*     current--;  
        ctx.setAttribute("currentusers",current);  
   */
    	
    	}

	
	
  
}  