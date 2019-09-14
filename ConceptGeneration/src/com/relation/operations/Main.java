package com.relation.operations;

import com.relation.lattice.BoolLattice;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] geometry = { { 1, 0, 1, 0 }, { 1, 0, 0, 0 }, { 0, 1, 0, 0 },
				{ 0,1, 0, 1 },{ 0,1, 1, 1 } };
		
		int[][] girlWomen = { { 1, 1, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 },
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
		Relation geo = new Relation(5, 4, new BoolLattice());
		
		gRw.setMatrix(girlWomen);
		fRc.setMatrix(f1c1);
		nR.setMatrix(num);
		testR.setMatrix(test);
		xx.setMatrix(x);
		yy.setMatrix(y);
		numR.setMatrix(numberMat);
		geo.setMatrix(geometry);
		
		int[][] test2 = { { 1, 1 }};
		Relation test2r = new Relation(1, 2, new BoolLattice());
		test2r.setMatrix(test2);
		test2r.AttributeToPowerset().Composition(Relation.Epsilon(2).RightResidue(Relation.Epsilon(2)));
	
	}

}
