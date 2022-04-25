## What does this repository contain?
This repository contains a simple example of sending a story over rabbit mq.

## Usage:

1. Make sure you have rabbit mq broker downloaded and running.

You can download it from: [Rabbit MQ download](https://www.rabbitmq.com/download.html)

After installing, you can run the broker using:
<pre><code>rabbitmq-server</code></pre>

You can also check available queues and remaining messages using:
<pre>code>sudo rabbitmqctl list_queues</code></pre>


2. The repo uses a maven architecture. Hence you can check the code in src/main/java and the classes under target/classes

To run the code, you can do:

<pre><code>java -cp .:amqp-client-5.7.1.jar:slf4j-api-1.7.26.jar:slf4j-simple-1.7.26.jar Producer
java -cp .:amqp-client-5.7.1.jar:slf4j-api-1.7.26.jar:slf4j-simple-1.7.26.jar Consumer </code></pre>

## References:
1. https://www.rabbitmq.com/tutorials/tutorial-one-java.html
2. https://blog.reedsy.com/short-story/nc54kv/

