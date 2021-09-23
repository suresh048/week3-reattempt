package Camera.Factory;

public class PhoneFactory {

    public static Phone getPhone(PhoneType phoneType) {
        switch (phoneType) {
            case ANDROID:
                return new AndroidPhone();
            case IPHONE:
                return new IPhone();
            default:
                return null;
        }
    }
}