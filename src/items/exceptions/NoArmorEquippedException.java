package items.exceptions;

/**
 * Custom no armor equipped exception.
 */
public class NoArmorEquippedException extends Exception{
    public NoArmorEquippedException(String s) {
        super(s);
    }
}
