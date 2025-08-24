package logic;

import java.util.ArrayList;

public class UnitDeck {

    private ArrayList<CardCounter> cardsInDeck;
    private String deckName;

    public UnitDeck(String deckName) {
        cardsInDeck = new ArrayList<>();
        setdeckName(deckName);
    }

    public void setdeckName(String deckName) {
        if (deckName == null || deckName.isBlank()) {
            this.deckName = "Untitled Deck";
        } else {
            this.deckName = deckName;
        }
    }

    public String getdeckName() {
        return deckName;
    }

    public void setCardsInDeck(ArrayList<CardCounter> cardsInDeck) {
        if (cardsInDeck == null) {
            this.cardsInDeck = new ArrayList<>();
        } else {
            this.cardsInDeck = cardsInDeck;
        }
    }

    public ArrayList<CardCounter> getCardsInDeck() {
        return cardsInDeck;
    }

    public void addCard(UnitCard newCard, int count) {
        if (newCard == null || count <= 0) return;

        for (CardCounter c : cardsInDeck) {
            if (c.getCard().equals(newCard)) {
                c.setCount(count + c.getCount());
                return;
            }
        }
        cardsInDeck.add(new CardCounter(newCard, count));
    }

    public void removeCard(UnitCard toRemove, int count) {
        if (toRemove == null || count <= 0) return;
        for (int i = 0; i < cardsInDeck.size(); i++) {
            CardCounter c = cardsInDeck.get(i);

            if (c.getCard().equals(toRemove)) {
                int newCount = c.getCount() - count;

                if (newCount > 0) {
                    c.setCount(newCount);
                } else {
                    cardsInDeck.remove(i);
                }
                return;
            }
        }
    }

    public int cardCount() {
        int total = 0;
        for (CardCounter c : cardsInDeck) {
            total += c.getCount();
        }
        return total;
    }

    public boolean existsInDeck(UnitCard card) {
        for (CardCounter c : cardsInDeck) {
            if (c.getCard().equals(card) && c.getCount() >= 1) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(UnitDeck other) {
        if (other == null) return false;
        return this.deckName != null && this.deckName.equals(other.deckName);
    }
}
