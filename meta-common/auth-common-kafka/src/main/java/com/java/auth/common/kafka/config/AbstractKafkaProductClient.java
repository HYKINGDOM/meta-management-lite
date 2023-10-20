package com.java.auth.common.kafka.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import java.util.concurrent.CompletableFuture;

/**
 * @param <K>
 * @param <V>
 * @author kscs
 */
@Slf4j
public abstract class AbstractKafkaProductClient<K, V> {
    private KafkaTemplate<K, V> kafkaTemplate;

    public AbstractKafkaProductClient() {
    }

    protected void setKafkaTemplate(KafkaTemplate<K, V> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, V value) {
        this.kafkaTemplate.send(topic, value);
    }

    public void send(String topic, K key, V value) {
        this.kafkaTemplate.send(topic, key, value);
    }

    public void send(String topic, int partition, K key, V value) {
        this.kafkaTemplate.send(topic, partition, key, value);
    }

    public void send(String topic, int partition, long timestamp, K key, V value) {
        this.kafkaTemplate.send(topic, partition, timestamp, key, value);
    }

    public void asyncSend(String topic, final V data) {
        CompletableFuture<SendResult<K, V>> future = this.kafkaTemplate.send(topic, data);

    }

    public void asyncSend(String topic, final K key, final V data) {
        CompletableFuture<SendResult<K, V>> future = this.kafkaTemplate.send(topic, key, data);

    }

    public void asyncSend(String topic, int partition, final K key, final V data) {
        CompletableFuture<SendResult<K, V>> future = this.kafkaTemplate.send(topic, partition, key, data);

    }

    public void asyncSend(String topic, int partition, long timestamp, final K key, final V data) {
        CompletableFuture<SendResult<K, V>> future = this.kafkaTemplate.send(topic, partition, timestamp, key, data);

    }
}
