package com.niteesh;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import javax.persistence.Query;
import javax.persistence.Tuple;
import java.util.Arrays;
import java.util.List;

public class SequenceGenBaseTest extends HelloWorldJPA {
    protected static final String SELECT_SCHEMA_SEQUENCES_SQL = "SELECT * FROM INFORMATION_SCHEMA.SEQUENCES";
    protected static final String SELECT_PUBLIC_TABLES_SQL = "SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'PUBLIC' ";
    //protected static final String SELECT_SEQUENCES_SQL = "SELECT * FROM SEQUENCE";
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
}
