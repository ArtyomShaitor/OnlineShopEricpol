package com.onlineshop.classes;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by Дарья on 02.12.2014.
 */
public class BrandTest {

    @Test
    public void testSetTitle() throws Exception {
        Brand brand = new Brand();
        brand.setTitle("new");
        assertEquals("Error",brand.getTitle(), "new");
    }

    @Test
    public void testSetId() throws Exception {
        Brand brand = new Brand();
        brand.setId(Long.valueOf("1"));
        assertEquals("Error", brand.getId(), Long.valueOf("1"));
    }

    @Test
    public void testSetGoods() throws Exception {
        Brand brand = new Brand();
        Set<Good> expected = new HashSet<Good>();
        Good good =  new Good();
        expected.add(good);
        brand.setGoods(expected);
        Set<Good> actual = brand.getGoods();
        assertTrue(actual.size() == expected.size() && actual.contains(good));
       }
}