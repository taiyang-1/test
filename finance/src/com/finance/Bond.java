package com.finance;

/**
 * Bond类表示一个债券对象
 * 这个类可能包含债券的基本属性和方法，如债券的面值、利率、到期日等
 */
public class Bond extends Asset{

    private double couponRate;//债券的利率
    public Bond(String code, String name, double price, int quantity,double couponRate) {
        super(code, name, price, quantity);
        this.couponRate = couponRate;
    }
    @Override
    public double calculateProfit() {
        return (getPrice()*getQuantity())*couponRate;
    }



    public double getCouponRate() {
        return couponRate;
    }
}
