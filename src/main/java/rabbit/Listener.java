package rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import lombok.SneakyThrows;

import javax.inject.Inject;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;


@WebListener
public class Listener implements ServletContextListener {
    Logger log = Logger.getLogger(Listener.class.getName());
    @Inject
    private PushBean pushBean;

    @SneakyThrows
    @Override
    public void contextInitialized(ServletContextEvent event) {
        ExecutorService service = Executors.newCachedThreadPool();

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("queue1", true, false, false, null);
        log.info(" [*] Waiting for messages. ");


        service.submit(() -> {

            while (true) {
                DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                    String message = new String(delivery.getBody(), StandardCharsets.UTF_8);

                    log.info(" [x] Received '" + message + "'");
                    log.info("Push bean: " + pushBean.toString());

                    pushBean.sendMessage(message);

                    log.info("Message [" + message + "] has been pushed to JSF page");
                };

                try {
                    channel.basicConsume("queue1", true, deliverCallback, consumerTag -> { });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
