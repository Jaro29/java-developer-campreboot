package pl.coderslab.advanced.optional;


import java.util.HashMap;
import java.util.Optional;

public class AddressBook {

    private static final HashMap<String, String> phoneBookEntries = new HashMap<>();

    public AddressBook() {
        phoneBookEntries.put("Jan Kowalski", "Kraków Polna 11");
        phoneBookEntries.put("Marek Marecki", "016/161617");
    }


    public Optional<String> findAddressByName(String name) {
        return null;
    }

    public Optional<String> findNameByAddress(String address) {
        return null;

    }
}
