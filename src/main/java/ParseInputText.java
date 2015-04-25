import java.sql.Timestamp;
import java.util.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


public class ParseInputText {
    public static final String MONTH = "month";
    public static final String DAY = "day";
    public static final String HOUR = "hour";
    public static final String MINUTE = "minute";
    public ParseInputText() {
    }
    public static String getParseData(String stringData) {
        String s = stringData;
        s = s.replaceAll(MONTH + 's', MONTH)
                .replaceAll(DAY + 's', DAY)
                .replaceAll(HOUR + 's', HOUR)
                .replaceAll(MINUTE + 's', MINUTE);
        List<String> m = Arrays.asList(s.split(" "));
        int month = 0;
        int day = 0;
        int hour = 0;
        int minutes = 0;
        if (m.contains(MONTH)) month = Integer.parseInt(m.get(m.indexOf(MONTH) - 1));
        if (m.contains(DAY)) day = Integer.parseInt(m.get(m.indexOf(DAY) - 1));
        if (m.contains(HOUR)) hour = Integer.parseInt(m.get(m.indexOf(HOUR) - 1));
        if (m.contains(MINUTE)) minutes = Integer.parseInt(m.get(m.indexOf(MINUTE) - 1));
        if (  month == 0 && day==0 & hour==0 & minutes==0 ){
            System.out.println("You have not one correct parametrs");
            System.exit(0);

        }
        // System.out.printf("month = %d | day = %s | hour = %s | min = %d\n", month, day, hour, minutes);
        System.out.println(month);
        System.out.println(day);
        System.out.println(hour);
        System.out.println(minutes);


        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -month);
        c.add(Calendar.DAY_OF_MONTH, -day);
        c.add(Calendar.HOUR_OF_DAY,-hour);
        c.add(Calendar.MINUTE, -minutes);
        Date date = c.getTime();
        System.out.println("DATE" + date);
        long dateLong = date.getTime()/1000;
        System.out.println();
        System.out.println(String.valueOf(dateLong));
       return String.valueOf(dateLong);

    }
}
