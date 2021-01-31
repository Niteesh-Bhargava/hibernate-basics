package com.niteesh.entity;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Item.class)
public abstract class Item_ {

	public static volatile SetAttribute<Item, Bid> bids;
	public static volatile SingularAttribute<Item, String> name;
	public static volatile SingularAttribute<Item, String> id;
	public static volatile SingularAttribute<Item, Date> auctionDate;

	public static final String BIDS = "bids";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String AUCTION_DATE = "auctionDate";

}

