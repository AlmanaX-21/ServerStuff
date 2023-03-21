package me.almana.serverstuff.models;


import org.bukkit.Material;

public class MiningStructure {

    public MiningStructure(Material blockType, SuperiorItem drop) {
        this.blockType = blockType;
        this.drop = drop;
    }

    Material blockType;
    SuperiorItem drop;

    public Material getBlockType() {
        return blockType;
    }

    public void setBlockType(Material blockType) {
        this.blockType = blockType;
    }

    public SuperiorItem getDrop() {
        return drop;
    }

    public void setDrop(SuperiorItem drop) {
        this.drop = drop;
    }
}
