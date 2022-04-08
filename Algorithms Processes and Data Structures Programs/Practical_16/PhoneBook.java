package Practical_16;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private Map<String,PhoneBookEntry> phoneBookEntryMap = new HashMap<>();
    public PhoneBook() {

    }

    public Map<String, PhoneBookEntry> getPhoneBookEntryMap() {
        return phoneBookEntryMap;
    }

    public void setPhoneBookEntryMap(Map<String, PhoneBookEntry> phoneBookEntryMap) {
        this.phoneBookEntryMap = phoneBookEntryMap;
    }


    public void insertEntry(String fullName, String phoneNumber, String email, String address) {
        PhoneBookEntry p = new PhoneBookEntry(fullName, phoneNumber, email, address); //creates a new entry
            if (phoneBookEntryMap.containsKey(p.getFullName())) //if the full name is already in the map
            {
                System.out.println("Entry already been mapped!");
            }
            else {
                phoneBookEntryMap.put(fullName, p); // else add entry to the amp
                p.setFullName(fullName);
            }

    }

    public void updateEntry(String fullName,String phoneNumber,String email, String address) {

        for (PhoneBookEntry p : phoneBookEntryMap.values()) {
            if (p.getFullName() == fullName) //if the full name is already in the map
            {
                System.out.println("Details for " + fullName + " have been updated.");
                // set the old details to new ones
                p.setPhoneNumber(phoneNumber);
                p.setEmail(email);
                p.setAddress(address);
            }
        }

    }

    public void deleteEntry(String fullName)
    {

        for (PhoneBookEntry p : phoneBookEntryMap.values())  //goes through each entry through the map
        {
            if (p.getFullName() == fullName) { //where the input is the same as the full name found in the entry
                phoneBookEntryMap.remove(p.getFullName()); //removes entry for full name
                System.out.println("Entry " + fullName + " has been removed.");
            }

        }

    }

    public void printEntryDetails(String fullName) {
        for (PhoneBookEntry p : phoneBookEntryMap.values()) {
            if (p.getFullName() == fullName) {
                System.out.println("Details for entry " + fullName + ": "+ p);
            }

        }
    }
    public void printPhoneBook()
    {
        // for each full name found in our map print an entry
   phoneBookEntryMap.forEach(((s, phoneBookEntry) -> System.out.println(phoneBookEntry.getFullName() + ":" + phoneBookEntry)));
    }


}

