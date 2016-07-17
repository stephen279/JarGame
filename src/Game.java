import java.util.Random;

public class Game {

	public static String mTreatName;
	public static int mMaxTreat;
	public int mAnswer;
	public String mHits;
	public int mMisses;

	public Game() {

	}

	public Game(int answer) {

		mAnswer = answer;
		mTreatName = "";
		mMaxTreat = 100; // initialise to 100 until jar fill method is called.

	}

	public int getAnswer() {

		return mAnswer;

	}

	public boolean checkGuess(int guessAsInt) {
		// TODO Auto-generated method stub

		if (guessAsInt == getAnswer()) {
			System.out.println("That guess is  right :) ");

			isSolved();
			return true;

		} else {

			System.out.println("Sorry Wrong number!!!!!! try another Guess: ");
			return false;

		}

	}

	public boolean isSolved() {

		System.out.println("SOLVED DONT EAT ALL THEM TREATS AT ONCE !!!! ");

		// TODO Auto-generated method stub
		return false;

	}

	public int getTries() {
		// TODO Auto-generated method stub

		mMisses = mMisses + 1;

		return mMisses;
	}

	public static int randomNumTreat() {

		Random random = new Random();
		int randomNumber = random.nextInt(5);
		return randomNumber;

	}

	public static void main(String[] args) {

		// Your code here
		System.out.println("----------ADMIN---------------------");
		Game game = new Game(randomNumTreat());
		Jar jarObject = new Jar(game);
		mTreatName = jarObject.promptTreatNameForAdmin();
		mMaxTreat = jarObject.promptTreatSizeForAdmin();

		System.out.println("---------------USER-----------------");

		jarObject.fill(mMaxTreat);

		jarObject.play();

	}

}