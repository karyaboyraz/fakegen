package com.fakegen.providers;

import com.fakegen.util.RandomService;
import com.fakegen.util.DataLoader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NameProvider {
    private final RandomService random;

    public NameProvider(RandomService random) {
        this.random = random;
    }

    public String firstName() {
        return random.randomElement(DataLoader.getListData("name", "first_names"));
    }

    public String lastName() {
        return random.randomElement(DataLoader.getListData("name", "last_names"));
    }

    public String fullName() {
        return firstName() + " " + lastName();
    }

    public String prefix() {
        return random.randomElement(DataLoader.getListData("name", "prefixes"));
    }

    public String suffix() {
        return random.randomElement(DataLoader.getListData("name", "suffixes"));
    }

    public String title() {
        return random.randomElement(DataLoader.getListData("name", "titles"));
    }

    public String gender() {
        return random.randomElement(DataLoader.getListData("name", "gender"));
    }

    public String jobTitle() {
        return random.randomElement(DataLoader.getListData("name", "titles"));
    }

    public String username() {
        return (firstName().toLowerCase() + random.numerify("###")).replace(" ", "");
    }

    public String turkeyGovIDN() {
        int[] digits = IntStream.concat(
            IntStream.of(random.nextInt(1, 9)),
            IntStream.concat(
                IntStream.range(0, 8).map(i -> random.nextInt(0, 9)),
                IntStream.of(0, 0)
            )
        ).toArray();
        int sumOdd = IntStream.range(0, 9).filter(i -> i % 2 == 0).map(i -> digits[i]).sum();
        int sumEven = IntStream.range(0, 9).filter(i -> i % 2 == 1).map(i -> digits[i]).sum();
        digits[9] = Math.floorMod(sumOdd * 7 - sumEven, 10);
        digits[10] = IntStream.range(0, 10).map(i -> digits[i]).sum() % 10;
        return Arrays.stream(digits)
                     .mapToObj(String::valueOf)
                     .collect(Collectors.joining());
    }

    
    public static void main(String[] args) {
        NameProvider nameProvider = new NameProvider(new RandomService());
        System.out.println("First Name: " + nameProvider.firstName());
        System.out.println("Last Name: " + nameProvider.lastName());
        System.out.println("Full Name: " + nameProvider.fullName());
        System.out.println("Prefix: " + nameProvider.prefix());
        System.out.println("Suffix: " + nameProvider.suffix());
        System.out.println("Title: " + nameProvider.title());
        System.out.println("Gender: " + nameProvider.gender());
        System.out.println("Job Title: " + nameProvider.jobTitle());
        System.out.println("Username: " + nameProvider.username());
        System.out.println("Turkey Gov ID: " + nameProvider.turkeyGovIDN());

    }
}
