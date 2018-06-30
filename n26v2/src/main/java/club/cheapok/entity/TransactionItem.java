package club.cheapok.entity;

public class TransactionItem {
private double amount;
private long timestamp;


    public TransactionItem(final double amount, final long timestamp) {
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

    @Override
    public String toString() {
        return "TransactionItem{" +
                "amount=" + amount +
                ", timestamp=" + timestamp +
                '}';
    }
}
