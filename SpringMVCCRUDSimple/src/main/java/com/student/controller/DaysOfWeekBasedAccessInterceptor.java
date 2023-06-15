package com.student.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DaysOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Calendar cal = Calendar.getInstance();

		int daysOfWeek = cal.get(cal.DAY_OF_WEEK);// getting the day on which request is made

		if (daysOfWeek == 1) { // 1 means sunday ,2 means monday ....7 means saturday
			response.getWriter()
					.write("The website is closed on sunday please try accessing it on any other week day !!");
			return false;

		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		// this method would be called after spring mvc executes the request handler
		// method for the request
		System.out.println(
				"HandlerInterceptor : Spring Mvc called postHandle method for " + request.getRequestURI().toString());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		// this method would be called after the response object is produced by the view
		// for the request
		System.out.println("HandlerInterceptor : Spring Mvc called afterCompletion method for "
				+ request.getRequestURI().toString());
	}

}