import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @author anp
* This class is used to send text message to the queue
 */
public class MessageSender {

    public static void main(String[] args) throws JMSException {

        /*
         Getting JMS connection from the JMS Server
         */
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        try (Connection connection = connectionFactory.createConnection()) {
            connection.start();

            /*
             * Creating a non transactional session to send/ receive JMS message
             * params- boolean transacted, int acknowledgeMode
             */
            try (Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE)) {
                /*
                 * The queue will be created automatically on the server
                 */
                Destination destination = session.createQueue(DefaultValues.queueName);

                try (MessageProducer producer = session.createProducer(destination)) {
                    TextMessage message = session.createTextMessage("Message from sender");
                    producer.send(message);
                    System.out.println("Message- \"" + message.getText() + "\" - sent to the queue");
                }
            }
        }
    }
}
