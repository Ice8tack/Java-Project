import java.util.Scanner;
public class MidtermProject
{
    public static boolean isClassValid(char a){
        if (a == 'W' || a == 'S' || a == 'R' || a == 'B'){
            return true;
        }
        return false;
    }

    public static void shop(Scanner input, Player user)
    {
        int itemsLeft;
        System.out.println("You stumble across a shop after defeating that nasty Orc. \nThe shop offers multiple goods that will help you on your journey.");
        System.out.println("There's a shiny weapon lying against a wall near an armor stand, with a better looking piece of armor then you currently have equppied.");
        System.out.println("A bright blue ring is on display next to a silver necklace embedded with a sapphire.");
        System.out.println("On the wall to the right is a steel shield with a red rook as the emblem. \nNear the edge of the clerk's counter is a dusty tome, and on the other side of the counter is a potion.");
        System.out.println("You stand there in the store, wondering about the different items and their benefits."); //ADD DESCRIPTION LATER
        System.out.println("1 is for the weapon, 2 is for the armor, 3 is for the ring, 4 is for the necklace \n5 is for the shield, 6 is for the dusty tome, and 7 is for the potion.");
        
        if (user.getPlayerClass() == 'R'){
            System.out.println("You find that you have enough gold to buy 2 items, and you're able to steal a third.");
            itemsLeft = 3;
        }
        else{
            System.out.println("You find that you have enough gold to buy 2 items");
            itemsLeft = 2;
        }
        
        boolean[] items = {false, false, false, false, false, false, false};
        
        while (itemsLeft > 0){
            String itemChoice = input.nextLine();
            int itemChoiceNum = Integer.parseInt(itemChoice) - 1;
            if(items[itemChoiceNum]){
                System.out.println("Item is already gone, pick another item");
            }
            else{
                System.out.println("You have picked up the item.");
                items[itemChoiceNum] = true;
                itemsLeft -= 1;
            }
        }
        
        if(items[0]){
            user.addDMG(); //upgraded Weapon,more physical dmgn [0]
        }
        if(items[1]){
            user.addHPRegen(); //armor, more hp regen
        }
        if(items[2]){
            user.addMagicDMG(); //ring, increase mana
        }
        if(items[3]){
            user.addManaRegen(); //necklace, more mana regen
        }
        if(items[4]){
            user.addHP(); //shield, more hp
        }
        if(items[5]){
            user.addMagicDMG(); //dustyTome, more magic dmg
        }
        if(items[6]){
            user.addPotion(); //potion, add to variable potionCount + 1 [6]
        }
    }

    public static void printVitals(int playerHealth, int playerMana, Monster enemy){
        System.out.printf("You currently have %d health remaining, and %d mana remaining!%n",playerHealth,playerMana);
        System.out.printf("%s currently has %d health remaining!%n",enemy.getName(),enemy.getCurrentHealth());
    }
    
    public static void chooseBattleOption(Player user, Monster enemy, Scanner input){
        System.out.println("What will you do?");
        System.out.println("Options: Attack, Magic, Item, Quit");
        String playerBattleOption = input.nextLine();
        while (!playerBattleOption.equalsIgnoreCase("attack") && !playerBattleOption.equalsIgnoreCase("magic") && !playerBattleOption.equalsIgnoreCase("item") && !playerBattleOption.equalsIgnoreCase("quit")){
            System.out.println("Invalid Input.");
            playerBattleOption = input.nextLine();
        }
        if (playerBattleOption.equalsIgnoreCase("attack")){
            user.attack(enemy);
            System.out.printf("You strike %s for %d damage!%n",enemy.getName(),user.getAttackDamage());
        }
        if (playerBattleOption.equalsIgnoreCase("magic")){
            if (user.getCurrentMana() > 14){
                user.magic(enemy);
                System.out.printf("You magically strike %s for %d damage!%n",enemy.getName(),user.getMagicDamage());
                user.adjustMana(-15);
            } else {
                System.out.println("The magic fizzles. Your mana supply is dry. (15 Mana required for Magic)");
            }
        }
        if (playerBattleOption.equalsIgnoreCase("item")){
            user.usePotion();
        }
        if(playerBattleOption.equalsIgnoreCase("quit")){
            System.exit(0);
            System.out.print("You have quit the game. Goodbye");
        }
    }


    public static boolean doBattle(Player user, Monster enemy, Scanner input){
        user.rest();
        System.out.printf("%s approaches!%n",enemy.getName());
        while (user.getCurrentHealth() > 0 && enemy.getCurrentHealth() > 0){
            user.regenStats();
            
            printVitals(user.getCurrentHealth(),user.getCurrentMana(),enemy);
            
            //playerMana -= chooseBattleOption(user,enemy, input, playerMana);
            chooseBattleOption(user, enemy, input);
            enemy.printAttackDescription();
            System.out.printf("%s attacks you for %d damage!%n",enemy.getName(),enemy.getAttackDamage());
            user.adjustHealth(-enemy.getAttackDamage());
        }
        if (user.getCurrentHealth() <= 0 && enemy.getCurrentHealth() <= 0){
            System.out.println("Using the last bit of your energy, you strike down your foe!");
            return true;
        }
        if (user.getCurrentHealth() >= 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("They took everything, \nAnd now you are here. \nNow go there, \nThey are not your friends, \nThey are not like you.");

        System.out.println("\nWhat is your name vengeful one?");
        String name = input.nextLine();

        System.out.println("Pick a class from among the ones available: " + "\nWizard (W), Swordsman (S), Rogue (R), or Bard (B)");
        String pickClass = input.nextLine();
        pickClass = pickClass.toUpperCase();
        char classSelect = pickClass.charAt(0);
        while (!isClassValid(classSelect)){
            System.out.println("Invalid class selection. Please select an available class.");
            pickClass = input.nextLine();
            pickClass.toUpperCase();
            classSelect = pickClass.charAt(0);
        }
        Player user = new Player(classSelect);
        Monster goblin = new Monster(15,3,"Boblin the Goblin","A muttering of frustration.");
        Monster orc = new Monster(25,5,"Gork the Orc","Galumphing rage.");
        Monster minotaur = new Monster(37,8,"Midas the Minotaur","He hit you where it hurts.");
        
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
        
        System.out.println("Wait a minute, this isn't an opponent, this is a store!"); //can change this later, just wanted smth before the shop print out stuff
        shop(input, user);
        
        if (doBattle(user,minotaur,input)){
            System.out.printf("YOU ARE THE WINNER!! CONGRATULATION!!");
        } else {
            System.out.println("You die.. And so close, too! Try again?");
            input.close();
            return;
        }
        
        input.close();
    }
}