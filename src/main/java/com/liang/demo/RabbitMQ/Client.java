package com.liang.demo.RabbitMQ;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

import java.io.IOException;

/**
 * @author : liyang
 * @date : 2021/10/6
 * rabbitMQ消费者
 */
public class Client {
    public static void main(String[] args) throws Exception {
        //连接工厂
        ConnectionFactory f = new ConnectionFactory();
        f.setHost("ip地址");
        f.setUsername("admin");
        f.setPassword("admin");
        //建立连接
        Connection c = f.newConnection();
        //建立信道
        Channel ch = c.createChannel();
        //声明队列,如果该队列已经创建过,则不会重复创建
        ch.queueDeclare("task_queue", true, false, false, null);
        System.out.println("等待接收数据");

        //收到消息后用来处理消息的回调对象
        DeliverCallback callback = new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery message) throws IOException {
                String msg = new String(message.getBody(), "UTF-8");
                System.out.println("收到: " + msg);
                //遍历字符串中的字符,每个点使进程暂停一秒
                for (int i = 0; i < msg.length(); i++) {
                    if (msg.charAt(i) == '.') {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                    }
                }
                System.out.println("处理结束");
                //参数1：消息标签，参数2：是否确认多条消息
                ch.basicAck(message.getEnvelope().getDeliveryTag(), false);
            }
        };

        //消费者取消时的回调对象
        CancelCallback cancel = new CancelCallback() {
            @Override
            public void handle(String consumerTag) throws IOException {
            }
        };
        //一次只能接受一条数据
        ch.basicQos(1);

        //第二个参数为消息回执，消息确认处理完成，为true为自动确认，只要消息发送到消费者即消息处理成功;为false为，手动发送确认回执，服务器才认为这个消息处理成功
        ch.basicConsume("task_queue", false, callback, cancel);
    }
}
