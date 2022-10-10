
public class Wolf extends Fleischfresser {
  public Wolf(String name, double gewicht, boolean lebendig, Zoo zoo) {
        super(name, gewicht, lebendig, true, zoo);
  }

  public void erlege(Tier beutetier) {
        if (beutetier != this)
        {
            if (this.istLebendig())
            {
                if (beutetier.istLebendig())
                {
                    System.out.println("Erlege " + beutetier.getName());
                    beutetier.setLebendig(false);
                }
                else
                {
                    System.out.println(this.getName() + " kann kein schon totes Tier " + beutetier.getName() + " erlegen!");
                }
            }
            else
            {
                System.out.println(this.getName() + " kann nicht im toten Zustand erlegen!");
            }
        }
        else
        {
            System.out.println(this.getName() + " kann nicht sich selber erlegen!");
        }
  }

}
