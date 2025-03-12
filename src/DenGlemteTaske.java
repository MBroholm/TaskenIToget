import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class DenGlemteTaske {
    public void startEftersøgning() {
        Tog tog = new Tog();
        Togvogn denFørsteVogn = tog.getDenFørsteVogn();

        Mille mille = new Mille(denFørsteVogn);
        boolean taskenErFundet = false;
        String taskenHunLederEfter = "Fjellræv";
        System.out.println("Mille har glemt sin taske i toget. Toget holder nu ved endestationen og hun er gået ind i første vogn for at lede efter den.");
        System.out.println("Du kan hjælpe hende med at lede efter tasken ved at bruge nogle simple kommandoer:");
        System.out.println("Skriv HVOR for at finde ud af hvor Mille er, KIG for at få hende til at se efter tasken,og VIDERE for at få hende til at gå ind i den næste vogn");

        while (!taskenErFundet) {
            Scanner input = new Scanner(System.in);
            String kommando = input.next();

            switch (kommando) {
                case "HVOR" -> {
                    System.out.println("Hej Mille! Hvor er du nu?");
                    System.out.println("Jeg er i vogn nummer " + mille.hvorErDu());
                }
                case "KIG" -> {
                    System.out.println("Kan du se om tasken er der?");
                    if (mille.erTaskenDer(taskenHunLederEfter)) {
                        System.out.println("Ja, jeg fandt den!");
                        taskenErFundet = true;
                    } else {
                        System.out.println("Nej, desværre, den var ikke i den her vogn.");
                        System.out.println("Her er " + mille.kanDuSeNogenTasker());
                    }

                }
                case "VIDERE" -> {
                    System.out.println("Du må hellere prøve at kigge i den næste vogn...");
                    System.out.println("Ja, det vil jeg gøre. Så håber jeg virkelig at den er dér.");
                    mille.gåIndINæsteVogn();
                }
            }
        }

    }

}
