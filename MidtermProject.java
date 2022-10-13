import java.util.Scanner;
public class MidtermProject
{
    public static boolean isClassValid(char a){
        if (a == 'W' || a == 'S' || a == 'R' || a == 'B'){
            return true;
        }
        return false;
    }
    
    public static char playerChoice(char choice, int maxHealth, int attackDamage) //Need to pass player health, monster health, player dmg, and monster dmg in here as well
    {
        int doBattle; 
        System.out.println("You encounter a creature before you and you go in and attack.");
        while(maxHealth > 0 && monsterHealth > 0)
        {
            int playerTakenBattleDmg = maxHealth - monsterDamage;
            int monsterTakenBattleDmg = monsterHealth - attackDamage;
            
            if (maxHealth < 0 || monsterHealth < 0)
            {
                String battle = "over";
            }
            
            System.out.printf("After taking an attack, your current health is %d %n", playerTakenBattleDmg);
        }
    }
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Hello and welcome to our game! Please enter your name");
        String name = input.nextLine();

        System.out.println("Pick a class from among the ones available: " + "\nWizard (W), Swordsman (S), Rogue (R), or Bard (B)");
        char pickClass = input.next().charAt(0);
        while (!isClassValid(pickClass)){
            System.out.println("Invalid class selection. Please select an available class.");
            pickClass = input.next().charAt(0);
        }
        Player user = new Player(pickClass);
        //Monster goblin = new Monster(10,3);
        
        input.close();
    }
}