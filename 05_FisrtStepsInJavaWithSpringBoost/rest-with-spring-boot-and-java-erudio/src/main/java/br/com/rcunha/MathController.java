package br.com.rcunha;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			          @PathVariable(value = "numberTwo") String numberTwo) throws Exception 
	{
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new Exception();
		}
		
		return (convertToDouble(numberOne) + convertToDouble(numberTwo)); 
	}

	private Double convertToDouble(String number) {
		
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

	private boolean isNumeric(String number) {
		if (number == null) { return false;	}
		
		//BR 10,25 -> US 10.25
        String numero = number.replaceAll(",", ".");
        
		return numero.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
} 
