package me.almana.serverstuff.utils;

import me.almana.serverstuff.ServerStuff;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public class PrefixUtils {

    public static HashMap<String, String> prefixes = new HashMap<String, String>();
    private static final Plugin plugin = ServerStuff.getPlugin();

    public static void prefixSetup() {

        prefixes.put("BASIC", "<color:#9e9e9e>[Basic] ");
        prefixes.put("PRIME", "<color:#9cffbe>[Prime] ");
        prefixes.put("DELTA", "<color:#66ccff>[Delta] ");
        prefixes.put("VICTOR", "<color:#d08fff>[Victor] ");
        prefixes.put("MONSTER", "<color:#ff3c26>[MONSTER] ");
        prefixes.put("MINOR", "<color:#d5e85a>[MINOR] ");
        prefixes.put("HUNTER", "");
        prefixes.put("DADDY", "");
        prefixes.put("KING", "");
        prefixes.put("MASTER", "");
        prefixes.put("DAWG", "");
        prefixes.put("SIGMA", "");
        prefixes.put("TOPG", "");
        prefixes.put("GOD", "");
        prefixes.put("HOLY", "");
        prefixes.put("QUEEN", "");

    }
}
