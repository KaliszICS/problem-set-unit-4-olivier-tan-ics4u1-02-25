import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

// Player class with player's information.
public class Player {
    private String name; //Store player's name.
    private int age; //Store player's age.
    private ArrayList hand; //Store the player's hand.

    public Player(String name, int age, Card[] handCards) {
        this.name = name; //Player name.
        this.age = age; //Player age.
        this.hand = new ArrayList(Arrays.asList(handCards)); //Convert the array to an arraylist. This allows for varying sizes.
    }

    public Player(String name, int age) {
        this.name = name; //Player name.
        this.age = age; //Player Age.
        this.hand = new ArrayList(); //Create the default empty hand.
    }

    public String getName() { 
        return name; //Return the player's name.
    }

    public int getAge() {
        return age; //Return the player's age.
    }

    public Card[] getHand() {
        return (Card[]) hand.toArray(new Card[0]); //Convert the players hand to an array of card objects.
    }

    public int size() {
        return hand.size(); //Return the size of the player's hand.
    }

    public void draw(Deck deck) { //Add a card from the deck, to the player's hand.
        Card drawn = deck.draw(); //Draw the card.
        if (drawn != null) {  //If a card gets drawn, add it to the player's hand.
            hand.add(drawn);
        }
    }

    public boolean discardCard(Card card, DiscardPile discardPile) {
        if (hand.remove(card)) {    //Remove the discarded card.
            discardPile.addCard(card);  //Add the discarded card to the discard pile.
            return true; //If the card exists in the hand.
        }
        return false; } //False otherwise.

    public boolean returnCard(Card card, Deck deck) {
        if (hand.remove(card)) { //Remove and return the card to the deck. 
            deck.addCard(card);
            return true; //True if the card exists in the hand.
        }
        return false; } //False otherwise.

    public String toString() {
        String result = name + ", " + age + ", "; //Prints out the name, and age that was given by the player.
        for (int i = 0; i < hand.size(); i++) {
            result += hand.get(i).toString(); //Add the string version of each card. Do this so that we are able to see the hand of the player.
            if (i < hand.size() - 1) { //Make sure to seperate each string so that it doesn't become one big string. Add space and commas between.
                result += ", ";
            }
        }
        return result; } //Return the name, age, and player's hand.
    }
