package com.springboot.controller;

import com.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author swy
 * @description:
 * @date 2020/10/20 15:19
 */
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 处理UserNotExistException异常,如果发生异常返回异常信息map
     * 这种写法只能返回json结构,不能返回页面
     * @param e
     * @return
     */
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handleException(Exception e){
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","user not exist");
//        map.put("exception",e.getMessage());
//        return map;
//    }

    /**
     *  处理UserNotExistException异常,如果发生异常携带异常信息返回指定错误页面
     *  这种写法只能返回错误页面
     * @param e
     * @param model
     * @return
     */
//    @ExceptionHandler(UserNotExistException.class)
//    public ModelAndView handleException(Exception e, Model model){
//        ModelAndView modelAndView = new ModelAndView();
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","user not exist");
//        map.put("exception",e.getMessage());
//        modelAndView.addObject("map",map);
//        modelAndView.setViewName("error/404");
//        return modelAndView;
//    }

    /***
     * 处理UserNotExistException异常,如果发生异常携带异常信息返回指定错误页面
     * 这种写法既可以返回错误页面也可以返回错误信息
     * 要求: request域中要求定义异常的错误code值： request.setAttribute("javax.servlet.error.status_code",500);
     *       自定义DefaultErrorAttributes  Bean覆盖原有的可以选择extends DefaultErrorAttributes 也可以选择implements ErrorAttributes,
     *             最好extends DefaultErrorAttributes 只需要重写父类getErrorAttributes方法即可
     *       在request域中或session域中自定义错误信息   request.setAttribute("ext",map);
     *       自定义DefaultErrorAttributes  Bean取出我们自定义的异常信息  Map<String,Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user not exist");
        map.put("msg","用户出错了");
        request.setAttribute("ext",map);
        //直接转发到/error是200,
        //Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
        //需要在request域中将状态码改变
        return "forward:/error";
    }
}
