package com.dmurphy.entities;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WishList {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ElementCollection
	private List<String> wishList;
	
	private String name;
	
	protected WishList() {}
	public WishList(String name, List<String> wishList) {
		this.name = name;
		this.wishList = wishList;
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public List<String> getWishList() {
		return wishList;
	}
	@Override
	public String toString() {
//		String listString = "";
		
		// For whatever reason, had issues logging the list... will find solution

//		if(!wishList.isEmpty()) {
//			for (String s : wishList)
//			{
//			    listString += s + " ";
//			}
//		}
		
		return "WishList [id=" + id + ", name=" + name + "]";
	}
	
}
