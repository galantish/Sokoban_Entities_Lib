package items;

/**
 * The Class Wall  - an item in the game. 
 */
@SuppressWarnings("serial")
public class Wall extends CommonItems implements iUnmoveable
{
	public Wall() 
	{
		super.setRepChar('#');
	}
	
	public Wall(Position position)
	{
		super.setRepChar('#');
		super.setPosition(position);
	}

	@Override
	public char getTypeOfObject() 
	{
		return '#';
	}
}
