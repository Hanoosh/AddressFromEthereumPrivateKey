package com.github.js0p.AddressFromEthereumPrivateKey;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.web3j.crypto.Keys;
import org.web3j.crypto.Sign;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class MainClass 
{
    public static void main( String[] args ) throws IOException
    {
        if (args.length != 1) {
        	System.err.println("Usage: java -jar NAME_OF_THIS_JAR_FILE ethereumPrivateKey");
        	System.err.println("Example: java -jar GetFromPrivateKey.jar b5b1870957d373ef0eeffecc6e4812c0fd08f554b37b233526acc331bf1544f7");
        	System.err.println("Returns:");
        	System.err.println("privateKey: a0f8a9a63a036e7086ec6c9c5920a99510474dbc34f6274ed7ac274585f0bc60");
        	System.err.println("publicKey: 4380012967277134650177182821193442438633819642963544868886445813370374183067958222788658560765371544920435771064004789670001362388520258090272804628738727");
            System.err.println("ethereumAddress: c0c35973fdfbdcb69572b1cbfa42faecb49329d5");
            return;
        }

        String privateKey = args[0];
        BigInteger publicKey = Sign.publicKeyFromPrivate(Numeric.toBigInt(privateKey));
        String ethereumAddress = Keys.getAddress(publicKey);

        System.out.println("privateKey: " + privateKey);
        System.out.println("publicKey: " + publicKey);
        System.out.println("ethereumAddress: " + ethereumAddress);
    }
}
