import java.util.ArrayList;
import java.util.Random;

public class _Deck 
{
	public ArrayList<_Card> deckOfCards = new ArrayList<_Card>();
	
	public _Deck()
	{
		_Card.Suit suits[] = _Card.Suit.values();	
		_Card.Value values[] = _Card.Value.values();
		for(_Card.Suit suit: suits)
		{
			for(_Card.Value value: values)
			{   //for each value in each suit, make a new Card object of that value and suit and add it to the deck
				deckOfCards.add(new _Card(suit, value)); 
			} 
		}
	}
	
	public void reset()
	{
		ArrayList<_Card> resetDeck = new ArrayList<_Card>();
		
		_Card.Suit suits[] = _Card.Suit.values();	
		_Card.Value values[] = _Card.Value.values();
		for(_Card.Suit suit: suits)
		{
			for(_Card.Value value: values)
			{
				resetDeck.add(new _Card(suit, value));
			}
		}
		deckOfCards = resetDeck; //sets the original deckOfCards array to the newly made deck
	}
	
	public void shuffle()
	{
		ArrayList<Integer> randomNumberList = new ArrayList<Integer>();
		ArrayList<_Card> tmpDeck = new ArrayList<_Card>();
		
		for(int i = 0; i < deckOfCards.size(); i++)
		{
			tmpDeck.add(new _Card(deckOfCards.get(i).getSuit(), deckOfCards.get(i).getValue())); //copies the deck of cards to a new temporary deck
		}
		
		for(int i = 0; i < deckOfCards.size(); i++)
		{
			randomNumberList.add(i); //Initialises a list of numbers 0, 1,..., size of deck - 1
		}
		
		int rand;
		
		for(int i = 0; i < tmpDeck.size(); i++)
		{
			rand = new Random().nextInt(randomNumberList.size()); //get random int (0 to randomNumberList size - 1)
			deckOfCards.set(randomNumberList.get(rand), tmpDeck.get(i)); //sets random card to the tempDeck card at index i
			randomNumberList.remove(randomNumberList.get(rand)); //removes that index of deckOfCards so the same card isn't changed again
		}
	}
	
	public _Card getCard(int i)
	{
		return deckOfCards.get(i);
	}
	
	public _Card dealRandomCard()
	{
		int rand = new Random().nextInt(deckOfCards.size());
		_Card tmp = deckOfCards.get(rand);
		deckOfCards.remove(rand);
		return tmp;
	}

	public _Card dealCard()
	{
		_Card tmp = deckOfCards.get(0);
		deckOfCards.remove(0);
		return tmp;
	}
	
	public int size()
	{
		return deckOfCards.size();
	}
	
	public void display() //NOT NEEDED FOR SUBMISSION
	{
		for(_Card card: deckOfCards)
		{
			System.out.println(card.getValue() + " of " + card.getSuit());
		}
		System.out.println("---------------------------------------------------------");
	}
}

