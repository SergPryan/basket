package com.example.commons;

import com.example.entity.UserData;

import javax.servlet.http.HttpServletRequest;

public class Utils {

    public static final String orderAttribute = "myOrder";

    public static UserData getOrderInSession(HttpServletRequest request){
        UserData userData = (UserData) request.getSession().getAttribute(orderAttribute);
        if(userData == null){
            userData = new UserData();
        }
        request.getSession().setAttribute(orderAttribute, userData);
        return userData;
    }



}
