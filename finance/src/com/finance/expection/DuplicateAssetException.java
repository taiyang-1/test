package com.finance.expection;
//代码重复异常
public class DuplicateAssetException extends Exception{
    public DuplicateAssetException(String message)
    {
        super(message);
    }
}
