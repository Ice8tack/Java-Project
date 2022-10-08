public class Player{
    int maxHealth;
    int maxMana;
    int attackDamage;
    public Player(char playerClassChar){
        setStats(playerClassChar);
    }
    
    public void setStats(char playerClassChar){
        if( playerClassChar == 'W')
        {
            maxHealth = 10;
            maxMana = 25;
            attackDamage = 5;
        }
        else if (playerClassChar == 'S')
        {
            maxHealth = 10;
            maxMana = 25;
            attackDamage = 5;
        }
        else if (playerClassChar == 'R')
        {
            maxHealth = 10;
            maxMana = 25;
            attackDamage = 5;
        }
        else if (playerClassChar == 'B')
        {
            maxHealth = 10;
            maxMana = 25;
            attackDamage = 5;
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
}