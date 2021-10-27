import java.util.*;

public class _Card {
    public static enum Suit {CLUBS, HEARTS, DIAMONDS, SPADES};
	public static enum Value {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING};
	
	Suit suit;
	Value value;

	public _Card(Suit suit, Value value)
	{
		this.suit = suit;
		this.value = value;
	}
	
	public ArrayList<Integer> getNumericalValue()
	{
		ArrayList<Integer> cardValue = new ArrayList<Integer>();
		
		switch(value)
		{
			case ACE:
			{
				cardValue.add(1);
				cardValue.add(11);
				return cardValue;
			}
			case TWO:
			{
				cardValue.add(2);
				return cardValue;
			}
			case THREE:
			{
				cardValue.add(3);
				return cardValue;
			}
			case FOUR:
			{
				cardValue.add(4);
				return cardValue;
			}
			case FIVE:
			{
				cardValue.add(5);
				return cardValue;
			}
			case SIX:
			{
				cardValue.add(6);
				return cardValue;
			}
			case SEVEN:
			{
				cardValue.add(7);
				return cardValue;
			}
			case EIGHT:
			{
				cardValue.add(8);
				return cardValue;
			}
			case NINE:
			{
				cardValue.add(9);
				return cardValue;
			}
			default:
			{
				cardValue.add(10);
				return cardValue;
			}
		}
	}
	
	
	public Suit getSuit()
	{
		return suit;
	}
	
	public void setSuit(Suit suit)
	{
		this.suit = suit;
	}
	
	public Value getValue()
	{
		return value;
	}
	
	public void setValue(Value value)
	{
		this.value = value;
	}
}
