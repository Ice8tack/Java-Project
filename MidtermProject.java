import java.util.Scanner;
public class MidtermProject
{
    public static boolean isClassValid(char a){
        if (a == 'W' || a == 'S' || a == 'R' || a == 'B'){
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
        //Monster goblin = new Monster(10,3);
        
        input.close();
    }
}