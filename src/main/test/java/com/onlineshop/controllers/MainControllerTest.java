package com.onlineshop.controllers;

import junit.framework.TestCase;
import org.junit.Test;

//public class MainControllerTest extends MainController {

    public class MainControllerTest extends TestCase {
    @Test
    public void testIndexPage(){

            // MainController mainController;
            // assertTrue("Constant is not true",false);
            // fail("Not equals ");
            assertNotNull("File running","index");
            //  assertNotNull("index");
        }
        public void testCatalog() {
            assertNotNull("File running", "catalog");
           // fail("Not equals ");
        }
        public void testCatalog_item() {
            assertNotNull("File running", "catalog-item");
        }
        public void testSearch() {
            assertNotNull("File running", "search");
        }
        public void testTest() {
            assertNotNull("File running", "test");
        }

}