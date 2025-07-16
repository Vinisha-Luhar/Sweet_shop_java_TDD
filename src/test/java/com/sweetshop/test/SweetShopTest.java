package com.sweetshop.test;

import com.sweetshop.model.SweetShopModel;
import com.sweetshop.services.SweetShopServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

/// Unit Test For SweetShopService using TDD
public class SweetShopTest{
    private SweetShopServices service;


    @BeforeEach
    void initialSweet() {
        // Initialize a new service and add some sweets before each test
        service = new SweetShopServices();
        service.addSweet(new SweetShopModel(1, "Kaju Katli", "Nut-Based", 50, 20));
        service.addSweet(new SweetShopModel(2, "Gajar Halwa", "Vegetable-Based", 30, 15));
        service.addSweet(new SweetShopModel(3, "Gulab Jamun", "Milk-Based", 10, 50));
    }

    @Test
    void addSweet_AddValidSweet() {
        assertTrue(service.addSweet(new SweetShopModel(4, "Ladoo", "Nut-Based", 20, 10)));
    }

    @Test
    void addSweet_DuplicateId() {
        assertFalse(service.addSweet(new SweetShopModel(1, "New Sweet", "Any", 15, 10)));
    }

    @Test
    void deleteSweet_RemoveSweet() {
        assertTrue(service.deleteSweet(2));
    }

    @Test
    void deleteSweet_IdNotFound() {
        assertFalse(service.deleteSweet(100));
    }

    @Test
    void viewAllSweets() {
        List<SweetShopModel> all = service.viewAllSweets();
        assertEquals(3, all.size());
    }

    @Test
    void searchByName() {
        assertEquals(1, service.searchByName("Kaju Katli").size());
    }

    @Test
    void searchByCategory() {
        assertEquals(1, service.searchByCategory("Nut-Based").size());
    }

    @Test
    void searchByPriceRange_ReturnInRange() {
        assertEquals(2, service.searchByPriceRange(10, 30).size());
    }

    @Test
    void sortByName() {
        List<SweetShopModel> sorted = service.sortByName();
        assertEquals("Gajar Halwa", sorted.get(0).getName());
    }

    @Test
    void sortByPrice() {
        List<SweetShopModel> sorted = service.sortByPrice();
        assertEquals("Gulab Jamun", sorted.get(0).getName());
    }

    @Test
    void purchaseSweet_ReduceStock() throws Exception {
        service.purchaseSweet(1, 5);
        assertEquals(15, service.viewAllSweets().get(0).getQuantity());
    }

    @Test
    void purchaseSweet_Insufficient() {
        assertThrows(Exception.class, () -> {
            service.purchaseSweet(1, 100);
        });
    }

    @Test
    void restockSweet_IncreaseStock() {
        assertTrue(service.restockSweet(1, 10));
        assertEquals(30, service.viewAllSweets().get(0).getQuantity());
    }
}
