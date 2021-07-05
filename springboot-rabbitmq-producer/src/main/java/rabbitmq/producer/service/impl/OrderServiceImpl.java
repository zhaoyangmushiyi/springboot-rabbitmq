package rabbitmq.producer.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rabbitmq.producer.service.IOrderService;

import java.util.UUID;

/**
 * @author monochrome
 * @date 2021/7/5
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void createOrder() {
        String uuid = UUID.randomUUID().toString();
        System.out.println("生成订单：" + uuid);
        String exchangeName = "fanout-order-exchange";
        String routingKey = "";
        rabbitTemplate.convertAndSend(exchangeName, routingKey, uuid);
    }

}
