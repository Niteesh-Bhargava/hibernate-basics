package com.niteesh.entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ItemBidSummery.class)
public abstract class ItemBidSummery_ {

	public static volatile SingularAttribute<ItemBidSummery, Long> itemId;
	public static volatile SingularAttribute<ItemBidSummery, String> name;
	public static volatile SingularAttribute<ItemBidSummery, Long> numberOfBids;

	public static final String ITEM_ID = "itemId";
	public static final String NAME = "name";
	public static final String NUMBER_OF_BIDS = "numberOfBids";

}

