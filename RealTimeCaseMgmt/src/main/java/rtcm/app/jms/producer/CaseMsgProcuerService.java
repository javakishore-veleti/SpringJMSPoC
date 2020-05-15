package rtcm.app.jms.producer;

import javax.jms.JMSException;

public interface CaseMsgProcuerService {

	public void sendMessages(String sendType) throws JMSException;
}
