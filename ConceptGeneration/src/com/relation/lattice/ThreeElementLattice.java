package com.relation.lattice;

import java.util.ArrayList;

public class ThreeElementLattice extends Lattice {

	/**
	 * This static two dimensional array contains the result of a meet operation
	 * between two elements.Since it is a three element lattice, we need to
	 * declare a 3 by 3 dimension array.
	 */
	private static int[][] meetArray = { { 0, 0, 0 }, { 0, 1, 2 }, { 0, 2, 2 } };

	/**
	 * This static two dimensional array contains the result of a join operation
	 * between two elements.Since it is a three element lattice, we need to
	 * declare a 3 by 3 dimension array.
	 */
	private static int[][] joinArray = { {0, 1, 2 }, { 1, 1, 1 }, { 2, 1, 2 } };

	/**
	 * This static two dimensional array contains the result of an implication
	 * operation between two elements.Since it is a three element lattice, we
	 * need to declare a 3 by 3 dimension array.
	 */
	private static int[][] implicationArray = { { 1, 1, 1 },
		{ 0, 1, 2 },
			{ 0, 1, 1 } };

	/**
	 * This is the constructor. Constructor assign the the total number of
	 * elements to represent this lattice.
	 */
	public ThreeElementLattice() {
		setNoOfElements(3);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.relation.lattice.Lattice#GetZero()
	 */
	@Override
	public int GetZero() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.relation.lattice.Lattice#GetOne()
	 */
	@Override
	public int GetOne() {
		// TODO Auto-generated method stub
		return 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.relation.lattice.Lattice#Meet(int, int)
	 */
	@Override
	public int Meet(int elem1, int elem2) {
		return meetArray[elem1][elem2];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.relation.lattice.Lattice#Join(int, int)
	 */
	@Override
	public int Join(int elem1, int elem2) {
		return joinArray[elem1][elem2];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.relation.lattice.Lattice#Implication(int, int)
	 */
	@Override
	public int Implication(int elem1, int elem2) {
		// TODO Auto-generated method stub
		/*
		 * for (int i = 0; i < 3; i++) { for (int j = 0; j < 3; j++) { int max =
		 * -1; for (int x = 0; x < 3; x++) { if (meetArray[i][x] <= j) { if (x >
		 * max) max = x; } } System.out.print(max + ","); max = -1;
		 * 
		 * } System.out.println(); }
		 */// return 0;
		
		int[][] meetArray = { { 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };

	 /*ArrayList<Integer> elements = new ArrayList<Integer>();
	 elements.add(0);
	 elements.add(3);
	 elements.add(1);
	 elements.add(1);
	 elements.add(2);
	 elements.add(2);
	 elements.add(-1);

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				int max = 6;
				for (int x = 0; x < 6; x++) {
					if (elements.get(meetArray[i][x]) <= elements.get(j)) {
						if (elements.get(x) > elements.get(max))
							max = x;
					}
				}
				System.out.print(max + ",");
				max = 6;

			}
			System.out.println();
		}*/
		return implicationArray[elem1][elem2];
	}

}
