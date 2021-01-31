package com.niteesh;

import com.niteesh.entity.Department;
import com.niteesh.entity.Employee;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Query;
import javax.persistence.Tuple;
import java.util.Arrays;
import java.util.List;

public class JPATableGeneratorTest extends SequenceGenBaseTest {

    protected static Logger log = LoggerFactory.getLogger(JPATableGeneratorTest.class);


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
    public void testTableSeqGenGen(){
        printNativeQueryResult(SELECT_SCHEMA_SEQUENCES_SQL);
        printNativeQueryResult(SELECT_PUBLIC_TABLES_SQL);
        //printNativeQueryResult(SELECT_SEQUENCES_SQL);
        printNativeQueryResult(SELECT_SEQUENCE_SCHEMA_COL_SQL);

        Employee niteesh = new Employee();
        niteesh.setName("Niteesh Bhargava");
        em.persist(niteesh);

        Employee ian = new Employee();
        ian.setName("Ian");
        em.persist(ian);
        //printNativeQueryResult(SELECT_SEQUENCES_SQL);
        printNativeQueryResult(SELECT_PUBLIC_TABLES_SQL);
    }
}
