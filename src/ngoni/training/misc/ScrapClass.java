package ngoni.training.misc;

public class ScrapClass {

	//Often times developer time optimization is the priority over 
	//convoluted yet efficient solutions.
	public String shiftMyWay(String input, int shift) {		
		int currentIndex = 0;
		boolean escape = false;
		while(!escape && currentIndex < input.length()) {
			if(currentIndex !=0) {
				int i=currentIndex;
				do {
					if(i==0) {
						escape=true;
						break;
					}
					i= (i+shift) % input.length();
				} while(i!=currentIndex);
			}
			if(!escape) {
				char temp = input.charAt(currentIndex);
				int i=currentIndex;
				do {
					char temp2 = input.charAt((i+shift) % input.length());
					if((i+shift+1) % input.length() != 0) {
						input = input.substring(0, (i+shift) % input.length()) + temp 
								+ input.substring((i+shift+1) % input.length());
					}else {
						input = input.substring(0, (i+shift) % input.length()) + temp;
					}
					
					temp = temp2;
					i= (i+shift) % input.length();
				} while(i!=currentIndex);
				currentIndex++;
			}
			
		}
		return input;
	}
	
	//This was the given solution
	/// You need to look into this further it seems like you solved the inverse of your intentions
	public String shiftTheirWay(String input, int shift) {
		shift = input.length()-shift;
		String a = input.substring(0, shift);
		String b = input.substring(shift);
		return reverse(reverse(a) + reverse(b));
	}
	
	public String reverse(String input) {
		for(int i =0; i<input.length()/2; i++) {
			char first = input.charAt(i);
			char last = input.charAt(input.length()-1-i);
			if(i==0) {
				input = last + input.substring(1, input.length()-1) + first;
			}else {
				input = input.substring(0, i) + last + input.substring(i+1, input.length()-1-i) + first + input.substring(input.length()-i);
			}
		}
		return input;
	}
	
	public static void main(String[] args) {
		System.out.println("STUB");
		ScrapClass scrap= new ScrapClass();
		System.out.println(scrap.shiftMyWay("plstoshifty", 8));
		System.out.println(scrap.shiftTheirWay("plstoshifty", 8));
		
		System.out.println(scrap.reverse("lost"));
	}
}
