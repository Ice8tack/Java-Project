public class Player{
    private int maxHealth;
    private int maxMana;
    private int attackDamage;
    private int magicDamage = 7;
    private int manaRegen = 4;
    private int healthRegen = 0;
    private int currentHealth;
    private int currentMana;
    private int potionCount = 1;
    private char playerClass; 
    
    public Player(char playerClassChar){
        setStats(playerClassChar);
        playerClass = playerClassChar;
        currentHealth = maxHealth;
        currentMana = maxMana;
    }
    
    public char getPlayerClass(){
        return playerClass;
    }
    
    public void usePotion()
    {
        if(potionCount >= 1)
            {
                rest();
                potionCount -= 1;
                System.out.printf("You used a full restore potion. You now have %d potions", potionCount);
            } else {
                System.out.println("You scramble for a potion and find none. You're open for attack.");
            }
    }
    
    public void addPotion()
    {
        potionCount += 1;
    }
    
    public void addDMG()
    {
        attackDamage += 1;
    }
    
    public void addMagicDMG()
    {
        magicDamage += 2;
    }
    
    public void addMaxMana()
    {
        maxMana += 5;
    } 
    
    public void addManaRegen()
    {
        manaRegen += 3;
    }
    
    public void addHPRegen()
    {
        healthRegen += 2;
    }
    
    public void addHP()
    {
        maxHealth += 5;
    }    
    
    public void rest()
    {
        currentHealth = maxHealth;
        currentMana = maxMana;
    }
    
    public void adjustHealth(int value)
    {
        currentHealth += value;
    }
    
     public void adjustMana(int value)
    {
        currentMana += value;
    }
    
    public void regenStats()
    {
        currentHealth += healthRegen;
        currentMana += manaRegen;
        if (currentHealth > maxHealth){
                currentHealth = getMaxHealth();
        }
        if (currentMana > maxMana){
                currentMana = getMaxMana();
        }
    }
    
    public int getCurrentHealth()
    {
        return currentHealth;
    }
    
    public int getCurrentMana()
    {
        return currentMana;
    }
    
    public void setStats(char playerClassChar){
        if( playerClassChar == 'W') //Wizard class
        {
            maxHealth = 18;
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
         enemy.takeDamage(getAttackDamage());
    }
    
    public void magic(Monster enemy){
         enemy.takeDamage(getMagicDamage());
    }
}