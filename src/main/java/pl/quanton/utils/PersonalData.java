package pl.quanton.utils;

import pl.quanton.utils.data.Cities;
import pl.quanton.utils.data.LastNames;
import pl.quanton.utils.data.Names;
import pl.quanton.utils.data.Streets;

import java.text.SimpleDateFormat;
import java.util.*;

public class PersonalData {

    private SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
    private String name = getName();
    private String city = getCity();
    private String peselPrefix = peselPrefix();

    public Map<String, String> personalDataSet() {
        return new HashMap<String, String>() {{
            put("name", name);
            put("lastname", getLastname());
            put("city", city);
            put("postalCode", getPostalCode());
            put("street", getStreet());
            put("PESEL", getPesel());
        }};
    }

    private String getName() {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }

    private String getLastname() {
        return LastNames.values()[new Random().nextInt(LastNames.values().length)].toString();
    }

    private String getCity() {
        return Cities.values()[new Random().nextInt(Cities.values().length)].toString();
    }

    private String getPostalCode() {
        return Cities
                .valueOf(city)
                .getPostalCode();
    }

    private String getStreet() {
        return Streets.values()[new Random().nextInt(Streets.values().length)].toString();
    }

    /**
     * PESEL Part
     */
    public String getPesel() {
        return peselPrefix + checkSumValue();
    }

    private int yearOfBirth() {
        final int minimalAge = 18;
        final int maximalAge = 70;
        final int age = new Random().nextInt(maximalAge) + minimalAge;
        int currentDateInt = Integer.parseInt(simpleDate
                .format(new Date())
                .substring(0, 4));
        return currentDateInt - age;
    }

    private String lastPartOfBirthDate() {
        return String
                .valueOf(yearOfBirth())
                .substring(2, 4);
    }

    private String monthAndDayOfTheBirth() {
        final int monthInYear = 11;
        final int daysInMonth = 27;
        final String month = String.format("%02d", new Random().nextInt(monthInYear) + 1);
        final String day = String.format("%02d", new Random().nextInt(daysInMonth) + 1);
        return month + day;
    }

    private String genderIndicator() {
        final String gender = Names
                .valueOf(name)
                .getGender();
        final String[] womenIndicator = {"0", "2", "4", "6", "8"};
        final String[] menIndicator = {"1", "3", "5", "7", "9"};
        String indicator = "";
        if (gender.equals("W")) {
            indicator = womenIndicator[new Random().nextInt(womenIndicator.length)];
        } else if (gender.equals("M")) {
            indicator = menIndicator[new Random().nextInt(womenIndicator.length)];
        }
        return indicator;
    }

    private String peselPrefix() {
        final int minRandomValue = 100;
        final int maxRandomValue = 899;
        final String ordinalNumber = String.valueOf(new Random().nextInt(maxRandomValue) + minRandomValue);
        return lastPartOfBirthDate() + monthAndDayOfTheBirth() + ordinalNumber + genderIndicator();
    }

    private String checkSumValue() {
        final List<Integer> corePeselParts = new ArrayList<>();
        for (String singlePrefixValue : peselPrefix.split("")) {
            corePeselParts.add(Integer.parseInt(singlePrefixValue));
        }
        /**
         * Specific weights per specific value
         */
        final Integer[] weightValues = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int sumAll = 0;
        int weightIndex = 0;
        for (int index : corePeselParts) {
            int mulValue = weightValues[weightIndex] * index;
            if (mulValue >= 10) {
                mulValue = mulValue % 10;
            }
            sumAll += mulValue;
            weightIndex++;
        }
        int checkSumNumberInt = (10 - sumAll % 10) % 10;
        return String.valueOf(checkSumNumberInt);
    }
}
