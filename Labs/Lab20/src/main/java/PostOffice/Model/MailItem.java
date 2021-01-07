package PostOffice.Model;

/**
 * Mailitem is used for Letters and Parcel to derived from.
 */
public abstract class MailItem implements IMailItem {
    private Customer receiver;
    private Customer sender;

    private double weight;
    private double cost;

    protected PostalType type;

    public Customer getReceiver() {
        return receiver;
    }

    public void setReceiver(Customer receiver) {
        this.receiver = receiver;
    }

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}