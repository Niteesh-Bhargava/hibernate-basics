package com.niteesh;

import com.niteesh.entity.NoopItem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PoundsToKGColumnTransformerTest extends HelloWorldJPA{

    @Test
    public void testColumnTransformerSave(){
        NoopItem item = new NoopItem();
        item.setName("Sunsilk");
        item.setMetricWeight(.5);
        em.persist(item);
    }

    @Test
    public void testFetchColumnTransformer(){
        NoopItem item = em.createQuery(
                "select item from NoopItem item " +
                        "where metricWeight = :weight"
                ,NoopItem.class
        )
                .setParameter("weight",.5)
                .setMaxResults(1)
                .getSingleResult();
        assertEquals(.5, item.getMetricWeight());
    }
}
