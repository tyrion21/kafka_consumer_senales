package com.example.kafka_consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "senales-vitales", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }
}

// package com.example.kafka_consumer.service;

// import com.example.kafka_consumer.entity.SenalVital;
// import com.example.kafka_consumer.repository.SenalVitalRepository;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import org.springframework.kafka.annotation.KafkaListener;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;
// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;
// import java.time.LocalDateTime;

// @Service
// @RequiredArgsConstructor
// @Slf4j
// public class KafkaConsumerService {

//     private final SenalVitalRepository repository;
//     private final ObjectMapper objectMapper;

//     @KafkaListener(topics = "senal_vital_topic", groupId = "group_id")
//     @Transactional
//     public void consume(String message) {
//         try {
//             log.info("Received message: {}", message);

//             SenalVital senalVital = objectMapper.readValue(message, SenalVital.class);
//             senalVital.setFechaRegistro(LocalDateTime.now());

//             SenalVital savedEntity = repository.save(senalVital);
//             log.info("Saved signal with ID: {}", savedEntity.getId());

//         } catch (Exception e) {
//             log.error("Error processing message: {}", e.getMessage(), e);
//         }
//     }
// }