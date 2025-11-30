package com.udemyJava.course.entities;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {
    private Category category;

    @BeforeEach
    void setUp(){
        category = new Category();
        category.setId(1L);
        category.setName("Eletronics");
    }

    @Test
    @DisplayName("Should return getters correctly")
    void shouldTestAttributes(){
        assertEquals(1L, category.getId());
        assertEquals("Eletronics", category.getName());
    }

    @Test
    @DisplayName("Parameterized constructor should initialize fields correctly")
    void testParameterizedConstructor() {
        Category c = new Category(5L, "Books");

        assertEquals(5L, c.getId());
        assertEquals("Books", c.getName());
    }

    @Test
    @DisplayName("Should update attributes with setters")
    void shouldTestSetters(){
        category.setName("Books");
        category.setId(2L);

        assertEquals("Books", category.getName());
        assertEquals(2L, category.getId());
    }
    @Test
    @DisplayName("Test if product list is initialized empty")
    void testProductListInitialized(){
        assertNotNull(category.getProducts());
        assertTrue(category.getProducts().isEmpty());
    }

    @Test
    @DisplayName("Products should allow adding items")
    void testAddProducts(){
        Product product = new Product();
        product.setId(10L);

        category.getProducts().add(product);
        assertFalse(category.getProducts().isEmpty());
        assertEquals(1, category.getProducts().size());
        assertTrue(category.getProducts().contains(product));
    }

    @Test
    @DisplayName("Test equals and hashcode")
    void testEqualsAndHashCode(){
        Category category2 = new Category(1L, "Eletronics");
        assertEquals(category, category2);
        assertEquals(category.hashCode(), category2.hashCode());
    }

    @Test
    @DisplayName("Equals: objects with different id should NOT be equal")
    void testNotEqualsDifferentId(){
        Category category3 = new Category(3L, "Eletronics");
        assertNotEquals(category, category3);
        assertNotEquals(category.hashCode(), category3.hashCode());
    }

    @Test
    @DisplayName("Equals should return false when comparing with null")
    void testEqualsNull(){
        assertNotEquals(category, null);
    }

    @Test
    @DisplayName("Equals should return false when comparing with different type")
    void testEqualsDifferenteType(){
        assertNotEquals(category, "default string");
    }

    @Test
    @DisplayName("Equals should return true when comparing object with itself")
    void testEqualsSameObject() {
        assertEquals(category, category);
    }
}
