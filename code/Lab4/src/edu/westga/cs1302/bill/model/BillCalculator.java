package edu.westga.cs1302.bill.model;

/**
 * Calculates the sub-total, tax, tip, and total for an Array of BillItem objects
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class BillCalculator {
	/**
     * Calculates the subTotal from an array of BillItems
     * 
     * @precondition items != null && no null values in items array
     * @postcondition none
     * 
     * @param items the array of BillItems to calculate subtotal for
     * @return the subTotal of all items
     */
    public static double getSubTotal(BillItem[] items) {
        if (items == null) {
            throw new IllegalArgumentException("items array must not be null");
        }
        
        double subTotal = 0.0;
        for (BillItem item : items) {
            if (item == null) {
                throw new IllegalArgumentException("items array must not contain null values");
            }
            subTotal += item.getAmount();
        }
        return subTotal;
    }
	
    /**
     * Calculates the tax based on subtotal
     * 
     * @precondition subtotal >= 0
     * @postcondition none
     * 
     * @param subtotal the subtotal to calculate tax on
     * @return the tax amount (10% of subtotal)
     */
    public static double getTax(double subtotal) {
        if (subtotal < 0) {
            throw new IllegalArgumentException("subtotal must not be negative");
        }
        return subtotal * 0.1;
    }
	
    /**
     * Calculates the tip based on subtotal
     * 
     * @precondition subtotal >= 0
     * @postcondition none
     * 
     * @param subtotal the subtotal to calculate tip on
     * @return the tip amount (20% of subtotal)
     */
    public static double getTip(double subtotal) {
        if (subtotal < 0) {
            throw new IllegalArgumentException("subtotal must not be negative");
        }
        return subtotal * 0.2;
    }
	
    /**
     * Calculates the total (subtotal + tax + tip)
     * 
     * @precondition subtotal >= 0
     * @postcondition none
     * 
     * @param subtotal the subtotal amount
     * @return the total amount (subtotal + tax + tip)
     */
    public static double getTotal(double subtotal) {
        if (subtotal < 0) {
            throw new IllegalArgumentException("subtotal must not be negative");
        }
        double tax = getTax(subtotal);
        double tip = getTip(subtotal);
        return subtotal + tax + tip;
    }
}

