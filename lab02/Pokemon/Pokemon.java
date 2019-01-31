public class Pokemon {
  // instance variables
  public String name;
  public int level;

  // constructor
  public Pokemon(String name, int level) {
    this.name = name;
    this.level = level;
  }

  // class method
  public static void change(Pokemon poke, int level) {
    poke.level = level; // public setter
    level = 50;
    poke = new Pokemon("Genger", 1);
  }

  public static void main(String[] args) {
    Pokemon p = new Pokemon("Pikachu", 17);
    int level = 100;
    change(p, level);
    System.out.println("Name: " + p.name + ", Level: " + p.level);
  }
}
