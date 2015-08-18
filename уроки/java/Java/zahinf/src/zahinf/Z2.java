package zahinf;

public class Z2 {
	public String sss;
	
	public void keys(char key[]) {
		for (int i = 0; i < key.length; i++) {
			int min = (int) key[i];
			int imin = i;
			for (int j = i + 1; j < key.length; j++) {
				if ((int) key[j] < min) {
					min = (int) key[j];
					imin = j;
				}
			}
			if (i != imin) {
				int temp = (int) key[i];
				key[i] = (char) key[imin];
				key[imin] = (char) temp;
			}
		}
		sss = "";
		for (int i = 0; i < key.length; i++) {
			sss = sss + key[i];
		}
	}
	
	public String res(){
		return sss;
		
	}

	public void keyArr(char key[], String keyWord) {
		for (int i = 0; i < keyWord.length(); i++) {
			key[i] = keyWord.charAt(i);
		}
	}
}
