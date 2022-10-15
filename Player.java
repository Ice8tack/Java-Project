public class Player{
    int maxHealth;
    int maxMana;
    int attackDamage;
    public Player(char playerClassChar){
        setStats(playerClassChar);
    }
    
    public void setStats(char playerClassChar){
        if( playerClassChar == 'W') //Wizard class
        {
            maxHealth = 15;
            maxMana = 40;
            attackDamage = 3;
        }
        else if (playerClassChar == 'S') //Swordsman class
        {
            maxHealth = 25;
            maxMana = 20;
            attackDamage = 5;
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
    
    public void attack(Monster enemy){
         enemy.currentHealth -= attackDamage;
    }
}