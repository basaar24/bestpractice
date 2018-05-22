package axity.appdynamics;

import org.eclipse.microprofile.sample.canonical.utils.QLogger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.inject.Inject;
import java.util.logging.Logger;

@Singleton
@Startup
public class AppDynamicsService  {

    @Resource
    private TimerService timer;

    @Inject
    @QLogger
    private Logger logger;


    @PostConstruct
    public void initCron(){
        logger.info("======== Iniciando Singleton...=============");
        System.out.println("======== Iniciando Singleton...=============");

        ScheduleExpression expression= new ScheduleExpression();
        expression.dayOfMonth("*").hour("*").minute("*/5");
        TimerConfig timerConfig= new TimerConfig();
        timerConfig.setPersistent(true);
        timer.createCalendarTimer(expression, timerConfig);
    }


    @Timeout
    public void executeGetInfoDynamics(){
        logger.info(" Iniciando cron cada 5 minutos");
        System.out.println("======== ejecutando=============");
    }
}
