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
    	//Se toma como limitante la copia de str2 ya que es la palabra que buscamos
    	for(int i = 0; i < copy2.length(); ++i) {
			boolean find = false;
    		for(int j = 0 ; j < copy1.length(); ++j) {
    			if(copy2.charAt(i) == copy1.charAt(j)) {
    				//En caso de encontrar una letra se sustituye su primera incidencia por una cadena vacia
    				//para poder tener la cantidad de letras suficientes en caso de que se repita, de esta
    				//manera elimino las letras ya encontradas.
    				copy1 = copy1.replaceFirst(String.valueOf(copy2.charAt(i)), "");
    				find = true;
    				System.out.println(copy1);
    				break;
    			}else if(j == copy1.length()-1) {
    				//En caso de recorrer el arreeglo de letras disponibles y no encontrar la letra retornamos falso
    				return false;
    			}
    		}
    		//en caso de llegar a la ultima letra por encontrar y que haya sido encontrada retornamos true
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
    		//Como es una palabra par no tenemos una letra intermedia por lo que tomamos a las que serian
    		//las intermedias
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
    	//convertimos todo el string a minusculas para poder compararlo con otras letras ya
    	//que se nos indica que el algoritmo no es sensible a mayusculas
    	String cp = text.toLowerCase();
    	text = text.toLowerCase();
    	for(int i = 0; i < text.length(); ++i) {
    		int sum = 0;
    		for(int j = 0 ; j < cp.length(); ++j) {
    			if(text.charAt(i) == cp.charAt(j)) {
    			    ++sum;
    			}
    			if(j == cp.length()-1) {
    				//En caso de que haya mas de una incidencia de la letra repetida sumamos 1 a el numero
    				//de letras repetidas y reemplazamos todas las letras dentro de la cadena con un espacio
    				//para evitar volver a contar una letra ya incluida en el conteo
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
    	//Simplemente se busca que la letra en la posicion actual este dentro del pequeño
    	//diccionario de vocales y si lo esta se le suma uno al contador
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
    	//Verificamos las unidades que tenemos: miles,centenas,decenas y unidades y luego las separamos
    	//para multiplicarlas y despues pasarla de manera recursiva a la misma funcion hasta que solo
    	//tengamos unidades
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
    	//Se aplica el mismo proceso que el algoritmo anterior solo que en
    	//vez de pasar de manera recursiva la multiplicacion de lo separado
    	//pasamos la suma de esto-
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
    	//Para asegurar que siempre habra pares obtenemos la longitud de la cadena
    	//y en caso de que sea impar le sumamos un guion bajo
    	if(s.length() % 2 != 0) {
    		s = s.concat("_");
    	}
    	int size = s.length()/2;
    	String[] pairs = new String[size];
    	int beg = 0, end = 2;
    	//Ya que tenemos el numero de pares simplemente vamos obteniendo subcadenas
    	//de tamaño 2 y se lo agregamos al arreglo de pares
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
    	//Se realiza la conversion del long a binario
    	String bin = Long.toBinaryString(ip);
    	System.out.println(bin);
    	//Para asegurar que sea un valor de 32 bits obtenemos su longitud
    	//en caso de que sea menor simplemente agregamos ceros a la izquierda
    	if(bin.length() < 32) {
    		int comp = 32 - bin.length();
    		for(int i = 0; i < comp; ++i) {
    			String aux = bin;
    			bin = "0";
    			bin = bin.concat(aux);
    		}
    	}
    	//Hacemos la extraccion de los 4 bytes de 8 bits
    	String first = bin.substring(0, 8);
    	String second = bin.substring(8, 16);
    	String third = bin.substring(16, 24);
    	String fourth = bin.substring(24, 32);
    	//Convertimos el valor del String a enteros haciendo una conversion de binario a decimal
    	int p1 = Integer.parseInt(first, 2);
    	int p2 = Integer.parseInt(second, 2);
    	int p3 = Integer.parseInt(third, 2);
    	int p4 = Integer.parseInt(fourth, 2);
    	//Generamos el string de la direccion ip concatenando todas sus partes
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
    	//Dividimos la cadena de entrada tomando como delimitador el espacio en blanco y simplemente
    	//comparamos la longitud de cada una de las divisiones realizadas en busca de la mas pequeña
    	int shortest = 100000;
    	String[] div = s.split(" ");
    	for(int i =0; i < div.length; ++i) {
    		if(div[i].length() < shortest) {
    			shortest = div[i].length();
    		}
    	}
        return shortest;
        /*
         * Done :D
         */
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
    	//Buscamos por una incidencia de el numero en la posicion del arreglo en la que estamos,
    	//en caso de que se encuentre lo retornamos como valor de salida, en caso contrario simplemente
    	//buscamos los demas numeros que siguen
    	int dist = 100000;
    	int val = 0;
    	for(int i =0 ; i < values.length; ++i) {
    		int cont = 0;
    		for(int j = i+1; j < values.length; ++j) {
    			++cont;
    			if(values[i] == values[j]) {
    				if(cont < dist) {
    					val = values[i];
    					dist = cont;
    					break;
    				}
    			}
    		}
    	}
        return val;
        			//Para este problema me surgieron dudas, al momento de realizar los casos pruebas me indico un
        			//error, tomando la logica de ese caso el codigo de arriba seria el que da los resultados
        			//dado a que se toma como factor la distancia para que se repita el numero
        			//Sin embargo los casos que se dan como ejemplo aqui seguirian una logica en la que la distancia
        			//es ignorada y solo se toma el primer numero que se encuentre segun el orden del arreglo
        			//aqui mismo dejo comentado el codigo que brinda un resultado para los casos ejemplo proporcionados
        /*
		        for(int i =0 ; i < values.length; ++i) {
		    		for(int j = i+1; j < values.length; ++j) {
		    			if(values[i] == values[j]) {
		    				return values[i];
		    			}
		    		}
		    	}
		        return -1;
        */
        /*
         * Completed
         */
    }
}
