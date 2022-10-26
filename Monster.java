public class Monster{
    private int maxHealth;
    private int currentHealth;
    private int attackDamage;
    private String name;
    private String attackDescription;
    private String monsterDescription;

    public Monster(int health, int damage, String n, String attackDescript, String descript){
        maxHealth = health;
        currentHealth = health;
        attackDamage = damage;
        name = n;
        attackDescription = attackDescript;
        monsterDescription = descript;
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
    
    public String getDescription(){
        return monsterDescription;
    }
}