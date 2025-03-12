import java.util.ArrayList;

public class Togvogn {
    private int vognnummer;
    private Togvogn vognenBagved;
    private ArrayList<Sæde> sæder;

    public Togvogn(int vognnummer, ArrayList<Sæde> sæder) {
        this.vognnummer = vognnummer;
        this.sæder = sæder;
    }

    public Togvogn getVognenBagved() {
        return vognenBagved;
    }

    public void setVognenBagved(Togvogn vognenBagved) {
        this.vognenBagved = vognenBagved;
    }


    public Taske kigEfterTaske(String taskenHunLederEfter) {// søger efter beskrivelse på taske
        Taske fundetTaske = null;
        for (Sæde sæde : sæder) {
            if (sæde.getTaske() != null && sæde.getTaske().getBeskrivelse().equalsIgnoreCase(taskenHunLederEfter)) {
                fundetTaske = sæde.getTaske();
            }
        }
        return fundetTaske;
    }

    public int getVognnummer() {
        return vognnummer;
    }

    public String hvilkeTaskerErIVognen() {
        String result = "";
        for (Sæde sæde : sæder) { //Iterate gennem sæder i vognen
            if (sæde.getTaske() != null) { //Hvis ikke tom:
                result += sæde.getTaske().toString() + "\n"; //tilføj taske-streng til result
            }
        }
        if (result.isEmpty()) {
            result = "ingen glemte tasker i vognen";
        }
        return result;
    }
}
