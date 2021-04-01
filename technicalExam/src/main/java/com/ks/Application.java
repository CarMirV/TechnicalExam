package com.ks;

/**
 * Exam :)
 */
public class Application
{
    /**
     * How many centuries have n years ?
     *
     * Example
     * Year 1 belongs to the 1st century
     * Year 99 belongs to the 1st century
     * Year 101 belongs to the 2nd century
     * Year 2020 belongs to the 21st century
     *
     * @param years years...
     * @return century on the years
     */
    public static int yearsToCenturies(int years)
    {
        //Let's start!
    	int centuries = (years/100)+1;
        return centuries;
        /*
         * Done :)
         */
    }

    /**
     * This method search a text equality inside of another text like SCRAMBLE !!!
     *
     * You don't need instructions, right?
     *
     * in: hdsasdellsdasooawwadwdwawrl ,  helloworld
     *     hd    ell    oo w        rl -> hdelloowrl
     * Yes, it doesn't look the same, but ordered you should get the same word, you know, like scramble ...
     *
     **** You must have the same number of letters if you use them more than once ***
     *
     * @param str1 unknown text
     * @param str2 searched word
     * @return if all same words and same quantity from second string exists in first string
     */
    public static boolean scramble(String str1, String str2)
    {
        //First tear ;(
    	String copy1 = str1;
    	String copy2 = str2;
    	boolean result = false;
    	for(int i = 0; i < copy2.length(); ++i) {
			boolean find = false;
    		for(int j = 0 ; j < copy1.length(); ++j) {
    			if(copy2.charAt(i) == copy1.charAt(j)) {
    				copy1 = copy1.replaceFirst(String.valueOf(copy2.charAt(i)), "");
    				find = true;
    				System.out.println(copy1);
    				break;
    			}else if(j == copy1.length()-1) {
    				return false;
    			}
    		}
    		if(i == copy2.length()-1 && find == true) {
    			return true;
    		}
    	}
        return false;
        /*
         * Done :)
         */
    }

    /**
     * Find a middle char(s) in a text
     *
     * Example
     *
     * in: yes (hint: odd)
     * out: e
     *
     * in: word (hint: pair)
     * out: or
     *
     * *** Always wait for a single word ***
     *
     * @param word is the resource
     * @return a middle char(s)
     */
    public static String getMiddle(String word)
    {
        //So easy ...
    	int length = word.length();
    	if (length % 2 != 0) {
    		return String.valueOf(word.charAt((length/2)));
    	}else {
    		String res = String.valueOf(word.charAt((length/2)-1));
    		res = res.concat(String.valueOf(word.charAt((length/2))));
    		return res;
    	}
        /*
         * Done :)
         */
    }

    /**
     * This method is used to find how many letters are repeated
     *
     * Example
     *
     * in: AcCoMmOdatIOn
     * out: 4
     *
     * AcCoMmOdatIOn -> have (a:2, c:2, o:3, m:2, d:1, t:1, i:1, n:1)
     *               -> just more than one (a:2, c:2, o:3, m:2)
     *               -> sum them             ^    ^    ^    ^  -> 4
     *
     * *** As you can see, case sensitive is irrelevant, spaces don't count ***
     *
     * @param text is the resource to search
     * @return how many words are repeated
     */
    public static int duplicateCount(String text)
    {
        //have fun!
    	int tot = 0;
    	String cp = text.toLowerCase();
    	for(int i = 0; i < text.length(); ++i) {
    		int sum = 0;
    		for(int j = 0 ; j < cp.length(); ++j) {
    			if(text.charAt(i) == cp.charAt(j)) {
    			    ++sum;
    			}
    			if(j == cp.length()-1) {
    				cp = cp.replace(text.charAt(i), ' ');
    				if(sum > 1){
    				    ++tot;
    				}
    			}
    		}
    		
    	}
        return tot;
        /*
         * Done :)
         */
    }

    /**
     * This method get how many times a vocals are in a text
     *
     * Example
     *
     * in : "vowel counting is not an everyday thing"
     *        ^ ^   ^^  ^   ^   ^  ^  ^ ^   ^    ^   -> 12
     *
     * ***Always wait lowercase***
     *
     * @param str is a text to search
     * @return a number of how many times a vocals are in a text
     */
    public static int getCount(String str)
    {
        //...
    	char voc[] = {'a','e','i','o','u'};
    	int tot=0;
    	str = str.toLowerCase();
    	for(int i = 0 ; i < str.length(); ++i) {
    		for(int j = 0 ; j < voc.length; ++j) {
    			if(str.charAt(i) == voc[j]) {
    				++tot;
    			}
    		}
    	}
        return tot;
        /*
         * Done :)
         */
    }

    /**
     * This method solve a quantity of multiply all separated decimal numbers on a number recursively
     *
     * in : 236
     * out: 8
     *
     * how ?
     *
     * 236 -> (2 * 3 * 6) = [36] -> (3 * 6) = [18] (1 * 8) = [8]
     *
     * <h3> How many times a decimal values need be multiplied to find a root number</h3>
     *
     * @param n a number to find a digital root
     * @return how many times a decimal values in a number can be multiplied recursively
     */
    public static int persistence(long n)
    {
        //Next is so easy after this
    	if(n/1000 != 0) {
    		int mil = (int)(n/1000);
    		n %= 1000;
    		int cent = (int)(n/100);
    		n %= 100;
    		int dec = (int)(n/10);
    		n %= 10;
    		int res = (int)(n/1);
    		n %= 1;
    		return (int)persistence(mil*cent*dec*res);
    	}else if(n/100 != 0) {
    		int cent = (int)(n/100);
    		n %= 100;
    		int dec = (int)(n/10);
    		n %= 10;
    		int res = (int)(n/1);
    		n %= 1;
    		return (int)persistence(cent*dec*res);
    	}else if(n/10 != 0) {
    		int dec = (int)(n/10);
    		n %= 10;
    		int res = (int)(n/1);
    		n /= 1;
    		return (int)persistence(dec*res);
    	}else if(n > 0){
    	    return (int)n;
    	}
    	return (int)n;
    	/*
    	 * Also done :)
    	 */
    }

    /**
     * This value sum all separated decimal numbers on a number recursively
     *
     * in : 123456
     * out : 3
     *
     * how ?
     *
     * 123456 -> (1 + 2 + 3 + 4 + 5 + 6) = [21] -> (2 + 1) = [3]
     *
     * @param n a number to find a digital root
     * @return digital root from a number
     */
    public static int digital_root(int n)
    {
        //Another easy
    	if(n/100000 != 0) {
    		int ht = n/100000;
    		n %= 100000;
    		int dt = n/10000;
    		n %= 10000;
    		int tho = n/1000;
    		n %= 1000;
    		int hund = n/100;
    		n %= 100;
    		int dec = n/10;
    		n %= 10;
    		int res = n/1;
    		return digital_root(ht+dt+tho+hund+dec+res);
    	}else if(n/10000 != 0) {
    		int dt = n/10000;
    		n %= 10000;
    		int tho = n/1000;
    		n %= 1000;
    		int hund = n/100;
    		n %= 100;
    		int dec = n/10;
    		n %= 10;
    		int res = n/1;
    		return digital_root(dt+tho+hund+dec+res);
    	}else if(n/1000 != 0) {
    		int tho = n/1000;
    		n %= 1000;
    		int hund = n/100;
    		n %= 100;
    		int dec = n/10;
    		n %= 10;
    		int res = n/1;
    		return digital_root(tho+hund+dec+res);
    	}else if(n/100 != 0) {
    		int hund = n/100;
    		n %= 100;
    		int dec = n/10;
    		n %= 10;
    		int res = n/1;
    		return digital_root(hund+dec+res);
    	}else if(n/10 != 0) {
    		int dec = n/10;
    		n %= 10;
    		int res = n/1;
    		return digital_root(dec+res);
    	}else {
    		return n;
    	}
    	/*
    	 * Done :)
    	 */
    }


    /**
     * This method return a char pair in array
     *
     * Example
     * in: "Give me some pairs please"
     * out: [Gi, ve,  m, e , so, me,  p, ai, rs,  p, le, as, e_]
     *
     * ***Spaces also count***
     *
     * @param s a text to evaluate
     * @return an array with pair of chars
     */
    public static String[] solution(String s)
    {
        //Will be worse ?
    	if(s.length() % 2 != 0) {
    		s = s.concat("_");
    	}
    	int size = s.length()/2;
    	String[] pairs = new String[size];
    	int beg = 0, end = 2;
    	for(int i = 0; i < size; ++i) {
    		pairs[i] = s.substring(beg, end);
    		beg += 2;
    		end += 2;
    	}
        return pairs;
        /*
         * Done :)
         */
    }

    /**
     * This method convert a long in a valid ip
     *
     * Example
     *
     * in: 2147483467L -> out : 127.255.255.75
     *
     * how ?
     * 1.- Convert a long in binary (you will always get 32 bits or less, if there is less just apply the pad to the left with zero)
     * 2.- Get 4 bytes (4 groups of 8 bits will give you 4 bytes)
     * 3.- Converts each byte to a decimal number
     * 4.- Apply the ip format to your 4 decimal numbers
     *
     * @param ip is a 32 bits number maximum
     * @return an IP
     */
    public static String longToIP(long ip)
    {
        //yes, can be worse...
    	String bin = Long.toBinaryString(ip);
    	System.out.println(bin);
    	if(bin.length() < 32) {
    		int comp = 32 - bin.length();
    		for(int i = 0; i < comp; ++i) {
    			String aux = bin;
    			bin = "0";
    			bin = bin.concat(aux);
    		}
    	}
    	System.out.println(bin);
    	String first = bin.substring(0, 8);
    	String second = bin.substring(8, 16);
    	String third = bin.substring(16, 24);
    	String fourth = bin.substring(24, 32);
    	System.out.println(first);
    	System.out.println(second);
    	System.out.println(third);
    	System.out.println(fourth);
    	int p1 = Integer.parseInt(first, 2);
    	int p2 = Integer.parseInt(second, 2);
    	int p3 = Integer.parseInt(third, 2);
    	int p4 = Integer.parseInt(fourth, 2);
    	System.out.println(p1);
    	System.out.println(p2);
    	System.out.println(p3);
    	System.out.println(p4);
    	String fIp = String.valueOf(p1);
    	fIp = fIp.concat("."+String.valueOf(p2)+"."+String.valueOf(p3)+"."+String.valueOf(p4));
        return fIp;
        /*
         * Done :)
         */
    }

    /**
     * This method find a shortest word in a text
     *
     * Example
     * in : "When I was young I had a lot of toys" -> out : 1
     *            ^           ^     ^              -> can be any of them
     *
     * in : "The worst part of school was solving problems like this" -> out : 2
     *                      ^^
     *
     * @param s a text to find the shortest word
     * @return a shortest word size in a text
     */
    public static int findShort(String s)
    {
        //have fun!
        return 0;
    }

    /**
     * Find a first number repeated in the array
     *
     * Example
     * in : {1,2,3,8,5,2} -> out : 2
     * in : {5,9,6,7,5,9,9} -> out : 5
     * in : {5,1,6,7,8,9,9} -> out : 9
     *
     * @param values is an int array
     * @return a first number repeated in the array or else return -1
     */
    public static Integer repeated(int[] values)
    {
        //Last one!
        return 0;
    }
}
