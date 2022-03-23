package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 * 
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public abstract class Player {

	protected GroupOfCards hand;
	protected int money;
	protected String name;

	/**
	 * A constructor that allows you to set the player's unique ID
	 * @param name the unique ID to assign to this player.
	 */
	public Player(String name) {

            
	}

	public void split() {
		// TODO - implement Player.split
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param bet
	 */
	public void hit(int bet) {
		// TODO - implement Player.hit
		throw new UnsupportedOperationException();
	}

	public void stand() {
		// TODO - implement Player.stand
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param bet
	 */
	public void doubleDown(int bet) {
		// TODO - implement Player.doubleDown
		throw new UnsupportedOperationException();
	}

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

	public int getMoney() {
		return this.money;
	}

	/**
	 * 
	 * @param money
	 */
	public void setMoney(int money) {
		this.money = money;
	}

}