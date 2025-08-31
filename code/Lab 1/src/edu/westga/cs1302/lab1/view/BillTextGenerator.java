package edu.westga.cs1302.lab1.view;

import edu.westga.cs1302.lab1.model.Bill;
import edu.westga.cs1302.lab1.model.BillItem;

/** Generates text representation of a Bill for display purposes.
 *
 * @author CS 1302
 * @version Fall 2025
 */
public class BillTextGenerator {

    /** Generates a text representation of the bill including items and totals
     *
     * @precondition bill != null
     * @postcondition none
     *
     * @param bill the bill to generate text for
     * @return a String containing the list of bill items and total for the bill
     */
    public String getText(Bill bill) {
        if (bill == null) {
            throw new IllegalArgumentException("bill must not be null.");
        }
        
        String text = "ITEMS" + System.lineSeparator();
        double subTotal = 0.0;
        for (BillItem item : bill.getItems()) {
            text += item.getName() + " - " + item.getAmount() + System.lineSeparator();
            subTotal += item.getAmount();
        }

        text += System.lineSeparator();
        text += "SUBTOTAL - $" + subTotal + System.lineSeparator();
        double tax = subTotal * Bill.TAX_RATE;
        double tip = subTotal * Bill.TIP_RATE;
        text += "TAX - $" + tax + System.lineSeparator();
        text += "TIP - $" + tip + System.lineSeparator();
        text += "TOTAL - $" + (subTotal + tip + tax);

        return text;
    }
}