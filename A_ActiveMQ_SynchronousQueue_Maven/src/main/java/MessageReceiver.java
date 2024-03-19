import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * This class is used to receive text message from the queue
 */
public class MessageReceiver {

    public static void main(String[] args) throws JMSException {

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_BIND_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(DefaultValues.queueName);

        MessageConsumer consumer = session.createConsumer(destination);

        Message message = consumer.receive();

        System.out.println("Hey");
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            System.out.println("Message received from the queue- \"" + textMessage.getText());
        }
        connection.close();
    }
}
