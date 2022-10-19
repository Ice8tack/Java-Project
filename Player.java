public class Player{
    private int maxHealth;
    private int maxMana;
    private int attackDamage;
    private int magicDamage = 7;
    private int manaRegen = 4;
    private int healthRegen = 0;
    
    public Player(char playerClassChar){
        setStats(playerClassChar);
    }
    
    public void setStats(char playerClassChar){
        if( playerClassChar == 'W') //Wizard class
        {
            maxHealth = 15;
            maxMana = 40;
            attackDamage = 3;
            magicDamage = 10;
            manaRegen = 7;
        }
        else if (playerClassChar == 'S') //Swordsman class
        {
            maxHealth = 25;
            maxMana = 20;
            attackDamage = 5;
            healthRegen = 2;
        }
        else if (playerClassChar == 'R') //Rogue class
        {
            maxHealth = 20;
            maxMana = 25;
            attackDamage = 7;
        }
        else if (playerClassChar == 'B') //Bard class
        {
            maxHealth = 18;
            maxMana = 30;
            attackDamage = 4;
            magicDamage = 8;
            healthRegen = 1;
            manaRegen = 6;
        }
    }
    
    public int getMaxHealth(){
        return maxHealth;
    }
    
    public int getMaxMana(){
        return maxMana;
    }
    
    public int getAttackDamage(){
        return attackDamage;
    }
    
    public int getMagicDamage(){
        return magicDamage;
    }
    
    public int getHPRegen(){
        return healthRegen;
    }
    
    public int getManaRegen(){
        return manaRegen;
    }
    
    public void attack(Monster enemy){
         enemy.currentHealth -= getAttackDamage();
    }
    
    public void magic(Monster enemy){
         enemy.currentHealth -= getMagicDamage();
    }
}