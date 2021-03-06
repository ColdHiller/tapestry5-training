package net.atos.mm.formation.tapestry.pages;

import java.util.Random;

import org.apache.tapestry5.annotations.Property;

public class Guess
{

    /**
     * This variable is used to store in session the last message for the user
     */
	@Property
    private String message;

    /**
     * This variable is used to store the current user choice
     */
    @Property
    private int guess;

    /**
     * This variable is used to store in session the target number
     */
    private int target;

    /**
     * Used to count the user attempts
     */
    private int count;

    /**
     * Used to redirect the user after a successful hit and then display the
     * game result
     */
    private Welcome welcomePage;


    /**
     * This method must be called on action event to verify if the user has
     * clicked on the target number.
     * 
     * @param userChoice
     *            the number clicked by the user
     * @return return an instance of Welcome page if the user win the hilo, null
     *         if verification fails
     */
    private Object verifyChoice(int userChoice)
    {

	count++;

	if (userChoice == target)
	{
	    // ...
	}

	if (userChoice < target)
	{
	    message = String.format("%d is too low.", userChoice);
	} else
	{
	    message = String.format("%d is too high.", userChoice);
	}

	return null;
    }

    /**
     * This method is called by the welcome page when the user click on the hilo
     * action link. The Welcome page create a random number that the user has to
     * find.
     * 
     * @param seed
     *            the seed to initialize a random number
     */
    public void setupGame(long seed)
    {
		Random random = new Random(seed);
	
		this.count = 0;
		this.message = null;
		this.target = random.nextInt(10) + 1;
    }

}
