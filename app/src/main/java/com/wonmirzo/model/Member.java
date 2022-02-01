package com.wonmirzo.model;

import java.util.List;

public class Member {
    private String firstName;
    private String lastName;
    private List<MemberSub> memberSubs;

    public Member(){}

    public Member(String firstName, String lastName, List<MemberSub> memberSubs) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberSubs = memberSubs;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<MemberSub> getMemberSubs() {
        return memberSubs;
    }

    public void setMemberSubs(List<MemberSub> memberSubs) {
        this.memberSubs = memberSubs;
    }
}
