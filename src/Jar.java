import java.util.Scanner;
import java.util.Random;

public class Jar {

	public int mAmountInJar;
	private Game mGame; // create a object variable
	public int guessAsInt;
	public int maxTreats;

	public Jar(Game game) { // passing in a Game Object

		mGame = game;

	}

	public void play() {

		while (!promptForGuess()) {

			promptForGuess();

		}

	}

	public String promptTreatNameForAdmin() {

		// Console console = System.console(); //for teamtreehouse console
		Scanner scanner = new Scanner(System.in); // For eclipse
		System.out.println("What type of treats do you want in Your JAR?" + "\n");
		// String guessAsString = console.readLine("Enter a Letter::");
		String treatName = scanner.next();

		return treatName;

	}

	public int promptTreatSizeForAdmin() {

		// Console console = System.console();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Whats the max number of treats the Jar can Hold?" + "\n");
		// String guessAsString = console.readLine("Enter a Letter::");
		maxTreats = scanner.nextInt();

		return maxTreats;

	}

	// fills the jar
	public void fill(int maxTreats) {

		// add random stuff here

		Random random = new Random();
		int maxItemsAllowed = maxTreats;
		int randomNumber = random.nextInt(maxItemsAllowed);
		System.out.println("Cool the Jar has Treats in it now so time to guess:");
		Game game = new Game(randomNumber);

	}

	public boolean promptForGuess() {

		// Console console = System.console();
		Scanner scanner = new Scanner(System.in);
		boolean isHit = false;
		boolean isValidGuess = false;

		while (!isValidGuess) { // keep prompting
			System.out.println("\n" + "Type in your guess?:");
			// String guessAsString = console.readLine("Enter a Letter::");
			guessAsInt = scanner.nextInt();
			if (maxTreats < guessAsInt) {

				System.out.println("Sorry !!!!!! Number to large Try Smaller number:");

			} else {

				try {

					isHit = mGame.checkGuess(guessAsInt);

					displayProgress();

					isValidGuess = true;

				} catch (IllegalArgumentException iae) {

					System.out.println("Please try again");

				}

			}

		}

		return isHit;

	}

	private boolean applyGuess(String guessAsString) {

		return false;
		// TODO Auto-generated method stub

	}

	public void displayProgress() {
		System.out.printf("you have tryed %d tries to solve ", mGame.getTries()

		);

	}

}
