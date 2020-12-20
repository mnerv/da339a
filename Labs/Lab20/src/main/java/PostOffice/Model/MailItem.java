package PostOffice.Model;

/**
 * Mailitem is used for Letters and Parcel to derived from.
 */
public abstract class MailItem implements IMailItem {
  private Receiver receiver;
  private Sender sender;

  private double weight;
  private double cost;

  protected PostalType type;

  public Receiver getReceiver() {
    return receiver;
  }

  public void setReceiver(Receiver receiver) {
    this.receiver = receiver;
  }

  public Sender getSender() {
    return sender;
  }

  public void setSender(Sender sender) {
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

  @Override
  public String toString() {
    return String.format("To: %s\nFrom: %s", receiver.toString(), sender.toString());
  }

}
