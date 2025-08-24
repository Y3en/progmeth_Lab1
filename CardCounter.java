package logic;

public class CardCounter {
	
	private UnitCard card;
	private int count;

    public CardCounter(UnitCard card, int count) {
        this.card = card;
        setCount(count);
    }

    public void setCount(int count) {
        if  (count < 0) {
            this.count = 0;
        } else {
            this.count = count;
        }
    }

    public int getCount() {
        return count;
    }

    public UnitCard getCard() {
        return card;
    }

    public String toString() {
        return  this.getCard() + " x " + this.getCount();
    }

}
