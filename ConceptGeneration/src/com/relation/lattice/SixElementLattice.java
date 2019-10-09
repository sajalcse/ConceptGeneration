package com.relation.lattice;

public class SixElementLattice extends Lattice {

	/**
	 * This static two dimensional array contains the result of a meet operation
	 * between two elements.Since it is a six element lattice, we need to declare a
	 * 6 by 6 dimension array.
	 */
	private static int[][] meetArray = { { 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };

	/**
	 * This static two dimensional array contains the result of a join operation
	 * between two elements.Since it is a six element lattice, we need to declare a
	 * 6 by 6 dimension array.
	 */
	private static int[][] joinArray = { { 0, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 } };

	/**
	 * This static two dimensional array contains the result of an implication
	 * operation between two elements.Since it is a six element lattice, we need to
	 * declare a 6 by 6 dimension array.
	 */
	private static int[][] implicationArray = { {1,1,1,1,1,1},
			{4,1,4,4,4,4},
			{1,1,1,1,1,1},
			{1,1,1,1,1,1},
			{1,1,1,1,1,1},
			{1,1,1,1,1,1},
};

	/**
	 * This is the constructor. Constructor assign the the total number of elements
	 * to represent this lattice.
	 */
	public SixElementLattice() {
		setNoOfElements(6);
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
		// TODO Auto-generated method stub
		return meetArray[elem1][elem2];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.relation.lattice.Lattice#Join(int, int)
	 */
	@Override
	public int Join(int elem1, int elem2) {
		// TODO Auto-generated method stub
		return joinArray[elem1][elem2];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.relation.lattice.Lattice#Implication(int, int)
	 */
	@Override
	public int Implication(int elem1, int elem2) {
		return implicationArray[elem1][elem2];
	}

}
