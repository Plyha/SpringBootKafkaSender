package plyha.com.demo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class Consumer {

    private final Path dir = Paths.get(".\\SavedMessagesFolder");

    @KafkaListener(topics = {"String_Kafka"})
    public void listen(ConsumerRecord<?, ?> record) {

        System.out.printf("topic = %s, offest = %d, value = %s\n",record.topic(),record.offset(),record.value());
        createDir();
        saveMessage(record);

    }
    private void saveMessage(ConsumerRecord<?, ?> record){

        String fileName = record.topic()+record.offset()+".txt";
        try(FileWriter fw = new FileWriter(dir+ File.separator + fileName,false)) {
            String text = record.value().toString();
            fw.write(text);
            System.out.printf("The file %s was saved in root directory\n", fileName);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void createDir(){

        if(!Files.exists(dir)){
            try {
                Files.createDirectories(dir);
            }catch (IOException e){
                System.out.printf("Can't create the directory %s\n",dir);
            }
        }
    }
}
