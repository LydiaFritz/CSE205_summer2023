package GetInitials;

public class Driver {

	public static void main(String[] args) {
		String name = "Lydia Kenion Fritz";
		System.out.println(getInitials(name));

	}
	
	public static String getInitials(String init) {
		int index = init.indexOf(" ");
		String result = init.charAt(0) + ".";
		String name = "";
				
		while(index != -1) {
			name = init.substring(index+1);
			result += " " + name.charAt(0) + ".";
			index = name.indexOf(" ");
		}
		return result;
	}

}
