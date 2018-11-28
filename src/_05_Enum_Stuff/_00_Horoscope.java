package _05_Enum_Stuff;

public class _00_Horoscope {
	// 1. Create an enum in a separate file called Zodiac that contains a category
	// for
	// all 12 zodiac signs.

	// 2. Write a method that takes in a Zodiac enum object and uses a JOPtionPane
	// to display
	// a different horoscope based on the Zodiac's state.
	static void horoscope(Zodiac z) {
		switch (z) {
		case ARIES:
			System.out.println("You are ARIES");
			break;
		case TAURUS:
			System.out.println("You are TAURUS");
			break;
		case GEMINI:
			System.out.println("You are GEMINI");
			break;
		case CANCER:
			System.out.println("You are CANCER");
			break;
		case LEO:
			System.out.println("You are LEO");
			break;
		case VIRGO:
			System.out.println("You are VIRGO");
			break;
		case LIBRA:
			System.out.println("You are LIBRA");
			break;
		case SCORPIO:
			System.out.println("You are SCORPIO");
			break;
		case SAGITTARIUS:
			System.out.println("You are SAGITTARIUS");
			break;
		case CAPRICORN:
			System.out.println("You are CAPRICORN");
			break;
		case AQUARIUS:
			System.out.println("You are AQUARIUS");
			break;
		case PISCES:
			System.out.println("You are PISCES");
			break;
		}

	}

	// 3. Make a main method to test your method
	public static void main(String[] args) {
		Zodiac z1 = Zodiac.ARIES;
		horoscope(z1);
		Zodiac z2 = Zodiac.TAURUS;
		horoscope(z2);
		Zodiac z3 = Zodiac.GEMINI;
		horoscope(z3);
		Zodiac z4 = Zodiac.CANCER;
		horoscope(z4);
		Zodiac z5 = Zodiac.LEO;
		horoscope(z5);
		Zodiac z6 = Zodiac.VIRGO;
		horoscope(z6);
		Zodiac z7 = Zodiac.LIBRA;
		horoscope(z7);
		Zodiac z8 = Zodiac.SCORPIO;
		horoscope(z8);
		Zodiac z9 = Zodiac.SAGITTARIUS;
		horoscope(z9);
		Zodiac z10 = Zodiac.CAPRICORN;
		horoscope(z10);
		Zodiac z11 = Zodiac.AQUARIUS;
		horoscope(z11);
		Zodiac z12 = Zodiac.PISCES;
		horoscope(z12);
	}
}
