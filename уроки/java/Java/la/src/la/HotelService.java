package la;

import java.util.ArrayList;
import java.util.List;

public class HotelService {
	private static String[] cities = { "Chernigov", "Kiev", };
	private static Hotel[] hotels = {
			new Hotel("Ukraine", "pr. Mira, 18", "Chernigov", 2),
			new Hotel("Bryansk", "Shevchenko str.,17", "Chernigov", 2),
			new Hotel("Gradetskiy", "pr. Mira,19", "Chernigov", 3),
			new Hotel("Verhovina", "Krechatik str.,135", "Kiev", 4),
			new Hotel("Krechatik", "Krechatik str.,14", "Kiev", 5), };
	
	private static String[] listies = {
		new String("str1"),
		new String("str2"),new String("str3"),new String("str4"), };

	public List<Hotel> findHotelsByCity(String city) {
		List<Hotel> hotelsFound = new ArrayList<Hotel>();
		for (Hotel hotel : hotels) {
			if (hotel.getCity().equalsIgnoreCase(city)) {
				hotelsFound.add(hotel);
			}
		}
		return hotelsFound;
	}

	public String[] findAvailableCities() {
		return cities;
	}
	
	public List<String> find() {
		List<String> strout = new ArrayList<String>();
		for (String str : listies) {
			strout.add(str);
		}
		return strout;
	}
	
	public List<String> findStrs() {
		List<String> a = find();
		return a;
	}
	
}
