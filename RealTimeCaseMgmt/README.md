https://dzone.com/articles/spring-jms-message-automatic

https://github.com/bsnyder/spring-jms-examples/blob/master/sync/jms-template/src/main/java/org/bsnyder/spring/jms/producer/SimpleMessageProducer.java

<!-- The ActiveMQ connection factory with specification of the server URL -->
	<bean id="activeMQConnectionFactory"
		class="org.apache.activemq.ActiveMQConnectionFactory">
		<property name="brokerURL" value="tcp://localhost:61616" />
	</bean>

	<!-- The name of the queue from which we will take the messages -->
	<bean id="origin"
		class="org.apache.activemq.command.ActiveMQQueue">
		<constructor-arg value="${jms.origin}" />
	</bean>
	<!-- The name of the queue to which we will route the messages -->
	<bean id="destination"
		class="org.apache.activemq.command.ActiveMQQueue">
		<constructor-arg value="${jms.destination}" />
	</bean>


	<!-- Spring's jms connection factory -->
	<bean id="cachingConnectionFactory"
		class="org.springframework.jms.connection.CachingConnectionFactory">
		<property name="targetConnectionFactory"
			ref="activeMQConnectionFactory" />
		<property name="sessionCacheSize" value="10" />
	</bean>