package designpattern.facade;

public class FacadeDemo {
  public static void main(String[] args) {
      Projector projector = new Projector();
      SoundSystem soundSystem = new SoundSystem();
      Lights lights = new Lights();

      HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(projector, soundSystem,lights);

      homeTheaterFacade.watchMovie();

      homeTheaterFacade.endMovie();

  }
}
