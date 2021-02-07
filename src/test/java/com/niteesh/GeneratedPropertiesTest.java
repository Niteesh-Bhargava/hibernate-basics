package com.niteesh;

import com.niteesh.entity.NoopItem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class GeneratedPropertiesTest extends HelloWorldJPA {

    @Test
    public void testSaveGeneratedDateAndPrice(){
        NoopItem item = new NoopItem();
        item.setName("MacBookPro");
        em.persist(item);
    }

    @Test
    public void testFetchGeneratedDateAndPrice(){
        List<NoopItem> items = em.createQuery("select i from NoopItem i", NoopItem.class)
                .setMaxResults(10).getResultList();
        items.stream().forEach(fetchedItem -> {
                    assertNotNull(fetchedItem.getLastModified());
                    assertEquals(1, fetchedItem.getInitialPrice().intValue());
                }
        );
    }
}
