package com.ymens.broker.api.model.generic;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Bulk Operation Representation.
 * </p>
 * 
 * Bulk is OPTIONAL. The bulk operation enables Consumers to send a potentially
 * large collection of Resource operations in a single request. The body of a a
 * bulk operation contains a set of HTTP Resource operations using one of the
 * API supported HTTP methods; i.e., POST, PUT, PATCH or DELETE.
 */
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(name = "Bulk", propOrder = { "failOnErrors", "operations" })
@XmlRootElement(name = "Bulk")
public class Bulk {

	private Integer failOnErrors;

	private List<Operation> operations;

	/**
	 * An Integer specifying the number of errors that the Service Provider will
	 * accept before the operation is terminated and an error response is
	 * returned. OPTIONAL.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getFailOnErrors() {
		return failOnErrors;
	}

	/**
	 * @param value
	 *            allowed object is {@link Integer }
	 */
	public void setFailOnErrors(Integer value) {
		this.failOnErrors = value;
	}

	/**
	 * Defines operations within a bulk job. Each operation corresponds to a
	 * single HTTP request against a Resource endpoint. REQUIRED.
	 * 
	 * @return possible object
	 * 
	 */
	@XmlElement(name = "Operations")
	public List<Operation> getOperations() {
		return operations;
	}

	/**
	 * @param value
	 */
	public void setOperations(List<Operation> value) {
		this.operations = value;
	}

	/**
	 * Defines operations within a bulk job. Each operation corresponds to a
	 * single HTTP request against a Resource endpoint. REQUIRED.
	 */
	@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
	@XmlType(name = "Operation", propOrder = { "method", "bulkId", "version", "path", "location", "data", "status" })
	public static class Operation {

		private String method;
		private String bulkId;
		private String version;
		private String path;
		private String location;
		private Resource data;
		private Status status;

		/**
		 * The HTTP method of the current operation. Possible values are POST,
		 * PUT, PATCH or DELETE. REQUIRED.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		@XmlElement(required = true)
		public String getMethod() {
			return method;
		}

		/**
		 * @param value
		 */
		public void setMethod(String value) {
			this.method = value;
		}

		/**
		 * The transient identifier of a newly created Resource, unique within a
		 * bulk request and created by the Consumer. The bulkId serves as a
		 * surrogate Resource id enabling Consumers to uniquely identify newly
		 * created Resources in the Response and cross reference new Resources
		 * in and across operations within a bulk request. REQUIRED when method
		 * is POST.
		 * 
		 * @return possible object is {@link String }
		 */
		public String getBulkId() {
			return bulkId;
		}

		/**
		 * @param value
		 */
		public void setBulkId(String value) {
			this.bulkId = value;
		}

		/**
		 * The current Resource version. Version is REQUIRED if the Service
		 * Provider supports ETags and the method is PUT, DELETE, or PATCH.
		 * 
		 * @return possible object is {@link String }
		 */
		public String getVersion() {
			return version;
		}

		/**
		 * @param value
		 *            allowed object is {@link String }
		 */
		public void setVersion(String value) {
			this.version = value;
		}

		/**
		 * The Resource's relative path. If the method is POST the value must
		 * specify a Resource type endpoint; e.g., /Users or /Groups whereas all
		 * other method values must specify the path to a specific Resource;
		 * e.g., /Users/2819c223-7f76-453a-919d-413861904646. REQUIRED in a
		 * request.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getPath() {
			return path;
		}

		public void setPath(String value) {
			this.path = value;
		}

		/**
		 * The Resource endpoint URL. REQUIRED in a response, except in the
		 * event of a POST failure.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getLocation() {
			return location;
		}

		public void setLocation(String value) {
			this.location = value;
		}

		/**
		 * The Resource data as it would appear for a single POST, PUT or PATCH
		 * Resource operation. REQUIRED in a request when method is POST, PUT
		 * and PATCH.
		 * 
		 * @return possible object is {@link Resource }
		 * 
		 */
		public Resource getData() {
			return data;
		}

		public void setData(Resource value) {
			this.data = value;
		}

		/**
		 * A complex type that contains information about the success or failure
		 * of one operation within the bulk job. REQUIRED in a response.
		 * 
		 * @return possible object is {@link Status }
		 */
		public Status getStatus() {
			return status;
		}

		public void setStatus(Status value) {
			this.status = value;
		}

		/**
		 * A complex type that contains information about the success or failure
		 * of one operation within the bulk job. REQUIRED in a response.
		 */
		@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
		@XmlType(name = "Status", propOrder = { "code", "description" })
		public static class Status {

			private String code;
			private String description;

			/**
			 * The HTTP response code that would have been returned if a a
			 * single HTTP request would have been used. REQUIRED.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getCode() {
				return code;
			}

			public void setCode(String value) {
				this.code = value;
			}

			/**
			 * A human readable error message. REQUIRED when an error occurred.
			 * 
			 * @return possible object is {@link String }
			 */
			public String getDescription() {
				return description;
			}

			public void setDescription(String value) {
				this.description = value;
			}

		}
	}
}
