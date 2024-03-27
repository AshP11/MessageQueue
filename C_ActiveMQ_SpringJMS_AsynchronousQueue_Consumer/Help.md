###This is a Spring project demonstrating Asynchronous working of Active MQ using Spring JMS API and Active MQ API
###using Message Listener

- Use MessageProducerApp from B_ActiveMQ_SpringJMS_Annotations_SynchronousQueue to send the Product data to the queue.
- Then start this application
- Try sending data multiple times to see the asynchronous behaviour in this current application logs
- As soon as message has been sent from the Producer to the queue and current application is running,
we should get the corresponding logs immediately.


#Reference
Receiving Messages Asynchronously from ActiveMQ Queue using MessageListener | Spring+ JMS+ActiveMQ
https://www.youtube.com/watch?v=K5VbMkv_poE&list=PLmCsXDGbJHdgt5mskUPyhtBHQvQsRoJWj&index=9