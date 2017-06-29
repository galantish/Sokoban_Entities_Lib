package db;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="LevelSolutionData")
public class LevelSolutionData  {
	
	@Column(name="LevelId")
	@Id
	String levelId;
	
	@Column(name="Solution")
	String solution;
	
	@Column(name="Board")
	String board;
	
	public LevelSolutionData() {
	}
	
	public LevelSolutionData(String  id, String solution, String board) {
		this.levelId = id;
		this.solution= solution;
		this.board = board;
	}
	
	
	public String getLevelId() {
		return levelId;
	}

	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}

	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	
	@Override
	public String toString() {
		return "LevelSolutionData [LevelId=" + levelId +"\n solution=" + solution + "\n board=" + board +"]";
	}

}
