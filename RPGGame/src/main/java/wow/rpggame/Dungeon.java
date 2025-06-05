/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wow.rpggame;

/**
 *
 * @author Students Account
 */
import java.util.*;

public class Dungeon {
    public String rank;
    public ArrayList<MonsterType> monsterTypes;
    public MonsterType bossType;
    public int movesRequired = 10;
    public Queue<String> moveQueue = new LinkedList<>();

    public Dungeon(String rank, ArrayList<MonsterType> monsterTypes, MonsterType bossType) {
        this.rank = rank; this.monsterTypes = monsterTypes; this.bossType = bossType;
    }
    public void start(Hero hero, Scanner scanner) {
        Random rand = new Random();
        int enemiesDefeated = 0;
        System.out.println("\nEntering " + rank + "-Rank Dungeon!");

        for (int move = 1; move <= movesRequired; move++) {
            System.out.println("\nMove " + move + "/" + movesRequired + ": Choose direction:");
            System.out.println("1. Move Left\n2. Move Right\n3. Move Forward\n4. Move Back");
            int dir = scanner.nextInt(); scanner.nextLine();
            String moveStr = switch (dir) {
                case 1 -> "Left";
                case 2 -> "Right";
                case 3 -> "Forward";
                case 4 -> "Back";
                default -> "Unknown";
            };
            moveQueue.offer(moveStr);

            if (rand.nextInt(100) < 70) {
                MonsterType mType = monsterTypes.get(rand.nextInt(monsterTypes.size()));
                Monster monster = new Monster(mType, rank, false);
                System.out.println("\nYou encountered a " + monster.name + "!");
                battle(hero, monster, scanner, rand);
                enemiesDefeated++;
            } else {
                System.out.println("No enemies encountered.");
            }
        }
        System.out.println("\nAll areas cleared. Boss awaits!");
        Monster boss = new Monster(bossType, rank, true);
        System.out.println("\nBoss Appears: " + boss.name + " the " + boss.bossTitle + "!");
        battle(hero, boss, scanner, rand);
        System.out.println("Dungeon Cleared! Moves: " + moveQueue);
    }

    public static void battle(Hero hero, Monster monster, Scanner scanner, Random rand) {
        LinkedList<String> battleLog = new LinkedList<>();
        while (!hero.isDead() && !monster.isDead()) {
            System.out.println("\n[Turn] " + hero.name + " vs " + monster.name);
            hero.displayStatus();
            monster.displayStatus();
            System.out.println("1. Basic Attack\n2. Skill 1\n3. Skill 2\n4. Skill 3\n5. Skill 4\n6. Unique Skill\n7. Heal to Full (Cheat)");
            int action = scanner.nextInt(); scanner.nextLine();
            int dmg = 0;
            switch (action) {
                case 1 -> dmg = hero.basicAttack();
                case 2, 3, 4, 5 -> dmg = hero.useSkill(action - 2);
                case 6 -> dmg = hero.useUniqueSkill();
                case 7 -> hero.healToFull();
            }
            if (dmg > 0) monster.takeDamage(dmg);
            if (monster.isDead()) {
                System.out.println("Monster defeated!");
                hero.gainExp(monster.getExpReward());
                if (rand.nextInt(100) < 40) {
                    Item loot = LootTable.getRandomLoot(rand);
                    System.out.println("You found an item!");
                    loot.display();
                }
                battleLog.add(hero.name + " defeated " + monster.name);
                break;
            }
            int mAction = rand.nextInt(100);
            if (mAction < 50) {
                dmg = monster.attack();
            } else if (mAction < 90) {
                dmg = monster.useSkill(rand.nextInt(monster.skills.size()));
            } else {
                dmg = monster.useUniqueSkill();
            }
            if (dmg > 0) hero.takeDamage(dmg);
            if (hero.isDead()) {
                System.out.println("You have been defeated!");
                battleLog.add(monster.name + " defeated " + hero.name);
                break;
            }
        }
        System.out.println("Battle Log: " + battleLog);
    }
}