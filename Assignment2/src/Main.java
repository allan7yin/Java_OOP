import address.Address;
import virtual.EmailAddress;
import virtual.TelecomAddress;
import virtual.WebPageAddress;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // default ones
        WebPageAddress web1 = new WebPageAddress();
        EmailAddress email1 = new EmailAddress();
        TelecomAddress telecom1 = new TelecomAddress();

        // passed parameters
        WebPageAddress web2 = new WebPageAddress("2000-01-01", "2030-01-01", "facebook", "users");
        EmailAddress email2 = new EmailAddress("a7yin", "uwaterloo", "ca", "2010-09-30", "3000-01-07");
        TelecomAddress telecom2 = new TelecomAddress(1, 0, 416, 2080565, 777, "mobile", "2003-01-07", "2023-05-01");

        ArrayList<Address> addresses = new ArrayList<Address>();
        addresses.add(web1);
        addresses.add(email1);
        addresses.add(telecom1);
        addresses.add(web2);
        addresses.add(email2);
        addresses.add(telecom2);

        traceObsoleteAddresses(addresses, 2022, 1, 6);

    }

    public static void traceObsoleteAddresses(ArrayList<Address> addresses, int year, int month, int day) {
        for (var address : addresses) {
            System.out.print(address.toString() + " | ");
            String local = Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(day);
            if ((local.compareTo(address.getValidFrom()) >= 0) && (local.compareTo(address.getValidTo()) <= 0)) {
                System.out.print("This address is valid for " + local);
            } else {
                System.out.print("This address is NOT valid for " + local);
            }
            System.out.println();
        }
    }
}
