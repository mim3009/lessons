package la;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
public class HotelServiceTest {
protected HotelService hotelService;
@Before
public void prepareTest() {
hotelService = new HotelService();
assertNotNull(hotelService);
}
@Test
public void testHotelServiceNullFields() {
assertNull(hotelService.findAvailableCities());
assertNull(hotelService.find());
}
}

