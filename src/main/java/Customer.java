import java.util.Vector;

public class Customer {

    private String name;
    private Vector rentals = new Vector ();
    private StatementGenerator statementGenerator;

    public Customer (String name, StatementGenerator statementGenerator) {
        this.name = name;
        this.statementGenerator = statementGenerator;
    }

    public void addRental (Rental rental) {
        rentals.addElement (rental);
    }

    public String statement() {
        return statementGenerator.generate(name, rentals);
    }

}

