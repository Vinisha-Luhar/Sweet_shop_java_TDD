package com.sweetshop.services;

import com.sweetshop.model.SweetShopModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public boolean deleteSweet(int id) {
        return sweetStore.remove(id) != null;
    }

    public List<SweetShopModel> viewAllSweets() {
        return new ArrayList<>(sweetStore.values());
    }
}
