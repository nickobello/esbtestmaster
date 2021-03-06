/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simulation;

import datas.AgentType;
import datas.EventType;
import datas.ProducerConfiguration;
import datas.SimulationScenario;
import datas.SimulationStep;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author samy
 */
public class ConsumerEntityTest {

    public ConsumerEntityTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of configureConsumer method, of class ConsumerEntity.
     */
    @Ignore
    @Test
    public void testConfigureConsumer() {
        System.out.println("configureConsumer");
        String id = "";
        SimulationScenario simulationScenario = null;
        ConsumerEntity instance = new ConsumerEntity();
        instance.configureConsumer(id, simulationScenario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of startSimulation method, of class ConsumerEntity.
     */
    
    @Test
    public void testStartSimulation() {
        System.out.println("startSimulation");
        String producerId = "producer1";
        String consumerId = "consumer1";
        // Test ConsumerEntity
        ConsumerEntity instance = new ConsumerEntity();

        SimulationScenario ss = new SimulationScenario();
        ProducerConfiguration pc = new ProducerConfiguration();
        pc.setName(producerId);
        pc.setWsAddress("http://localhost:8090/ESBTestCompositeService1/casaPort1");
        ss.getAgentsconfiguration().add(pc);

        ss.addStep(new SimulationStep(consumerId, producerId, 0, 3000, 1, 16, 1000L, 20));
        ss.addStep(new SimulationStep(consumerId, producerId, 3000, 4500, 2, 16, 1000L, 20));

        instance.configureConsumer(consumerId, ss);
        instance.startSimulation();
        
        
    }

    /**
     * Test of abortSimulation method, of class ConsumerEntity.
     */
    @Ignore
    @Test
    public void testAbortSimulation() {
        System.out.println("abortSimulation");
        ConsumerEntity instance = new ConsumerEntity();
        instance.abortSimulation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }    

    /**
     * Test of main method, of class ConsumerEntity.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ConsumerEntity.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}