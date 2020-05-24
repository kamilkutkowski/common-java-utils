package pl.quanton.utils.data;

import lombok.Getter;

public enum Cities {
    WARSZAWA("01-493"),
    KRAKÓW("30-434"),
    POZNAN("60-103"),
    SZCZECIN("70-017"),
    GDANSK("80-030"),
    GDYNIA("81-008"),
    KOSZALIN("75-075"),
    WROCLAW("50-051"),
    BIALYSTOK("15-682"),
    SIEDLCE("08-101");

    @Getter
    private String postalCode;

    Cities(final String postalCode) {
        this.postalCode = postalCode;
    }
}
