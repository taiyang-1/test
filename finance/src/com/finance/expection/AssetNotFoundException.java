package com.finance.expection;
//资产未找到异常
public class AssetNotFoundException extends  Exception{
    public AssetNotFoundException(String message)
    {
        super(message);
    }
}
