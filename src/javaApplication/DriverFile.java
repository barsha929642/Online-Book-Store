package javaApplication;

public class DriverFile {

	public static void main(String[] args) {
		 try {
	            BookShopManagementSystem window = new BookShopManagementSystem();
	            window.frame.setVisible(true);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
