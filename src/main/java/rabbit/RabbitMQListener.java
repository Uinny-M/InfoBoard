//package com.example.InfoBoard;
//
//import org.springframework.amqp.rabbit.annotation.EnableRabbit;
//import org.springframework.stereotype.Component;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//
//import java.util.logging.Logger;
//
//@EnableRabbit
//@Component
//public class RabbitMQListener {
//    Logger log = Logger.getLogger(RabbitMQListener.class.getName());
//
//    @RabbitListener(queues = "queue1")
//    public void processQueue1(String message){
//        log.info("Received from queue1: " + message);
//    }
//}
