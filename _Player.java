import java.util.ArrayList;

public class _Player 
{
	private String name;
	public ArrayList<_Card> hand = new ArrayList<_Card>();
	
	public _Player(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void dealToPlayer(_Card card)
	{
		hand.add(card);
	}
	
	public void removeCard(_Card card)
	{
		hand.remove(card);
	}
	
	public ArrayList<Integer> getNumericalHandValue()
	{
		ArrayList<Integer> total = new ArrayList<Integer>();
		boolean hasAce = false;
			
		for(int j = 0; j < hand.size(); j++)
		{
			if(hand.get(j).getValue() == _Card.Value.ACE) //first checks if an ace is present anywhere in the hand
			{
				hasAce = true;
			}
		}
		
		if(!hasAce) //if no ace is present then only need to deal with a single value in the array list
		{
			total.add(0);
			for(int k = 0; k < hand.size(); k++)
			{
				total.set(0, total.get(0) + hand.get(k).getNumericalValue().get(0));
			}
		}
		else if(hasAce)
		{
			total.add(0);
			total.add(0);
			for(int i = 0; i < hand.size(); i++)
			{
				if(hand.get(i).getValue() != _Card.Value.ACE) //add the same value to each int in the array list
				{
					total.set(0, total.get(0) + hand.get(i).getNumericalValue().get(0));
					total.set(1, total.get(1) + hand.get(i).getNumericalValue().get(0));
				}
				else //add each possibility for the ACE card to each int in the array
				{
					total.set(0, total.get(0) + hand.get(i).getNumericalValue().get(0));
					total.set(1, total.get(1) + hand.get(i).getNumericalValue().get(1));
				}
			}
		}
		
		return total;
	}
	
	public int getBestNumericalHandValue()
	{
		if(getNumericalHandValue().size() == 1) //no ACE is present so only 1 option
		{
			return getNumericalHandValue().get(0);
		}
		else if(getNumericalHandValue().get(1) > 21) //check whether ACE will cause bust
        {
            return getNumericalHandValue().get(0); //if yes, return hand with ACE = 1
        }
        else
        {
            return getNumericalHandValue().get(1); //if not, return maximum hand (ACE = 11)
        }
	}
	
	public ArrayList<_Card> getCards()
	{
		return hand;
	}
	
	public int getHandSize()
	{
		return hand.size();
	}

    public void showHand()
    {
        for(_Card card: hand)
		{
			System.out.println(card.getValue() + " of " + card.getSuit());
		}
    }
	
	
}

