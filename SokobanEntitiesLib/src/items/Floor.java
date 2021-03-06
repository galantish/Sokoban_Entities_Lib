package items;

/**
 * The Class Floor - an item in the game. 
 */
@SuppressWarnings("serial")
public class Floor extends CommonItems implements iUnmoveable
{
	public Floor() 
	{
		super.setRepChar(' ');
	}

	public Floor(Position position)
	{
		super.setRepChar(' ');
		super.setPosition(position);
	}
	
	@Override
	public char getTypeOfObject() 
	{
		return ' ';
	}
}
