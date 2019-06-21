package com.relation.operations;

import com.relation.lattice.ThreeElementLattice;
import com.relation.utility.Utility;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		int[][] girlWomen = { { 1, 1, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 },
				{ 0, 0, 1, 1 } };

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

		gRw.setMatrix(girlWomen);
		fRc.setMatrix(f1c1);
		nR.setMatrix(num);
		testR.setMatrix(test);
		xx.setMatrix(x);
		yy.setMatrix(y);
		
		testR.GenerateConcepts();
*/
		int[][] t = { { 1, 2, 1 }, { 2, 2, 2 } };
		Relation relation = new Relation(2, 3, new ThreeElementLattice());
		relation.setMatrix(t);
		
		int[][] tt = { { 1, 2 }, { 2, 2 }, { 1, 2 } };
		Relation tranRelation = new Relation(3, 2, new ThreeElementLattice());
		tranRelation.setMatrix(tt);

		Utility.Write(Relation
				.Pi(9, 27)
				.Composition(
						Relation.Epsilon(2).SymetricQuotient(
								Relation.Epsilon(2)))
				.Composition(relation.GenerateConcepts())
				.Composition(relation.GetAttributeSet())
				.Composition(
						Relation.Epsilon(3).SymetricQuotient(
								Relation.Epsilon(3)))
				.Composition(Relation.Rho(9, 27).Transpose())
				.Intersection(Relation.IdentityRelation(243)).getMatrix());

		
	//	Utility.PrintArray("attribute",relation.GetAttributeSet().getMatrix());

		//Utility.PrintArray("concepts",relation.GenerateConcepts().getMatrix());
	}

}

