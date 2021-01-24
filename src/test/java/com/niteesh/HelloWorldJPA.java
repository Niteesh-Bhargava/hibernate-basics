package com.niteesh;

import com.niteesh.entity.Message;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class HelloWorldJPA {

    protected EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction tx;
    protected static Logger log = LoggerFactory.getLogger(HelloWorldJPA.class);

    @BeforeAll
    public void init() {
        emf = Persistence.createEntityManagerFactory("RestaurantPU");
    }

    @AfterAll
    public void destroy() {
        if (emf != null) {
            emf.close();
        }
    }

    @BeforeEach
    public void beforeEachTest() {
        em = emf.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    @AfterEach
    public void afterEachTest() {
        if (tx != null) {
            tx.commit();
        }
        if (em != null) {
            em.close();
        }
    }

    @Test
    public void testHelloWorld() {
        Message message = new Message();
        message.setText("Hello World");
        em.persist(message);
    }

    @Test
    public void testMessagesDataFetch() {
        List<Message> messages = em.createQuery("select m from Message m").getResultList();
        log.debug("Fetched essages " + messages);
        messages.get(0).setText("Updated Text");
    }
}
