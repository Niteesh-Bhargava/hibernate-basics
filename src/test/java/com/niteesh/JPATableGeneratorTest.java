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

public class JPATableGeneratorTest extends HelloWorldJPA {

    protected static Logger log = LoggerFactory.getLogger(JPATableGeneratorTest.class);
    protected static final String SELECT_SCHEMA_SEQUENCES_SQL = "SELECT * FROM INFORMATION_SCHEMA.SEQUENCES";
    protected static final String SELECT_PUBLIC_TABLES_SQL = "SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'PUBLIC' ";
    protected static final String SELECT_SEQUENCES_SQL = "SELECT * FROM SEQUENCE";
    protected static final String SELECT_SEQUENCE_SCHEMA_COL_SQL = "SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'SEQUENCE'";

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

    protected void printNativeQueryResult(final String nativeSqlQuery){
        Query query = em.createNativeQuery(nativeSqlQuery, Tuple.class);
        List<Tuple> tuples =  query.getResultList();
        if(tuples != null){
            tuples.forEach(sequence -> log.debug(Arrays.toString(sequence.toArray())));
        }
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
