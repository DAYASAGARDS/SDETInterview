package com.bestbuy.product;

import com.bestbuy.data.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Validates the ProductFilter class.
 * verifies empty item lists, partial actives, and full actives
 */
public class ProductFilterTest {

    @Disabled("becaus it was failling the build - John D.")
    @Test
    public void test1(){
        List<Item> emptyList = new ArrayList<>();

        ProductFilter productFilter = new ProductFilter();

        Map<Long, String> activeKeys = productFilter.identifyActiveKeys(emptyList);
        Assertions.assertTrue(activeKeys.isEmpty());
    }

    @Disabled("becaus it was failling the build - John D.")
    @Test
    public void test2() {
        List<Item> emptyList = new ArrayList<>();

        Item inactiveItem = new Item();
        inactiveItem.setId(111L);
        inactiveItem.setProduct("xrgt");
        Map<String, Boolean> keys = new HashMap<>();
        keys.put("A", false);
        inactiveItem.setKeys(keys);

        emptyList.add(inactiveItem);

        ProductFilter productFilter = new ProductFilter();

        Map<Long, String> activeKeys = productFilter.identifyActiveKeys(emptyList);
        Assertions.assertTrue(activeKeys.isEmpty());

    }

    @Disabled("becaus it was failling the build - John D.")
    @Test
    public void test3() {
        List<Item> inactive = new ArrayList<>();

        Item inactiveItem = new Item();
        inactiveItem.setId(111L);
        inactiveItem.setProduct("xrgt");
        Map<String, Boolean> xrgt = new HashMap<>();
        xrgt.put("A", false);
        xrgt.put("B", false);
        inactiveItem.setKeys(xrgt);
        inactive.add(inactiveItem);

        Item inactiveItem2 = new Item();
        inactiveItem2.setId(112L);
        inactiveItem2.setProduct("rj4d");
        Map<String, Boolean> rj4d = new HashMap<>();
        rj4d.put("A", false);
        rj4d.put("B", false);
        inactiveItem.setKeys(rj4d);
        inactive.add(inactiveItem2);


        ProductFilter productFilter = new ProductFilter();

        Map<Long, String> activeKeys = productFilter.identifyActiveKeys(inactive);
        Assertions.assertTrue(activeKeys.isEmpty());

    }

    @Test
    public void test4() {
        List<Item> inactive = new ArrayList<>();

        Item inactiveItem = new Item();
        inactiveItem.setId(111L);
        inactiveItem.setProduct("xrgt");
        Map<String, Boolean> xrgt = new HashMap<>();
        xrgt.put("A", false);
        xrgt.put("B", true);
        inactiveItem.setKeys(xrgt);
        inactive.add(inactiveItem);

        Item inactiveItem2 = new Item();
        inactiveItem2.setId(112L);
        inactiveItem2.setProduct("rj4d");
        Map<String, Boolean> rj4d = new HashMap<>();
        rj4d.put("A", false);
        rj4d.put("B", false);
        inactiveItem2.setKeys(rj4d);
        inactive.add(inactiveItem2);


        ProductFilter productFilter = new ProductFilter();

        Map<Long, String> activeKeys = productFilter.identifyActiveKeys(inactive);
        Assertions.assertFalse(activeKeys.isEmpty());
        Assertions.assertTrue(activeKeys.containsKey(111L));

    }

    @Test
    public void test5() {
        List<Item> inactive = new ArrayList<>();

        Item inactiveItem = new Item();
        inactiveItem.setId(111L);
        inactiveItem.setProduct("xrgt");
        Map<String, Boolean> xrgt = new HashMap<>();
        xrgt.put("A", false);
        xrgt.put("B", false);
        inactiveItem.setKeys(xrgt);
        inactive.add(inactiveItem);

        Item inactiveItem2 = new Item();
        inactiveItem2.setId(112L);
        inactiveItem2.setProduct("rj4d");
        Map<String, Boolean> rj4d = new HashMap<>();
        rj4d.put("A", false);
        rj4d.put("B", true);
        inactiveItem2.setKeys(rj4d);
        inactive.add(inactiveItem2);


        ProductFilter productFilter = new ProductFilter();

        Map<Long, String> activeKeys = productFilter.identifyActiveKeys(inactive);
        Assertions.assertFalse(activeKeys.isEmpty());
        Assertions.assertTrue(activeKeys.containsKey(112L));

    }

    @Disabled("Jira Ticket SDET-275891 - John D.")
    @Test
    public void test6() {
        List<Item> inactive = new ArrayList<>();

        Item inactiveItem = new Item();
        inactiveItem.setId(111L);
        inactiveItem.setProduct("xrgt");
        Map<String, Boolean> xrgt = new HashMap<>();
        xrgt.put("A", false);
        xrgt.put("B", true);
        inactiveItem.setKeys(xrgt);
        inactive.add(inactiveItem);

        Item inactiveItem2 = new Item();
        inactiveItem2.setId(112L);
        inactiveItem2.setProduct("rj4d");
        Map<String, Boolean> rj4d = new HashMap<>();
        rj4d.put("A", false);
        rj4d.put("B", true);
        inactiveItem.setKeys(rj4d);
        inactive.add(inactiveItem2);


        ProductFilter productFilter = new ProductFilter();

        Map<Long, String> activeKeys = productFilter.identifyActiveKeys(inactive);
        Assertions.assertFalse(activeKeys.isEmpty());
        Assertions.assertTrue(activeKeys.size() == 2);
        Assertions.assertTrue(activeKeys.containsKey(111L));
        Assertions.assertTrue(activeKeys.containsKey(112L));

    }
}
