/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.twitter.TwitterSource;

import java.util.Properties;

/**
 * Skeleton for a Flink Streaming Job.
 *
 * <p>For a tutorial how to write a Flink streaming application, check the
 * tutorials and examples on the <a href="http://flink.apache.org/docs/stable/">Flink Website</a>.
 *
 * <p>To package your appliation into a JAR file for execution, run
 * 'mvn clean package' on the command line.
 *
 * <p>If you change the name of the main class (with the public static void main(String[] args))
 * method, change the respective entry in the POM.xml file (simply search for 'mainClass').
 */
public class StreamingJob {

	public static void main(String[] args) throws Exception {

		Properties props = new Properties();
		props.setProperty(TwitterSource.CONSUMER_KEY, "qzNlqrFckPFTsp6bQchKlhI3o");
		props.setProperty(TwitterSource.CONSUMER_SECRET, "mQMxCb2mb9NBkxZ28ozV9HV2oyEwfkVdSYDJgOPa6suGKPvBDZ");
		props.setProperty(TwitterSource.TOKEN, "1006501086100942848-uvX2b6VJq0y5rzZLmNlKQSadbqRJGY");
		props.setProperty(TwitterSource.TOKEN_SECRET, "0O4CvsXeKUof13lkPFaLIwdG8pD7MtlOWq6ES9gyULR6A");

		// set up the streaming execution environment
		StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

		DataStream<String> inputTwitterStream = env.addSource(new TwitterSource(props));

		inputTwitterStream.print();

		env.execute("StreamingJob");
	}
}
