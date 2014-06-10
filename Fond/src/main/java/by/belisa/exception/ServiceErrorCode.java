package by.belisa.exception;

public enum ServiceErrorCode {
    ERR_SRVC_100("Failed to add item."),
    ERR_SRVC_101("Failed to update item."),
    ERR_SRVC_102("Failed to get item, id=%d."),
    ERR_SRVC_103("Failed to get %s by name=%s"),
    ERR_SRVC_104("Failed to field uniqueness validate"),
    ERR_SRVC_105("Failed to delete item"),
    ERR_SRVC_106("Failed to get list");

    private final String value;

    private ServiceErrorCode(String s) {
	value = s;
    }

    public boolean equalsValue(String value2) {
	return (value2 != null) && value.equals(value2);
    }

    public String toString() {
	return value;
    }
}
