# kafka-producer-ssm

Uso del servicio System Manager Parameter Store para recuperar y usar parametros de configuración para aplicación spring boot.

Rol de Usuario - Json Policy 
ssm-parameter-store.json

Requisitos: 
Kafka 3.5.0 - https://archive.apache.org/dist/kafka/3.5.0/kafka_2.13-3.5.0.tgz

Uso: 
java -DPROFILE_SSM_STORE="aws-parameterstore:/config/producer-ssm/;/config/producer-ssm_local/" -jar .\target\kafka-producer-ssm-0.0.1-SNAPSHOT.jar
