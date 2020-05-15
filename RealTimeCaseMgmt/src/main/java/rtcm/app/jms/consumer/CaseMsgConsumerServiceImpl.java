package rtcm.app.jms.consumer;

import javax.jms.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;

public class CaseMsgConsumerServiceImpl implements CaseMsgConsumerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CaseMsgConsumerServiceImpl.class);

	protected JmsTemplate jmsTemplate;

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void receive(String receiveType) {
		if ("jmsReceive".equalsIgnoreCase(receiveType)) {
			jmsReceive();
		} else if ("receiveAndConvert".equalsIgnoreCase(receiveType)) {
			receiveAndConvert();
		}
	}

	public void jmsReceive() {
		Message message = jmsTemplate.receive();
		LOGGER.debug("Received a JMS message: {}", message);
	}

	public void receiveAndConvert() {
		String message = (String) jmsTemplate.receiveAndConvert();
		LOGGER.debug("Received a text message: {}", message);
	}

}
