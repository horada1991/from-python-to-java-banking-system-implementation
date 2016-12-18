package frompythontojava.exercise3.model;

import java.util.ArrayList;

/**
 * Created by Cerianth on 2016.12.18..
 */
public class Receipt {
    private ArrayList<String> details;

    {
        details = new ArrayList<String>();
    }

    public void addDetails(String detail){
        details.add(detail);
    }

    @Override
    public String toString() {
        String stringToPrint = "\n<<<<<<<<<<<<<<<\nReceipt\n";
        for (String detail: details) {
            stringToPrint += detail + "\n";
        }
        stringToPrint += ">>>>>>>>>>>>>>>";
        return stringToPrint;
    }
}
