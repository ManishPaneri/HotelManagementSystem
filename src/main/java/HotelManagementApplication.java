
import utils.RequestHandler;

import java.util.Scanner;


/**
 *
 * @author Manish
 */
public class HotelManagementApplication {
    private static RequestHandler requestHandler = new RequestHandler();

    public static void main(String[] args) {

        // Using Console to input data from user
        Scanner in = new Scanner(System.in);
        while (true) {
            String input = in.nextLine();
            requestHandler.requestMapping(input);
        }
    }
}
