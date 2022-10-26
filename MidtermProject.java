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
        System.out.println("There's one more to kill. \nThe shop offers multiple goods that will help you do that.");
        System.out.println("There's a sharp sliver of steel lying against a wall near an armor stand, with a better looking piece of armor, it makes you jealous.");
        System.out.println("Misunderstood jewelry lay on the table, a blue ring and a sapphire necklace.");
        System.out.println("On the wall to the right is a shield stronger than yourself. \nNear the edge of the clerk's counter is a dusty tome, and on the other side of the counter is a potion.");
        System.out.println("You stand there in the store, wondering what'll make you better."); //ADD DESCRIPTION LATER
        System.out.println("1: Weapon, 2: Armor, 3: Ring, 4: Necklace \n5: Shield, 6: Dusty Tome, 7: Potion.");

        if (user.getPlayerClass() == 'R'){
            System.out.println("You have enough coins to buy 2 items. The clerk doesn't seem to be very attentive.");
            itemsLeft = 3;
        }
        else{
            System.out.println("You have enough coins to buy 2 items");
            itemsLeft = 2;
        }

        boolean[] items = {false, false, false, false, false, false, false};

        while (itemsLeft > 0){
            int itemChoiceNum = input.nextInt() - 1;
            if(itemChoiceNum > 6){
                System.out.println("You reach for what isn't there.");
            }
            else if(items[itemChoiceNum]){
                System.out.println("Item is already gone, pick another item and keep track of your inventory.");
            }
            else{
                System.out.println("You have picked up the item.");
                items[itemChoiceNum] = true;
                itemsLeft -= 1;
            }
        }

        if(items[0]){
            user.addDMG(); //upgraded Weapon,more physical dmg [0]
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
        System.out.printf("%nYou currently have %d health remaining, and %d mana remaining!%n",playerHealth,playerMana);
        System.out.printf("%s currently has %d health remaining!%n",enemy.getName(),enemy.getCurrentHealth());
    }

    public static void chooseBattleOption(Player user, Monster enemy, Scanner input){
        System.out.println("What will you do?");
        System.out.println("Options: Attack, Magic, Item, Quit");
        String playerBattleOption = input.nextLine();
        while (!playerBattleOption.equalsIgnoreCase("attack") && !playerBattleOption.equalsIgnoreCase("magic") && !playerBattleOption.equalsIgnoreCase("item") && !playerBattleOption.equalsIgnoreCase("quit")){
            System.out.println("You bumble around.");
            playerBattleOption = input.nextLine();
        }
        if (playerBattleOption.equalsIgnoreCase("attack")){
            user.attack(enemy);
            System.out.printf("%nYou torment %s for %d damage!%n",enemy.getName(),user.getAttackDamage());
        }
        if (playerBattleOption.equalsIgnoreCase("magic")){
            if (user.getCurrentMana() > 14){
                user.magic(enemy);
                System.out.printf("%nYou magically harass %s for %d damage!%n",enemy.getName(),user.getMagicDamage());
                user.adjustMana(-15);
            } else {
                System.out.printf("%nThe magic fizzles. (15 Mana required for Magic)");
            }
        }
        if (playerBattleOption.equalsIgnoreCase("item")){
            user.usePotion();
        }
        if(playerBattleOption.equalsIgnoreCase("quit")){
            System.exit(0);
            System.out.println("You have quit the game. Coward");
        }
    }

    public static boolean doBattle(Player user, Monster enemy, Scanner input){
        user.rest();
        System.out.printf("%s looks %s.%n",enemy.getName(),enemy.getDescription());
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
            System.out.println("Your foe is a dying mess! This feels good.");
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

        System.out.println("\nWhat is your name?");
        String name = input.nextLine();

        System.out.println("Pick an identity: " + "\nWizard (W), Swordsman (S), Rogue (R), or Bard (B)");
        String pickClass = input.nextLine();
        pickClass = pickClass.toUpperCase();
        char classSelect = pickClass.charAt(0);
        while (!isClassValid(classSelect)){
            System.out.println("Just follow directions. Please select an available identity.");
            pickClass = input.nextLine();
            pickClass.toUpperCase();
            classSelect = pickClass.charAt(0);
        }
        Player user = new Player(classSelect);
        Monster goblin = new Monster(15,3,"Boblin the Goblin","A muttering of frustration.","pathetic.");
        Monster orc = new Monster(25,5,"Gork the Orc","Galumphing rage.","amped up and agitated.");
        Monster minotaur = new Monster(37,8,"Midas the Minotaur","He hit you where it hurts.","vengeful");

        System.out.printf("%s the murderer.%nThats you,%nThat's who you are.%nThey know that too.%n%nWandering the road between here and there%nA goblinoid%nIt's sifting the area%n",name);

        if (doBattle(user,goblin,input)){
            System.out.printf("A useless corpse. There's some blood with a little money \n ...%n%n");
        } else {
            System.out.println("You die.. :(");
            input.close();
            return;
        }

        System.out.printf("%nHere is always around.%nBut there, you're so close to there.%nA road here to there.%nNever can leave here even trying to get there%nno matter the there, it’s not here,%nnot yet…%n");
        System.out.printf("%nYou find tents and supper%n\"%s, you did this.%nYour revenge stops here.\"%nGork doesn't like you.%n",name);

        if (doBattle(user,orc,input)){
            System.out.printf("If he didn't want to die then why was he mortal?. \nBetween here and there is a shop.  ..%n%n");
        } else {
            System.out.println("You die.. :(");
            input.close();
            return;
        }

        System.out.println("A shop for shopping and nothing else."); //can change this later, just wanted smth before the shop print out stuff
        shop(input, user);

        System.out.printf("Here is now there%nMidas is right there,%nHe’s here with you.%n\"%s, why are you here?%nWhere’s my friends?%nThey were supposed to be here too.%n%nOh, that’s what you did.\"%n",name);

        if (doBattle(user,minotaur,input)){
            System.out.printf("You didn't win much, but at least they're dead.");
        } else {
            System.out.println("You die as you're supposed to. Try again?");
            input.close();
            return;
        }

        input.close();
    }
}