package snippet;

public class Snippet {
	<?xml version="1.0" encoding="UTF-8"?>
	
	
	<Configuration status="WARN"> 
	
	<Properties>
			<Property name="basePath">./logs</Property>
	</Properties>
	
	
	 <Appenders>
	    <Console name="Console" target="SYSTEM_OUT">
	      <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
	    </Console>
	    
	  <RollingFile name="File" fileName="${basePath}/automation.log" filePattern="${basePath}/automation-%d{yyyy-MM-dd}.log">
	     <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
	      <SizeBasedTriggeringPolicy size="5000" />
	   </RollingFile>
	      
	  </Appenders>
	  
	  <Loggers>
	    <Root level="Info"><!-- Here you can use multiple log levels All < Trace < Debug < Info < Warn < Error < Fatal < Off -->
	      <!-- <AppenderRef ref="Console"/> -->
	      <AppenderRef ref="File"/> 
	    </Root>
	  </Loggers>
	  
	</Configuration>
}

