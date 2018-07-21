# bachelor_thesis
## Apache Flink
### Cluster start
```bash
bin/start-cluster.sh
```
### Cluster stop
```bash
bin/stop-cluster.sh
```
### Task Executor
```bash
tail -f log/flink-*-taskexecutor-*.out
```
## Apache Kafka
### console-consumer
```bash
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
```
### console-producer
```bash
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test
```
### Kafka Server starten
```bash
bin/kafka-server-start.sh config/server.properties
```
### Zookeeper starten
```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
```