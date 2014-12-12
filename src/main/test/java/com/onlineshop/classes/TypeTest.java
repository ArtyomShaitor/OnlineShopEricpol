package com.onlineshop.classes;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by Дарья on 02.12.2014.
 */
public class TypeTest {
    @Test
      public void testSetTitle() throws Exception {
        Type type = new Type();
        type.setTitle("new");
        assertEquals(type.getTitle(), "new");
    }

    @Test
    public void testSetId() throws Exception {
        Type type = new Type();
        type.setId(Long.valueOf("1"));
        assertEquals(type.getId(), Long.valueOf("1"));
    }

    @Test
    public void testSetGoods() throws Exception {
        Type type = new Type();
        Set<Good> expected = new HashSet<Good>();
        Good good =  new Good();
        expected.add(good);
        type.setGoods(expected);
        Set<Good> actual = type.getGoods();
        assertTrue(actual.size() == expected.size() && actual.contains(good));
    }
}
