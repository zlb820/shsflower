package com.jkxy.interceptor;

import java.util.List;
import java.util.Map;

import com.jkxy.action.userAction;
import com.jkxy.model.Guashi;
import com.jkxy.service.IUserService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class guashiInter extends AbstractInterceptor {
	private IUserService userService;
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {

		userAction action=(userAction) arg0.getAction();
		//登陆时  ，用户名 和 密码信息 提交到 userAction  ,因此 要在 userAction中获取 username
		String username=action.getUser().getUsername();
		
		List<Guashi> list =userService.getGuashi();
		
		for(int i=0;i<list.size();i++){
			if(list.get(i).getUser().getUsername().equals(username)){
				
				System.out.println(((Guashi) list.get(i)).getUser().getUsername());
				Map request = (Map) arg0.getInvocationContext().get("request");
				request.put("msg", "对不起，您的账号已挂失！！");
				System.out.println("sorry");
				return "error";
			}
			
		}
		
		
		return arg0.invoke();
	}

}








