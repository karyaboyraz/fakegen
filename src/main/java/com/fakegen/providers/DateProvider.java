package com.fakegen.providers;

import com.fakegen.RandomService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateProvider {
    private final RandomService random;

    public DateProvider(RandomService random) {
        this.random = random;
    }

    public String today() {
        LocalDate today = LocalDate.now();
        return today.toString();
    }

    public String tomorrow() {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        return tomorrow.toString();
    }

    public String yesterday() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        return yesterday.toString();
    }

    public String randomDateInPast() {
        int daysToSubtract = random.nextInt(365);
        LocalDate randomDate = LocalDate.now().minusDays(daysToSubtract);
        return randomDate.toString();
    }

    public String randomDateInFuture() {
        int daysToAdd = random.nextInt(365);
        LocalDate randomDate = LocalDate.now().plusDays(daysToAdd);
        return randomDate.toString();
    }

    public String randomDateBetween(LocalDate start, LocalDate end) {
        long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(start, end);
        long randomDays = random.nextInt((int) daysBetween + 1);
        LocalDate randomDate = start.plusDays(randomDays);
        return randomDate.toString();
    }

    public String randomHours() {
        int hours = random.nextInt(24);
        return String.format("%02d:00", hours);
    }

    public String RandomHoursAndMinutes() {
        int hours = random.nextInt(24);
        int minutes = random.nextInt(60);
        return String.format("%02d:%02d", hours, minutes);
    }

    public LocalDate date() {
        return LocalDate.now().plusDays(random.nextInt(365) - 365);
    }

    public LocalTime time() {
        return LocalTime.of(
            random.nextInt(24),
            random.nextInt(60),
            random.nextInt(60)
        );
    }

    public LocalDateTime dateTime() {
        return LocalDateTime.of(date(), time());
    }

    public String dateString(String pattern) {
        return date().format(DateTimeFormatter.ofPattern(pattern));
    }

    public String timeString(String pattern) {
        return time().format(DateTimeFormatter.ofPattern(pattern));
    }

    public String dateTimeString(String pattern) {
        return dateTime().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static void main(String[] args) {
        DateProvider dateProvider = new DateProvider(new RandomService());
        System.out.println("Today: " + dateProvider.today());
        System.out.println("Tomorrow: " + dateProvider.tomorrow());
        System.out.println("Yesterday: " + dateProvider.yesterday());
        System.out.println("Random Date in Past: " + dateProvider.randomDateInPast());
        System.out.println("Random Date in Future: " + dateProvider.randomDateInFuture());
        System.out.println("Random Date Between: " + dateProvider.randomDateBetween(LocalDate.of(2020, 1, 1), LocalDate.of(2023, 1, 1)));
        System.out.println("Random Hours: " + dateProvider.randomHours());
        System.out.println("Random Hours and Minutes: " + dateProvider.RandomHoursAndMinutes());
        System.out.println("Random Date: " + dateProvider.date());
        System.out.println("Random Time: " + dateProvider.time());
        System.out.println("Random DateTime: " + dateProvider.dateTime());
        System.out.println("Random Date String: " + dateProvider.dateString("yyyy-MM-dd"));
        System.out.println("Random Time String: " + dateProvider.timeString("HH:mm:ss"));
        System.out.println("Random DateTime String: " + dateProvider.dateTimeString("yyyy-MM-dd HH:mm:ss"));
        System.out.println("Random Date String: " + dateProvider.dateString("dd/MM/yyyy"));

    }
}
