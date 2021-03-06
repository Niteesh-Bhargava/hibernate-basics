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

public class JPASequenceGeneratorTest extends SequenceGenBaseTest{

    protected static Logger log = LoggerFactory.getLogger(JPASequenceGeneratorTest.class);

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
    public void testSequenceGen(){
        Department department = new Department();
        department.setDeptName("Finance Department");
        em.persist(department);
        printNativeQueryResult(SELECT_SCHEMA_SEQUENCES_SQL);
    }
}
