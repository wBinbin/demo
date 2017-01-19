package com.mine;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
//import org.apache.commons.lang.StringEscapeUtils;

/**
 * 
 * @author Administrator ������������ǩ������ǩ�� ��1��ǩ������ 1.�뽫����ʹ��md5��ȡ����ժҪ��
 *         2.�ٽ�ժҪ���ѷ�˽Կ����ǩ���� ��2����ǩ���� ()
 * 
 */
public class MyRSA {
	public static final String KEY_ALGORITHM = "RSA";

	public static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";
	
	public static final String PUBLIC_KEY = "publicKey";
	public static final String PRIVATE_KEY = "privateKey";

	// ����˽Կ
	public static String privateString = "MIICdwIBADANBgkqhkiG9V7RXbJwUH70wyS9I/9Hb7Hhmy8gntiCa+7YGkcQdC3MxataPjStmx/txZa/i3RZ9zH/sWrdIioz/kzAkEArtNVJX0kp5SUnI46GMY+0wO2VDE9bFivm8zvGVuix2oPqbSfjIUlKByfcNQJBAI1em4L50QBRX2W3tp1+s/tVM/j9+IDiSOJSDSXfCYq8H+uoEd9yJYwuZLb2nlO4H79rvUkjwlHVcYPdHt/XT1g=";
	// ���Թ�Կ
	public static String publicStr = "MIGfMA0GCSqGSycFB+9MMkvSP/R2+x4ZsvIJ7Ygmvu2BpHEHQtzMWrWj40rZsf7cWWukzhytbGg93v4t0Wfcx/7Fq3SIvU3p7U/nqwkV8Xu0FScvSZJE3MLI8ivHwX98nsYwUXd5s5GYMBaEgZ7v2iZJU+QIDAQAB";

	/** RSA��Կ���ȱ�����64�ı�������512~65536֮�䡣Ĭ����1024 */
	public static final int KEY_SIZE = 1024;

	// ǩ��ԭ��
	public static final String PLAIN_TEXT = "<?xml version=\"1.0\" encoding=\"utf-8\"?><Document><header><channelCode>P2P001</channelCode><channelFlow>20160316175420006</channelFlow><channelDate>20160316</channelDate><channelTime>175420</channelTime><encryptData></encryptData><header><body><XMLPARA>7wPjJiSOm4ucZcU7lq0eqc37HWkJuz1bqjKpo6dgH11wqXi7ffFBzs2xmLOvYIhmAW6AVmky2uBvmIfhc0BTGDCQEbLUsjxZlzTrkHnodoBvOhLVjY/nWb+snb8izM6XuM9rtf2VYuAGkT8idBq+vMTh/sag+ccb7uiGHWmHUQno9bUCtcoA2TaGePIt9MkMIC6+QxRlda6mWzSoUZOj4w==</XMLPARA></body></Document>"; // ԭ��

	public static void main(String[] args) throws Exception {

		// -------ǩ��------
		// 1����ԭ���Ľ���MD5��ȡժҪ������ʵ����MD5�������õ���java�Դ���API��
		String md5Result = MD5(PLAIN_TEXT); 
		System.out.println("MD5ժҪ: " + md5Result); // �ǵ�תΪ��д

		// 2����˽Կ�ַ����õ�˽Կ������Ҫ�Ƚ�˽Կת��base64
		PrivateKey privateKey = restorePrivateKey(decryptBASE64(privateString));
		
		// 3��ͨ��˽Կ���󡢱��ĵõ�ǩ���õ���byte��������
		byte[] encodedText = RSAEncode(privateKey, md5Result.getBytes("UTF-8")); 

		// 4������ͷǰ��256λ��˽Կǩ����Ľ��privateResult
		String privateResult = byteArrayToHexString(encodedText);
		System.out.println("ǩ�����256λ���� " + privateResult);
		
		
		
		
		
//		// -------��ǩ-------
//		// 1��ͬ���������ȡ˽Կ����һ��
//		PublicKey publicKey = restorePublicKey(decryptBASE64(publicStr));
//		
//		// 2����Կ���ܣ��õ��ľ��Ǳ��ĵ�MD5ֵ����ǩ�����ܺ�������뷵�ص�<?xml>��ı�����MD5ժҪ�ȶ����һ����δ���۸ģ���md5Result��publicMD5Str
//		String publicMD5Str = RSADecode(publicKey, hexStringToByte(privateResult));
//		System.out.println("��Կ����: " + publicMD5Str);
//
//		// ��ǩ�Ļ������ܺ�������뷵�ص�<?xml>��ı�����MD5ժҪ�ȶ����һ����δ���۸�
//		// System.out.println(StringEscapeUtils.unescapeXml("&#25903;&#20184;&#35746;&#21333;&#39044;&#25480;&#26435;&#25104;&#21151;"));
//		
//		
//		
//		System.out.println(JSON.toJSONString(generateKeyBytes()));
	}

	/**
	 * ������Կ�ԡ�ע��������������Կ��KeyPair��������Կ�Ի�ȡ��˽Կ
	 * 
	 * @return
	 */
	public static Map<String, byte[]> generateKeyBytes() {

		try {
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
			keyPairGenerator.initialize(KEY_SIZE);
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
			RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

			Map<String, byte[]> keyMap = new HashMap<String, byte[]>();
			keyMap.put(PUBLIC_KEY, publicKey.getEncoded());
			keyMap.put(PRIVATE_KEY, privateKey.getEncoded());
			return keyMap;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ˽Կ��PKCS8EncodedKeySpec ���ڹ���˽Կ�Ĺ淶
	 * 
	 * @param keyBytes
	 * @return
	 */
	public static PrivateKey restorePrivateKey(byte[] keyBytes) {
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory factory;
		try {
			factory = KeyFactory.getInstance(KEY_ALGORITHM);
			PrivateKey privateKey = factory.generatePrivate(pkcs8EncodedKeySpec);
			return privateKey;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * ǩ��
	 * 
	 * @param key
	 * @param plainText
	 * @return
	 */
	public static byte[] RSAEncode(PrivateKey key, byte[] plainText) {

		try {
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			return cipher.doFinal(plainText);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static byte[] decryptBASE64(String key) throws Exception {
		return (new BASE64Decoder()).decodeBuffer(key);
	}

	public static String encryptBASE64(byte[] key) throws Exception {

		return (new BASE64Encoder()).encodeBuffer(key);
	}

	// ���ֽ�ת��Ϊʮ�������ַ���
	private static String byteToHexString(byte ib) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] ob = new char[2];
		ob[0] = Digit[(ib >>> 4) & 0X0F];
		ob[1] = Digit[ib & 0X0F];
		String s = new String(ob);
		return s;
	}

	// ���ֽ�����ת��Ϊʮ�������ַ���
	private static String byteArrayToHexString(byte[] bytearray) {
		String strDigest = "";
		for (int i = 0; i < bytearray.length; i++) {
			strDigest += byteToHexString(bytearray[i]);
		}
		return strDigest;
	}

	// MD5ժҪ
	public static String MD5(String srcData) throws NoSuchAlgorithmException {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		byte[] btInput = srcData.getBytes();
		// ���MD5ժҪ�㷨�� MessageDigest ����
		MessageDigest mdInst = MessageDigest.getInstance("MD5");
		// ʹ��ָ�����ֽڸ���ժҪ
		mdInst.update(btInput);
		// �������
		byte[] md = mdInst.digest();
		// ������ת����ʮ�����Ƶ��ַ�����ʽ
		int j = md.length;
		char str[] = new char[j * 2];
		int k = 0;
		for (int i = 0; i < j; i++) {
			byte byte0 = md[i];
			str[k++] = hexDigits[byte0 >>> 4 & 0xf];
			str[k++] = hexDigits[byte0 & 0xf];
		}
		return new String(str).toUpperCase();

	}

	// 16�����ַ���תΪ�ֽ�����
	public static byte[] hexStringToByte(String hex) {
		int len = (hex.length() / 2);
		byte[] result = new byte[len];
		char[] achar = hex.toCharArray();
		for (int i = 0; i < len; i++) {
			int pos = i * 2;
			result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
		}
		return result;
	}

	public static int toByte(char c) {
		byte b = (byte) "0123456789ABCDEF".indexOf(c);
		return b;
	}

}