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
import java.util.Arrays;
import java.util.HashMap;

public class MonsterType {
    public String name, resourceType, uniqueSkill, bossTitle;
    public int baseHP, baseResource, baseAtk, baseDef, baseAgi, bonusBossHP, bonusBossResource, bonusBossAtk, bonusBossDef, bonusBossAgi;
    public ArrayList<String> passives, skills;

    public MonsterType(String name, String resourceType, int baseHP, int baseResource, int baseAtk, int baseDef, int baseAgi,
                      ArrayList<String> passives, ArrayList<String> skills, String uniqueSkill, String bossTitle,
                      int bonusBossHP, int bonusBossResource, int bonusBossAtk, int bonusBossDef, int bonusBossAgi) {
        this.name = name; this.resourceType = resourceType; this.baseHP = baseHP; this.baseResource = baseResource;
        this.baseAtk = baseAtk; this.baseDef = baseDef; this.baseAgi = baseAgi;
        this.passives = passives; this.skills = skills; this.uniqueSkill = uniqueSkill; this.bossTitle = bossTitle;
        this.bonusBossHP = bonusBossHP; this.bonusBossResource = bonusBossResource; this.bonusBossAtk = bonusBossAtk;
        this.bonusBossDef = bonusBossDef; this.bonusBossAgi = bonusBossAgi;
    }
    public static HashMap<String, ArrayList<MonsterType>> allMonsterTypes() {
        HashMap<String, ArrayList<MonsterType>> map = new HashMap<>();
        map.put("D", new ArrayList<>(Arrays.asList(
                new MonsterType("Goblin", "Stamina", 60, 30, 10, 4, 8,
                        new ArrayList<>(Arrays.asList("Cowardly", "Opportunist")), new ArrayList<>(Arrays.asList("Sneak", "Throw Dirt", "Wild Swing", "Shout")),
                        "Goblin Mob", "Goblin King", 80, 30, 10, 6, 5),
                new MonsterType("Rat", "Stamina", 55, 20, 7, 3, 13,
                        new ArrayList<>(Arrays.asList("Disease", "Fast")), new ArrayList<>(Arrays.asList("Scurry", "Gnaw", "Hide", "Swarm")),
                        "Rat Plague", "Rat Queen", 60, 30, 8, 8, 7),
                new MonsterType("Wolf", "Stamina", 80, 20, 13, 5, 14,
                        new ArrayList<>(Arrays.asList("Alpha", "Agile")), new ArrayList<>(Arrays.asList("Howl", "Pounce", "Pack Tactics", "Dodge")),
                        "Wolfpack", "Alpha Wolf", 65, 25, 10, 7, 8),
                new MonsterType("Slime", "Mana", 70, 40, 10, 10, 4,
                        new ArrayList<>(Arrays.asList("Acidic", "Resilient")), new ArrayList<>(Arrays.asList("Split", "Engulf", "Corrode", "Bounce")),
                        "Divide", "Slime Lord", 80, 40, 10, 12, 4),
                new MonsterType("Skeleton", "Stamina", 65, 25, 12, 9, 5,
                        new ArrayList<>(Arrays.asList("Undead", "Rattle")), new ArrayList<>(Arrays.asList("Bone Throw", "Shield Up", "Taunt", "Bone Armor")),
                        "Bone Wall", "Bone General", 70, 30, 12, 10, 7),
                new MonsterType("Spider", "Stamina", 50, 35, 9, 7, 11,
                        new ArrayList<>(Arrays.asList("Venomous", "Spinner")), new ArrayList<>(Arrays.asList("Web Trap", "Poison Spray", "Leap", "Harden")),
                        "Cocoon", "Spider Queen", 60, 35, 11, 7, 10),
                new MonsterType("Zombie", "Stamina", 90, 0, 15, 10, 3,
                        new ArrayList<>(Arrays.asList("Rot", "Relentless")), new ArrayList<>(Arrays.asList("Bite", "Moan", "Lurch", "Grab")),
                        "Zombie Horde", "Zombie Lord", 110, 0, 12, 13, 4),
                new MonsterType("Bat", "Stamina", 45, 40, 8, 3, 15,
                        new ArrayList<>(Arrays.asList("Nocturnal", "Vampiric")), new ArrayList<>(Arrays.asList("Sonic Screech", "Blind", "Blood Suck", "Echolocation")),
                        "Bat Swarm", "Vampire Bat", 50, 40, 13, 5, 13),
                new MonsterType("Imp", "Mana", 50, 50, 11, 6, 12,
                        new ArrayList<>(Arrays.asList("Mischievous", "Fireproof")), new ArrayList<>(Arrays.asList("Fire Puff", "Blink", "Cackle", "Taunt")),
                        "Imp Swarm", "Imp Lord", 60, 70, 8, 10, 12),
                new MonsterType("Beetle", "Stamina", 75, 10, 14, 13, 6,
                        new ArrayList<>(Arrays.asList("Hard Shell", "Burrow")), new ArrayList<>(Arrays.asList("Shell Guard", "Roll", "Dig", "Charge")),
                        "Swarm", "Beetle Emperor", 85, 15, 10, 15, 6)
        )));
        // Add more for C/B/A/S/SS/SSS ranks as needed
        return map;
    }
}
