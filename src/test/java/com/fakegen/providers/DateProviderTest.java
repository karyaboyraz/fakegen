package com.fakegen.providers;

import com.fakegen.RandomService;
import com.fakegen.locale.FakerLocale;
import com.fakegen.util.DataLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DateProviderTest {
    private DateProvider dateProvider;

    @BeforeEach
    void setUp() {
        DataLoader.setLocale(FakerLocale.TR_TR);
        dateProvider = new DateProvider(new RandomService());
    }

    @Test
    void today_ShouldReturnValidDate() {
        String today = dateProvider.today();
        assertNotNull(today);
        assertFalse(today.isEmpty());
        assertEquals(LocalDate.now().toString(), today);
    }

    @Test
    void tomorrow_ShouldReturnValidDate() {
        String tomorrow = dateProvider.tomorrow();
        assertNotNull(tomorrow);
        assertFalse(tomorrow.isEmpty());
        assertEquals(LocalDate.now().plusDays(1).toString(), tomorrow);
    }

    @Test
    void yesterday_ShouldReturnValidDate() {
        String yesterday = dateProvider.yesterday();
        assertNotNull(yesterday);
        assertFalse(yesterday.isEmpty());
        assertEquals(LocalDate.now().minusDays(1).toString(), yesterday);
    }

    @Test
    void randomDateInPast_ShouldReturnValidDate() {
        String randomDate = dateProvider.randomDateInPast();
        assertNotNull(randomDate);
        assertFalse(randomDate.isEmpty());
        LocalDate date = LocalDate.parse(randomDate);
        assertTrue(date.isBefore(LocalDate.now()));
    }

    @Test
    void randomDateInFuture_ShouldReturnValidDate() {
        String randomDate = dateProvider.randomDateInFuture();
        assertNotNull(randomDate);
        assertFalse(randomDate.isEmpty());
        LocalDate date = LocalDate.parse(randomDate);
        assertTrue(date.isAfter(LocalDate.now()));
    }

    @Test
    void randomDateBetween_ShouldReturnValidDate() {
        LocalDate start = LocalDate.now().minusYears(1);
        LocalDate end = LocalDate.now().plusYears(1);
        String randomDate = dateProvider.randomDateBetween(start, end);
        assertNotNull(randomDate);
        assertFalse(randomDate.isEmpty());
        LocalDate date = LocalDate.parse(randomDate);
        assertTrue(date.isAfter(start) || date.isEqual(start));
        assertTrue(date.isBefore(end) || date.isEqual(end));
    }

    @Test
    void randomHours_ShouldReturnValidTime() {
        String time = dateProvider.randomHours();
        assertNotNull(time);
        assertFalse(time.isEmpty());
        assertTrue(time.matches("^\\d{2}:00$"));
    }

    @Test
    void RandomHoursAndMinutes_ShouldReturnValidTime() {
        String time = dateProvider.RandomHoursAndMinutes();
        assertNotNull(time);
        assertFalse(time.isEmpty());
        assertTrue(time.matches("^\\d{2}:\\d{2}$"));
    }

    @Test
    void date_ShouldReturnValidDate() {
        LocalDate date = dateProvider.date();
        assertNotNull(date);
    }

    @Test
    void time_ShouldReturnValidTime() {
        LocalTime time = dateProvider.time();
        assertNotNull(time);
    }

    @Test
    void dateTime_ShouldReturnValidDateTime() {
        LocalDateTime dateTime = dateProvider.dateTime();
        assertNotNull(dateTime);
    }

    @Test
    void dateString_ShouldReturnValidDateString() {
        String dateString = dateProvider.dateString("yyyy-MM-dd");
        assertNotNull(dateString);
        assertFalse(dateString.isEmpty());
        assertTrue(dateString.matches("^\\d{4}-\\d{2}-\\d{2}$"));
    }

    @Test
    void timeString_ShouldReturnValidTimeString() {
        String timeString = dateProvider.timeString("HH:mm:ss");
        assertNotNull(timeString);
        assertFalse(timeString.isEmpty());
        assertTrue(timeString.matches("^\\d{2}:\\d{2}:\\d{2}$"));
    }

    @Test
    void dateTimeString_ShouldReturnValidDateTimeString() {
        String dateTimeString = dateProvider.dateTimeString("yyyy-MM-dd HH:mm:ss");
        assertNotNull(dateTimeString);
        assertFalse(dateTimeString.isEmpty());
        assertTrue(dateTimeString.matches("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$"));
    }
} 