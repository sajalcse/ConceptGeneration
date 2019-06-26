package com.relation.operations;

import com.relation.lattice.BoolLattice;
import com.relation.lattice.ThreeElementLattice;
import com.relation.utility.Utility;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*int[][] girlWomen = { { 1, 1, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 },
				{ 0, 0, 1, 1 } };

		int[][] numberMat = { { 1, 1, 0 }, { 1, 1, 0 } };

		int[][] f1c1 = { { 1, 0, 0, 1, 0, 1, 1 }, { 0, 1, 0, 1, 1, 0, 1 },
				{ 0, 0, 1, 0, 1, 1, 1 } };

		int[][] num = { { 0, 0, 1, 0, 1 }, { 0, 1, 0, 1, 0 },
				{ 0, 0, 1, 1, 0 }, { 1, 1, 0, 0, 1 }, { 0, 0, 1, 1, 0 },
				{ 1, 1, 0, 0, 0 }, { 0, 0, 1, 1, 0 }, { 1, 1, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 }, { 1, 1, 0, 0, 0 } };

		int[][] x = { { 0, 0, 0, 0, 1, 1, 1, 1 }, { 0, 0, 1, 1, 0, 0, 1, 1 },
				{ 0, 1, 0, 1, 0, 1, 0, 1 } };

		int[][] y = { { 1, 0, 0, 1, 0, 1, 1 }, { 0, 1, 0, 1, 1, 0, 1 },
				{ 0, 0, 1, 0, 1, 1, 1 } };

		int[][] test = { { 1, 0, 1 }, { 1, 1, 1 } };

		Relation gRw = new Relation(4, 4, new BoolLattice());
		Relation fRc = new Relation(3, 7, new BoolLattice());
		Relation nR = new Relation(10, 5, new BoolLattice());
		Relation testR = new Relation(2, 3, new BoolLattice());
		Relation xx = new Relation(3, 8, new BoolLattice());
		Relation yy = new Relation(3, 7, new BoolLattice());
		Relation numR = new Relation(2, 3, new BoolLattice());
		
		
		gRw.setMatrix(girlWomen);
		fRc.setMatrix(f1c1);
		nR.setMatrix(num);
		testR.setMatrix(test);
		xx.setMatrix(x);
		yy.setMatrix(y);
		numR.setMatrix(numberMat);
*/
		int[][] t = { { 1, 2, 1 }, { 2, 2, 2 } };
		Relation relation = new Relation(2, 3, new ThreeElementLattice());
		relation.setMatrix(t);

		int[][] anotherMat = { { 1, 2, 0, 2 }, { 1, 1, 1, 1 }, { 1, 0, 2, 0 },
				{ 1, 0, 0, 1 } };
		Relation anotherRel = new Relation(4, 4, new ThreeElementLattice());
		anotherRel.setMatrix(anotherMat);

		int[][] tt = { { 1, 2 }, { 2, 2 }, { 1, 2 } };
		Relation tranRelation = new Relation(3, 2, new ThreeElementLattice());
		tranRelation.setMatrix(tt);

		int m = (int) Math.pow(new ThreeElementLattice().getNoOfElements(),
				anotherRel.getRow());
		int n = (int) Math.pow(new ThreeElementLattice().getNoOfElements(),
				anotherRel.getColumn());
		Relation r = relation.GenerateConceptsV3Modified();
		
		Relation r1 = relation.GenerateConceptsV2Modified();
		r.GetNumberOfConcepts(2);
		r1.GetNumberOfConcepts(2);
		r.isEqual(r1);

	
	}

}
