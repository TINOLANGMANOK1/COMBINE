/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wow.rpggame;

/**
 *
 * @author Students Account
 */
import java.util.ArrayList;

public class Monster {
    public String name, resourceType, bossTitle, dungeonRank;
    public int maxHP, hp, maxResource, resource, atk, def, agi, uniqueExp;
    public ArrayList<String> passives = new ArrayList<>();
    public ArrayList<String> skills = new ArrayList<>();
    public String uniqueSkill;
    public boolean isBoss;

    public Monster(MonsterType type, String dungeonRank, boolean isBoss) {
        this.name = type.name;
        this.resourceType = type.resourceType;
        this.maxHP = type.baseHP + (isBoss ? type.bonusBossHP : 0);
        this.hp = maxHP;
        this.maxResource = type.baseResource + (isBoss ? type.bonusBossResource : 0);
        this.resource = maxResource;
        this.atk = type.baseAtk + (isBoss ? type.bonusBossAtk : 0);
        this.def = type.baseDef + (isBoss ? type.bonusBossDef : 0);
        this.agi = type.baseAgi + (isBoss ? type.bonusBossAgi : 0);
        this.passives.addAll(type.passives);
        this.skills.addAll(type.skills);
        this.uniqueSkill = type.uniqueSkill;
        this.bossTitle = isBoss ? type.bossTitle : "";
        this.isBoss = isBoss;
        this.dungeonRank = dungeonRank;
        this.uniqueExp = type.baseHP/2 + type.baseResource/2 + (isBoss ? 100 : 0);
    }
    public void displayStatus() {
        System.out.println((isBoss ? "[BOSS] " : "") + name + (isBoss ? " the " + bossTitle : "") + " (" + dungeonRank + "-Rank)");
        System.out.println("HP: " + hp + "/" + maxHP + " | " + resourceType + ": " + resource + "/" + maxResource);
        System.out.println("Attack: " + atk + " | Defense: " + def + " | Agi: " + agi);
        System.out.println("Passives: " + String.join(", ", passives));
        System.out.println("Skills: " + String.join(", ", skills));
        System.out.println("Unique Skill: " + uniqueSkill);
    }
    public int attack() {
        int dmg = atk + (int)(Math.random() * (agi + 6));
        System.out.println(name + (isBoss ? " (BOSS)" : "") + " attacks for " + dmg + " damage!");
        return dmg;
    }
    public int useSkill(int idx) {
        if (idx < 0 || idx >= skills.size()) return 0;
        if (resource < 15) {
            System.out.println(name + " not enough " + resourceType + "!");
            return 0;
        }
        resource -= 15;
        int dmg = atk * (2 + idx) + (int)(Math.random() * (agi + 10));
        System.out.println(name + " uses " + skills.get(idx) + " for " + dmg + " damage!");
        return dmg;
    }
    public int useUniqueSkill() {
        if (resource < 40) {
            System.out.println(name + " not enough " + resourceType + "!");
            return 0;
        }
        resource -= 40;
        int dmg = atk * 4 + (int)(Math.random() * (agi + 25));
        System.out.println(name + " uses Unique Skill: " + uniqueSkill + " for " + dmg + " damage!");
        return dmg;
    }
    public void takeDamage(int dmg) {
        int taken = Math.max(0, dmg - def);
        hp = Math.max(0, hp - taken);
        System.out.println(name + " takes " + taken + " damage! (after defense)");
    }
    public boolean isDead() { return hp <= 0; }
    public int getExpReward() { return uniqueExp; }
}