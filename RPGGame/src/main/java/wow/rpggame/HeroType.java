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

public class HeroType {
    public String name;
    public int baseHP, baseResource, baseAtk, baseDef, baseAgi, baseStr, baseIntel, baseLuck;
    public String resourceType, ascendTo;
    public ArrayList<String> passives, skills;
    public String uniqueSkill;

    public HeroType(String name, int baseHP, int baseResource, String resourceType, int baseAtk, int baseDef, int baseAgi, int baseStr, int baseIntel, int baseLuck,
                    ArrayList<String> passives, ArrayList<String> skills, String uniqueSkill, String ascendTo) {
        this.name = name; this.baseHP = baseHP; this.baseResource = baseResource; this.resourceType = resourceType;
        this.baseAtk = baseAtk; this.baseDef = baseDef; this.baseAgi = baseAgi; this.baseStr = baseStr; this.baseIntel = baseIntel; this.baseLuck = baseLuck;
        this.passives = passives; this.skills = skills; this.uniqueSkill = uniqueSkill; this.ascendTo = ascendTo;
    }

    public static HeroType[] allTypes() {
        return new HeroType[] {
            new HeroType("Warrior", 150, 50, "Stamina", 22, 13, 10, 12, 7, 6,
                new ArrayList<>(Arrays.asList("Endurance", "Toughness")),
                new ArrayList<>(Arrays.asList("Shield Bash", "Battle Cry", "Whirlwind", "Heroic Leap")),
                "Blade Storm", "Champion"),
            new HeroType("Mage", 90, 130, "Mana", 13, 9, 10, 7, 20, 14,
                new ArrayList<>(Arrays.asList("Mana Flow", "Spell Mastery")),
                new ArrayList<>(Arrays.asList("Fireball", "Ice Spike", "Arcane Shield", "Meteor")),
                "Time Stop", "Archmage"),
            new HeroType("Archer", 110, 75, "Stamina", 17, 10, 18, 11, 8, 14,
                new ArrayList<>(Arrays.asList("Quick Step", "Eagle Eye")),
                new ArrayList<>(Arrays.asList("Double Shot", "Evade", "Rain of Arrows", "Piercing Arrow")),
                "Sniper Focus", "Ranger"),
            new HeroType("Paladin", 160, 85, "Mana", 20, 18, 8, 15, 10, 9,
                new ArrayList<>(Arrays.asList("Divine Aura", "Sanctity")),
                new ArrayList<>(Arrays.asList("Smite", "Holy Shield", "Judgment", "Purify")),
                "Heaven's Fury", "Crusader"),
            new HeroType("Druid", 120, 120, "Mana", 16, 12, 13, 12, 15, 12,
                new ArrayList<>(Arrays.asList("Regeneration", "Wild Bond")),
                new ArrayList<>(Arrays.asList("Entangle", "Bear Form", "Nature's Fury", "Regrowth")),
                "Wild Shape", "Archdruid"),
            new HeroType("Assassin", 100, 70, "Stamina", 22, 9, 22, 14, 10, 16,
                new ArrayList<>(Arrays.asList("Stealth", "Deadly Precision")),
                new ArrayList<>(Arrays.asList("Backstab", "Poison Strike", "Shadow Step", "Evasion")),
                "Death Mark", "Shadowblade"),
            new HeroType("Monk", 115, 90, "Stamina", 18, 13, 18, 11, 14, 13,
                new ArrayList<>(Arrays.asList("Inner Calm", "Zen Mind")),
                new ArrayList<>(Arrays.asList("Meditate", "Chi Burst", "Inner Peace", "Blinding Speed")),
                "Transcendence", "Grandmaster"),
            new HeroType("Priest", 110, 135, "Mana", 11, 12, 13, 9, 22, 14,
                new ArrayList<>(Arrays.asList("Blessing", "Light Ward")),
                new ArrayList<>(Arrays.asList("Heal", "Bless", "Sanctuary", "Holy Light")),
                "Divine Intervention", "Saint"),
            new HeroType("Necromancer", 105, 120, "Mana", 14, 11, 12, 8, 21, 13,
                new ArrayList<>(Arrays.asList("Soul Harvest", "Undying")),
                new ArrayList<>(Arrays.asList("Raise Skeleton", "Life Drain", "Curse", "Bone Armor")),
                "Army of the Dead", "Lich"),
            new HeroType("Knight", 175, 60, "Stamina", 21, 18, 11, 16, 8, 10,
                new ArrayList<>(Arrays.asList("Chivalry", "Iron Will")),
                new ArrayList<>(Arrays.asList("Shield Block", "Charge", "Valor", "Sword Dance")),
                "Invincible", "Templar")
        };
    }
}
