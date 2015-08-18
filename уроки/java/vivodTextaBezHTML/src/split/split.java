package split;

public class split {

	public static void main(String[] args) {
		String s = "<head>lalala</head><body>lololo</body>";
		String []arr = s.split("\\<[a-z]*\\>");
		String g = "";
		for(int i = 0; i<arr.length; i++){
			g += arr[i];
		}
		String []c = g.split("\\<\\/[a-z]*\\>");
		for(int j = 0; j<c.length; j++){
			System.out.println(c[j]);
		}
	}

}
