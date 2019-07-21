package hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    private String type;
    private Value value;

    public Quote() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        type = MaskPiString.checkForPi( type );

        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
//        value = MaskPiAccount.checkForPi( value ) );
        this.value = value;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
