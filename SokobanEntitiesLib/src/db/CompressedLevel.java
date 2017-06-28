package db;

import java.io.Serializable;
import java.util.HashMap;
import items.MovableFactory;
import items.Player;
import items.Position;
import items.Target;
import items.UnmovableFactory;
import items.iMoveable;
import items.iUnmoveable;

@SuppressWarnings("serial")
public class CompressedLevel implements Serializable
{
	/** The chars and type of object list */
	private HashMap<Character, String> hashMapTypes;
	private char[][] levelBoard;
	private String levelID;
	
	public CompressedLevel()
	{
		this.levelBoard = null;
		initHashMapTypes();
	}
	
	public CompressedLevel(String levelID, char[][] levelBoard)
	{
		this.levelID = levelID;
		this.levelBoard = levelBoard;
		initHashMapTypes();
	}

	public void initHashMapTypes()
	{
		this.hashMapTypes = new HashMap<Character, String>();
		this.hashMapTypes.put('A', "movable");
		this.hashMapTypes.put('@', "movable");
		this.hashMapTypes.put('o', "unmovable");
		this.hashMapTypes.put('#', "unmovable");
		this.hashMapTypes.put(' ', "unmovable");
	}
	
	public Level deCompressedLevel()
	{
		if(this.levelBoard == null)
			return null;
		
		int row = this.levelBoard.length;
		int col = this.levelBoard[0].length;
		
		//Creating 2 factories for movable and unmovable item
		MovableFactory movFactory = new MovableFactory();
		UnmovableFactory unmovFactory = new UnmovableFactory();
		
		//Creating a new level with the row and column we found earlier
		Level level = new Level(row, col, this.levelID);
		
		//Initializing the 2D array from chars to objects
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				//Using this method that returns the type of the item
				switch (this.hashMapTypes.get(levelBoard[i][j]))
				{
					case "movable":
						
						//Creating a movable item and sets the position
						iMoveable mov = movFactory.CreateMovable(levelBoard[i][j], new Position(i,j));
						
						//Inserts the movable item to the 2D array list (Level Class)
						level.setMovableItemInIndex(mov);
						
						//Adding the item to the fitting array list
						if(mov instanceof Player)
							level.addPlayerToPlayers(mov);
						else
							level.addBoxToBoxes(mov);
					break;
					
					case "unmovable":
						
						//Creating an unmovable item and sets the position
						iUnmoveable unmov = unmovFactory.CreateUnmovable(levelBoard[i][j], new Position(i, j));
						
						//Inserts the unmovable item to the 2D array list (Level Class)
						level.setUnmovableItemsInIndex(unmov);
						
						//Adding the item to the Targers arraylist if it is a type of target
						if(unmov instanceof Target)
							level.addTargetToTargets(unmov);
					break;
					
					default:
						break;
				}
			}
		}	
		
		return level;
	}
	
	public char[][] getLevelBoard()
	{
		return levelBoard;
	}

	public void setLevelBoard(char[][] levelBoard)
	{
		this.levelBoard = levelBoard;
	}

	public String getLevelID()
	{
		return levelID;
	}

	public void setLevelID(String levelID)
	{
		this.levelID = levelID;
	}

	public HashMap<Character, String> getHashMapTypes()
	{
		return hashMapTypes;
	}

	public void setHashMapTypes(HashMap<Character, String> hashMapTypes)
	{
		this.hashMapTypes = hashMapTypes;
	}
	
	
}