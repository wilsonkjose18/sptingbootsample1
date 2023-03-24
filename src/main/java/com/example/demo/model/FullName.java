package com.example.demo.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;


@Data
@Slf4j
public class FullName {
    private String prefix;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public FullName(String fullName) {
        prefix = "";
        firstName = "";
        lastName = "";
        middleName = "";
        suffix = "";
        String[] words = fullName.split(" ");
        int first_name_index, last_name_index;

        if (words[0].equalsIgnoreCase("mr.") | words[0].equalsIgnoreCase("dr.")) {
            prefix = words[0];
            if (words.length > 1) firstName = words[1];
            first_name_index = 1;
        } else {
            firstName = words[0];
            first_name_index = 0;
        }
        last_name_index = words.length - 1;
        if (words.length > 1) {
            if (words[words.length - 1].equalsIgnoreCase("jr.") || words[words.length - 1].equalsIgnoreCase("sr.")) {
                suffix = words[words.length - 1];
                if (words.length > 2) {
                    lastName = words[words.length - 2];
                    last_name_index = words.length - 2;
                }
            } else {
                lastName = words[words.length - 1];
                last_name_index = words.length - 1;
            }
        } else last_name_index = first_name_index;

        log.info("first name index is " + first_name_index);
        log.info("last name Index is " + last_name_index);
        if ((words.length > 2) && (last_name_index > (first_name_index + 1))) {
            StringBuilder s = new StringBuilder();
            for (int i = first_name_index + 1; i < last_name_index; i++) {
                s.append(" ");
                s.append(words[i]);
            }
            middleName = s.toString();
            log.info("middle name " + middleName);
        }
    }

    public String getReversedName() {
        return this.getLastName()
                + " "
                + this.getSuffix()
                + ","
                + this.getFirstName()
                + " "
                + this.getMiddleName();
    }
}

