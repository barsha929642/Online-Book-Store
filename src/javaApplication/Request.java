package javaApplication;

public class Request {
	
	public String boookName;
    public String authorName;
    public int phoneNo;

    public Request(String boookName, String authorName, int phoneNo) {
        this.boookName = boookName;
        this.authorName = authorName;
        this.phoneNo = phoneNo;
    }

    public String getBoookName() {
        return boookName;
    }

    public void setBoookName(String boookName) {
        this.boookName = boookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "Requested Book[" + "boookName=" + boookName + ", authorName=" + authorName + ", phoneNo=" + phoneNo + ']'+"\n";
    }

}
