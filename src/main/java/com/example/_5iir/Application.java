package com.example._5iir;

import com.example._5iir.entities.BankAccount;
import com.example._5iir.enums.AccoutType;
import com.example._5iir.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository)
    {
        return args -> {
            for(int i=0; i<10 ; i++)
            {
                BankAccount bankAccount=BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .type(Math.random()>0.5? AccoutType.CURRENT_ACCOUNT:AccoutType.SAVING_Account)
                        .balance(10000+Math.random()+90000)
                        .createdAt(new Date())
                        .currency("MAD")
                        .build();
                bankAccountRepository.save(bankAccount);
            }
        };
    }

}
