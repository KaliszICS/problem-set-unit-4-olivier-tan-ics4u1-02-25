import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

//DiscardPile method for unwanted cards.
class DiscardPile {
      private ArrayList pile; //This will hold the discarded cards
  
      public DiscardPile() {
          pile = new ArrayList();
      }
  
      public DiscardPile(Card[] initialCards) {
          pile = new ArrayList(Arrays.asList(initialCards)); //Starting cards
      }
  
      public Card[] getPile() {
          return (Card[]) pile.toArray(new Card[0]); //Return the cards in the pile as an array.
      }
  
      public int size() {
          return pile.size(); //Return how many cards are in the pile.
      }
  
      public void addCard(Card card) {
          if (card != null) {
              pile.add(card); //If it is not null, then a card will be added to the pile.
          }
      }
  
     
    public Card removeCard(Card card) {
        if (pile.contains(card)) { //See if the card exists.
            pile.remove(card); //If it exists, remove a specific card.
            return card; //Return the card
        }
        return null;
    }
  
    public Card[] removeAll() { //Removing all cards from the pile.
          Card[] allCards = getPile();
          pile.clear(); //Clears the pile.
          return allCards; //Returns all cards in the pile.
      }
  
      
    public String toString() { 
        String string = "";
        for (int i = 0; i < pile.size(); i++) { //Check through the pile.
            Card card = (Card) pile.get(i); //Retrieve a card from the pile.
            string += card.toString(); //Convert that card to a string.
            if (i < pile.size() - 1) { //Seperates the strings if they are not already seperated. Do this by adding a comma and a space.
                string += ", ";
            }
        }
        return string; // Return the pile as a formatted string.
    }
}