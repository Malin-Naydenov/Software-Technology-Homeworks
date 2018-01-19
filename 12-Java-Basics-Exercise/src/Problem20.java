import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Problem20 {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();

        startDate.setTime(format.parse(scanner.nextLine()));
        endDate.setTime(format.parse(scanner.nextLine()));

        ArrayList<Calendar> holidays = getHolidays(format);

        int workingDays = 0;

        endDate.add(Calendar.DATE, 1);
        for (Calendar currDate = startDate; currDate.before(endDate); currDate.add(Calendar.DATE, 1)) {
            boolean isHoliday = false;

            if (currDate.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
                    || currDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                isHoliday = true;
            }
            for (Calendar holiday : holidays) {
                if (holiday.get(Calendar.DAY_OF_MONTH) == currDate.get(Calendar.DAY_OF_MONTH)
                        && holiday.get(Calendar.MONTH) == currDate.get(Calendar.MONTH)) {
                    isHoliday = true;
                    break;
                }
            }

            if (!isHoliday) {
                workingDays++;
            }
        }
        System.out.println(workingDays);
    }

    public static ArrayList<Calendar> getHolidays(SimpleDateFormat format) throws ParseException {

        ArrayList<Calendar> holidays = new ArrayList<>();

        for (int i = 0; i < 11; i++) {
            holidays.add(Calendar.getInstance());
        }

        holidays.get(0).setTime(format.parse("01-01-1970"));
        holidays.get(1).setTime(format.parse("03-03-1970"));
        holidays.get(2).setTime(format.parse("01-05-1970"));
        holidays.get(3).setTime(format.parse("06-05-1970"));
        holidays.get(4).setTime(format.parse("24-05-1970"));
        holidays.get(5).setTime(format.parse("06-09-1970"));
        holidays.get(6).setTime(format.parse("22-09-1970"));
        holidays.get(7).setTime(format.parse("01-11-1970"));
        holidays.get(8).setTime(format.parse("24-12-1970"));
        holidays.get(9).setTime(format.parse("25-12-1970"));
        holidays.get(10).setTime(format.parse("26-12-1970"));

        return holidays;
    }
}
