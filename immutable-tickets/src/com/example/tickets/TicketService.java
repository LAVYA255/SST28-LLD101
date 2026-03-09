package com.example.tickets;

import java.util.ArrayList;
import java.util.List;

/**
 * Service layer that creates tickets.
 *
 * CURRENT STATE (BROKEN ON PURPOSE):
 * - creates partially valid objects
 * - mutates after creation (bad for auditability)
 * - validation is scattered & incomplete
 *
 * TODO (student):
 * - After introducing immutable IncidentTicket + Builder, refactor this to stop mutating.
 */
public class TicketService {

    public IncidentTicket createTicket(String id, String reporterEmail, String title) {
        // scattered validation (incomplete on purpose)

        List<String> tags = new ArrayList<>();
        tags.add("NEW");

        return new IncidentTicket.Builder(id,reporterEmail,title).priority("MEDIUM").source("CLI").customerVisible(false).tags(tags).build();
        // if (id == null || id.trim().isEmpty()) throw new IllegalArgumentException("id required");
        // if (reporterEmail == null || !reporterEmail.contains("@")) throw new IllegalArgumentException("email invalid");
        // if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("title required");

        // IncidentTicket t = new IncidentTicket(id, reporterEmail, title);

        // // BAD: mutating after creation
        // t.setPriority("MEDIUM");
        // t.setSource("CLI");
        // t.setCustomerVisible(false);

       
        // t.setTags(tags);

        // return t;
    }

    public IncidentTicket escalateToCritical(IncidentTicket t) {
        // BAD: mutating ticket after it has been "created"

        List<String> temp =new ArrayList<>(t.getTags());
        return t.toBuilder().priority("CRITICAL").tags(temp).build();
        // t.setPriority("CRITICAL");
        // t.getTags().add("ESCALATED"); // list leak
    }

    public IncidentTicket assign(IncidentTicket t, String assigneeEmail) {
        // scattered validation
        return t.toBuilder().assigneeEmail(assigneeEmail).build();
        // if (assigneeEmail != null && !assigneeEmail.contains("@")) {
        //     throw new IllegalArgumentException("assigneeEmail invalid");
        // }
        // t.setAssigneeEmail(assigneeEmail);
    }
}