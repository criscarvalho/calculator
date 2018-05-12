package br.unisal.interfaces;

import javax.jws.*;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.soap.SOAPException;

import br.unisal.exceptions.DivisionByZeroArithymeticException;

import static br.unisal.util.Constants.*;

/**
 * 
 * @author jether.rodrigues
 *
 *         Style.RPC: menos verboso, menos detalhes Style.DOCUMENT: mais
 *         verboso, gera mais detalhes
 */

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface Calculable {

	@WebMethod(action = HOST + "/divide", operationName = "division")
	public double divide(@WebParam(name = "dividend") double dividend, @WebParam(name = "divisor") double divisor)
			throws DivisionByZeroArithymeticException, SOAPException;

	@WebMethod(action = HOST + "/sum", operationName = "sum")
	public double sum(@WebParam(name = "portion1") double portion1, @WebParam(name = "portion2") double portion2);

	@WebMethod(action = HOST + "/subtract", operationName = "subtract")
	public double subtract(@WebParam(name = "portion1") double portion1, @WebParam(name = "portion2") double portion2);

	@WebMethod(action = HOST + "/multiply", operationName = "multiply")
	public double multiply(@WebParam(name = "factor1") double factor1, @WebParam(name = "factor2") double factor2);
}
