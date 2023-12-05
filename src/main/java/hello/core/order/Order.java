package hello.core.order;

public class Order {
    private long MemberId;
    private String ItemName;
    private int ItemPrice;
    private int discountPrice;

    public Order(long memberId, String itemName, int itemPrice, int discountPrice) {
        this.MemberId = memberId;
        this.ItemName = itemName;
        this.ItemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    public long getMemberId() {
        return MemberId;
    }

    public void setMemberId(long memberId) {
        MemberId = memberId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public int getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(int itemPrice) {
        ItemPrice = itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }


    public int calculatePrice(){
        return ItemPrice - discountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "MemberId=" + MemberId +
                ", ItemName='" + ItemName + '\'' +
                ", ItemPrice=" + ItemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
