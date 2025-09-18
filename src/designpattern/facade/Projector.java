package designpattern.facade;

class Projector {
    void on() { System.out.println("Projector on"); }
    void off() { System.out.println("Projector off"); }
}

class SoundSystem {
    void on() { System.out.println("Sound system on"); }
    void off() { System.out.println("Sound system off"); }
}

class Lights {
    void dim() { System.out.println("Lights dimmed"); }
    void on() { System.out.println("Lights on"); }
}
