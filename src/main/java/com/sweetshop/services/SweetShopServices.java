package com.sweetshop.services;

import com.sweetshop.model.SweetShopModel;
import java.util.*;
import java.util.stream.Collectors;

/// Service class to manage sweets -- add, delete, view, search, sort, purchase, restock
public class SweetShopServices {

    // sweets using a map (id as key)
    private Map<Integer, SweetShopModel> sweetStore = new HashMap<>();

    /* Adds a new sweet to the inventory.
    Returns false if sweet ID already exists or if invalid data */
    public boolean addSweet(SweetShopModel sweetShopModel) {
        if (sweetShopModel.getPrice() < 0 || sweetShopModel.getQuantity() < 0 || sweetStore.containsKey(sweetShopModel.getId())) {
            return false;
        }
        sweetStore.put(sweetShopModel.getId(), sweetShopModel);
        return true;
    }

    /* Deletes a sweet from inventory by ID.
    Returns true if deletion was successful */
    public boolean deleteSweet(int id) {
        return sweetStore.remove(id) != null;
    }

    // Returns a list of all available sweets in the inventory.
    public List<SweetShopModel> viewAllSweets() {
        return new ArrayList<>(sweetStore.values());
    }

    // Searches sweets by name and category and price range
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

    // Sort all sweets by name or price
    public List<SweetShopModel> sortByName() {
        return sweetStore.values().stream()
                .sorted(Comparator.comparing(SweetShopModel::getName))
                .collect(Collectors.toList());
    }
    public List<SweetShopModel> sortByPrice() {
        return sweetStore.values().stream()
                .sorted(Comparator.comparingDouble(SweetShopModel::getPrice))
                .collect(Collectors.toList());
    }

    /* purchase of a sweet by reducing stock quantity.
       Throws Exception if not enough quantity */
    public void purchaseSweet(int id, int quantity) throws Exception {
        SweetShopModel sweetShopModel = sweetStore.get(id);
        if (sweetShopModel == null || sweetShopModel.getQuantity() < quantity) {
            throw new Exception("Not enough stock");
        }
        sweetShopModel.setQuantity(sweetShopModel.getQuantity() - quantity);
    }

    /* Increases stock quantity of a sweet by a given amount.
    Returns true if restock was successful */
    public boolean restockSweet(int id, int quantity) {
        SweetShopModel sweetShopModel = sweetStore.get(id);
        if (sweetShopModel == null || quantity <= 0) {
            return false;
        }
        sweetShopModel.setQuantity(sweetShopModel.getQuantity() + quantity);
        return true;
    }
}
