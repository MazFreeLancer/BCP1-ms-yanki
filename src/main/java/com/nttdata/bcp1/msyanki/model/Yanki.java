package com.nttdata.bcp1.msyanki.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("yanki")
public class Yanki {
    @Id
    String id;
    String documentNumber;
    String phoneNumber;
    String email;
    String cardNumber;
    Double balance;
}
