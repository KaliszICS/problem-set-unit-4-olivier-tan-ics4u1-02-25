import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
// Deck class to manage a full deck of cards
  class Deck {
      private ArrayList cards; //Arraylists will allow for me to have an array of any size.

      public Deck(Card[] cardArray) {
          cards = new ArrayList (Arrays.asList(cardArray)); //Start with an array, and convert it into an arraylist. This arraylist will allow for the size of the deck to be whatever the player chooses. If they want a deck of 100 cards, it can make it since the size is not finalized.
      }
      
      //This constructor will build an unshuffled deck of card.
      public Deck() {
        cards = new ArrayList(); //Need cards to not be equal to null, otherwise it throws a nullpointexception.

         String[] suits = {"Heart", "Clubs", "Diamond", "Spades"}; //Possible suits for the cards.
         String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"}; //Possible numbers/faces for the cards.

        for (int i = 0; i < suits.length; i++) { //Loop through the different suit types.
            String suit = suits[i];
            for (int j = 0; j < names.length; j++) { //Loop through the different card names.
                cards.add(new Card(names[j], suit, j + 1)); //Add the names, suit and values of the cards to the deck.
            }
        }
    }

        
      public int size() {
          return cards.size(); //Return the number of cards in the deck.
      }
  
      public Card draw() { //Draw a card, removing it from the top of the deck.
          if(size() > 0){
            return (Card) cards.remove(0);
          } 
          return null; //If the size of the deck is 0, the return null.
      }
        
      //A shuffle method to shuffle the deck.
        public void shuffle() {
            Random random = new Random(); //Create an object to make random numbers
            for (int i = cards.size() - 1; i > 0; i--) { 
                int j = random.nextInt(i + 1); //Generate a random index between 0 and i.
                Card temp = (Card) cards.get(i); //Store the card at index i temporarily (now we can shuffle by setting to other indexes).
                cards.set(i, cards.get(j)); //Set the card at index i to the card at index j. I learned .get here: https://www.w3schools.com/java/ref_arraylist_get.asp
                cards.set(j, temp); //Set the card index at j to the original card at i.
        }
    }

      public void addCard(Card card) { //As long as card isn't null, it will add a card to the deck.
          if (card != null) {
              cards.add(card);
          }
      }
  
      public void reshuffle(Card[] cardsAdd) {
          if (cards != null){
            for (int i = 0; i < cardsAdd.length; i++){
                this.cards.add(cardsAdd[i]);
            }
          }
          shuffle();
      }
  }
  