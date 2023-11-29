package bo;

import utils.Validation;

public class SortInputter {
    public SortInputter() {

    }

    public int enterNumberOfArray(String message, int min, int max) {
        return Validation.getInt(message, min, max);
    }
}
