package com.bestbuy.product;

import com.bestbuy.data.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//Filters Item so that we can identify if the the item has any active keys.
public class ProductFilter {

    /*
     * This class was discovered deep in the codebase and has had failing tests for a number of years. The developer
     * that wrote it is long gone and it was originally written back before Java 8 became standard. We would like to see
     * this updated to be more readable and potentially more efficient since there is going to be active development
     * around this feature in the near future
     */
    public Map<Long, String> identifyActiveKeys(List<Item> keys)
    {
        List<Item> active = new ArrayList<Item>();
       
       // if(keys.size()!=0);

        Iterator<Item> iter = keys.iterator();
        do
        {
        	
        	if(iter.hasNext()) {
            Item next = (Item) iter.next();
            if(next != null)
            {
                if(next.keys != null)
                {
                    for(Map.Entry<String, Boolean> entry : next.keys.entrySet())
                    {
                        if(entry.getValue() == true)
                        {
                            active.add(next);
                            break;
                        }
                    }
                }
            }
        	}
        }
        while (iter.hasNext());

        Map<Long, String> activeKeyIds = new HashMap<Long, String>();
        Iterator<Item> iter2 = active.iterator();

        if(iter2.hasNext()) {
        do
        {
            Item activeItem = (Item) iter2.next();
            activeKeyIds.put( activeItem.id, activeItem.value);
        } while (iter2.hasNext());
        }
        return activeKeyIds;
    }
        
}
