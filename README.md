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
### Start Taskmanager
```
bin/taskmanager.sh start
```
### Stop Taskmanager
```
bin/taskmanager.sh stop
```
### Task Executor
```bash
tail -f log/flink-*-taskexecutor-*.out
```
## Apache Kafka
### Zookeeper starten
```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
```
### Kafka Server starten
```bash
bin/kafka-server-start.sh config/server.properties
```
### Kafka create topics
```bash
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic StockPrices
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic TweetTerms
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic TweetUsers
in/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic TEMTweets
in/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic NPTweets
in/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic StockPriceUpEvents
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic RateFluctuationEvents
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic HotTopicEvents
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic ImpactTweetSMEvents
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic ImpactTweetCMEvents
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic ImpactTweetStoreEvents

```
### console-producer
```bash
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test
```
### console-consumer
```bash
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
```


