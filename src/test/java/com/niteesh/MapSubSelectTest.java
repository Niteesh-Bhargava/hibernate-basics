package com.niteesh;

import com.niteesh.entity.Employee;
import com.niteesh.entity.ItemBidSummery;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapSubSelectTest extends HelloWorldJPA {

    protected static Logger log = LoggerFactory.getLogger(MapSubSelectTest.class);


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
    public void testMapSubSelect(){
        ItemBidSummery itemBidSummery = em.find(ItemBidSummery.class,1L);
        log.debug(itemBidSummery.toString());
    }
}
