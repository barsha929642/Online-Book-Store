package javaApplication;

public class Customer {
	
	private String name;
    private String address;
    private int phoneNo;

    public Customer(String name, String address, int phoneNo) {
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "\n\nCustomer[" + "Name=" + name + ", Address=" + address + ", PhoneNo=" + phoneNo + "]\n";
    }
	
}
