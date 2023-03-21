package me.almana.serverstuff.utils;

import com.google.gson.Gson;
import me.almana.serverstuff.ServerStuff;
import me.almana.serverstuff.models.MiningStructure;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class JsonUtils {

    static Gson gson = new Gson();
    Plugin plugin = ServerStuff.getPlugin();
    private static final File file = new File(ServerStuff.getPlugin().getDataFolder().getAbsolutePath() + "/mineables.json");
    private static HashMap<Material, MiningStructure> blockBreakThing = new HashMap<>();

    public static HashMap<Material, MiningStructure> getBlockBreakThing() {
        return blockBreakThing;
    }

    public static void setBlockBreakThing(HashMap<Material, MiningStructure> blockBreakThing) {
        JsonUtils.blockBreakThing = blockBreakThing;
    }

    public static File getFile() {
        return file;
    }

    public static HashMap<Material, MiningStructure> loadMiningStructure() throws IOException {

        FileReader reader = new FileReader(file);
        MiningStructure[] miningStructures = gson.fromJson(reader, MiningStructure[].class);
        reader.close();
            for (MiningStructure ms: miningStructures) {

                blockBreakThing.put(ms.getBlockType(), ms);
        }
            return blockBreakThing;
    }

    public static void saveMiningStructure() throws IOException {

        Writer writer = new FileWriter(file);
        ArrayList<MiningStructure> miningStructureArrayList = new ArrayList<>(blockBreakThing.values());
        gson.toJson(miningStructureArrayList, writer);
        writer.flush();
        writer.close();
        ServerStuff.getPlugin().getLogger().info("Saved Mineables.");
    }
}
