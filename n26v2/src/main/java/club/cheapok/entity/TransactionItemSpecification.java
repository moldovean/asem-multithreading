package club.cheapok.entity;

public class TransactionItemSpecification {
private double amount;
private long timestamp;

    public TransactionItemSpecification() {
    }

    public TransactionItemSpecification(final double amount, final long timestamp) {
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(final double amount) {
        this.amount = amount;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(final long timestamp) {
        this.timestamp = timestamp;
    }


}
