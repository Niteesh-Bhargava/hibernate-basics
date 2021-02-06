package com.niteesh;

import com.niteesh.entity.Message;
import com.niteesh.entity.NoopItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class HelloWorldHibernate {

    protected static SessionFactory sessionFactory;
    protected static Session session;

    private static Logger log = LoggerFactory.getLogger(HelloWorldHibernate.class);

    @BeforeAll
    public void init(){
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = registryBuilder.build();
        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        metadataSources.addAnnotatedClass(Message.class);
        Metadata metadata = metadataSources.buildMetadata();
        sessionFactory = metadata.buildSessionFactory();
        log.debug("Initialized Session Factory : "+sessionFactory.toString());
    }
    @BeforeEach
    public void beforeEachTest(){
        log.trace("Initializing new session and starting transaction for new test");
        session = sessionFactory.openSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        log.debug("Initialized new session and transaction for test");
    }

    @AfterEach
    public void cleanupPerTest(){
        log.debug("Cleaning up session and transaction");
        if(session != null){
            Transaction tx = session.getTransaction();
            tx.commit();
            session.close();
        }
        log.debug("Transaction commited and session is closed from previous test");
    }

    @AfterAll
    public void cleanup(){
        if(sessionFactory != null){
            sessionFactory.close();
        }
    }

    @Test
    public void testSaveMessage(){
        Message message = new Message();
        message.setText("Created from Hibernate API");
        session.persist(message);
    }

    @Test
    public void testFetchMessages(){
        List<Message> messages = session.createCriteria(Message.class).list();
        log.debug("Fetched Messages : "+messages);
    }

}
