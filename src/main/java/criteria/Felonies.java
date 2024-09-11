package criteria;

import models.Applicant;
import models.Decision;
import models.Results;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Felonies implements IResults {

    @Override
    public Results getDecision(Applicant applicant) {
        if (applicant.getFelonies()) {
            List<LocalDate> validFelonyDates = new ArrayList<>();
            for (LocalDate felonyDate : applicant.getFelonyDates()) {
                // Get the current date
                LocalDate currentDate = LocalDate.now();
                System.out.println(currentDate);

                // Calculate the number of days between the two dates
                long daysBetween = ChronoUnit.DAYS.between(felonyDate, currentDate);

                // Convert days to years with a floating-point representation
                double yearsBetween = daysBetween / 365.00;

                // Check if the period is greater than or equal to 5 years
                if (yearsBetween <= 5) {
                    System.out.println(yearsBetween);
                    validFelonyDates.add(felonyDate);
                }
            }
            // Define a DateTimeFormatter to format dates as desired
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

            // Convert LocalDate objects to formatted strings
            String formattedDates = validFelonyDates.stream()
                    .map(date -> date.format(formatter)) // Format each date
                    .collect(Collectors.joining(", ")); // Join formatted dates with a comma and space

            if (!validFelonyDates.isEmpty()) {
                return new Results(String.format("%d felonies found over the past 5 years: %s", validFelonyDates.size(), formattedDates), Decision.REJECT);
            }

        }
        return new Results("No felonies found over the past 5 years", Decision.ACCEPT);
    }
}
