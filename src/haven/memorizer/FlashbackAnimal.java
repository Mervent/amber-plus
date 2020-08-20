package haven.memorizer;

import haven.livestock.Animal;

public class FlashbackAnimal extends Flashback {
    public String name;
    public Integer quality;
    public Integer breeding;

    public FlashbackAnimal() {
    }

    public FlashbackAnimal(Animal animal) {
        this.name = animal.name;
        this.quality = animal.get("Quality:");
        this.breeding = animal.get("Breeding quality:");
    }

    public String asTooltip() {
        String tooltip = "Name: " + this.name + "\n";
        tooltip += "Quality: " + this.quality + "\n";
        tooltip += "Breeding Quality: " + this.breeding + "\n";
        return tooltip;
    }
}
