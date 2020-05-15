package rtcm.app;

import javax.jms.JMSException;

import org.apache.activemq.broker.BrokerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import rtcm.app.jms.consumer.CaseMsgConsumerService;
import rtcm.app.jms.producer.CaseMsgProcuerService;

public class AppMain {

	public static void main(String[] args) throws JMSException, InterruptedException {
		ClassPathXmlApplicationContext ctx = null;

		try {
			
			BrokerService broker = new BrokerService();
			// configure the broker
			broker.addConnector("tcp://localhost:61616");
			broker.start();
			
			ctx = new ClassPathXmlApplicationContext("application-context.xml");

			CaseMsgProcuerService producer = ctx.getBean(CaseMsgProcuerService.class);

			producer.sendMessages("jmsSend");
			
			CaseMsgConsumerService receiver = ctx.getBean(CaseMsgConsumerService.class);
	        
	    	for (int i = 0; i < 100; ++i) {
	    		receiver.receive("jmsReceive");
	    	}

			System.out.println("Sleeping now 1000");

			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (ctx != null) {
				ctx.close();
			}

			System.exit(0);
		}

	}

}
