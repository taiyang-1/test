package com.finance.expection;
//价格非法异常
public class InvalidPriceException extends RuntimeException{
    public InvalidPriceException(String message) {
        super(message);
    }
    public InvalidPriceException() {
        super();
    }

}
