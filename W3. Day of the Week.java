class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};        
        int totalDays = 0;        
        // Add days for past years starting from 1971
        for (int y = 1971; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }        
        // Add days for past months in the current year
        for (int m = 0; m < month - 1; m++) {
            totalDays += daysInMonth[m];
            if (m == 1 && isLeapYear(year)) {
                totalDays++;
            }
        }        
        // Add days in the current month
        totalDays += day - 1;        
        // January 1, 1971 was a Friday (index 5 in days array)
        return days[(totalDays + 5) % 7];
    }
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
