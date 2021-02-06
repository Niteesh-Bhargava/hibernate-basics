package com.niteesh.entity;

import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SaleItem.class)
public abstract class SaleItem_ {

	public static volatile SingularAttribute<SaleItem, BigDecimal> initialPrice;
	public static volatile SingularAttribute<SaleItem, String> name;
	public static volatile SingularAttribute<SaleItem, Long> id;

	public static final String INITIAL_PRICE = "initialPrice";
	public static final String NAME = "name";
	public static final String ID = "id";

}

