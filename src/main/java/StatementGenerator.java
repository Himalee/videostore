import java.util.Enumeration;
import java.util.Vector;

public class StatementGenerator {

    public String generate (String customerName, Vector customerRentals) {
        double 				totalAmount 			= 0;
        int					frequentRenterPoints 	= 0;
        Enumeration rentals 				= customerRentals.elements ();
        String 				result 					= "Rental Record for " + customerName + "\n";

        while (rentals.hasMoreElements ()) {
            double 		thisAmount = 0;
            Rental 		each = (Rental)rentals.nextElement ();

            // determines the amount for each line
            switch (each.getMovie ().getPriceCode ()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented () > 2)
                        thisAmount += (each.getDaysRented () - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented () * 3;
                    if (each.getDaysRented() > 1)
                        frequentRenterPoints ++;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented () > 3)
                        thisAmount += (each.getDaysRented () - 3) * 1.5;
                    break;
            }

            frequentRenterPoints++;

            result += "\t" + each.getMovie ().getTitle () + "\t"
                    + String.valueOf (thisAmount) + "\n";
            totalAmount += thisAmount;

        }

        result += "You owed " + String.valueOf (totalAmount) + "\n";
        result += "You earned " + String.valueOf (frequentRenterPoints) + " frequent renter points\n";


        return result;
    }
}
