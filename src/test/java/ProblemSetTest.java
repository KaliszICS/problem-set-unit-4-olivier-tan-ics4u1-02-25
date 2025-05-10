// Don't forget to import anything else you need
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;

public class ProblemSetTest {

    @Test
    public void testCardEquality() {
        Card card1 = new Card("Ace", "Spades", 1);
        Card card2 = new Card("Ace", "Spades", 1);
        assertEquals(card1, card2);
    }

    @Test
    public void testDeckDrawAndSize() {
        Deck deck = new Deck();
        int initialSize = deck.size();
        Card drawn = deck.draw();
        assertNotNull(drawn);
        assertEquals(initialSize - 1, deck.size());
    }

    @Test
    public void testDeckAddCard() {
        Deck deck = new Deck(new Card[0]);
        Card card = new Card("King", "Hearts", 13);
        deck.addCard(card);
        assertEquals(1, deck.size());
    }

    @Test
    public void testDiscardPileAddAndSize() {
        DiscardPile pile = new DiscardPile();
        Card card = new Card("Queen", "Diamonds", 12);
        pile.addCard(card);
        assertEquals(1, pile.size());
    }

    @Test
    public void testDiscardPileRemoveCard() {
        Card card = new Card("10", "Clubs", 10);
        DiscardPile pile = new DiscardPile(new Card[]{card});
        Card removed = pile.removeCard(card);
        assertEquals(card, removed);
        assertEquals(0, pile.size());
    }

    @Test
    public void testDiscardPileRemoveAll() {
        Card card1 = new Card("2", "Hearts", 2);
        Card card2 = new Card("3", "Spades", 3);
        DiscardPile pile = new DiscardPile(new Card[]{card1, card2});
        Card[] removed = pile.removeAll();
        assertEquals(2, removed.length);
        assertEquals(0, pile.size());
    }

    @Test
    public void testPlayerDrawAndHandSize() {
        Deck deck = new Deck();
        Player player = new Player("Alice", 21);
        int initialDeckSize = deck.size();
        player.draw(deck);
        assertEquals(1, player.size());
        assertEquals(initialDeckSize - 1, deck.size());
    }

    @Test
    public void testPlayerDiscardCard() {
        Card card = new Card("7", "Diamonds", 7);
        Player player = new Player("Bob", 22, new Card[]{card});
        DiscardPile pile = new DiscardPile();
        boolean success = player.discardCard(card, pile);
        assertTrue(success);
        assertEquals(0, player.size());
        assertEquals(1, pile.size());
    }

    @Test
    public void testPlayerReturnCardToDeck() {
        Card card = new Card("5", "Clubs", 5);
        Player player = new Player("Eve", 19, new Card[]{card});
        Deck deck = new Deck(new Card[0]);
        boolean success = player.returnCard(card, deck);
        assertTrue(success);
        assertEquals(0, player.size());
        assertEquals(1, deck.size());
    }

    @Test
    public void testPlayerToString() {
        Player player = new Player("Jane", 30, new Card[]{
            new Card("4", "Spades", 4),
            new Card("King", "Hearts", 13)
        });
        String output = player.toString();
        assertTrue(output.contains("Jane"));
        assertTrue(output.contains("4 of Spades"));
        assertTrue(output.contains("King of Hearts"));
    }
}