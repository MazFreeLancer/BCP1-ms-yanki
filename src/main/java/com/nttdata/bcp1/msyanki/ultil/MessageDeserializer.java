package com.nttdata.bcp1.msyanki.ultil;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.bcp1.msyanki.model.MessageDTO;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.data.redis.serializer.SerializationException;

public class MessageDeserializer implements Deserializer<MessageDTO> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public MessageDTO
    deserialize(String topic, byte[] data) {
        try {
            if (data == null){
                System.out.println("Null received at deserializing");
                return null;
            }
            System.out.println("Deserializing...");
            return objectMapper.readValue(new String(data, "UTF-8"), MessageDTO.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to Message...");
        }
    }
}
