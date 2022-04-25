import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.rabbitmq.client.Channel;

public class Producer {
	public static void main(String[] args) throws Exception {

		// Setting a connection factory object pointing to localhost
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");

		// Next create a channel object where most of the API commands reside
		// For creating a channel we need to create a Connection object
		// And since both implement java.io.Closeable, we put them under try so
		// we dont have to explicitly close them.
		try (Connection con = factory.newConnection(); Channel channel = con.createChannel();) {

			channel.queueDeclare("my_queue", false, false, false, null);
			// docs can be found, this is a simple setup

			// Reading a story and then publishing it:
			String message = readStory();
			channel.basicPublish("", "my_queue", null, message.getBytes());
			System.out.println("Message Sent!");

		}

	}

	static String readStory() throws FileNotFoundException {

		// Reading a story to send and lets see if receiver can read it.
		File f = new File("./story.txt");
		Scanner sc = new Scanner(f);
		String story = "";
		while (sc.hasNextLine())
			story = story + sc.nextLine() + "\n";

		return story;

	}
}