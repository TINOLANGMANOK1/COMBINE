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
import java.util.Stack;

public class Hero {
    public String name;
    public HeroType type;
    public int maxHP, hp, maxResource, resource, level, exp, ascension, atk, def, agi, luck, str, intel;
    public String resourceType;
    public ArrayList<String> passives = new ArrayList<>();
    public ArrayList<String> skills = new ArrayList<>();
    public String uniqueSkill;
    public Stack<String> ascensionHistory = new Stack<>();

    public Hero(HeroType type) {
        this.type = type;
        this.name = type.name;
        this.maxHP = type.baseHP;
        this.hp = maxHP;
        this.maxResource = type.baseResource;
        this.resource = maxResource;
        this.level = 1;
        this.exp = 0;
        this.ascension = 0;
        this.resourceType = type.resourceType;
        this.atk = type.baseAtk;
        this.def = type.baseDef;
        this.agi = type.baseAgi;
        this.luck = type.baseLuck;
        this.str = type.baseStr;
        this.intel = type.baseIntel;
        this.passives.addAll(type.passives);
        this.skills.addAll(type.skills);
        this.uniqueSkill = type.uniqueSkill;
    }

    public void displayStatus() {
        System.out.println("Hero: " + name + " (Lv." + level + (ascension > 0 ? " Ascended x" + ascension : "") + ")");
        System.out.println("HP: " + hp + "/" + maxHP + " | " + resourceType + ": " + resource + "/" + maxResource);
        System.out.println("Attack: " + atk + " | Defense: " + def + " | Agi: " + agi + " | Str: " + str + " | Int: " + intel + " | Luck: " + luck);
        System.out.println("Passives: " + String.join(", ", passives));
        System.out.println("Skills: " + String.join(", ", skills));
        System.out.println("Unique Skill: " + uniqueSkill);
        System.out.println("Ascension History: " + ascensionHistory);
        System.out.println("EXP: " + exp + "/" + (level * 100));
    }

    public int basicAttack() {
        int dmg = atk + (int)(Math.random() * (str + agi + 5));
        System.out.println(name + " uses Basic Attack for " + dmg + " damage!");
        return dmg;
    }
    public int useSkill(int idx) {
        if (idx < 0 || idx >= skills.size()) return 0;
        if (resource < 20) {
            System.out.println("Not enough " + resourceType + "!");
            return 0;
        }
        resource -= 20;
        int dmg = atk * (2 + idx) + (int)(Math.random() * (int)(agi + str + 10));
        System.out.println(name + " uses " + skills.get(idx) + " for " + dmg + " damage!");
        return dmg;
    }
    public int useUniqueSkill() {
        if (resource < 50) {
            System.out.println("Not enough " + resourceType + "!");
            return 0;
        }
        resource -= 50;
        int dmg = atk * 4 + (int)(Math.random() * (agi + intel + 30));
        System.out.println(name + " unleashes Unique Skill: " + uniqueSkill + " for " + dmg + " damage!");
        return dmg;
    }
    public void takeDamage(int dmg) {
        int taken = Math.max(0, dmg - def);
        hp = Math.max(0, hp - taken);
        System.out.println(name + " takes " + taken + " damage! (after defense)");
    }
    public void healToFull() {
        hp = maxHP;
        resource = maxResource;
    }
    public boolean isDead() { return hp <= 0; }
    public void gainExp(int e) {
        exp += e;
        while (exp >= level * 100) {
            exp -= level * 100;
            level++;
            maxHP += 15; maxResource += 10; atk += 3; def += 2;
            agi += 1; str += 1; intel += 1; luck += 1;
            System.out.println("Level up! Now Lv." + level + ". Stats increased.");
        }
        healToFull();
    }
    public void ascend() {
        ascension++;
        ascensionHistory.push("Ascended to " + type.ascendTo + " at Lv." + level);
        atk += 10; def += 10; maxHP += 50; maxResource += 30;
        System.out.println(name + " ascends to " + type.ascendTo + "! Stat boost!");
    }
}