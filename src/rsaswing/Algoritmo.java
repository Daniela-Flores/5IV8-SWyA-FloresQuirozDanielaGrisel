/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsaswing;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author Danielao.0
 */
public class Algoritmo {
     int tamPrimo;
    BigInteger n,p,q;
    BigInteger fi;
    BigInteger e,d;
    
    public Algoritmo(int taPrimo){
        tamPrimo = taPrimo;
        generarPrimos();
    }
    
    public Algoritmo(BigInteger P, BigInteger Q, int taPrimo){
          tamPrimo = taPrimo;
          p = P;
          q = Q;
          generarClaves();
    }
    
     public void generarPrimos(){
        p = new BigInteger(tamPrimo, 10, new Random());
        do{
             q = new BigInteger(tamPrimo, 10, new Random());
        }while(q.compareTo(p) == 0);
    }
    
      public void generarClaves(){
        n = p.multiply(q);
        fi  = p.subtract(BigInteger.valueOf(1));
        fi = fi.multiply(q.subtract(BigInteger.valueOf(1)));
        
        do e =  new BigInteger(2*tamPrimo, new Random());
        while((e.compareTo(fi) != -1)||(e.gcd(fi).compareTo(BigInteger.valueOf(1)) != 0));
        
        d =  e.modInverse(fi);
        
    }
      
        public BigInteger[] cifrar(String mensaje){
        int i;
        byte [] temp  =  new byte[1];
        byte [] digitos = mensaje.getBytes();
        
        BigInteger [] bigdigitos = new BigInteger[digitos.length];
        
        for (i = 0; i < bigdigitos.length; i++) {
            temp [0] = digitos[i];
            bigdigitos[i] =  new BigInteger(temp);
        }
        
        BigInteger[] cifrado = new BigInteger[bigdigitos.length];
        
        for (i = 0; i < bigdigitos.length; i++) {
            cifrado[i] = bigdigitos[i].modPow(e, n);
        }
        
        return cifrado;
    }
        
     public String Descifrar (BigInteger[] cifrado){
         BigInteger[]  descifrado = new BigInteger[cifrado.length];
         for (int i = 0; i < descifrado.length; i++) {
             descifrado[i] = cifrado[i].modPow(d, n);
         }
     char[] ArregloChar = new char[descifrado.length];
     
         for (int i = 0; i < ArregloChar.length; i++) {
             ArregloChar[i] = (char) (descifrado[i].intValue());
         }
         return (new String(ArregloChar));
     }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getFi() {
        return fi;
    }

    public BigInteger getE() {
        return e;
    }

    public BigInteger getD() {
        return d;
    }

    public BigInteger getQ() {
        return q;
    }
    
     
     
}
