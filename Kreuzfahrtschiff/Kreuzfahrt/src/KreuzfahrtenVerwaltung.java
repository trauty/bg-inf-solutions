import java.util.ArrayList;

public class KreuzfahrtenVerwaltung
{
    public void belegeKabinen(Kreuzfahrt fahrt)
    {
        ArrayList<Buchung> tempBuchungen = fahrt.getBuchungen();

        for (int i = 0; i < tempBuchungen.size(); i++)
        {
            Buchung tempBuchung = tempBuchungen.get(i);
            ArrayList<Passagier> tempPass = tempBuchung.getPassagiere();
            for (int j = 0; j < tempPass.size(); j++)
            {
                Kabine derzKab = fahrt.getKreuzfahrtschiff().sucheFreieKabine(tempBuchung.getKategorie());
                if (derzKab != null)
                {
                    if (derzKab.getBewohner()[0] == null)
                    {
                        if (j == tempPass.size() - 1)
                        {
                            derzKab.belegeKabine(new Passagier[] { tempPass.get(j) });
                        }
                        else
                        {
                            derzKab.belegeKabine(new Passagier[] { tempPass.get(j), tempPass.get(j + 1) });
                            j++;
                        }
                    }
                }
            }
        }
    }
}
