/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverwofacade;

/**
 *
 * @author kedkeke
 */
public class ScheduleFacade {
    private static ScheduleFacade myFacade = null;
    private ScheduleFacade() {}
    public static ScheduleFacade get() {
        if (myFacade == null) {
            myFacade = new ScheduleFacade();
        }
        return myFacade;
    }
    
    public void start() {
        ScheduleServer scheduleServer = new ScheduleServer();
	scheduleServer.startBooting();
	scheduleServer.readSystemConfigFile();
	scheduleServer.init();
	scheduleServer.initializeContext();
	scheduleServer.initializeListeners();
	scheduleServer.createSystemObjects();
    }
    
    public void stop() {
        ScheduleServer scheduleServer = new ScheduleServer();
	scheduleServer.releaseProcesses();
	scheduleServer.destory();
	scheduleServer.destroySystemObjects();
	scheduleServer.destoryListeners();
	scheduleServer.destoryContext();
	scheduleServer.shutdown();
    }
}
