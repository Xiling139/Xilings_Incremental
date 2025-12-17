package generator;

import main.Gamepanel;

public class Generator {
    Gamepanel gp;

    public Generator(Gamepanel gp) {
        this.gp = gp;
    }

    public double score = 1;
    public double generatorAmount;

    public double generatorAmount2;

    public void update() {
        double generationSpeed = getSpeed(generatorAmount, 1);
        double generationSpeed2 = getSpeed(generatorAmount2, 2);
        score = score + generationSpeed / gp.ticksPerSecond;
        generatorAmount = generatorAmount + generationSpeed2 / gp.ticksPerSecond;
    }

    private double getSpeed(double amount, int type) {
        double constant = 1.0 / type;
        return (amount * constant);
    }
}
