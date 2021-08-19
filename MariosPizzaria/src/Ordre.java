import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ordre {
  static int ordreCount = 0;

  int ordrerNummer = 0;
  int pris = 0;
  private LocalDateTime leveringsTidspunkt;
  DateTimeFormatter tidsformat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
  Scanner input = new Scanner(System.in);

  Ordrebehandling ordrebehandling = new Ordrebehandling();
  ArrayList<Pizza> valgtePizzaer = new ArrayList<>();

  File displayOrdreMario = new File("Mariotext.txt");
  PrintStream marioListe = new PrintStream(new FileOutputStream("src/Mariotext.txt", true));
  ArrayList mariosOrdrer = new ArrayList();

  public Ordre(int ordrerNummer, ArrayList<Pizza> valgtePizzaer) throws FileNotFoundException {
    this.ordrerNummer = ordrerNummer;
    this.valgtePizzaer = valgtePizzaer;
  }

  public Ordre(int ordrerNummer, ArrayList<Pizza> valgtePizzaer, boolean ringende, int pris) throws FileNotFoundException {
    this.ordrerNummer = ordrerNummer;
    this.valgtePizzaer = valgtePizzaer;
    this.pris = pris;
    leveringsTidspunkt = tilberedelsestid(ringende);
  }


  public void lavOrdre() throws FileNotFoundException {

    System.out.println("Ringer kunden ind eller kommer kunden ind fra gaden? Tryk 1 for ringende, 2 for gående");

    while (!input.hasNextInt()) {
      System.out.print("Indtast gyldigt tal (1 eller 2): ");
      input.nextLine();
    }

    int choice = input.nextInt();
    input.nextLine(); //scanner bug

    switch (choice) {
      case 1:
        opretOrdre(true);
        break;
      case 2:
        opretOrdre(false);
        break;
    }
  }

  public void opretOrdre(boolean ringende) throws FileNotFoundException {
    ordreCount++;
    ArrayList<Pizza> gaaendePizzaer = ordrebehandling.pizzaValg(); //går ind i pizzaValg-metoden i ordrebehandlings-klassen
    pris = ordrebehandling.totalPris(gaaendePizzaer);
    Ordre ordre = new Ordre(ordreCount, gaaendePizzaer, ringende, pris);
    System.out.println("Ordrenummer: " + ordre.ordrerNummer);

    OrdreListeMario();

    SystemStart.ordreListe.add(ordre);
  }


  public void OrdreListeMario() throws FileNotFoundException {

    marioListe.println("Ordre NR: " + (ordrerNummer - 1));

    marioListe.println("\nHej Mario\nDer er kommet en nye ordre og du skal lave disse pizzaer:\n");
    for (int i = 0; i < ordrebehandling.getPizzaListe().size(); i++) {
      marioListe.println(ordrebehandling.getPizzaListe().get(i).toString().replace("[", "").replace("]", ""));

    }
    marioListe.println("\nOrdren blev modtaget: " + ordrebehandling.getSalgsTidspunkt());
    marioListe.println("\nRåb til Alfonso, når ordren er lavet\n\n");
    marioListe.println("======================================================================================================================");
  }

  public LocalDateTime tilberedelsestid(boolean ringende) {
    LocalDateTime temp = LocalDateTime.now();

    if (ringende) {
      return temp.plusMinutes(50);
    } else {
      return temp.plusMinutes(10);
    }
  }


  @Override
  public String toString() {
    return "\nOrdrenummer: " + ordrerNummer +
        "\nAntal pizzaer " + valgtePizzaer.size() +
        "\nValgte pizzaer " + valgtePizzaer.toString() +
        "\nPris: " + pris +
        "\nLeveringstidspunkt: " + leveringsTidspunkt.format(tidsformat) +
        "\n\n";
  }
}


