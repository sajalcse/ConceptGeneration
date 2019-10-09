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
		// TODO Auto-generated method stub

		/*
		 * int[][] geometry = { { 1, 0, 1, 0 }, { 1, 0, 0, 0 }, { 0, 1, 0, 0 },
		 * { 0, 1, 0, 1 }, { 0, 1, 1, 1 } };
		 * 
		 * int[][] girlWomen = { { 1, 1, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 },
		 * { 0, 0, 1, 1 } };
		 * 
		 * int[][] numberMat = { { 1, 1, 0 }, { 1, 1, 0 } };
		 * 
		 * int[][] f1c1 = { { 1, 0, 0, 1, 0, 1, 1 }, { 0, 1, 0, 1, 1, 0, 1 }, {
		 * 0, 0, 1, 0, 1, 1, 1 } };
		 * 
		 * int[][] num = { { 0, 0, 1, 0, 1 }, { 0, 1, 0, 1, 0 }, { 0, 0, 1, 1, 0
		 * }, { 1, 1, 0, 0, 1 }, { 0, 0, 1, 1, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0,
		 * 1, 1, 0 }, { 1, 1, 0, 0, 0 }, { 1, 0, 1, 0, 1 }, { 1, 1, 0, 0, 0 } };
		 * 
		 * int[][] x = { { 0, 0, 0, 0, 1, 1, 1, 1 }, { 0, 0, 1, 1, 0, 0, 1, 1 },
		 * { 0, 1, 0, 1, 0, 1, 0, 1 } };
		 * 
		 * int[][] y = { { 1, 0, 0, 1, 0, 1, 1 }, { 0, 1, 0, 1, 1, 0, 1 }, { 0,
		 * 0, 1, 0, 1, 1, 1 } };
		 * 
		 * int[][] test = { { 1, 0, 1 }, { 1, 1, 1 } };
		 * 
		 * Relation gRw = new Relation(4, 4, new BoolLattice()); Relation fRc =
		 * new Relation(3, 7, new BoolLattice()); Relation nR = new Relation(10,
		 * 5, new BoolLattice()); Relation testR = new Relation(2, 3, new
		 * BoolLattice()); Relation xx = new Relation(3, 8, new BoolLattice());
		 * Relation yy = new Relation(3, 7, new BoolLattice()); Relation numR =
		 * new Relation(2, 3, new BoolLattice()); Relation geo = new Relation(5,
		 * 4, new BoolLattice());
		 * 
		 * gRw.setMatrix(girlWomen); fRc.setMatrix(f1c1); nR.setMatrix(num);
		 * testR.setMatrix(test); xx.setMatrix(x); yy.setMatrix(y);
		 * numR.setMatrix(numberMat); geo.setMatrix(geometry);
		 */

		ArrayList<String> attribute = new ArrayList<String>();
		attribute.add("Red");
		attribute.add("Green");
		attribute.add("Yellow");
		ArrayList<String> object = new ArrayList<String>();
		object.add("Apple");
		object.add("Mango");
		object.add("Banana");

		int[][] fruitMatrix = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
		Relation fruitRelation = new Relation(3, 3, new BoolLattice());
		fruitRelation.setMatrix(fruitMatrix);
		fruitRelation.setObject(object);
		fruitRelation.setAttribute(attribute);

		fruitRelation.rightResidue(fruitRelation);

		/*Relation e = Relation.e(3);
		Relation pi = Relation.pi(8, 8);
		Relation rho = Relation.rho(8, 8);
		Relation ep = Relation.epsilon(3);
		Relation j = ep.composition(pi.transpose()).union(ep.composition(rho.transpose()));//.symetricQuotient(ep);
		Utility.PrintArray(j,"j");*/
		
		
		
		
		int[][] lm = { { 1 }, { 1 }, { 1 }, { 1 } };
		Relation l = new Relation(4, 1, new BoolLattice());
		l.setMatrix(lm);

		int[][] l18 = { { 1, 1, 1, 1, 1, 1, 1, 1 } };
		Relation l18r = new Relation(1, 8, new BoolLattice());
		l18r.setMatrix(l18);

		int[][] l88 = { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 } };
		Relation l88r = new Relation(8, 8, new BoolLattice());
		l88r.setMatrix(l88);
		
		int[][] l48 = {{ 1, 1, 1, 1, 1, 1, 1, 1 },  { 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1 },  { 1, 1, 1, 1, 1, 1, 1, 1 } };
		Relation l48r = new Relation(4, 8, new BoolLattice());
		l48r.setMatrix(l48);

		Relation cm = fruitRelation.generateAttributeConcept();
		Relation cme = cm.getEquivalence();
		Relation e = Relation.e(3);
		Relation i = Relation.identity(8);
		
		
		Relation eii = e.intersection(i.Not());
		Relation cml = cme.transpose().composition(l48r);
		Relation eircml = eii.rightResidue(cml);
		Relation cmln = cml.Not();
		Relation a = eircml.intersection(cmln);
		//Utility.PrintArray(fruitRelation.getAttributePrime().composition(fruitRelation.getObjectPrime()).composition(e),"a");
		
		
		
		Relation leftOfr = e.intersection(i.Not()).intersection(a.composition(l88r));
		
		Relation rightOfr = fruitRelation.getAttributePrime().composition(
				fruitRelation.getObjectPrime()).composition(e);
	
		Relation mid = ((leftOfr.rightResidue(rightOfr)).intersection(Relation.identity(8))).composition(l88r);
		
		Relation last = cml.Not();
		
		Utility.PrintArray(a.union(mid).intersection(last),"rightOfr");
	
		
		
	}

}
