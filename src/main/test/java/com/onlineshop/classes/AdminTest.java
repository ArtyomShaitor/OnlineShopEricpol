package com.onlineshop.classes;
/**
 * Created by Дарья on 02.12.2014.
 */
import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class AdminTest extends TestCase {
    @Test
    public void testSetLogin() throws Exception {
        Admin admin = new Admin();
        admin.setLogin("new");
        assertEquals("Error",admin.getLogin(), "new");
    }

    @Test
public void testSetId() throws Exception {
        Admin admin = new Admin();
        admin.setId(Long.valueOf("1"));
        assertEquals("Error",admin.getId(), Long.valueOf("1"));
    }

    @Test
public void testSetPassword() throws Exception {
        Admin admin = new Admin();
        admin.setPassword("bla");
        assertEquals("Error",admin.getPassword(), "bla");
    }
    @Test
    public void testSetGoods() throws Exception {
        Admin admin = new Admin();
        Set<Good> expected = new HashSet<Good>();
        Good good =  new Good();
        expected.add(good);
        admin.setGoods(expected);
        Set<Good> actual = admin.getGoods();
        assertTrue(actual.size() == expected.size() && actual.contains(good));
    }
}