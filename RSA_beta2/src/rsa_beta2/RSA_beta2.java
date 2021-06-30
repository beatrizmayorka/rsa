package rsa_beta2;

import java.math.BigInteger;
import java.util.Random;

public class RSA_beta2 {
    
     public static void main(String args[]) {

    String msg = "Mamão com açucar";
    String msgcript = null; 
    String msgdescript = null;
    BigInteger n, d, e;

    //Escolha de forma aleatória dois números primos grandes p e q 
    Random r = new Random(); 
 
    BigInteger p = new BigInteger(499,100, r); 
    BigInteger q = new BigInteger(547,100, r); 


    //Compute n = p * q
    n = p.multiply(q);

    //Compute a função totiente phi(n) = (p -1) (q -1)
    BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

    //Escolha um inteiro  "e"  , 1 < "e" < phi(n) ,  "e" e phi(n) sejam primos entre si.
    e = new BigInteger("3");
    while(m.gcd(e).intValue() > 1) e = e.add(new BigInteger("2"));
    

   // d seja inverso multiplicativo de "e"
    d = e.modInverse(m);

    System.out.println("p:"+p);
    System.out.println("q:"+q);
    System.out.println("n:"+n);
    System.out.println("e:"+e);
    System.out.println("d:"+d);

    //mensagem criptografada 
    msgcript = new BigInteger(msg.getBytes()).modPow(e, n).toString();
    System.out.println("msg criptografada: "+ msgcript);

    //mensagem descriptografada 
    msgdescript = new String(new BigInteger(msgcript).modPow(d, n).toByteArray());
    System.out.println("msg descriptografada: " + msgdescript);
  }
}