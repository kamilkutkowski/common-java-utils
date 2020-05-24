package pl.quanton.utils.data;

import lombok.Getter;

public enum Names {
    /**
     * Women's
     * */
    KALINA("W"),
    ZUZANNA("W"),
    LENA("W"),
    JULIA("W"),
    MAJA("W"),
    ZOFIA("W"),
    HANNA("W"),
    AMELIA("W"),
    ALEKSANDRA("W"),
    ALICJA("W"),
    NATALIA("W"),
    WIKTORIA("W"),
    OLIWIA("W"),
    MARIA("W"),
    EMILIA("W"),
    NIKOLA("W"),

    /**
     * Men's
     */
    KRZESIMIR("M"),
    RADOMIR("M"),
    KUBA("M"),
    ANTONI("M"),
    SZYMON("M"),
    JAN("M"),
    FILIP("M"),
    KACPER("M"),
    ALEKSANDER("M"),
    FRANCISZEK("M"),
    MIKOLAJ("M"),
    WOJCIECH("M"),
    ADAM("M"),
    MICHAL("M"),
    MARCEL("M"),
    WIKTOR("M"),
    PIOTR("M");

    @Getter
    private String gender;

    Names(String gender){ this.gender = gender;}
}
