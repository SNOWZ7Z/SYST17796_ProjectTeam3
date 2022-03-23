package ca.sheridancollege.project;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 * 
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public abstract class Game {

	private Dealer dealer;
	private String name;
	private Player player;
	private Boolean running;

	/**
	 * the players of the game
	 * @param name
	 */
	public Game(String name) {
		// TODO - implement Game.Game
		throw new UnsupportedOperationException();
	}

	/**
	 * Play the game. This might be one method or many method calls depending on your game.
	 */
	public abstract void play();

	/**
	 * When the game is over, use this method to declare and display a winning player.
	 */
	public abstract void declareWinner();

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Player getPlayers() {
		// TODO - implement Game.getPlayers
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param players
	 */
	public void setPlayers(Player players) {
		// TODO - implement Game.setPlayers
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param player
	 */
	public void makeLooser(Player player) {
		// TODO - implement Game.makeLooser
		throw new UnsupportedOperationException();
	}

}