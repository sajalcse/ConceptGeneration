package com.relation.lattice;

public class FiveElementLattice extends Lattice {

	/**
	 * This static two dimensional array contains the result of a meet operation
	 * between two elements.Since it is a three element lattice, we need to
	 * declare a 3 by 3 dimension array.
	 */
	private static int[][] meetArray = { { 0, 0, 0, 0, 0 }, { 0, 1, 2, 3, 4 },
			{ 0, 2, 2, 2, 2 }, { 0, 1, 2, 3, 3 }, { 0, 4, 2, 3, 4 } };

	/**
	 * This static two dimensional array contains the result of a join operation
	 * between two elements.Since it is a three element lattice, we need to
	 * declare a 3 by 3 dimension array.
	 */
	private static int[][] joinArray = { { 0, 1, 2, 3, 4 }, { 1, 1, 1, 1, 1 },
			{ 2, 1, 2, 3, 4 }, { 3, 1, 3, 3, 4 }, { 4, 1, 4, 4, 4 } };

	/**
	 * This static two dimensional array contains the result of an implication
	 * operation between two elements.Since it is a three element lattice, we
	 * need to declare a 3 by 3 dimension array.
	 */
	private static int[][] implicationArray = { { 4, 4, 4, 4, 4 },
			{ 0, 1, 2, 3, 4 }, { 0, 0, 4, 4, 4 }, { 0, 1, 2, 4, 4 },
			{ 0, 0, 2, 3, 4 } };

	public FiveElementLattice()
	{
		setNoOfElements(5);
	}
	@Override
	public int GetZero() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int GetOne() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int Meet(int elem1, int elem2) {
		// TODO Auto-generated method stub
		return meetArray[elem1][elem2];
	}

	@Override
	public int Join(int elem1, int elem2) {
		// TODO Auto-generated method stub
		return joinArray[elem1][elem2];
	}

	@Override
	public int Implication(int elem1, int elem2) {/*
		// TODO Auto-,generated method stub
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int max = -1;
				for (int x = 0; x < 5; x++) {
					if (meetArray[i][x] <= j) {
						if (x > max)
							max = x;
					}
				}
				System.out.print(max + ",");
				max = -1;

			}
			System.out.println();
		}
		return 0;
	*/
		return implicationArray[elem1][elem2];}

}
