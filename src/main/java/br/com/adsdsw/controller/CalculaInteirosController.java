package br.com.adsdsw.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.adsdsw.model.DivisaoInteiros;
import br.com.adsdsw.model.ModulusInteiros;
import br.com.adsdsw.model.MultiplicaInteiros;
import br.com.adsdsw.model.SomaInteiros;
import br.com.adsdsw.model.SubtraiInteiros;

/**
* Esta classe contempla o controle das requisições
* e processamento e direcionamento de dados deste projeto.
*
* @author  Colab003
* @version 1.0
* @since   05/07/2023
*/


@WebServlet("/processa")
public class CalculaInteirosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num1 = request.getParameter("txtnum1");
		String num2 = request.getParameter("txtnum2");
		String mtdCalc = request.getParameter("metodoCalculo");
		
		String divisao = new String("div");
		String soma = new String("sum");
		String subtracao = new String("sub");
		String multiplicacao = new String("mult");
		String modulus = new String("mod");
		
		
		if (divisao.equals(mtdCalc)) {	
			/*  Divisao  */
			try {
				DivisaoInteiros divisaoInteiros = new DivisaoInteiros(num1, num2);
				Double resultado = divisaoInteiros.divideInteiros();
				response.getWriter().append(String.format("%.2f", resultado));
			} catch (Exception e) {
				response.getWriter().append(e.getMessage());
			}
		} else if (soma.equals(mtdCalc)) {
			/*  Soma  */
			SomaInteiros somaInteiros = new SomaInteiros(num1, num2);
			Double resultado = somaInteiros.somaInteiros();
			response.getWriter().append(String.format("%.2f", resultado));
		} else if (subtracao.equals(mtdCalc)) {
			/*  Subtracao  */
			SubtraiInteiros subtrai = new SubtraiInteiros(num1, num2);
			Double resultado = subtrai.subtraiInteiros();
			response.getWriter().append(String.format("%.2f", resultado));
		} else if (multiplicacao.equals(mtdCalc)) {
			/*  Multiplicacao  */
			MultiplicaInteiros multiplicaInteiros = new MultiplicaInteiros(num1, num2);
			Double resultado = multiplicaInteiros.multiplicaInteiros();
			response.getWriter().append(String.format("%.2f", resultado));
		} else if (modulus.equals(mtdCalc)) {
			/*  Modulus  */
			try {
				ModulusInteiros modulusInteiros = new ModulusInteiros(num1, num2);
				Double resultado = modulusInteiros.modulusInteiros();
				response.getWriter().append(String.format("%.2f", resultado));
			} catch (Exception e) {
				response.getWriter().append(e.getMessage());
			}
		}
	}
}
