package isp.consulting.app.EcommerceISPConsulting.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ClockPE {

	public static String getClockLima() {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(ZonedDateTime.now(ZoneId.of("America/Lima")));
	}

}
