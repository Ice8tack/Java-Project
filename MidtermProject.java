import java.util.Scanner;
public class MidtermProject
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Hello and welcome to our game!" + "Please enter your name");
        String name = input.nextLine();

        System.out.println("Pick a class from among the ones available: " + "\nWizard (W), Swordsman (S), Rogue (R), or Bard (R)");
        char pickClass = input.next().charAt(0);

        if( pickClass == 'W')
        {
            int playerMaxHealth = 10;
            int playerMaxMana = 25;
            int playerAttack = 5;
        }
        else if (pickClass == 'S')
        {
            int playerMaxHealth = 10;
            int playerMaxMana = 25;
            int playerAttack = 5;
        }
        else if (pickClass == 'R')
        {
            int playerMaxHealth = 10;
            int playerMaxMana = 25;
            int playerAttack = 5;
        }
        else if (pickClass == 'B')
        {
            int playerMaxHealth = 10;
            int playerMaxMana = 25;
            int playerAttack = 5;
        }

    }
}