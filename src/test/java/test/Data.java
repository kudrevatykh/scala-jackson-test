package test;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Data {

    private final String name;
    private final String domain;

    public Data(String name, String domain) {
        this.name = name;
        this.domain = domain;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static Data fromString(String dataString) {
        String[] parts = dataString.split("@");
        if (parts.length > 2 || parts.length == 0) {
            throw new RuntimeException(String.format("Invalid data format: %s", dataString));
        }
        return new Data(parts[0], parts[1]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return Objects.equals(name, data.name) && Objects.equals(domain, data.domain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, domain);
    }
}
