package com.finance.service;

import com.finance.expection.AssetNotFoundException;
import com.finance.expection.DuplicateAssetException;
import com.finance.model.Asset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Portfolio {
    private ArrayList<Asset> assets;//主存储
    private HashMap<String, Asset> codeIndex;//索引
    private HashSet<String> codes;//防止重复

    public Portfolio() {
        this.assets = new ArrayList<>();
        this.codeIndex = new HashMap<>();
        this.codes = new HashSet<>();
    }

    //添加资产
    public void add(Asset asset) throws DuplicateAssetException {
       if(codes.contains(asset.getCode())){
           throw new DuplicateAssetException("资产代码重复，请重新输入");
       }
           assets.add(asset);
           codeIndex.put(asset.getCode(), asset);
           codes.add(asset.getCode());
    }

/**
 * 根据资产代码查找资产对象
 * @param code 资产代码，用于唯一标识一个资产
 * @return 返回找到的Asset对象，如果未找到则返回null
 */
    public Asset findByCode(String code) throws AssetNotFoundException {
    // 通过codeIndex映射表根据code键获取对应的Asset值
       Asset a = codeIndex.get(code);
        if (a == null) {
            throw new AssetNotFoundException("资产代码 '" + code + "' 不存在");
        }
        return a;
    }

/**
 * 根据资产代码移除资产的方法
 * @param code 要移除的资产代码
 * @return 如果成功移除返回true，如果资产不存在返回false
 */
    public void remove(String code) throws AssetNotFoundException {
        if (!codes.contains(code)) {
            throw new AssetNotFoundException("资产代码 '" + code + "' 不存在，无法删除");
        }
        assets.remove(codeIndex.get(code));
        codeIndex.remove(code);
        codes.remove(code);
    }
     public ArrayList<Asset> getAll() {
        return assets;
    }

     public int size (){
        return assets.size();
     }

     public double getTotalMarketValue(){
        double totalMarketValue = 0;
        for(Asset asset : assets){
            totalMarketValue += asset.getMarketValue();
        }
        return totalMarketValue;
     }

     public double getTotalProfit(){
        double totalProfit = 0;
        for(Asset asset : assets){
            totalProfit += asset.calculateProfit();
        }
        return totalProfit;
     }
}
