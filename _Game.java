import _Card.Suit;
import _Card.Value;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class _Game {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Boolean playAgain = true;

        while(playAgain == true) //game loop
        {
        Boolean playerTurnOver = false;
        Boolean cpuTurnOver = false;
        _Player cpu = new _Player("CPU");
        _Player player = new _Player("PLAYER");
        _Deck deck = new _Deck();
        int input = -1;
        int input2 = -1;
        deck.shuffle();

        player.hand.add(deck.dealCard());
        cpu.hand.add(deck.dealCard());
        player.hand.add(deck.dealCard());
        cpu.hand.add(deck.dealCard());
        
            while(playerTurnOver == false) //player's turn
            {
            System.out.print("Current hand: ");

                for(int i = 0; i < player.hand.size(); i++)
                {
                    if(i != player.hand.size() - 1)
                    {
                        System.out.print(player.hand.get(i).getValue() + " of " + player.hand.get(i).getSuit() + ", ");
                    }
                    else
                    {
                        System.out.print(player.hand.get(i).getValue() + " of " + player.hand.get(i).getSuit() + "\n");
                    }
                }

            System.out.println("Stand (1) or Hit (2)");
            input = sc.nextInt();
            
            if(input == 2)
            {
                System.out.println("Dealing...");
                player.hand.add(deck.dealCard());
            }
            else if(input == 1)
            {
                System.out.print("Final hand: ");

                for(int i = 0; i < player.hand.size(); i++)
                {
                    if(i != player.hand.size() - 1)
                    {
                        System.out.print(player.hand.get(i).getValue() + " of " + player.hand.get(i).getSuit() + ", ");
                    }
                    else
                    {
                        System.out.print(player.hand.get(i).getValue() + " of " + player.hand.get(i).getSuit() + ". Totals: ");
                    }
                }
                System.out.println(player.getBestNumericalHandValue());
                playerTurnOver = true;
            }
            else
            {
                System.out.println("Invalid input. Enter \"1\" or \"2\"");
            }

            if(player.getBestNumericalHandValue() > 21)
            {
                System.out.println("Bust! ");
                System.out.print("Final hand: ");

                for(int i = 0; i < player.hand.size(); i++)
                {
                    if(i != player.hand.size() - 1)
                    {
                        System.out.print(player.hand.get(i).getValue() + " of " + player.hand.get(i).getSuit() + ", ");
                    }
                    else
                    {
                        System.out.print(player.hand.get(i).getValue() + " of " + player.hand.get(i).getSuit() + ". Totals: ");
                    }
                }
                System.out.println(player.getBestNumericalHandValue());

                playerTurnOver = true;
            }
        }

        //sc.close();
        System.out.println("CPU's turn");

        while(cpuTurnOver == false) //CPU turn
        {
            System.out.print("CPUs hand: ");

                for(int i = 0; i < cpu.hand.size(); i++)
                {
                    if(i != cpu.hand.size() - 1)
                    {
                        System.out.print(cpu.hand.get(i).getValue() + " of " + cpu.hand.get(i).getSuit() + ", ");
                    }
                    else
                    {
                        System.out.print(cpu.hand.get(i).getValue() + " of " + cpu.hand.get(i).getSuit() + "\n");
                    }
                }

            if(cpu.getBestNumericalHandValue() < 17)
            {
                System.out.println("Dealing...");
                cpu.hand.add(deck.dealCard());
            }
            else if(cpu.getBestNumericalHandValue() > 21)
            {
                System.out.println("CPU Bust!");
                System.out.print("CPUs final hand: ");

                for(int i = 0; i < cpu.hand.size(); i++)
                {
                    if(i != cpu.hand.size() - 1)
                    {
                        System.out.print(cpu.hand.get(i).getValue() + " of " +cpu.hand.get(i).getSuit() + ", ");
                    }
                    else
                    {
                        System.out.print(cpu.hand.get(i).getValue() + " of " + cpu.hand.get(i).getSuit() + ". Totals: ");
                    }
                }
                System.out.println(cpu.getBestNumericalHandValue());
                cpuTurnOver = true;
            }
            else
            {
                System.out.println("CPUs turn over!");

                System.out.print("CPUs final hand: ");

                for(int i = 0; i < cpu.hand.size(); i++)
                {
                    if(i != cpu.hand.size() - 1)
                    {
                        System.out.print(cpu.hand.get(i).getValue() + " of " +cpu.hand.get(i).getSuit() + ", ");
                    }
                    else
                    {
                        System.out.print(cpu.hand.get(i).getValue() + " of " + cpu.hand.get(i).getSuit() + ". Totals: ");
                    }
                }
                System.out.println(cpu.getBestNumericalHandValue());
                cpuTurnOver = true;
            }
        }

        if(player.getBestNumericalHandValue() < 22)
        {
            if(cpu.getBestNumericalHandValue() < 22)
            {
                if(player.getBestNumericalHandValue() > cpu.getBestNumericalHandValue())
                {
                    System.out.println("You Win!");
                }
                else if(player.getBestNumericalHandValue() < cpu.getBestNumericalHandValue())
                {
                    System.out.println("CPU Wins!");
                }
                else
                {
                    System.out.println("Game is a draw!");
                }
            }
            else
            {
                System.out.println("You Win!");
            }
        }
        else
        {
            if(cpu.getBestNumericalHandValue() < 22)
            {
                System.out.println("CPU Wins");
            }
            else
            {
                System.out.println("Game is a draw");
            }
            }

            System.out.println("Play again? Yes (1) or No (2)");
            input2 = sc.nextInt();

            if(input2 == 1)
            {
                playAgain = true;
            }
            else
            {
                System.out.println("Quitting.");
                playAgain = false;
                sc.close();
            }
        }
        
    }
}
