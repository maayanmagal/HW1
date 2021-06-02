public class Card {
    int value;
    Main.Shape shape;

    Card(int value, int shape) {
        this.value = value;
        this.shape = Main.Shape.values()[shape];
    }

    public int getValue() {
        return value;
    }


    public Main.Shape getShape() {
        return shape;
    }


    public int compare(Card other) {
        if (this.value > other.getValue())
            return 1;
        else if (this.value == other.getValue())
            return 0;
        else
            return -1;
    }

    public String toString() {
        String shape="";
        switch (this.shape) {
            case CLUBS:
                shape="♣";
            case HEARTS:
                shape="♥";
            case SPADES:
                shape="♠";
            case DIAMONDS:
                shape="♦";
        }
        switch (this.value) {
            case 1:
                return "Ace of "+shape;
            case 11:
                return "Prince of "+shape;
            case 12:
                return "Queen of "+shape;
            case 13:
                return "King of "+shape;
            default:
                return this.value+" of "+shape;
        }
    }
}

