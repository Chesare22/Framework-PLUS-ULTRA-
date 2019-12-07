package mvc.utilities;


import java.util.ArrayList;
import java.util.List;

public class Notifier {
  private final List<Listener> listeners = new ArrayList<>();
  
  public void addListener(Listener l){
    listeners.add(l);
  }
  
  public void updateAll(){
    listeners.forEach((listener) -> {
      listener.update();
    });
  }
}
