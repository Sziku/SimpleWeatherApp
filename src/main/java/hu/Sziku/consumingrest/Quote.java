package hu.Sziku.consumingrest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Quote(String type, Value value) {

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Quote) obj;
        return Objects.equals(this.type, that.type) &&
                Objects.equals(this.value, that.value);
    }

    @Override
    public String toString() {
        return "Quote[" +
                "type=" + type + ", " +
                "value=" + value + ']';
    }
}

