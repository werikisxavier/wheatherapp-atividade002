package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

    private static DateFormat instance = null;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");

    private DateFormat() {
    }

    public static DateFormat getInstance() {
        if (instance == null) {
            instance = new DateFormat();
        }
        return instance;
    }

    public static Date parseStringToDate(String date) {
        Date data = null;

        try {
            data = sdf.parse(date);
            return data;
        } catch (ParseException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return data;
    }

    public static String parseDateToString(Date date) {
        if (date == null) {
            return null;
        }
        return sdf.format(date);
    }

        public static String parseToString(Date date) {
        if (date == null) {
            return null;
        }
        return sdf1.format(date);
    }

}
