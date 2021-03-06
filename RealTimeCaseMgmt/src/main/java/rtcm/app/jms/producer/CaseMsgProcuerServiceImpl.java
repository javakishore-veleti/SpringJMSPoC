package rtcm.app.jms.producer;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class CaseMsgProcuerServiceImpl implements CaseMsgProcuerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CaseMsgProcuerServiceImpl.class);

	protected JmsTemplate jmsTemplate;

	protected int numberOfMessages = 100;

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void sendMessages(String sendType) throws JMSException {
		if ("jmsSend".equalsIgnoreCase(sendType)) {
			jmsSendMessages();
		} else if ("convertAndSend".equalsIgnoreCase(sendType)) {
			convertAndSendMessages();
		}
	}

	public void jmsSendMessages() throws JMSException {
		final StringBuilder buffer = new StringBuilder();

		for (int i = 0; i < numberOfMessages; ++i) {
			buffer.append("Message '").append(i).append("' sent at: ").append(new Date());

			final int count = i;
			final String payload = buffer.toString();

			jmsTemplate.send(new MessageCreator() {
				public Message createMessage(Session session) throws JMSException {
					TextMessage message = session.createTextMessage(payload);
					message.setIntProperty("messageCount", count);
					LOGGER.info("Sending message number '{}'", count);
					return message;
				}
			});
		}
	}

	public void convertAndSendMessages() throws JMSException {
		final StringBuilder buffer = new StringBuilder();

		for (int i = 0; i < numberOfMessages; ++i) {
			buffer.append("Message '").append(i).append("' sent at: ").append(new Date());
			jmsTemplate.convertAndSend(buffer.toString());
		}
	}
}
