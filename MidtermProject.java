import java.util.Scanner;
public class MidtermProject
{
    public static boolean isClassValid(char a){
        if (a == 'W' || a == 'S' || a == 'R' || a == 'B'){
            return true;
        }
        return false;
    }

    /*public static char playerChoice(char choice, int maxHealth, int attackDamage) //Need to pass player health, monster health, player dmg, and monster dmg in here as well
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
    }*/

    public static void printVitals(int playerHealth, int playerMana, Monster enemy){
        System.out.printf("You currently have %d health remaining, and %d mana remaining!%n",playerHealth,playerMana);
        System.out.printf("%s currently has %d health remaining!%n",enemy.name,enemy.currentHealth);
    }
    
    public static int chooseBattleOption(Player user, Monster enemy, Scanner input, int playerMana){
        System.out.println("What will you do?");
        System.out.println("Options: Attack, Magic");
        String playerBattleOption = input.nextLine();
        while (!playerBattleOption.equalsIgnoreCase("attack") && !playerBattleOption.equalsIgnoreCase("magic")){
            System.out.println("Invalid Input.");
            playerBattleOption = input.nextLine();
        }
        if (playerBattleOption.equalsIgnoreCase("attack")){
            user.attack(enemy);
            System.out.printf("You strike %s for %d damage!%n",enemy.getName(),user.getAttackDamage());
        }
        if (playerBattleOption.equalsIgnoreCase("magic")){
            if (playerMana > 14){
                user.magic(enemy);
                System.out.printf("You magically strike %s for %d damage!%n",enemy.getName(),user.getMagicDamage());
                return 15; // Mana spent for ability. TODO: Build magic into player?
            } else {
                System.out.println("The magic fizzles. Your mana supply is dry. (15 Mana required for Magic)");
            }
        }
        return 0;
    }

    public static boolean doBattle(Player user, Monster enemy, Scanner input){
        int playerHealth = user.getMaxHealth();
        int playerMana = user.getMaxMana();
        System.out.printf("%s approaches!%n",enemy.name);
        while (playerHealth > 0 && enemy.currentHealth > 0){
            playerHealth += user.getHPRegen();
            playerMana += user.getManaRegen();
            if (playerHealth > user.getMaxHealth()){
                playerHealth = user.getMaxHealth();
            }
            if (playerMana > user.getMaxMana()){
                playerMana = user.getMaxMana();
            }
            
            printVitals(playerHealth,playerMana,enemy);
            
            playerMana -= chooseBattleOption(user,enemy, input, playerMana);
            System.out.printf("%s attacks you for %d damage!%n",enemy.getName(),enemy.getAttackDamage());
            playerHealth -= enemy.getAttackDamage();
        }
        if (playerHealth <= 0 && enemy.currentHealth <= 0){
            System.out.println("Using the last bit of your energy, you strike down your foe!");
            return true;
        }
        if (playerHealth >= 0){
            return true;
        }
        return false;
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
        Monster goblin = new Monster(15,3,"Boblin the Goblin");
        Monster orc = new Monster(25,5,"Gork the Orc");
        Monster minotaur = new Monster(30,7,"Midas the Minotaur");
        
        if (doBattle(user,goblin,input)){
            System.out.printf("You win!! Now for your next opponent...%n%n");
        } else {
            System.out.println("You die.. :(");
            input.close();
            return;
        }
        
        if (doBattle(user,orc,input)){
            System.out.printf("You win!! Now for your next opponent...%n%n");
        } else {
            System.out.println("You die.. :(");
            input.close();
            return;
        }
        
        if (doBattle(user,minotaur,input)){
            System.out.printf("YOU ARE WINNER!! CONGRATULATION!!");
        } else {
            System.out.println("You die.. And so close, too! Try again?");
            input.close();
            return;
        }
        
        input.close();
    }
}