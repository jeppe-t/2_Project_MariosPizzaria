public class Pizza {
  private int nummer;
  private String navn;
  private int pris;
  private String ingredienser;


  public Pizza(int nummer, int pris, String navn, String ingredienser) {
    this.nummer = nummer;
    this.navn = navn;
    this.pris = pris;
    this.ingredienser = ingredienser;
  }


  public int getPris() {
    return pris;
  }

  @Override
  public String toString() {
    return "Pizza: " +
        "Nr. " + nummer +
        ", " + navn +
        ": " + ingredienser;
  }
}
