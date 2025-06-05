/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wow.rpggame;

/**
 *
 * @author Students Account
 */
import java.util.Random;

public class LootTable {
    static Item[] items = {
        new Item("Sword of Legends", "Legendary", 20, 5, 4, 8, 0, 5),
        new Item("Arcane Staff", "Epic", 7, 2, 2, 0, 15, 4),
        new Item("Hunter's Bow", "Rare", 6, 1, 7, 2, 0, 8),
        new Item("Paladin Shield", "Unique", 2, 14, 2, 2, 0, 1),
        new Item("Boots of Speed", "Rare", 1, 1, 10, 0, 0, 2),
        new Item("Ring of Luck", "Legendary", 0, 0, 2, 0, 0, 20)
    };
    public static Item getRandomLoot(Random rand) {
        int idx = rand.nextInt(items.length);
        return items[idx];
    }
}
