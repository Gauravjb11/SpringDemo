package com.spring;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Student {
	private int id; 
	private String name; 
	private Adress adress;
	
	private List<String> list;
	private Set<Integer> set;
	private Map<String,String> map;
	
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public Set<Integer> getSet() {
		return set;
	}
	public void setSet(Set<Integer> set) {
		this.set = set;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void Display(){
		/**
		 * For Primitive type
		 */
		System.out.print(id+" "+name+" ");
		/**
		 * For Ref Type
		 */
		System.out.println(adress.Adress());
		/**
		 * For List
		 */
		System.out.println("Roomates are ");
		Iterator<String> it=list.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
		/**
		 * For Set
		 */
		Iterator<Integer> its=set.iterator();
		while(its.hasNext()){
			System.out.print(its.next()+" ");
		}
		System.out.println();
		/**
		 * For Map
		 */
		Set<Entry<String ,String>> maps=map.entrySet();
		Iterator<Entry<String,String>> itts=maps.iterator();
		while(itts.hasNext()){
			Entry<String,String> entry=itts.next();
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		
	}
	

}
