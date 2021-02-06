package com.niteesh;

import com.niteesh.entity.SaleItem;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.RollbackException;
import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class BasicMappingsTest extends HelloWorldJPA{

    protected static Logger log = LoggerFactory.getLogger(BasicMappingsTest.class);

    @BeforeAll
    public void init(){
        super.init();
    }

    @AfterAll
    public void destroy(){
        super.destroy();
    }

    @BeforeEach
    public void beforeEachTest(){
        super.beforeEachTest();
    }

    @AfterEach
    public void afterEachTest(){
        super.afterEachTest();
    }

    @Test
    public void testTransientProperty(){
        String itemName = "TestItem1";
        SaleItem item = new SaleItem(itemName,new BigDecimal(4.89), new BigDecimal(5));
        em.persist(item);
        SaleItem returnedItem = em.createQuery(
                "SELECT s FROM SaleItem s WHERE s.name = :itemName", SaleItem.class)
                .setParameter("itemName", itemName).setMaxResults(1).getSingleResult();

        // Make sure that returned item contains all the other properties except transient one
        //assertEquals(4.89, Math.round(returnedItem.getInitialPrice(),2));
        assertNull(returnedItem.getTotalPrice());
    }

    @Test
    public void testSaveWithoutInitialPrice(){
        SaleItem itemWithoutPrice = new SaleItem();
        itemWithoutPrice.setName("This item is invaluable");
        assertThrows(RollbackException.class, () -> {
            em.persist(itemWithoutPrice);
            tx.commit();
        });
    }

    @Test
    public void testSaveSaleItem(){
        SaleItem pressureCooker = new SaleItem();
        pressureCooker.setName("Pressure Cooker");
        pressureCooker.setInitialPrice(new BigDecimal(70));
        em.persist(pressureCooker);
    }
}
