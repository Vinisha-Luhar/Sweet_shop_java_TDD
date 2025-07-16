package com.sweetshop.test;

import com.sweetshop.model.SweetShopModel;
import com.sweetshop.services.SweetShopServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SweetShopTest{
    private SweetShopServices service;

    @BeforeEach
    void setUp() {
        service = new SweetShopServices();
        service.addSweet(new SweetShopModel(1, "Kaju Katli", "Nut-Based", 50, 20));
        service.addSweet(new SweetShopModel(2, "Gajar Halwa", "Vegetable-Based", 30, 15));
        service.addSweet(new SweetShopModel(3, "Gulab Jamun", "Milk-Based", 10, 50));
    }

    @Test
    void addSweet_ShouldAddValidSweet() {
        assertTrue(service.addSweet(new SweetShopModel(4, "Ladoo", "Nut-Based", 20, 10)));
    }

    @Test
    void addSweet_WhenDuplicateId_ShouldFail() {
        assertFalse(service.addSweet(new SweetShopModel(1, "New Sweet", "Any", 15, 10)));
    }

    @Test
    void deleteSweet_ShouldRemoveSweet() {
        assertTrue(service.deleteSweet(2));
    }

    @Test
    void deleteSweet_WhenIdNotFound_ShouldReturnFalse() {
        assertFalse(service.deleteSweet(100));
    }

    @Test
    void viewAllSweets_ShouldReturnAll() {
        List<SweetShopModel> all = service.viewAllSweets();
        assertEquals(3, all.size());
    }
}
