class Solution {
    private static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysFromEpoch(date1) - daysFromEpoch(date2));
    }
    private int daysFromEpoch(String date) {
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        int days = day;
        // Add days for preceding years since 1971
        for (int y = 1971; y < year; y++) {
            days += isLeapYear(y) ? 366 : 365;
        }
        // Add days for preceding months in the current year
        for (int m = 1; m < month; m++) {
            days += DAYS_IN_MONTH[m - 1];
            if (m == 2 && isLeapYear(year)) {
                days += 1;
            }
        }
        return days;
    }
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
