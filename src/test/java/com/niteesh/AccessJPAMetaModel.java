package com.niteesh;

import com.niteesh.entity.Item;
import com.niteesh.entity.Item_;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.metamodel.*;
import java.util.Date;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class AccessJPAMetaModel extends HelloWorldJPA {

    protected static Logger log = LoggerFactory.getLogger(AccessJPAMetaModel.class);
    protected Metamodel metamodel;
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
        metamodel = em.getMetamodel();
    }
    @AfterEach
    public void afterEachTest(){
        super.afterEachTest();
    }

    @Test
    public void testMetaModelApi(){
        Set<ManagedType<?>> managedTypes = metamodel.getManagedTypes();
        assertEquals(6, managedTypes.size());
        managedTypes
                .stream().
                forEach(managedType -> assertEquals(managedType.getPersistenceType(), Type.PersistenceType.ENTITY));
    }

    @Test
    public void testItemNameAttribute(){
        ManagedType<Item> itemManagedType = metamodel.managedType(Item.class);
        SingularAttribute<? super Item, String> nameAttribute =  itemManagedType.getSingularAttribute("name",String.class);
        assertEquals(String.class, nameAttribute.getJavaType());
        assertEquals(Attribute.PersistentAttributeType.BASIC, nameAttribute.getPersistentAttributeType());
        assertFalse(nameAttribute.isOptional());
    }

    @Test
    public void testItemNameAttributeStatic(){
        SingularAttribute<? super Item, String> nameAttribute = Item_.name;
        assertEquals(String.class, nameAttribute.getJavaType());
        assertEquals(Attribute.PersistentAttributeType.BASIC, nameAttribute.getPersistentAttributeType());
        assertFalse(nameAttribute.isOptional());
    }

    @Test
    public void testItemAuctionDateAttribute(){
        ManagedType<Item> itemManagedType = metamodel.managedType(Item.class);
        SingularAttribute<? super Item, Date> auctionDateAttribute = itemManagedType.getSingularAttribute("auctionDate", Date.class);
        assertEquals(Date.class, auctionDateAttribute.getJavaType());
        assertFalse(auctionDateAttribute.isAssociation());
        assertFalse(auctionDateAttribute.isCollection());
    }
}
