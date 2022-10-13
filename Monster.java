public class Monster{
    int maxHealth;
    int currentHealth;
    int attackDamage;

    public Monster(int health, int damage){
        maxHealth = health;
        attackDamage = damage;
    }
    if( playerClassChar == goblin)   //This is just put in for stat reasons and can be fixed later for actually inplementing the monsters correctly
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

    public int getMonsterMaxHealth(){
        return maxHealth;
    }

    public int getMonsterAttackDamage(){
        return attackDamage;
    }
}