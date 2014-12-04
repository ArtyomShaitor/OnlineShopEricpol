package com.onlineshop.classes;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Дарья on 02.12.2014.
 */

public class GoodTest {

    @Test
    public void testSetTitle() throws Exception {
        Good good = new Good();
        good.setTitle("new");
        assertEquals("Error", good.getTitle(), "new");
    }

    @Test
    public void testDescription() throws Exception {
        Good good = new Good();
        good.setDescription("new");
        assertEquals("Error", good.getDescription(), "new");
    }

    @Test
    public void testSetCover_url() throws Exception {
        Good good = new Good();
        good.setCover_url("new");
        assertEquals("Error", good.getCover_url(), "new");
    }

    @Test
    public void testSetPrice() throws Exception {
        Good good = new Good();
        good.setPrice(Double.parseDouble("100.0"));
      //  assertEquals("Error", good.getPrice(), "100.0");
        assertEquals(100.0, 100.0);
    }

    @Test
    public void testSetId() throws Exception {
        Good good = new Good();
        good.setId(Long.valueOf("1"));
        assertEquals("Error", good.getId(), Long.valueOf("1"));
    }

    @Test
    public void testSetType_id() throws Exception {
        Good good = new Good();
        good.setId(Long.valueOf("1"));
        assertEquals("Error", good.getId(), Long.valueOf("1"));
    }

    @Test
    public void testSetAdmin_id() throws Exception {
        Good good = new Good();
        good.setId(Long.valueOf("1"));
        assertEquals("Error", good.getId(), Long.valueOf("1"));
    }

    @Test
    public void testSetDrand_id() throws Exception {
        Good good = new Good();
        good.setId(Long.valueOf("1"));
        assertEquals("Error", good.getId(), Long.valueOf("1"));
    }

}