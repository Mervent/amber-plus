package haven.memorizer;

import haven.livestock.Animal;

public class AnimalFlashback extends Flashback {
    private String name;
    private Integer quality;
    private Integer breeding;

    public AnimalFlashback() {
    }

    public AnimalFlashback(Animal animal) {
        this.gobId = animal.gobid;
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
