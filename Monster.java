public class Monster{
    private int maxHealth;
    private int currentHealth;
    private int attackDamage;
    private String name;
    private String attackDescription;

    public Monster(int health, int damage, String n, String ad){
        maxHealth = health;
        currentHealth = health;
        attackDamage = damage;
        name = n;
        attackDescription = ad;
    }

    /*if( playerClassChar == goblin)   //This is just put in for stat reasons and can be fixed later for actually inplementing the monsters correctly
    {   //Goblin Monster
    maxHealth = 15;
    attackDamage = 3;
    }
    else if (playerClassChar == orc) //Orc Monster
    {
    maxHealth = 25;
    attackDamage = 5;
    }
    else if (playerClassChar == IFORGETTHE3RDMONSTER) //I don't remember what we were going to do for the 3rd monster so I just put some numbers down
    {
    maxHealth = 30;
    attackDamage = 7;
    }
     */

    public int getMaxHealth(){
        return maxHealth;
    }

    public int getCurrentHealth(){
        return currentHealth;
    }
    
    public int getAttackDamage(){
        return attackDamage;
    }
    
    public String getName(){
        return name;
    }
    
    public void printAttackDescription(){
        System.out.println(attackDescription);
    }
    
    public void takeDamage(int value){
        currentHealth -=value;
    }
}