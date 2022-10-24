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