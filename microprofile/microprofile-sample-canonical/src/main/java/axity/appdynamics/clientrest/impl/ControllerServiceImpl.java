package axity.appdynamics.clientrest.impl;

import axity.appdynamics.clientrest.ControllerService;

import javax.enterprise.inject.Default;
import java.util.ArrayList;
import java.util.List;


@Default
public class ControllerServiceImpl implements ControllerService {


    @Override
    public void invokeRestService() {

    }

    @Override
    public List<String> buildFizzBuzz(List<Integer> data) {
        List<String> dataresult = new ArrayList<>();
        data.forEach(number->{
            String result=number+"-";
            boolean fizzOrBuzz = false;
            if (number % 3 == 0) {
                result=result.concat("Fizz");
                fizzOrBuzz = true;
            }
            if (number % 5 == 0) {
                result=result.concat("Buzz");
                fizzOrBuzz = true;
            }
            dataresult.add(result);
        });
        return dataresult;
    }
}
