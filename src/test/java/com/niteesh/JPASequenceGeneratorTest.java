package com.niteesh;

import com.niteesh.entity.Department;
import com.niteesh.entity.Item;
import com.niteesh.entity.Item_;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.metamodel.*;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class JPASequenceGeneratorTest extends HelloWorldJPA {

    protected static Logger log = LoggerFactory.getLogger(JPASequenceGeneratorTest.class);
    protected static final String SELECT_SEQUENCES_SQL = "SELECT * FROM INFORMATION_SCHEMA.SEQUENCES";

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

    protected void printSequences(){
        Query query = em.createNativeQuery(SELECT_SEQUENCES_SQL, Tuple.class);
        List<Tuple> sequences =  query.getResultList();
        if(sequences != null){
            sequences.forEach(sequence -> log.debug(Arrays.toString(sequence.toArray())));
        }
    }

    @Test
    public void testSequenceGen(){
        Department department = new Department();
        department.setDeptName("Finance Department");
        em.persist(department);
        printSequences();
    }
}
