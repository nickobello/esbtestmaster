/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 
package monitoring;


import interfaces.MonitoringInterface;
import javax.jws.WebService;


/**
 *
 * @author gilles
 */
@WebService()
public class MonitoringWS implements MonitoringInterface{



    public void configureAS(int behavior, int id)
     {
        if(behavior==0)

            System.out.print("you are consumer and your id is " + id);//just a test
            //Here We will invoke the configuration method
        else
             System.out.print("you are provider and your id is" +  id);//just a test
              //Here We will invoke the configuration method
     }

    public void configureProvider(int responseTime, int messageLength)
    {
        System.out.print("response Time is" +responseTime+ "and Message Length" + messageLength);//just a test
         //Here We will invoke the provider method
    }
}
