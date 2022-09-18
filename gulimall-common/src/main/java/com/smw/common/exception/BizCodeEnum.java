package com.smw.common.exception;

public enum BizCodeEnum {
  UNKNOWN_EXCEPTION(10000, "系统位置异常"),
  VALID_EXCEPTION(10001, "参数格式校验失败");

  private final int code;
  private final String message;

  BizCodeEnum(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
