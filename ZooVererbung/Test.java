public class Test{
    public static void main (String[] args) {
	Zoo z1 = new Zoo("Koeln");
	Zoo z2 = new Zoo("Berlin");
	Wolf lupo1 = new Wolf("Lupo1", 80.0, true, z1);
	Wolf lupo2 = new Wolf("Lupo2", 65.5, true, z1);
	Hase bunny = new Hase("Bunny", 7.8, true, "Karotten", 5.2, z2);
	Hase hasi  = new Hase("Hasi", 5.0, false, "Salat", 4.1, z1);
	Reh bambi  = new Reh("Bambi",25.0, true, "Gras", true, z1);
	Hyaene shenzi = new Hyaene("Shenzi", 50, true, z1);

	System.out.println (z2.toString());
	System.out.println (z1.toString());
	lupo1.friss(lupo1);
	lupo1.erlege(bambi);
	System.out.println (z1.toString());
	lupo1.friss(bambi);
	System.out.println (z1.toString());
	System.out.println ("Der Mageninhalt von "
			    + lupo1.getName()
			    + " ist: "
			    + lupo1.magenInhalt());
	lupo1.erlege(hasi);
	lupo1.friss(hasi);
	lupo1.erlege(lupo2);
	lupo1.friss(lupo2);
	System.out.println ("Jetzt ist der Mageninhalt von "
			    + lupo1.getName()
			    + ": "
			    + lupo1.magenInhalt());
	lupo2.friss(bunny);
	lupo1.erlege(lupo1);
	System.out.println (z1.toString());
    }
}
