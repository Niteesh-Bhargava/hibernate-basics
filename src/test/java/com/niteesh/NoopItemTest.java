package com.niteesh;

import com.niteesh.entity.NoopItem;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class NoopItemTest extends HelloWorldHibernate {


    @Test
    public void testNoopItemQuery(){
        String query = "select item from NoopItem item where validated = true";
        List<NoopItem> validNoopItems = session.createQuery(query,NoopItem.class).list();
        assertTrue(validNoopItems.size()>0);
    }
}
