package com.relation.operations;

import java.util.ArrayList;
import java.util.Iterator;

import com.relation.lattice.BoolLattice;
import com.relation.utility.Utility;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		ArrayList<String> attribute = new ArrayList<String>();
		attribute.add("Red");
		attribute.add("Green");
		attribute.add("Yellow");
		ArrayList<String> object = new ArrayList<String>();
		object.add("Apple");
		object.add("Mango");
		object.add("Banana");

		int[][] fruitMatrix = { { 1, 1,0}, { 1, 1,1 },{0,1,1}};
		Relation fruitRelation = new Relation(3, 3, new BoolLattice());
		fruitRelation.setMatrix(fruitMatrix);
		fruitRelation.setObject(object);
		fruitRelation.setAttribute(attribute);

		Utility.isEqual(fruitRelation.generateImplicationsUsingBase(), fruitRelation.generateImplicationUsingLemma());
		
	 
		
		
	}

}
