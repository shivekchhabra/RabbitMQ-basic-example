import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Consumer {

	public static void main(String[] args) throws Exception {
		String q_name = "my_queue";

		// Setting up connection and channel
		ConnectionFactory fac = new ConnectionFactory();
		fac.setHost("localhost");
		Connection con = fac.newConnection();
		Channel channel = con.createChannel();
		// Imp! - We didn't use try with close here cuz we want this code to always stay
		// active.
		// Using that would just close and code would end.

		// Declaring queue as consumer might run before producer.
		// So queue should be there.
		channel.queueDeclare(q_name, false, false, false, null);

		System.out.println("Waiting...");
		

		// Consuming it over the queue.
		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");
			System.out.println(message);
		};
		channel.basicConsume(q_name, true, deliverCallback, consumerTag -> {
		});

	}
}