package com.niteesh.entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(NoopItem.class)
public abstract class NoopItem_ {

	public static volatile SingularAttribute<NoopItem, Double> metricWeight;
	public static volatile SingularAttribute<NoopItem, Boolean> validated;
	public static volatile SingularAttribute<NoopItem, String> name;
	public static volatile SingularAttribute<NoopItem, Long> id;

	public static final String METRIC_WEIGHT = "metricWeight";
	public static final String VALIDATED = "validated";
	public static final String NAME = "name";
	public static final String ID = "id";

}

