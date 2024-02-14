package br.com.rcunha.converters;

public class NumberConverter {

	public static Double convertToDouble(String number) {
		
		if (number == null) {
			return 0D;
		}

		//BR 10,25 -> US 10.25
		String numero = number.replaceAll(",", ".");
		if (isNumeric(numero)) {
			return Double.parseDouble(numero);
		}
		
		return 0D;
	}

	public static boolean isNumeric(String number) {
		if (number == null) { return false;	}
		
		//BR 10,25 -> US 10.25
        String numero = number.replaceAll(",", ".");
        
		return numero.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
