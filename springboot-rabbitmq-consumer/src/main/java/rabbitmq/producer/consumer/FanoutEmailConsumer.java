package rabbitmq.producer.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author monochrome
 * @date 2021/7/5
 */
@RabbitListener(queues = {"email.fanout.queue"})
@Component
public class FanoutEmailConsumer {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("email接收到消息：" + message);
    }

}
