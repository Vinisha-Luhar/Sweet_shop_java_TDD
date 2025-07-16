package com.sweetshop.services;

import com.sweetshop.model.SweetShopModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public List<SweetShopModel> searchByName(String name) {
        return sweetStore.values().stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<SweetShopModel> searchByCategory(String category) {
        return sweetStore.values().stream()
                .filter(s -> s.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public List<SweetShopModel> searchByPriceRange(double min, double max) {
        return sweetStore.values().stream()
                .filter(s -> s.getPrice() >= min && s.getPrice() <= max)
                .collect(Collectors.toList());
    }
}
