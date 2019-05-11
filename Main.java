import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;
class Samochod {
    String marka, model, kolor, rocznik_produkcji, nr_vin;//definiujemy jakie wartosci bedzie mial obiekt

    //ponizej funkcje wewnetrzne obiektu (dodawanie i usuwanie pojazdow)
    public static void dodajSamochod(ArrayList lista) {
        Samochod samochodzik = new Samochod();
        Scanner skanuj = new Scanner(System.in);
        System.out.println("Podaj marke samochodu : ");
        String marka = skanuj.nextLine();
        System.out.println("Podaj model samochodu : ");
        String model = skanuj.nextLine();
        System.out.println("Podaj rocznik produkcji samochodu : ");
        String rocznik = skanuj.nextLine();
        System.out.println("Podaj numer Vin pojazdu : ");
        String vin = skanuj.nextLine();
        System.out.println("Podaj kolor samochodu : ");
        String kolor = skanuj.nextLine();
        samochodzik.kolor = kolor;
        samochodzik.rocznik_produkcji = rocznik;
        samochodzik.marka = marka;
        samochodzik.model = model;
        samochodzik.nr_vin = vin;
        lista.add(samochodzik);
    }

    public static void usunSamochod(ArrayList<Samochod> lista1) {
        System.out.println("Ktory samochod chcesz usunac?");
        Scanner skanuj = new Scanner(System.in);
        int ktory = skanuj.nextInt();
        ktory--;
        try {
            lista1.remove(ktory);
            System.out.println("Usunieto samochod z listy.");
        }
        catch (Exception e){
            System.out.println("Cos poszlo nie tak z : "+e);
        }

    }
}


public class Main {


    public static void main(String[] args) {
        ArrayList<Samochod> lista1 = new ArrayList<Samochod>(10);//definiujemy liste (obiektow) samochodow i nadajemy jej poczatkowa wielkosc
        //ponizej wpisuje dwa samochody do listy "na sztywno"
        Samochod samochod = new Samochod();
        samochod.marka  = "Skoda";
        samochod.kolor = "Srebrny";
        samochod.model = "Octavia II";
        samochod.rocznik_produkcji = "2013";
        samochod.nr_vin = "321987637981";
        lista1.add(samochod);
        Samochod samochod2 = new Samochod();
        samochod2.nr_vin = "10983712908714";
        samochod2.rocznik_produkcji = "2001";
        samochod2.model = "Mondeo";
        samochod2.marka = "Ford";
        samochod2.kolor = "Czarny";
        lista1.add(samochod2);
        //koniec wklepywania na sztywno, reszta niech sie zajmie program. ;)

        int wyjdz = 0;//tworzymy wartosc, ktora definiuje czy petla programu ma sie zakonczyc.

        //petla programu
        while (wyjdz == 0) {

            System.out.println("Zdefiniuj co chcesz zrobic : \n1.Dodaj samochod.\n2.Wyswietl wszystkie samochody z listy.\n3.Usun samochod z listy.\n0.Wyjdz.");
            Scanner skan = new Scanner(System.in);
            int co = 0;
            try {
                 co = skan.nextInt();
            }
            catch (Exception e){
                System.out.println("Cos poszlo nie tak.. : "+ e);
            }
                switch (co) {
                    case 1:
                        Samochod.dodajSamochod(lista1);
                        break;
                    case 2:
                        wyswietlSamochody(lista1);
                        break;
                    case 3:
                        Samochod.usunSamochod(lista1);
                        break;
                    case 0:
                        wyjdz++;
                        break;
                    default:
                        System.out.println("Emm... ale ze co?");
                        break;
                }
        }
    }

    private static void wyswietlSamochody(ArrayList lista) {
        Iterator itr = lista.iterator();//Do wyswietlania zawartosci listy ArrayList najlepiej uzyc iteratora
        int i=0;//dodajemy indeks, zeby wiedziec ktory obiekt z listy jest wyswietlany
        while(itr.hasNext())
        {
            i++;
            Samochod samochod = (Samochod)itr.next();
            System.out.println("Numer na liscie : "+i+"\nNazwa marki : "+ samochod.marka + "\nNazwa modelu : " + samochod.model + "\nRocznik produkcji : " + samochod.rocznik_produkcji+ "\nKolor : " + samochod.kolor + "\nNr. vin : " + samochod.nr_vin+"\n");
        }
    }
}






