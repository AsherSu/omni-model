package cn.ashersu.omni.model.billing;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Account information
 */
public class Subscription {
    @JsonProperty("object")
    private String object;
    @JsonProperty("has_payment_method")
    private boolean hasPaymentMethod;
    @JsonProperty("canceled")
    private boolean canceled;
    @JsonProperty("canceled_at")
    private Object canceledAt;
    @JsonProperty("delinquent")
    private Object delinquent;
    @JsonProperty("access_until")
    private long accessUntil;
    @JsonProperty("soft_limit")
    private long softLimit;
    @JsonProperty("hard_limit")
    private long hardLimit;
    @JsonProperty("system_hard_limit")
    private long systemHardLimit;
    @JsonProperty("soft_limit_usd")
    private double softLimitUsd;
    @JsonProperty("hard_limit_usd")
    private double hardLimitUsd;
    @JsonProperty("system_hard_limit_usd")
    private double systemHardLimitUsd;
    @JsonProperty("plan")
    private Plan plan;
    @JsonProperty("account_name")
    private String accountName;
    @JsonProperty("po_number")
    private Object poNumber;
    @JsonProperty("billing_email")
    private Object billingEmail;
    @JsonProperty("tax_ids")
    private Object taxIds;
    @JsonProperty("billing_address")
    private Object billingAddress;
    @JsonProperty("business_address")
    private Object businessAddress;

    public Subscription() {
    }

    public Subscription(String object, boolean hasPaymentMethod, boolean canceled, Object canceledAt,
                        Object delinquent, long accessUntil, long softLimit, long hardLimit,
                        long systemHardLimit, double softLimitUsd, double hardLimitUsd,
                        double systemHardLimitUsd, Plan plan, String accountName, Object poNumber,
                        Object billingEmail, Object taxIds, Object billingAddress, Object businessAddress) {
        this.object = object;
        this.hasPaymentMethod = hasPaymentMethod;
        this.canceled = canceled;
        this.canceledAt = canceledAt;
        this.delinquent = delinquent;
        this.accessUntil = accessUntil;
        this.softLimit = softLimit;
        this.hardLimit = hardLimit;
        this.systemHardLimit = systemHardLimit;
        this.softLimitUsd = softLimitUsd;
        this.hardLimitUsd = hardLimitUsd;
        this.systemHardLimitUsd = systemHardLimitUsd;
        this.plan = plan;
        this.accountName = accountName;
        this.poNumber = poNumber;
        this.billingEmail = billingEmail;
        this.taxIds = taxIds;
        this.billingAddress = billingAddress;
        this.businessAddress = businessAddress;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public boolean isHasPaymentMethod() {
        return hasPaymentMethod;
    }

    public void setHasPaymentMethod(boolean hasPaymentMethod) {
        this.hasPaymentMethod = hasPaymentMethod;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public Object getCanceledAt() {
        return canceledAt;
    }

    public void setCanceledAt(Object canceledAt) {
        this.canceledAt = canceledAt;
    }

    public Object getDelinquent() {
        return delinquent;
    }

    public void setDelinquent(Object delinquent) {
        this.delinquent = delinquent;
    }

    public long getAccessUntil() {
        return accessUntil;
    }

    public void setAccessUntil(long accessUntil) {
        this.accessUntil = accessUntil;
    }

    public long getSoftLimit() {
        return softLimit;
    }

    public void setSoftLimit(long softLimit) {
        this.softLimit = softLimit;
    }

    public long getHardLimit() {
        return hardLimit;
    }

    public void setHardLimit(long hardLimit) {
        this.hardLimit = hardLimit;
    }

    public long getSystemHardLimit() {
        return systemHardLimit;
    }

    public void setSystemHardLimit(long systemHardLimit) {
        this.systemHardLimit = systemHardLimit;
    }

    public double getSoftLimitUsd() {
        return softLimitUsd;
    }

    public void setSoftLimitUsd(double softLimitUsd) {
        this.softLimitUsd = softLimitUsd;
    }

    public double getHardLimitUsd() {
        return hardLimitUsd;
    }

    public void setHardLimitUsd(double hardLimitUsd) {
        this.hardLimitUsd = hardLimitUsd;
    }

    public double getSystemHardLimitUsd() {
        return systemHardLimitUsd;
    }

    public void setSystemHardLimitUsd(double systemHardLimitUsd) {
        this.systemHardLimitUsd = systemHardLimitUsd;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Object getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(Object poNumber) {
        this.poNumber = poNumber;
    }

    public Object getBillingEmail() {
        return billingEmail;
    }

    public void setBillingEmail(Object billingEmail) {
        this.billingEmail = billingEmail;
    }

    public Object getTaxIds() {
        return taxIds;
    }

    public void setTaxIds(Object taxIds) {
        this.taxIds = taxIds;
    }

    public Object getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Object billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Object getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(Object businessAddress) {
        this.businessAddress = businessAddress;
    }
}
