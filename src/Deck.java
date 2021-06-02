import java.util.Stack;

public class Deck {
    Stack<Card> deck;

    Deck(boolean full)
    {
        deck=new Stack<Card>();
        if(full)
        {
            for(int i=0;i<Main.Shape.values().length;i++)
            {
                for (int j=1;j<=13;j++)
                {
                    deck.push(new Card(j,i));
                }
            }
        }
    }
    public void addCard(Card card)
    {
        deck.push(card);
    }
    public Card removeTopCard()
    {
        return deck.pop();
    }
    public boolean isEmpty()
    {
        return deck.isEmpty();
    }
    public void shuffle()
    {
        int i=0;
        int j=0;
        Card ci;
        Card cj;
        for(int x=0;x<50;x++)
        {
            i=Main.rnd.nextInt(deck.size());
            j=Main.rnd.nextInt(deck.size());
            if(i!=j) {
                ci = deck.get(i);
                cj = deck.get(j);
                deck.insertElementAt(ci,j);
                deck.removeElementAt(j+1);
                deck.insertElementAt(cj,i);
                deck.removeElementAt(i+1);
            }
        }
    }
}
