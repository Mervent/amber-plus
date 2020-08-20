package haven.memorizer;

import haven.livestock.Animal;

public class FlashbackHorse extends FlashbackAnimal {
    public Integer stamina;
    public Integer endrance;
    public Integer metabolism;

    public FlashbackHorse() {
    }

    public FlashbackHorse(Animal animal) {
        super(animal);
        this.stamina = animal.get("Stamina:");
        this.endrance = animal.get("Endurance:");
        this.metabolism = animal.get("Endurance:");
    }

    public String asTooltip() {
        String tooltip = super.asTooltip();
        tooltip += "Stamina: " + this.stamina + "\n";
        tooltip += "Endurance: " + this.endrance + "\n";
        tooltip += "Metabolism: " + this.metabolism + "\n";
        return tooltip;
    }

}
