package me.almana.serverstuff.utils;

import me.almana.serverstuff.ServerStuff;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class CraftingUtils {

    static MiniMessage mm = ServerStuff.getMiniMessage();

    public static ItemStack craftGear(Player player, Material material, float xp, String toCraft) {

        ItemStack gear = new ItemStack(material);
        ItemMeta meta = gear.getItemMeta();
        meta.lore(List.of(mm.deserialize("<color:#8082ff><!i>Crafted By: <color:#97ff91>" + player.getName()), mm.deserialize("<color:#8082ff><!i>Level: <color:#97ff91>" + xp)));
        meta.displayName(mm.deserialize("<color:#ffd22e><!i>APPRENTICE " + toCraft.toUpperCase()));
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(),
                "bleh",  nums(xp),
                AttributeModifier.Operation.ADD_NUMBER,
                material.getEquipmentSlot()));
        if (xp >= 100) {

            meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(),
                    "tough", new Random().nextDouble(7),
                    AttributeModifier.Operation.ADD_NUMBER, material.getEquipmentSlot()));
        } else if (xp >= 80) {

            meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(),
                    "tough", new Random().nextDouble(5),
                    AttributeModifier.Operation.ADD_NUMBER, material.getEquipmentSlot()));
        } else if (xp >= 50) {

            meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(),
                    "tough", new Random().nextDouble(3),
                    AttributeModifier.Operation.ADD_NUMBER, material.getEquipmentSlot()));
        }

        gear.setItemMeta(meta);
        return gear;
    }

    public static ItemStack craftSword(Player player, Material material, float xp, String toCraft) {

        ItemStack gear = new ItemStack(material);
        ItemMeta meta = gear.getItemMeta();
        meta.lore(List.of(mm.deserialize("<color:#8082ff><!i>Crafted By: <color:#97ff91>" + player.getName()), mm.deserialize("<color:#8082ff><!i>Level: <color:#97ff91>" + xp)));
        meta.displayName(mm.deserialize("<color:#ffd22e><!i>APPRENTICE " + toCraft.toUpperCase()));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(),
                "bleh",  nums(xp),
                AttributeModifier.Operation.ADD_NUMBER,
                material.getEquipmentSlot()));
        if (xp >= 100) {

            meta.addAttributeModifier(Attribute.GENERIC_LUCK, new AttributeModifier(UUID.randomUUID(),
                    "tough", new Random().nextDouble(5),
                    AttributeModifier.Operation.ADD_NUMBER, material.getEquipmentSlot()));
        } else if (xp >= 80) {

            meta.addAttributeModifier(Attribute.GENERIC_LUCK, new AttributeModifier(UUID.randomUUID(),
                    "tough", new Random().nextDouble(3),
                    AttributeModifier.Operation.ADD_NUMBER, material.getEquipmentSlot()));
        } else if (xp >= 50) {

            meta.addAttributeModifier(Attribute.GENERIC_LUCK, new AttributeModifier(UUID.randomUUID(),
                    "tough", new Random().nextDouble(2),
                    AttributeModifier.Operation.ADD_NUMBER, material.getEquipmentSlot()));
        }

        gear.setItemMeta(meta);
        return gear;
    }

    public static void craftingArmorClick(Player player, String toCraft) {

        HashMap<Material, Integer> ingredientHash = IngredientHashes.returnIngredients(player.getLevel());

        if (!playerHasItems(player, ingredientHash)) {
            for (Material ingredients: ingredientHash.keySet()) {

                player.sendMessage(ServerStuff.SERVER_PREFIX.append(mm.deserialize("<color:#ff371c> Need " + ingredientHash.get(ingredients) + " of " + ingredients.name())));
            }
            player.closeInventory();
        } else {

            removeIngredients(player, ingredientHash);

            if (player.getLevel() <= 10) {

                player.getInventory().addItem(craftGear(player, Material.matchMaterial("Leather_" + toCraft), player.getLevel(), toCraft));
            } else if (player.getLevel() <= 20) {

                player.getInventory().addItem(craftGear(player, Material.matchMaterial("Chainmail_" + toCraft), player.getLevel(), toCraft));
            } else if (player.getLevel() <= 30) {

                player.getInventory().addItem(craftGear(player, Material.matchMaterial("Gold_" + toCraft), player.getLevel(), toCraft));
            } else if (player.getLevel() <= 50) {

                player.getInventory().addItem(craftGear(player, Material.matchMaterial("Iron_" + toCraft), player.getLevel(), toCraft));
            } else if (player.getLevel() <= 70) {

                player.getInventory().addItem(craftGear(player, Material.matchMaterial("Diamond_" + toCraft), player.getLevel(), toCraft));
            } else {

                player.getInventory().addItem(craftGear(player, Material.matchMaterial("Netherite_" + toCraft), player.getLevel(), toCraft));
            }
            player.sendMessage(ServerStuff.SERVER_PREFIX.append(mm.deserialize("<green>Crafted " + toCraft)));
            player.closeInventory();
        }
    }

    public static void craftingSwordClick(Player player, String toCraft) {

        HashMap<Material, Integer> ingredientHash = IngredientHashes.returnIngredients(player.getLevel());

        if (!playerHasItems(player, ingredientHash)) {
            for (Material ingredients: ingredientHash.keySet()) {

                player.sendMessage(ServerStuff.SERVER_PREFIX.append(mm.deserialize("<color:#ff371c> Need " + ingredientHash.get(ingredients) + " of " + ingredients.name())));
            }
            player.closeInventory();
        } else {

            removeIngredients(player, ingredientHash);

            if (player.getLevel() <= 10) {

                player.getInventory().addItem(craftGear(player, Material.matchMaterial("Wooden_" + toCraft), player.getLevel(), toCraft));
            } else if (player.getLevel() <= 20) {

                player.getInventory().addItem(craftGear(player, Material.matchMaterial("Stone_" + toCraft), player.getLevel(), toCraft));
            } else if (player.getLevel() <= 30) {

                player.getInventory().addItem(craftGear(player, Material.matchMaterial("Gold_" + toCraft), player.getLevel(), toCraft));
            } else if (player.getLevel() <= 50) {

                player.getInventory().addItem(craftGear(player, Material.matchMaterial("Iron_" + toCraft), player.getLevel(), toCraft));
            } else if (player.getLevel() <= 70) {

                player.getInventory().addItem(craftGear(player, Material.matchMaterial("Diamond_" + toCraft), player.getLevel(), toCraft));
            } else {

                player.getInventory().addItem(craftGear(player, Material.matchMaterial("Netherite_" + toCraft), player.getLevel(), toCraft));
            }
            player.sendMessage(ServerStuff.SERVER_PREFIX.append(mm.deserialize("<green>Crafted " + toCraft)));
            player.closeInventory();
        }
    }

    /*
        LEATHER
        CHAINMAIL
        GOLD
        IRON
        DIAMOND
        NETHERITE
     */

    private static double nums(float i) {

        Random random = new Random();
        double j = Math.ceil(Math.log((i + 1) * 0.2 + 1) / Math.log(1.4));

        if (i < 10) {

            return (float) (j + random.nextDouble(-1, 1));
        } else if ( i < 20) {

            return (float) (j + random.nextDouble(-2, 2));
        } else if ( i < 40) {

            return (float) (j + random.nextDouble(-3, 3));
        } else if ( i < 60) {

            return (float) (j + random.nextDouble(-4, 4));
        } else if ( i < 80) {

            return (float) (j + random.nextDouble(-5, 5));
        }
        return (float) (j + random.nextDouble(-6, 6));
    }


    private static boolean playerHasItems(Player player, HashMap<Material, Integer> itemRequirements) {
        for (Material itemReq: itemRequirements.keySet()) {

            if (!player.getInventory().contains(itemReq, itemRequirements.get(itemReq))) {

                return false;
            }
        } return true;
    }

    private static void removeIngredients(Player player, HashMap<Material, Integer> itemRequirements) {

        for (Material itemReq: itemRequirements.keySet()) {
            player.getInventory().removeItem(new ItemStack(itemReq, itemRequirements.get(itemReq)));
        }
    }
}
