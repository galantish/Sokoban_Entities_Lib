package items;

/**
 * The Class Target - an item in the game. 
 */
@SuppressWarnings("serial")
public class Target extends Floor implements iUnmoveable
{
	public Target() 
	{
		super.setRepChar('o');
	}
	
	public Target(Position position)
	{
		super.setRepChar('o');
		super.setPosition(position);
	}

	@Override
	public char getTypeOfObject() 
	{
		return 'o';
	}
}
