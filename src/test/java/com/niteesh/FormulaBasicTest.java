package com.niteesh;

import com.niteesh.entity.Employee;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FormulaBasicTest extends HelloWorldJPA{
    @Test
    public void testEmployeeNameFormula(){
        Employee niteesh = em.find(Employee.class,102L);
        assertEquals(niteesh.getId()+" - "+niteesh.getName().toUpperCase(),niteesh.getDisplayName());
    }
}
