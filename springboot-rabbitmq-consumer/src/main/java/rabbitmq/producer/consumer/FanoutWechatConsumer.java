package rabbitmq.producer.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author monochrome
 * @date 2021/7/5
 */
@RabbitListener(queues = {"wechat.fanout.queue"})
@Component
public class FanoutWechatConsumer {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("wechat接收到消息：" + message);
    }

}
