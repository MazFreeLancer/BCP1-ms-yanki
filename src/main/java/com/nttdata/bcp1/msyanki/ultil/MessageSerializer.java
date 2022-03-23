package com.nttdata.bcp1.msyanki.ultil;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.bcp1.msyanki.model.MessageDTO;

import org.apache.kafka.common.serialization.Serializer;
import org.springframework.data.redis.serializer.SerializationException;


public class MessageSerializer implements Serializer<MessageDTO> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, MessageDTO messageDto) {
        try {
            if (messageDto == null){
                System.out.println("Null received at serializing");
                return null;
            }
            System.out.println("Serializing...");
            return objectMapper.writeValueAsBytes(messageDto);
        } catch (Exception e) {
            throw new SerializationException("Error when serializing MessageDto to byte[]");
        }
    }

}
