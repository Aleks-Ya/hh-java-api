package ru.yaal.project.hhapi.vacancy;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.yaal.project.hhapi.dictionary.entry.INullable;

/**
 * Адрес.
 */
@ToString
public final class Address implements INullable {
    public static final Address NULL_ADDRESS = new Address();
    private static final String NULL_CITY = "NullCity";
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private String building;
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private String city;
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private String street;
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private String description;
    @Setter
    @SerializedName("metro")
    private Station station;
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private String raw;
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private Double lat;
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private Double lng;

    public Address() {
        setCity(NULL_CITY);
    }

    @Override
    public boolean isNull() {
        boolean cityEmpty = (getCity() == null || getCity().isEmpty());
        boolean metroEmpty = getStation().isNull();
        return ((cityEmpty && metroEmpty) || NULL_CITY.equalsIgnoreCase(getCity()));
    }

    public Station getStation() {
        return (station != null) ? station : Station.NULL_STATION;
    }

    @Data
    public static class Station implements INullable {
        public static final Station NULL_STATION = new Station();
        @SerializedName("station_id")
        private String stationId;

        @Override
        public boolean isNull() {
            return (stationId == null || stationId.isEmpty());
        }
    }
}
