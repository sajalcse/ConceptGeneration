package com.relation.operations;

import com.relation.utility.Utility;

public class Main {
	public static void main(String[] args) {

		boolean[][] sMatrix = {
				{ false, false, false, true, false, true, true, true, false,
						true, false, false },
				{ true, false, false, true, false, false, true, false, false,
						true, false, false },
				{ true, true, false, false, true, true, false, true, false,
						false, false, true },
				{ true, true, false, false, false, false, true, false, true,
						false, true, true },
				{ false, false, false, true, false, true, true, true, false,
						false, false, false } };

		boolean[][] rMatrix = {
				{ false, false, false, false, false, false, false, false,
						false, false, false, false, true },
				{ false, true, false, false, false, false, false, true, false,
						false, false, false, false },
				{ false, false, true, false, false, false, true, true, false,
						true, false, true, false },
				{ false, true, true, false, false, false, false, true, false,
						false, false, false, true },
				{ false, false, false, true, false, false, true, false, false,
						true, true, false, true } };

		boolean[][] qMatrix = { { false, false, false, false, false },
				{ false, true, false, true, false },
				{ false, false, true, true, false },
				{ false, false, false, false, true },
				{ false, false, false, false, false },
				{ false, false, false, false, false },
				{ false, false, true, false, true },
				{ false, true, true, true, false },
				{ false, false, false, false, false },
				{ false, false, true, false, true },
				{ false, false, false, false, true },
				{ false, false, true, false, false },
				{ true, false, false, true, true } };

		boolean[][] pMatrix = { { false, true, true, true, false },
				{ false, false, true, true, false },
				{ false, false, false, false, false },
				{ true, true, false, false, true },
				{ false, false, true, false, false },
				{ true, false, true, false, true },
				{ true, true, false, true, true },
				{ true, false, true, false, true },
				{ false, false, false, true, false },
				{ true, true, false, false, false },
				{ false, false, false, true, false },
				{ false, false, true, true, false } };

		boolean[][] girlWomen = { { true, true, false, false },
				{ true, false, true, false }, { false, true, false, true },
				{ false, false, true, true } };

		boolean[][] f1c1 = { { true, false, false, true, false, true, true },
				{ false, true, false, true, true, false, true },
				{ false, false, true, false, true, true, true } };

		boolean[][] num = { { false, false, true, false, true },
				{ false, true, false, true, false },
				{ false, false, true, true, false },
				{ true, true, false, false, true },
				{ false, false, true, true, false },
				{ true, true, false, false, false },
				{ false, false, true, true, false },
				{ true, true, false, false, false },
				{ true, false, true, false, true },
				{ true, true, false, false, false } };

		Relation gRw = new Relation(4, 4);
		Relation fRc = new Relation(3, 7);
		Relation nR = new Relation(10, 5);
		gRw.setMatrix(girlWomen);
		fRc.setMatrix(f1c1);
		nR.setMatrix(num);

		Utility.PrintArray(fRc.GenerateConcepts().getMatrix());

	}
}
