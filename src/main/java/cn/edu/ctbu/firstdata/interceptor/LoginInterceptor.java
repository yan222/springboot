package cn.edu.ctbu.firstdata.interceptor;

import cn.edu.ctbu.firstdata.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.handler.Handler;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,Object handler) throws Exception{
        Student user=(Student) request.getSession().getAttribute("user");
        log.info(request.getRequestURI().toString());
        if(user==null){
            response.sendRedirect("/login/student");
            log.info("请先登录"+request.getRequestURI());
            return false;
        }
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView)
        throws Exception{
        log.info("postHandle…");
    }
    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,
                                Object handler,Exception ex)
        throws Exception{
        log.info("afterCompletion…");
    }
}
