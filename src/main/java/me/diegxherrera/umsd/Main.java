package me.diegxherrera.umsd;

public class Main {
    public static void main(String[] args) {
        DIContainer container = new DIContainer();
        GameFrame gameFrame = container.getGameFrame();
        gameFrame.showStoryFrame();
    }
}