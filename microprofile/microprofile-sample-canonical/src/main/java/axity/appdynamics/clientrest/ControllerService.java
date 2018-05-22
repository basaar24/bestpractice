package axity.appdynamics.clientrest;
import java.util.List;
public interface ControllerService {

    void invokeRestService();

    List<String> buildFizzBuzz(List<Integer> data);
}
