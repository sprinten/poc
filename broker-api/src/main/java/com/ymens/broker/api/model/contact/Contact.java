package com.ymens.broker.api.model.contact;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Representation of a contact.
 * </p>
 * <h5>Formatting Notes:</h5>
 * <ul>
 * <li>Date and time attribute values MUST be represented in Universal Coordinated Time (UTC) using the Gregorian
 * calendar.</li>
 * </ul>
 */
@XmlType(name = "Contact")
@XmlRootElement(name = "Contact")
public class Contact implements Serializable {

    private static final long serialVersionUID = 1l;

    private String id;

    private String roId;

    private List<Status> status;

    private PostalInfo postalInfo = new PostalInfo();

    private String voice;

    private String fax;

    private String email;

    private String clientId;

    private String createId;

    private Date createDate;

    private String updateId;

    private Date updateDate;

    private Date transferDate;

    private String authInfo;

    private Map<String, String> extensions = new HashMap<String, String>();

    /**
     * The server-unique identifier. Character strings with a specified minimum
     * length, a specified maximum length, and a specified format.
     * 
     * @return The contact ID
     */
    public String getId() {
        return this.id;
    }

    /**
     * The server-unique identifier. Character strings with a specified minimum
     * length, a specified maximum length, and a specified format.
     * 
     * @param contactId
     *        The new contact ID
     */
    public void setId(String contactId) {
        this.id = contactId;
    }

    /**
     * The Repository Object IDentifier assigned to the object when the object
     * was created.
     * 
     * @return The Repository Object ID
     */
    public String getRoId() {
        return this.roId;
    }

    /**
     * The Repository Object IDentifier assigned to the object when the object
     * was created.
     * 
     * @param roId
     *        The new Repository Object ID
     */
    public void setRoId(String roId) {
        this.roId = roId;
    }

    /**
     * The status.
     * 
     * @return The status
     */
    public List<Status> getStatus() {
        return this.status;
    }

    /**
     * The status.
     * 
     * @param status
     *        The new status
     */
    public void setStatus(List<Status> status) {
        this.status = status;
    }

    /**
     * The contact's voice telephone number.
     * 
     * @return The voice
     */
    public String getVoice() {
        return this.voice;
    }

    /**
     * The contact's voice telephone number.
     * 
     * @param voice
     *        The new voice
     */
    public void setVoice(String voice) {
        this.voice = voice;
    }

    /**
     * The contact's facsimile telephone number.
     * 
     * @return The fax
     */
    public String getFax() {
        return this.fax;
    }

    /**
     * The contact's facsimile telephone number.
     * 
     * @param fax
     *        The new fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * The contact's email address.
     * 
     * @return The email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * The contact's email address.
     * 
     * @param email
     *        The new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * The identifier of the sponsoring client.
     * 
     * @return The client ID.
     */
    public String getClientId() {
        return this.clientId;
    }

    /**
     * The identifier of the sponsoring client.
     * 
     * @param clientId
     *        the new client id
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * The identifier of the client that created the contact.
     * 
     * @return The create ID
     */
    public String getCreateId() {
        return this.createId;
    }

    /**
     * The identifier of the client that created the contact.
     * 
     * @param createId
     *        The new create ID
     */
    public void setCreateId(String createId) {
        this.createId = createId;
    }

    /**
     * The identifier of the client that updated the contact.
     * 
     * @return The update ID
     */
    public String getUpdateId() {
        return this.updateId;
    }

    /**
     * The identifier of the client that updated the contact.
     * 
     * @param updateId
     *        The new update ID
     */
    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    /**
     * The date and time when the contact name is registered.
     * 
     * @return the create date
     */
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * The date and time when the contact name is registered.
     * 
     * @param createDate
     *        The new create date
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * The date and time when the contact name is updated.
     * 
     * @return The update date
     */
    public Date getUpdateDate() {
        return this.updateDate;
    }

    /**
     * The date and time when the contact name is updated.
     * 
     * @param updateDate
     *        The new update date
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * The date and time of the most recent successful transfer.
     * 
     * @return The transfer date
     */
    public Date getTransferDate() {
        return this.transferDate;
    }

    /**
     * The date and time of the most recent successful transfer.
     * 
     * @param transferDate
     *        The new transfer date
     */
    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    /**
     * Element that contain postal-address information. The address information
     * is provided in internationalized form with the "type" attribute used to
     * identify the form. If an internationalized form (type="int") is provided,
     * element content MUST be represented in a subset of UTF-8 that can be
     * represented in the 7-bit US-ASCII character set.
     * 
     * @return The postal info US-ASCII character set
     */
    public PostalInfo getPostalInfo() {
        return postalInfo;
    }

    /**
     * Element that contain postal-address information. The address information
     * is provided in internationalized form with the "type" attribute used to
     * identify the form. If an internationalized form (type="int") is provided,
     * element content MUST be represented in a subset of UTF-8 that can be
     * represented in the 7-bit US-ASCII character set.
     * 
     * @param postalInfo
     *        The new postal info in US-ASCII character set
     */
    public void setPostalInfo(PostalInfo postalInfoInt) {
        this.postalInfo = postalInfoInt;
    }

    /**
     * The auth info.
     * 
     * @return The auth info
     */
    public String getAuthInfo() {
        return this.authInfo;
    }

    /**
     * The auth info.
     * 
     * @param authInfo
     *        The new auth info
     */
    public void setAuthInfo(String authInfo) {
        this.authInfo = authInfo;
    }

    /**
     * The host extensions and annexes. Additional fields defined by registry.
     * 
     * @return The extensions
     */
    public Map<String, String> getExtensions() {
        return this.extensions;
    }

    /**
     * The host extensions and annexes. Additional fields defined by registry.
     * 
     * @param extensions
     *        The extensions
     */
    public void setExtensions(Map<String, String> extensions) {
        this.extensions = extensions;
    }

    /**
     * Adds an extension.
     * 
     * @param annex
     *        The annex
     * @param value
     *        The value
     */
    public void addExtension(String annex, String value) {
        this.extensions.put(annex, value);
    }

    /**
     * The Enum for Contact Status.
     */
    @XmlType(name = "status")
    public enum Status {

        /** The ok status. */
        ok,

        /** The linked status. */
        linked,

        /** The client transfer prohibited status. */
        clientTransferProhibited,

        /** The client update prohibited status. */
        clientUpdateProhibited,

        /** The client delete prohibited status. */
        clientDeleteProhibited,

        /** The server transfer prohibited status. */
        serverTransferProhibited,

        /** The server update prohibited status. */
        serverUpdateProhibited,

        /** The server delete prohibited status. */
        serverDeleteProhibited,

        /** The pending create status. */
        pendingCreate,

        /** The pending delete status. */
        pendingDelete,

        /** The pending transfer status. */
        pendingTransfer,

        /** The pending update status. */
        pendingUpdate
    }
}
