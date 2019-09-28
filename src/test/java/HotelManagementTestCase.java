import org.junit.Test;
import utils.FileReader;
import utils.RequestHandler;

import java.util.ArrayList;

public class HotelManagementTestCase {
    private  static FileReader fileReader = new FileReader();
    private  static RequestHandler requestHandler = new RequestHandler();

    @Test
    public void testCaseForRoomsAvailability()
    {
        ArrayList<String> inputArr = fileReader.getFileInput("TestFile/testcase.txt");
        inputArr.stream().forEach(input->{
            System.out.println(input);
            requestHandler.requestMapping(input);
        });

    }
}
