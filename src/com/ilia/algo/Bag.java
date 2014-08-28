package com.ilia.algo;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
	
	private ArrayList<Item> s;
	public Bag()
	{
		s = new ArrayList<Item>();
	}

	void add(Item i)
	{
		s.add(i);
	}
	
	int size()
	{
		return s.size();
	}
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return s.iterator();
	}

}
