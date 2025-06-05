/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wow.rpggame;

/**
 *
 * @author Students Account
 */
public class Item {
    public String name, rarity;
    public int bonusAtk, bonusDef, bonusAgi, bonusStr, bonusIntel, bonusLuck;
    public Item(String name, String rarity, int bonusAtk, int bonusDef, int bonusAgi, int bonusStr, int bonusIntel, int bonusLuck) {
        this.name = name; this.rarity = rarity; this.bonusAtk = bonusAtk; this.bonusDef = bonusDef;
        this.bonusAgi = bonusAgi; this.bonusStr = bonusStr; this.bonusIntel = bonusIntel; this.bonusLuck = bonusLuck;
    }
    public void display() {
        System.out.println("[" + rarity + "] " + name + "  (+" + bonusAtk + " Atk, +" + bonusDef + " Def, +" + bonusAgi + " Agi, +" + bonusStr + " Str, +" + bonusIntel + " Int, +" + bonusLuck + " Luck)");
    }
}
