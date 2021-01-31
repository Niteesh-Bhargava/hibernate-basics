package com.niteesh;

import com.niteesh.entity.Department;
import com.niteesh.entity.hibernate.sequence.Bus;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Query;
import javax.persistence.Tuple;
import java.util.Arrays;
import java.util.List;

public class HibernateSeqGenTest extends SequenceGenBaseTest {

    protected static Logger log = LoggerFactory.getLogger(HibernateSeqGenTest.class);

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
    public void testHibernateSequenceGen(){
        Bus bus = new Bus();
        bus.setCompanyName("City Link Bus");
        em.persist(bus);
        printNativeQueryResult(SELECT_SCHEMA_SEQUENCES_SQL);
    }
}
