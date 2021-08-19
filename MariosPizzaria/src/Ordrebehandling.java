import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ordrebehandling {

  private Menu menu = new Menu();
  private int subTotal;
  private final LocalDateTime salgsTidspunkt = LocalDateTime.now();
  private ArrayList<Pizza> pizzaListe = new ArrayList<>();

  DateTimeFormatter tidsformat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

  public ArrayList<Pizza> getPizzaListe() {
    return pizzaListe;
  }

  public LocalDateTime getSalgsTidspunkt() {
    return salgsTidspunkt;
  }

  public int totalPris(ArrayList<Pizza> pizza) {
    int subTotal = 0;
    for (int i = 0; i < pizza.size(); i++) {
      subTotal += pizza.get(i).getPris(); //subtotal = subtotal + getPris
    }
    return subTotal;
  }

  @Override
  public String toString() {
    return "\n" +
        "--------------------------------" +
        "\nKvittering\n" +
        "Antal pizzaer: " + pizzaListe.size() +
        "\nPris: " + totalPris(pizzaListe) +
        "kr." +
        "\nSalgstidspunkt: " + salgsTidspunkt.format(tidsformat) +
        "\n--------------------------------";
  }

  public ArrayList<Pizza> pizzaValg() {

    Scanner scan = new Scanner(System.in);
    pizzaListe.clear(); //rydder ArrayListen hver gang en ny kunde bestiller, så pizzaListe kun indeholder én kundes ordre

    System.out.println("Hvor mange pizzaer vil du bestille?");
    while (!scan.hasNextInt()) {
      System.out.print("Indtast gyldigt tal: ");
      scan.nextLine();
    }
    int antalPizza = scan.nextInt();
    scan.nextLine();

    if (antalPizza < 1) {
      System.out.println("Indtast gyldigt valg, prøv igen: \n");
      pizzaValg();
    }


    for (int i = 0; i < antalPizza; i++) {
      System.out.println("\nAlfonso indtaster ordre her: ");

      while (!scan.hasNextInt()) {
        System.out.print("Indtast gyldigt valg, 1-30. Prøv igen: "); //udskriver den her 2 gange, hvorfor?
        scan.nextLine();
      }
      int valg = scan.nextInt();

      if (valg < 1 || valg > menu.menuKort.size()) {
        System.out.println("Indtast gyldigt valg, 1-30. Prøv igen: ");
        pizzaValg();
      } else {

        System.out.println("Du har valgt: \n" + menu.getPizza(valg));
        Pizza pizza = menu.getPizza(valg);
        pizzaListe.add(pizza);
      }
    }

    System.out.println(toString());
    return pizzaListe;
  }
}