package com.niteesh;

import com.niteesh.entity.Item;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class ModelOperations extends HelloWorldJPA {

    protected ValidatorFactory validatorFactory;
    protected Validator validator;

    @BeforeAll
    public void init(){
        super.init();
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterAll
    public void destroy(){
        super.destroy();
    }

    @Test
    public void testIBidItemValid() {
        Item item = new Item();
        item.setAuctionDate(new Date());
        item.setName("Some Item");

        Set<ConstraintViolation<Item>> voilations = validator.validate(item);
        assertEquals(1,voilations.size());

        ConstraintViolation<Item> voilation = voilations.iterator().next();
        String failedPropertyName = voilation.getPropertyPath().iterator().next().getName();
        assertEquals(failedPropertyName, "auctionDate");

        if(Locale.getDefault().getLanguage().equals("en")){
            assertEquals(voilation.getMessage(),"must be in the future");
        }
    }


}
