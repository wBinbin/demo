package com.mq.rabbitmq;

public class RabbitMQDemo {

	private static final String exchange = "topic_log";

	public static void main(String[] args) {
		publishAndSubscribe();
	}

	private static void publishAndSubscribe() {
		new Thread(() -> {
			Subscribe s1 = new Subscribe();
			s1.receive("s1", exchange, new String[] { "*.c1.*" });
		}).start();

		new Thread(() -> {
			Subscribe s2 = new Subscribe();
			s2.receive("s2", exchange, new String[] { "*.*.c2", "c2.#" });
		}).start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		new Thread(() -> {
			Publish p1 = new Publish();
			p1.send("p1", exchange, "a.c1.b", " 1 to s1 ( a.c1.b ) "); // yes
			p1.send("p1", exchange, "a.c1", " 2 to s1 ( a.c1 ) "); // no

			p1.send("p1", exchange, "m.n.c2", " 3 to s2 ( m.n.c2 ) "); // yes
			p1.send("p1", exchange, "m.n.l.c2", " 4 to s2 ( m.n.l.c2 ) "); // no

			p1.send("p1", exchange, "c2.y.z", " 5 to s2 ( c2.y.z ) "); // yes
		}).start();
	}

}
