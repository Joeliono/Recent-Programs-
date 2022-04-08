package Practical_16;

public class User {

    public static void main(String[] args) {


        PhoneBook map = new PhoneBook();

        map.insertEntry("John Doe","0123456789", "123johndoe@gmail.com","68 lane street");
        map.insertEntry("Jane Doe","0123357689", "143janedoe@gmail.com","46 top street");
        map.insertEntry("Gary Stu","0123577789", "123GSTEW@gmail.com",  "32 mid street");
        map.insertEntry("Foo bar", "0123499989", "123fool@gmail.com",   "232 diagonal street");
        map.insertEntry("Foo bar", "0123499989", "123fool@gmail.com",   "232 diagonal street");
        map.printPhoneBook();

        map.deleteEntry("Jane Doe");
        map.printEntryDetails("John Doe");
        map.updateEntry("John Doe","01234564689", "123johndoe@gmail.com","68 lane street");



        map.printPhoneBook();


    }
}

