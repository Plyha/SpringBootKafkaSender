# SpringBootKafkaSender
 
Самый простой клиент для отправки сообщений с использованием SpringBoot и брокера сообщений Kafka <br/>

Как настроить среду: <br/>
1.Распаковать архив kafka_2.13-3.2.1 в корень диска C:\ <br/>

2.Запустить Zookeper.В CMD ввести ```bash C:\kafka_2.13-3.2.1\bin\windows\zookeeper-server-start.bat C:\kafka_2.13-3.2.1\config\zookeeper.properties ``` <br/>

3.Запустить Server Kafka.В CMD ввести ```bash C:\kafka_2.13-3.2.1\bin\windows\kafka-server-start.bat C:\kafka_2.13-3.2.1\config\server.properties``` <br/>

4.Открыть через IDE проект и запустить файл SpringKafkaApplication.java <br/>

5.Запустить Consumer.В CMD ввести ```bash  C:\kafka_2.13-3.2.1\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic stirng_java --from-beginning ``` <br/>

6.Ввести данный текст в браузере/Postman, где message произвольное сообщение, к примеру test http://localhost:8080/kafka/producer?message=test <br/>

7.В корне проекта появится папка "SavedMessagesFolder" куда будут складываться все сообщения. <br/>
