package org.oj.conf;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConf {

    @Bean
    public Queue queue() {
        return new Queue("exec_c", true);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("exec_dir", true, false);
    }

    @Bean
    public Binding bindingDirect() {
        return BindingBuilder.bind(queue()).to(directExchange()).with("exec.run.c");
    }

}
