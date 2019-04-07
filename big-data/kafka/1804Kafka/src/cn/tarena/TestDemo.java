package cn.tarena;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.security.JaasUtils;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.Test;

import kafka.admin.AdminUtils;
import kafka.admin.RackAwareMode;
import kafka.utils.ZkUtils;

public class TestDemo {

	/*
	 * 通过代码连接Kafka服务并生成数据
	 */
	@Test
	public void producer() throws  ExecutionException{
		Properties props=new Properties();
		props.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.150.137:9092,192.168.150.138:9092");

		Producer<Integer, String> kafkaProducer = new KafkaProducer<Integer, String>(props);
		for(int i=0;i<100;i++){
			ProducerRecord<Integer, String> message
					= new ProducerRecord<Integer, String>("jpbook",""+i);
			kafkaProducer.send(message);
		}

		while(true);
	}

	@Test
	public void create_topic(){

		ZkUtils zkUtils = ZkUtils.apply(
				"192.168.150.137:2181,"
						+ "192.168.150.138:2181,"
						+ "192.168.150.139:2181",
				30000, 30000, JaasUtils.isZkSecurityEnabled());
		// 创建一个单分区单副本名为t1的topic
		//--①参：zk连接参数 ②参:主题名  ③参:分区数  ④参:副本数
		AdminUtils.createTopic(zkUtils, "t2",3,2, new Properties(), RackAwareMode.Enforced$.MODULE$);
		zkUtils.close();
	}

	/*
	 * 删除主题
	 */
	@Test
	public void delete_topic(){
		ZkUtils zkUtils = ZkUtils.apply("192.168.150.137:2181,192.168.150.138:2181,192.168.150.139:2181", 30000, 30000, JaasUtils.isZkSecurityEnabled());
		// 删除topic 't1'
		AdminUtils.deleteTopic(zkUtils, "t1");
		zkUtils.close();
	}

	/*
	 * 消费数据
	 */
	@Test
	public void consumer_1(){
		Properties props = new Properties();
		//--设置kafka的服务列表
		props.put("bootstrap.servers", "192.168.150.137:9092,192.168.150.138:9092");
		//--指定当前的消费者属于哪个消费者组 g1是自己定的
		props.put("group.id", "g1");
		props.put("key.deserializer", StringDeserializer.class.getName());
		props.put("value.deserializer", StringDeserializer.class.getName());
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

		//--指定消费者消费的主题，可以指定多个
		consumer.subscribe(Arrays.asList("enbook", "t2"));

		try {
			while (true) {
				//--消费者从分区队列中消费数据，用到poll阻塞方法，如果没有数据可以消费，则一直阻塞
				ConsumerRecords<String, String> records = consumer.poll(Long.MAX_VALUE);
				for (ConsumerRecord<String, String> record : records)

					System.out.println("g1组c1消费者,分区编号:"+record.partition()+"offset:"+record.offset() + ":" + record.value());
			}
		} catch (Exception e) {
		} finally {
			consumer.close();
		}
	}


	@Test
	public void consumer_2(){
		Properties props = new Properties();
		props.put("bootstrap.servers", "192.168.150.137:9092,192.168.150.138:9092");
		//--指定当前的消费者属于哪个消费者组 g1是自己定的
		props.put("group.id", "g1");
		props.put("key.deserializer", StringDeserializer.class.getName());
		props.put("value.deserializer", StringDeserializer.class.getName());
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

		//--指定消费者消费的主题，可以指定多个
		consumer.subscribe(Arrays.asList("enbook", "t2"));

		try {
			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(Long.MAX_VALUE);
				for (ConsumerRecord<String, String> record : records)
					System.out.println("g1组c2消费者,分区编号:"+record.partition()+"offset:"+record.offset() + ":" + record.value());
			}
		} catch (Exception e) {
		} finally {
			consumer.close();
		}
	}
	@Test
	public void testE(){

		int a=Math.abs("console-consumer-45471".hashCode())%50;
		System.out.println(a);

	}





}
