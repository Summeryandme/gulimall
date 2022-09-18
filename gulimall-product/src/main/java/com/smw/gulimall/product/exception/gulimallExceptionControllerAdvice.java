package com.smw.gulimall.product.exception;

import com.smw.common.exception.BizCodeEnum;
import com.smw.common.utils.R;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackages = "com.smw.gulimall.product.controller")
public class gulimallExceptionControllerAdvice {
  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public R handleValidException(MethodArgumentNotValidException e) {
    log.error("数据校验出现问题{},异常类型{}", e.getMessage(), e.getClass());
    BindingResult bindingResult = e.getBindingResult();
    HashMap<String, String> map = new HashMap<>();
    bindingResult
        .getFieldErrors()
        .forEach(fieldError -> map.put(fieldError.getField(), fieldError.getDefaultMessage()));
    return R.error(BizCodeEnum.VALID_EXCEPTION.getCode(), BizCodeEnum.VALID_EXCEPTION.getMessage())
        .put("data", map);
  }

  @ExceptionHandler(value = Throwable.class)
  public R handleException(Throwable throwable) {
    log.error("未知异常{},异常类型{}", throwable.getMessage(), throwable.getClass());
    return R.error(
        BizCodeEnum.UNKNOWN_EXCEPTION.getCode(), BizCodeEnum.UNKNOWN_EXCEPTION.getMessage());
  }
}
