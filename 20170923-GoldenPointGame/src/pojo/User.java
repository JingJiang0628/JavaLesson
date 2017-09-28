package pojo;

public class User {
	private int gameNumber;
	private String userName;
	private String password;
	private int score=0;
	
	public User(){
		
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public int getGameNumber() {
//		System.out.println("getNum---"+gameNumber);
		return gameNumber;
	}

	public void setGameNumber(int gameNumber) {
//		System.out.println("setNum---"+gameNumber);
		this.gameNumber = gameNumber;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
}
