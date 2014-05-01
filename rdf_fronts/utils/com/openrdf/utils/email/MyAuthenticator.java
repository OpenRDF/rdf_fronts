package com.openrdf.utils.email;
  
import javax.mail.*;

/**
 * E-mail MyAuthenticator
 * 
 * @description 本程序用于来自谢先斌毕业论文，如有使用请联系作 者，注明出处。
 * @URL 代码地址：http://github.com/openRDF/rdf_fronts
 * @dateTime 2014-3-22 下午6:56:09
 * @author XieXianbin
 * @email a.b@hotmail.com
 *
 */

public class MyAuthenticator extends Authenticator{  
	
    String userName=null;
    String password=null;
       
    public MyAuthenticator(){  
    }  
    public MyAuthenticator(String username, String password) {   
        this.userName = username; 
        this.password = password; 
    }   
    protected PasswordAuthentication getPasswordAuthentication(){  
        return new PasswordAuthentication(userName, password);
    }  
}