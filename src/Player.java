public class Player {


    String name;
    Deck deck;
    Deck win;

    Player(String name)
    {
        this.name=name;
        this.deck=new Deck(false);
        this.win=new Deck(false);
    }
    public void addCard(Card card,boolean deck)
    {
        if(deck)
            this.deck.addCard(card);
        else
            this.win.addCard(card);
    }
    public Card drawCard()
    {
        return this.deck.removeTopCard();
    }
    public boolean outOfCards()
    {
        return false;
    }
    public String toString()
    {
        return this.name;
    }

}
