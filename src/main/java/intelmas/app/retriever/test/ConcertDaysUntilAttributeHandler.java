package intelmas.app.retriever.test;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;




public class ConcertDaysUntilAttributeHandler {
	
	public static void main(String[] args) {

	    System.out.println("99: "+toZonedDateTime(new Date()));
	    System.out.println("100.-Days: "+get());
	  }

	
	public static Long get()
    {
		final Date futureDate = new Date(new Date().getTime() + 49 * 60 * 60 * 1000);
        final ZonedDateTime concertDate = toZonedDateTime(futureDate);
        final ZonedDateTime now = ZonedDateTime.now();
        System.out.println("001.- "+now.getDayOfMonth()+"/"+
        		now.getMonth()+"/:"+now.getYear()+" "
        		+"Time:"+
        now.getHour()+":"+now.getMinute()+":"+now.getSecond());
        if (concertDate.isBefore(now))
        {
            return Long.valueOf(0L);
        }
                
        final Duration duration = Duration.between(now, concertDate);
        return Long.valueOf(duration.toDays());
    }
	
	public static ZonedDateTime toZonedDateTime(Date utilDate) {
	    if (utilDate == null) {
	      return null;
	    }
	    final ZoneId systemDefault = ZoneId.systemDefault();
	    return ZonedDateTime.ofInstant(utilDate.toInstant(), systemDefault);
	  }
	

}
