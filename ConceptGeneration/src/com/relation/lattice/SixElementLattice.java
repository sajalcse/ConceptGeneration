package com.relation.lattice;

public class SixElementLattice extends Lattice {

	/**
	 * This static two dimensional array contains the result of a meet operation
	 * between two elements.Since it is a six element lattice, we need to
	 * declare a 6 by 6 dimension array.
	 */
	private static int[][] meetArray = { { 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 2, 3, 4, 5 }, { 0, 2, 2, 0, 2, 0 }, { 0, 3, 0, 3, 3, 3 },
			{ 0, 4, 2, 3, 4, 3 }, { 0, 5, 0, 3, 3, 5 } };

	/**
	 * This static two dimensional array contains the result of a join operation
	 * between two elements.Since it is a six element lattice, we need to
	 * declare a 6 by 6 dimension array.
	 */
	private static int[][] joinArray = { { 0, 1, 2, 3, 4, 5 },
			{ 1, 1, 1, 1, 1, 1 }, { 2, 1, 2, 4, 4, 1 }, { 3, 1, 4, 3, 4, 5 },
			{ 4, 1, 4, 4, 4, 1 }, { 5, 1, 1, 5, 1, 5 } };
	
	/**
	 * This static two dimensional array contains the result of an implication operation
	 * between two elements.Since it is a six element lattice, we need to
	 * declare a 6 by 6 dimension array.
	 */
	private static int[][] implicationArray = { { 5, 5, 5, 5, 5, 5 },
			{ 0, 1, 2, 3, 4, 5 }, { 5, 5, 5, 5, 5, 5 }, { 2, 2, 2, 5, 5, 5 },
			{ 0, 0, 2, 5, 5, 5 }, { 2, 2, 2, 4, 4, 5 } };

	/**
	 * This is the constructor. Constructor assign the the total number of
	 * elements to represent this lattice.
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
