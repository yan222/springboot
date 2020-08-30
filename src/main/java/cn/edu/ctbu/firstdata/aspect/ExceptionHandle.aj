package cn.edu.ctbu.firstdata.aspect;

import cn.edu.ctbu.firstdata.exception.RException;
import cn.edu.ctbu.firstdata.helper.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public aspect ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    public R handle(Exception e){
        if(e instanceof RException){
            RException rException=(RException) e;
            return R.error(rException.getCode(),rException.getMessage());
        }
        else {
            return R.error(-999,e.getMessage());
        }

    }
}
