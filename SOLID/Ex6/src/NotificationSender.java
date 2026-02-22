public abstract class NotificationSender {
    protected final AuditLog audit;
    protected NotificationSender(AuditLog audit) { this.audit = audit; }

    /**
     * Contract:
     * - n must not be null
     * - never throws for a valid Notification
     * - always logs to audit
     */
    public abstract void send(Notification n);
}