package haven.memorizer;

import haven.livestock.Animal;

public class HorseFlashback extends AnimalFlashback {
    public Integer stamina;
    public Integer endrance;
    public Integer metabolism;

    public HorseFlashback() {
    }

    public HorseFlashback(Animal animal) {
        super(animal);
        this.stamina = animal.get("Stamina:");
        this.endrance = animal.get("Endurance:");
        this.metabolism = animal.get("Metabolism:");
    }

    public String asTooltip() {
        String tooltip = super.asTooltip();
        tooltip += "Stamina: " + this.stamina + "\n";
        tooltip += "Endurance: " + this.endrance + "\n";
        tooltip += "Metabolism: " + this.metabolism + "\n";

        return tooltip;
    }

    public String asOverlay() {
        String overlay = super.asOverlay() + " ";
        overlay += "S" + this.stamina + ";";
        overlay += "E" + this.endrance + ";";
        overlay += "M" + this.metabolism + ";";

        return overlay;
    }

}
