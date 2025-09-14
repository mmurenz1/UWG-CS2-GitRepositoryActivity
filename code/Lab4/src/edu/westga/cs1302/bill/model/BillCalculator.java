package edu.westga.cs1302.bill.model;

/**
 * Calculates the sub-total, tax, tip, and total for an Array of BillItem objects
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class BillCalculator {
	private final BillItem[] items = new BillItem[3];
	private final double subTotal = 0;
	private final double tax = 0;
	private final double tip = 0;
	private final double total = 0;
	
    /**
     * Calculates the subTotal
     * 
     * @precondition none
     * @postcondition none
     * 
     * @return the subTotal
     */
	public static double getSubTotal(BillItem[] items) {
		return subTotal;
	}
	
	/**
     * Calculates the tax
     * 
     * @precondition none
     * @postcondition none
     * 
     * @return the subTotal
     */
	public static double getTax() {
		return tax;
	}
	
	/**
     * Calculates the tip
     * 
     * @precondition none
     * @postcondition none
     * 
     * @return the subTotal
     */
	public static double getTip() {
		return tip;
	}
	
	/**
     * Calculates the total
     * 
     * @precondition none
     * @postcondition none
     * 
     * @return the subTotal
     */
	public static double getTotal() {
		return total;
	}
}

