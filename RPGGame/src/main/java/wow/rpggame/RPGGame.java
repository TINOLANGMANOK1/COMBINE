/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package wow.rpggame;

/**
 *
 * @author Students Account
 */
import java.util.*;

public class RPGGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== RPGGG MENU =====");
            System.out.println("1. Start Dungeon Adventure");
            System.out.println("2. Exit Game");
            System.out.print("Enter choice: ");
            int menuChoice;
            try {
                menuChoice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            if (menuChoice == 2) {
                System.out.println("Thanks for playing! Goodbye!");
                break;
            } else if (menuChoice == 1) {
                // HERO SELECTION
                HeroType[] heroTypes = HeroType.allTypes();
                System.out.println("Choose your hero:");
                for (int i = 0; i < heroTypes.length; i++)
                    System.out.println((i + 1) + ". " + heroTypes[i].name);
                int heroIdx;
                try {
                    heroIdx = Integer.parseInt(scanner.nextLine()) - 1;
                    if (heroIdx < 0 || heroIdx >= heroTypes.length) throw new Exception();
                } catch (Exception e) {
                    System.out.println("Invalid choice. Returning to menu.");
                    continue;
                }
                Hero hero = new Hero(heroTypes[heroIdx]);
                hero.displayStatus();

                // DUNGEON SELECTION
                HashMap<String, ArrayList<MonsterType>> allMonsters = MonsterType.allMonsterTypes();
                String[] dungeonRanks = {"D"}; // Expand as needed for more ranks
                ArrayList<Dungeon> dungeons = new ArrayList<>();
                for (String rank : dungeonRanks) {
                    ArrayList<MonsterType> types = allMonsters.get(rank);
                    Dungeon d = new Dungeon(rank, types, types.get(types.size() - 1));
                    dungeons.add(d);
                }

                System.out.println("\nChoose Dungeon Location:");
                for (int i = 0; i < dungeons.size(); i++)
                    System.out.println((i + 1) + ". " + dungeons.get(i).rank + "-Rank Dungeon");
                int dungIdx;
                try {
                    dungIdx = Integer.parseInt(scanner.nextLine()) - 1;
                    if (dungIdx < 0 || dungIdx >= dungeons.size()) throw new Exception();
                } catch (Exception e) {
                    System.out.println("Invalid choice. Returning to menu.");
                    continue;
                }
                Dungeon dungeon = dungeons.get(dungIdx);

                // START DUNGEON
                dungeon.start(hero, scanner);

                System.out.println("\nDungeon run finished! Returning to main menu.\n");
            } else {
                System.out.println("Invalid choice. Please choose 1 or 2.");
            }
        }
    }
}
