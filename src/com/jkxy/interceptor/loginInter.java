package com.jkxy.interceptor;

import java.util.Map;

import com.jkxy.model.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class loginInter extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Map session=arg0.getInvocationContext().getSession();
		User user1=(User) session.get("user");
		if(user1==null){
			return "error";
			
		}
		
		return arg0.invoke();
	}

}
