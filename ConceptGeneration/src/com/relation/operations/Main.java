package com.relation.operations;

import com.relation.lattice.BoolLattice;
import com.relation.lattice.ThreeElementLattice;
import com.relation.utility.Utility;
import com.sun.xml.internal.ws.api.addressing.AddressingVersion.EPR;

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
		
		numR.GenerateConceptsV2Modified().GetNumberOfConcepts(1);*/
		

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

		
		int[][] newMatr = { { 1, 1, 0}, { 1, 2, 1},{ 0, 1, 1} };
		Relation newrelation = new Relation(3, 3, new ThreeElementLattice());
		newrelation.setMatrix(newMatr);
		
	
		int[][] A = {{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
		int[][] B = {{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
		
		Relation relA = new Relation(1, 27, new ThreeElementLattice());
		Relation relB = new Relation(1, 27, new ThreeElementLattice());

		relA.setMatrix(A);
		relB.setMatrix(B);
		
		/*Relation Q = relA.Composition(Relation.Epsilon(3).RightResidue(Relation.Epsilon(3))).Composition(newrelation.GenerateConcepts()).Up();
		Relation R = relB.Composition(Relation.Epsilon(3).RightResidue(Relation.Epsilon(3))).Composition(newrelation.GenerateConcepts()).Up();
		Q.Implication(R).Composition(newrelation.GenerateConcepts()).Transpose();
		relB.Composition(newrelation.GetPrimePrime()).Transpose();*/
		//relation.GenerateConceptsV2Own().isEqual(relation.GenerateConceptsV2Modified());
		
		
		/*Relation q = relA.Composition(Relation.Epsilon(3).RightResidue(Relation.Epsilon(3))).Composition(newrelation.generateExtentConcepts().getEquivalence().Transpose()).Up();
		Relation r = relB.Composition(Relation.Epsilon(3).RightResidue(Relation.Epsilon(3))).Composition(newrelation.generateExtentConcepts().getEquivalence().Transpose()).Up();
		q.Intersection(r);*/
		//relation.generateExtentConcepts().Up().getEquivalence().Transpose();
		
		/*Relation e = newrelation.generateExtentConcepts().Up().getEquivalence();
		Relation q=Relation.Pi(27, 27).Composition(Relation.Epsilon(3).RightResidue(Relation.Epsilon(3))).Composition(newrelation.generateExtentConcepts().Up().getEquivalence().Transpose());
		Relation r=Relation.Rho(27, 27).Composition(Relation.Epsilon(3).RightResidue(Relation.Epsilon(3))).Composition(newrelation.generateExtentConcepts().Up().getEquivalence().Transpose());
	
		Relation s=q.Implication(r).Composition(e).Composition(newrelation.generateExtentConcepts()).Composition(e.Transpose());
		Relation relL = new Relation(1, 18, new ThreeElementLattice());
		int[][] L = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
		relL.setMatrix(L);
		Relation ss = s.LeftResidue(relL);
		System.out.println("-------start-----");
		Utility.PrintArray(ss.getMatrix());
		System.out.println(ss.getRow());
		*/
		relation.GenerateConceptsV2Modified();
	}

}
