package designpattern.facade;

class HomeTheaterFacade {
    private Projector projector;
    private SoundSystem soundSystem;
    private Lights lights;

    public HomeTheaterFacade(Projector projector, SoundSystem soundSystem, Lights lights) {
        this.projector = projector;
        this.soundSystem = soundSystem;
        this.lights = lights;
    }

    public void watchMovie() {
        lights.dim();
        projector.on();
        soundSystem.on();
        System.out.println("Movie is starting...");
    }

    public void endMovie() {
        lights.on();
        projector.off();
        soundSystem.off();
        System.out.println("Movie ended.");
    }
}
