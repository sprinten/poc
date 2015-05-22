package com.ybroker.scim.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Logger;

import javax.xml.bind.DatatypeConverter;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Utils {

	private static Logger logger = Logger.getLogger(Utils.class.getName());

	private final static String TIME_ZONE = "UTC";
	private final static String CHARSET_NAME = "UTF-8";

	private static DatatypeFactory datatypeFactory;

	/**
	 * Converts a java.sql.Timestamp into an instance of XMLGregorianCalendar
	 *
	 * @param timestamp Instance of java.sql.Timestamp from database
	 * @return XMLGregorianCalendar instance
	 */
	public static XMLGregorianCalendar asXMLGregorianCalendar(java.sql.Timestamp timestamp) {

		if (timestamp == null) {
			return null;
		}
		GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone(TIME_ZONE));
		gregorianCalendar.setTime(timestamp);
		XMLGregorianCalendar calendar = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
		calendar.setFractionalSecond(null);
		return calendar;
	}

	/**
	 * Checks if given locale is valid according to SCIM schema.
	 *
	 * @param locale String to parse and check
	 * @return boolean true if valid, false otherwise
	 */
	public static boolean isLocaleValid(String locale) {
		String[] split = locale.split("_");

		return split.length == 2
				&& Arrays.binarySearch(Locale.getISOLanguages(), split[0]) > 0
				&& isCountryValid(split[1]);
	}

	/**
	 * Checks if given 2-letter country code is valid according to ISO 3166.
	 *
	 * @param twoLetterCountryCode String to check
	 * @return boolean true if valid, false otherwise
	 */
	public static boolean isCountryValid(String twoLetterCountryCode) {
		return Arrays.binarySearch(Locale.getISOCountries(), twoLetterCountryCode) > 0;
	}

	/**
	 * Trims this string if it is not null.
	 *
	 * @param s string to trim
	 * @return string trimmed or null
	 */
	public static String trimOrNull(String s) {
		s = s != null ? s.trim() : s;
		return s != null && s.length() > 0 ? s : null;
	}

	/**
	 * Digests this Date object with SHA-1 algorithm.
	 *
	 * @param dateTime to digest
	 * @return String which is base 64 encoded byte array
	 */
	public static String toSHA1(java.util.Date dateTime) {
		try {
		    MessageDigest md = MessageDigest.getInstance("SHA-1");
		    byte[] digested = md.digest(dateTime.toString().getBytes(CHARSET_NAME));

		    return DatatypeConverter.printBase64Binary(digested);

		} catch(NoSuchAlgorithmException | UnsupportedEncodingException e) {
			logger.fine(e.toString());
			return null;
		}
	}

	/**
	 * Digests this string with SHA-256 algorithm.
	 *
	 * @param string to digest
	 * @return String which is base 64 encoded byte array
	 */
	public static String toSHA256(String string) {
		try {
		    MessageDigest md = MessageDigest.getInstance("SHA-256");
		    byte[] digested = md.digest(string.getBytes(CHARSET_NAME));

		    return DatatypeConverter.printBase64Binary(digested);

		} catch(NoSuchAlgorithmException | UnsupportedEncodingException e) {
			logger.fine(e.toString());
			return null;
		}
	}

	public static String hashPassword(String password) {
		String passwd = trimOrNull(password);
		return passwd != null ? toSHA256(passwd) : null;
	}

	/**
	 * Convenience method, calls toSHA1(dateTime) function first and
	 * then wraps the result into extra quotes.
	 *
	 * @param dateTime to digest and wrap
	 * @return String result of toSHA1(dateTime) wrapped into extra quotes
	 */
	public static String createVersion(java.util.Date dateTime) {
		return "\"" + toSHA1(dateTime) + "\"";
	}
}
