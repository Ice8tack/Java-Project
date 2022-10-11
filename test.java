public class test{
    public static void main(String[] args){
        System.out.println("Test!");
        Player user = new Player('R');
        System.out.printf("Player's attack value: %d",user.getAttackDamage());
    }
}