package rabbitmq.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author monochrome
 * @date 2021/7/5
 */
@Configuration
public class RabbitMQConfiguration {

    @Bean
    public FanoutExchange fanoutOrderExchange() {
        return new FanoutExchange("fanout-order-exchange", true, false);
    }

    @Bean
    public Queue smsQueue() {
        return new Queue("sms.fanout.queue", true);
    }
    @Bean
    public Queue emailQueue() {
        return new Queue("email.fanout.queue", true);
    }
    @Bean
    public Queue wechatQueue() {
        return new Queue("wechat.fanout.queue", true);
    }

    @Bean
    public Binding smsBinding() {
        return BindingBuilder.bind(smsQueue()).to(fanoutOrderExchange());
    }
    @Bean
    public Binding emailBinding() {
        return BindingBuilder.bind(emailQueue()).to(fanoutOrderExchange());
    }
    @Bean
    public Binding wechatBinding() {
        return BindingBuilder.bind(wechatQueue()).to(fanoutOrderExchange());
    }
}
