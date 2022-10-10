
public class Hase extends Pflanzenfresser {
  private double ohrenlaenge;

  public Hase(String name, double gewicht, boolean lebendig, String lieblingsPflanze, double ohrenlaenge, Zoo zoo) {
        super(name, gewicht, lebendig, lieblingsPflanze, zoo);
        this.ohrenlaenge = ohrenlaenge;
  }

  public double getOhrenlaenge() {
 return ohrenlaenge;
  }

}
