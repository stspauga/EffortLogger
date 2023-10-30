package src;
import java.util.HashMap;
import java.util.Map;

public class ScheduleSystem {
    private Map<String, String> memberRoles;
    private Map<String, String> memberSchedules;

    public ScheduleSystem() {
        memberRoles = new HashMap<>();
        memberSchedules = new HashMap<>();
    }

    // Method to add a team member and their role
    public void addTeamMember(String memberName, String memberRole) {
        memberRoles.put(memberName, memberRole);
    }

    // Method to set a team member's schedule
    public boolean setMemberSchedule(String memberName, String schedule) {
        // Check for scheduling conflicts before setting the schedule
        if (hasSchedulingConflict(memberName, schedule)) {
            System.out.println("Error: Conflicted schedule! Schedule not set for " + memberName);
            return false;
        }

        memberSchedules.put(memberName, schedule);
        System.out.println("Succeeded! Schedule set for " + memberName);
        return true;
    }

    // Method to get a team member's role
    public String getMemberRole(String memberName) {
        return memberRoles.get(memberName);
    }

    // Method to get a team member's schedule
    public String getMemberSchedule(String memberName) {
        return memberSchedules.get(memberName);
    }

    // Method to check for scheduling conflicts
    public boolean hasSchedulingConflict(String memberName, String proposedSchedule) {
        String existingSchedule = memberSchedules.get(memberName);
        
        //return NULL if a team member has not set the schedule yet.
        if (existingSchedule == null) {
            return false;
        }

        // Check if the proposed schedule overlaps with the existing schedule
        String[] existingScheduleParts = existingSchedule.split("-");
        String[] proposedScheduleParts = proposedSchedule.split("-");

        // Parse and compare time slots to check for conflicts
        try {
            String[] existingStartTime = existingScheduleParts[0].split(":");
            String[] existingEndTime = existingScheduleParts[1].split(":");

            int existingStartHour = Integer.parseInt(existingStartTime[0]);
            int existingStartMinute = Integer.parseInt(existingStartTime[1]);
            int existingEndHour = Integer.parseInt(existingEndTime[0]);
            int existingEndMinute = Integer.parseInt(existingEndTime[1]);

            String[] proposedStartTime = proposedScheduleParts[0].split(":");
            String[] proposedEndTime = proposedScheduleParts[1].split(":");

            int proposedStartHour = Integer.parseInt(proposedStartTime[0]);
            int proposedStartMinute = Integer.parseInt(proposedStartTime[1]);
            int proposedEndHour = Integer.parseInt(proposedEndTime[0]);
            int proposedEndMinute = Integer.parseInt(proposedEndTime[1]);

            if (
                (proposedStartHour < existingEndHour || (proposedStartHour == existingEndHour && proposedStartMinute < existingEndMinute)) &&
                (proposedEndHour > existingStartHour || (proposedEndHour == existingStartHour && proposedEndMinute > existingStartMinute))
            ) {
                //return True if schedules are conflicted.
                return true;
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            // Handle invalid time format if necessary
            System.err.println("Invalid time for given schedules.");
        }
        // No scheduling conflict
        return false;
    }
}