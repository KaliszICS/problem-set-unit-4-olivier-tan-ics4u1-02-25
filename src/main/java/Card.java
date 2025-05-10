// Card class for creating cards.
    class Card {
      private String name; //name of the card (for playing cards for Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King)
      private String suit; //suit of a card (for a playing card for  Hearts, Spades, Diamonds, Clubs)
      private int value; //a number value that represents if a card is worth more or less than another. This should be represented by a whole number

      //Constructor is being used to create a new card object
      public Card(String name, String suit, int value) {
          this.name = name; //This can create the card to have either an Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, or King.
          this.suit = suit; //This chooses a suit: either Diamonds, Clubs, Hearts, Spades.
          this.value = value; //Store a numeric value for each card (helps for comparisons).
      }
  
      //Getters. These methods are public as it allows for the values of the cards to be read by other classes.
      public String getName() { //Get the name of the card.
          return name; 
      }
    
      public String getSuit() { //Get the suit of the card.
          return suit;
      }
      
      public int getValue() { //Get the numerical value of the card.
          return value;
      }
    
      public String toString() { 
          return name + " of " + suit; //Return the name of the card and it's suit.
      }
  
      @Override
      public boolean equals(Object object){
        Card card = (Card) object; //Casting the object to the a Card object.
        if (name.equals(card.name) && suit.equals(card.suit) && value == card.value){
            return true; //Check to see if the provided card is equal to the card object. Use .equals for strings, and == for integers.
        }
        
        return false; //False otherwise.
      }
  }