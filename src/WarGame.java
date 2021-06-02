public class WarGame {

    Player p1;
    Player p2;
    Deck deckFirst;
    Deck deckSecond;

    WarGame(String nameP1,String nameP2)
    {
        this.p1=new Player(nameP1);
        this.p2=new Player(nameP2);
        this.deckFirst=new Deck(false);
        this.deckSecond=new Deck(false);
    }
    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }
    public boolean initializeGame()
    {
        Deck intial=new Deck(true);
        intial.shuffle();
        if(p1.toString().compareTo(p2.toString())<0) {
            deal(intial, p1, p2);
            return true;
        }
        else {
            deal(intial, p2, p1);
            return false;
        }
    }
    private void deal(Deck deck,Player first,Player second)
    {
        while(!deck.isEmpty()) {
            first.addCard(deck.removeTopCard(), true);
            second.addCard(deck.removeTopCard(),true);
        }
    }
    public String start()
    {
       boolean first=initializeGame();
       while (true) {
           if (p1.outOfCards())
               return p2.toString();
           else if (p2.outOfCards())
               return p1.toString();
           else {
               if (first)
                   round(p1, p2);
               else
                   round(p2, p1);
           }
       }


    }
    private void round(Player first,Player second)
    {
        Card pFirst=first.drawCard();
        Card pSecond= second.drawCard();
        deckFirst.addCard(pFirst);
        deckSecond.addCard(pSecond);
        if(pFirst.compare(pSecond)>0)
            loot(first);
        else if(pFirst.compare(pSecond)<0)
            loot(second);
        else
            war(first,second);
    }
    private void loot(Player won)
    {
        while(!deckFirst.isEmpty())
        {
            won.addCard(deckSecond.removeTopCard(),false);
            won.addCard(deckFirst.removeTopCard(),false);
        }
    }
    private void war(Player first,Player second)
    {
        for(int i=0;i<2;i++) {
            if(!first.deck.isEmpty())
            first.drawCard();
            if(!second.deck.isEmpty())
            second.drawCard();
        }
        round(first,second);
    }

}
