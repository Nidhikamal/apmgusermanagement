package com.bourntec.apmg.usermanagement.v1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

import com.bourntec.apmg.usermanagement.v1.queue.MessagePublisher;
import com.bourntec.apmg.usermanagement.v1.queue.RedisMessagePublisher;
import com.bourntec.apmg.usermanagement.v1.queue.RedisMessageSubscriber;

@Configuration
@ComponentScan("com.bourntec.redis")
@EnableRedisRepositories(basePackages = "com.bourntec.redis.repository")
@PropertySource("classpath:application.properties")
public class RedisConfig {
	@Value("${spring.redis.host}")
	String hostName;

	@Value("${spring.redis.port}")
	Integer port;

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(hostName, port);
		return new JedisConnectionFactory(redisStandaloneConfiguration);

	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
		return template;
	}

	@Bean
	RedisMessageListenerContainer redisContainer() {
		final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(jedisConnectionFactory());
		container.addMessageListener(messageListenerAdapter(receiver()),
				new PatternTopic("receiveMessage"));

		return container;
	}

	@Bean
	RedisMessageSubscriber receiver() {
		return new RedisMessageSubscriber();
	}

	@Bean("messageListenerAdapter")
	MessageListenerAdapter messageListenerAdapter(RedisMessageSubscriber redisReceiver) {
		return new MessageListenerAdapter(redisReceiver, "receiveMessage");
	}


	@Bean
	MessagePublisher redisPublisher() {// String channelName
		return new RedisMessagePublisher(redisTemplate(), topic("firstQ"));
	}

	@Bean
	ChannelTopic topic(String channelName) {
		return new ChannelTopic(channelName);
	}
}
