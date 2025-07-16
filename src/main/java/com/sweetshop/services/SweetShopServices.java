package com.sweetshop.services;

import com.sweetshop.model.SweetShopModel;

import java.util.HashMap;
import java.util.Map;

public class SweetShopServices {
    private Map<Integer, SweetShopModel> sweetStore = new HashMap<>();

    public boolean addSweet(SweetShopModel sweetShopModel) {
        if (sweetShopModel.getPrice() < 0 || sweetShopModel.getQuantity() < 0 || sweetStore.containsKey(sweetShopModel.getId())) {
            return false;
        }
        sweetStore.put(sweetShopModel.getId(), sweetShopModel);
        return true;
    }
}
