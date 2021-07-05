package rabbitmq.producer.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author monochrome
 * @date 2021/7/5
 */
@RabbitListener(queues = {"sms.fanout.queue"})
@Component
public class FanoutSmsConsumer {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("sms接收到消息：" + message);
    }

}
