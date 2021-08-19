import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

  ArrayList<Pizza> menuKort = new ArrayList();

  public Menu() {
    menuKort.add(new Pizza(1, 57, "Vesuvio", "Tomat, Ost, Origano, Skinke                                    "));
    menuKort.add(new Pizza(2, 53, "Amerikaner", "Tomat, Ost, Oksefars, Oregano                               "));
    menuKort.add(new Pizza(3, 57, "Cacciatore", "Tomat, Ost, Pepperoni, Oregano                              "));
    menuKort.add(new Pizza(4, 63, "Carbona", "Tomat, Ost, Kødsovs, Spagetti, Pølser, Oregano                 "));
    menuKort.add(new Pizza(5, 65, "Dennis", "Tomat, Ost, Skinke, Pepperoni, Pølser, Oregano                  "));
    menuKort.add(new Pizza(6, 57, "Bertil", "Tomat, Ost, Skinke, Bacon, Oregano                              "));
    menuKort.add(new Pizza(7, 61, "Silvia", "Tomat, Ost, Pepperoni, Rød peber, Løg, Oliven, Oregano          "));
    menuKort.add(new Pizza(8, 61, "Victoria", "Tomat, Ost, Skinke, Ananas, Champignon, Løg, Oregano          "));
    menuKort.add(new Pizza(9, 61, "Toronfo", "Tomat, Ost, Skinke, Bacon, Kebab, Chili, Oregano               "));
    menuKort.add(new Pizza(10, 61, "Capricciosa", "Tomat, Ost, Skinke, Champignon, Oregano                   "));
    menuKort.add(new Pizza(11, 61, "Hawaii", "Tomat, Ost, Skinke, Ananas, Oregano                            "));
    menuKort.add(new Pizza(12, 61, "Le Blissola", "Tomat, Ost, Skinke, Rejer, Oregano                        "));
    menuKort.add(new Pizza(13, 61, "Venezia", "Tomat, Ost, Skinke, Bacon, Oregano                            "));
    menuKort.add(new Pizza(14, 61, "Mafia", "Tomat, Ost, Pepperoni, Bacon, Løg, Oregano                      "));
    menuKort.add(new Pizza(15, 63, "Browser", "Tomat, Ost, Kødboller, Chili, Jalapenos, Oregano              "));
    menuKort.add(new Pizza(16, 67, "Luigi", "Tomat, Ost, Kylling, Pesto, Oregano                             "));
    menuKort.add(new Pizza(17, 63, "Yoshi", "Tomat, Ost, Kødsovs, Løg, Oregano                               "));
    menuKort.add(new Pizza(18, 57, "Mario", "Tomat, Ost, Oregano                                             "));
    menuKort.add(new Pizza(19, 57, "Peach", "Tomat, Ost, Ananas, Løg, Pesto, Oregano                         "));
    menuKort.add(new Pizza(20, 57, "Daisy", "Tomat, Ost, Kødstrimler, Grøn Peber, Oregano                    "));
    menuKort.add(new Pizza(21, 63, "Mirage", "Tomat, Ost, Salat, Kebab, Tomat, Dressing, Oregano             "));
    menuKort.add(new Pizza(22, 63, "Vertigo", "Tomat, Ost, Rucola, Kebab, Pesto, Oregano                     "));
    menuKort.add(new Pizza(23, 63, "Inferno", "Tomat, Ost, Jalapeno, 2 Slags Chili, Kylling, Oregano         "));
    menuKort.add(new Pizza(24, 63, "Overpass", "Tomat, Ost, Gorgonzola, Parmaskinke, Rucola, Pesto, Oregano  "));
    menuKort.add(new Pizza(25, 67, "Cache", "Tomat, Ost, Kødstrimler, Champignon, Gorgonzola, Oregano        "));
    menuKort.add(new Pizza(26, 67, "Vegetar", "Tomat, Ost, Paprika, Løg, Ananas, Champignon, Oliven, Oregano "));
    menuKort.add(new Pizza(27, 65, "Train", "Tomat, Ost, Tomat, Kylling, Pesto, Oregano                      "));
    menuKort.add(new Pizza(28, 65, "Han Solo", "Tomat, Ost, Skinke, Kebab, Bearnaise, Oregano                "));
    menuKort.add(new Pizza(29, 65, "Yoda", "Tomat, Ost, Skinke, Bacon, Æg, Oregano                           "));
    menuKort.add(new Pizza(30, 61, "Mando", "Tomat, Ost, Pepperoni, Løg, Dressing, Oregano                   "));
  }

  public void udskrivMenu() {

    System.out.println("Menu:");
    for (int i = 0; i < menuKort.size(); i++) {
      System.out.println(menuKort.get(i));
    }
  }


  public Pizza getPizza(int pizzaNummer) {
    return menuKort.get(pizzaNummer - 1);
  }
}