package com.ybroker.model.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Filtering is OPTIONAL. Consumers may request a subset of Resources by
 * specifying the 'filter' URL query parameter containing a filter expression.
 * When specified only those Resources matching the filter expression SHALL be
 * returned. The expression language that is used in the filter parameter
 * supports references to attributes and literals. The literal values can be
 * strings enclosed in double quotes, numbers, date times enclosed in double
 * quotes, and Boolean values; i.e., true or false. String literals MUST be
 * valid JSON strings.
 * </p>
 * 
 * <p>
 * The attribute name and attribute operator are case insensitive.
 * </p>
 * 
 * <p>
 * The filter parameter MUST contain at least one valid Boolean expression. Each
 * expression MUST contain an attribute name followed by an attribute operator
 * and optional value. Multiple expressions MAY be combined using the two
 * logical operators. Furthermore expressions can be grouped together using
 * "()".
 * </p>
 * 
 * <h3>Attribute Operators</h3>
 * 
 * <table border="0" class="bodyTable  table-striped table table-bordered table-hover">
 * <tr>
 * <th>Operator</th>
 * <th>Description</th>
 * <th>Behavior</th>
 * </tr>
 * 
 * <tr>
 * <td>eq</td>
 * <td>equal</td>
 * <td>The attribute and operator values must be identical for a match.
 * </tr>
 * 
 * <tr>
 * <td>co</td>
 * <td>contains</td>
 * <td>The entire operator value must be a substring of the attribute value for
 * a match.
 * </tr>
 * 
 * <tr>
 * <td>sw</td>
 * <td>starts with</td>
 * <td>The entire operator value must be a substring of the attribute value,
 * starting at the beginning of the attribute value. This criterion is satisfied
 * if the two strings are identical.
 * </tr>
 * 
 * <tr>
 * <td>pr</td>
 * <td>present (has value)</td>
 * <td>If the attribute has a non-empty value, or if it contains a non-empty
 * node for complex attributes there is a match.
 * </tr>
 * 
 * <tr>
 * <td>gt</td>
 * <td>greater than</td>
 * <td>If the attribute value is greater than operator value, there is a match.
 * The actual comparison is dependent on the attribute type. For string
 * attribute types, this is a lexicographical comparison and for DateTime types,
 * it is a chronological comparison.
 * </tr>
 * 
 * <tr>
 * <td>ge</td>
 * <td>greater than or equal</td>
 * <td>If the attribute value is greater than or equal to the operator value,
 * there is a match. The actual comparison is dependent on the attribute type.
 * For string attribute types, this is a lexicographical comparison and for
 * DateTime types, it is a chronological comparison.
 * </tr>
 * 
 * <tr>
 * <td>less than</td>
 * <td>equal</td>
 * <td>If the attribute value is less than operator value, there is a match. The
 * actual comparison is dependent on the attribute type. For string attribute
 * types, this is a lexicographical comparison and for DateTime types, it is a
 * chronological comparison.
 * </tr>
 * 
 * <tr>
 * <td>le</td>
 * <td>less than or equal</td>
 * <td>If the attribute value is less than or equal to the operator value, there
 * is a match. The actual comparison is dependent on the attribute type. For
 * string attribute types, this is a lexicographical comparison and for DateTime
 * types, it is a chronological comparison.
 * </tr>
 * 
 * </table>
 * 
 * <h3>Logical Operators</h3>
 * 
 * <table border="0" class="bodyTable table table-striped table-bordered table-hover">
 * <tr>
 * <th>Operator</th>
 * <th>Description</th>
 * <th>Behavior</th>
 * </tr>
 * 
 * <tr>
 * <td>and</td>
 * <td>Logical And</td>
 * <td>The filter is only a match if both expressions evaluate to true.</td>
 * </tr>
 * <td>or</td>
 * <td>Logical Or</td>
 * <td>The filter is a match if either expression evaluates to true.</td>
 * </tr>
 * </table>
 * 
 * <h3>Grouping Operators</h3>
 * 
 * <table border="0" class="bodyTable table table-striped table-bordered table-hover">
 * <tr>
 * <th>Operator</th>
 * <th>Description</th>
 * <th>Behavior</th>
 * </tr>
 * 
 * <tr>
 * <td>()</td>
 * <td>Precedence grouping</td>
 * <td>Boolean expressions may be grouped using parentheses to change the
 * standard order of operations; i.e., evaluate OR logical operators before
 * logical AND operators.</td>
 * </tr>
 * </table>
 * 
 * <p>
 * Filters MUST be evaluated using standard order of operations. Attribute
 * operators have the highest precedence, followed by the grouping operator
 * (i.e, parentheses), followed by the logical AND operator, followed by the
 * logical OR operator.
 * </p>
 * 
 * <p>
 * If the specified attribute in a filter expression is a multi-valued
 * attribute, the Resource MUST match if any of the instances of the given
 * attribute match the specified criterion; e.g. if a User has multiple emails
 * values, only one has to match for the entire User to match. For complex
 * attributes, a fully qualified Sub-Attribute MUST be specified using standard
 * attribute notation. For example, to filter by userName the parameter value is
 * userName and to filter by first name, the parameter value is name.givenName.
 * </p>
 * 
 * <p>
 * Providers MAY support additional filter operations if they choose. Providers
 * MUST decline to filter results if the specified filter operation is not
 * recognized and return a HTTP 400 error with an appropriate human readable
 * response. For example, if a Consumer specified an unsupported operator named
 * 'regex' the Service Provider should specify an error response description
 * identifying the Consumer error; e.g., 'The operator 'regex' is not
 * supported.'
 * </p>
 * 
 * <p>
 * String type attributes are case insensitive by default unless the attribute
 * type is defined as a caseExact string. Attribute operators 'eq', 'co', and
 * 'sw' MUST perform caseIgnore matching for all string attributes unless the
 * attribute is defined as caseExact. By default all string attributes are
 * caseIgnore.
 * </p>
 * 
 */
@XmlType(name = "Filter", propOrder = { "attribute", "operator", "value" })
@XmlRootElement(name = "Filter")
public class Filter {

	private String attribute;

	private String operator;

	private String value;

	/**
	 * The attribute name
	 * 
	 * @return
	 */
	@XmlElement(required = true)
	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	/**
	 * The attribute operator
	 * 
	 * @return
	 */
	@XmlElement(required = true)
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * The attribute value
	 * 
	 * @return
	 */
	@XmlElement(required = true)
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}