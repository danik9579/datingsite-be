package com.datingsite.entities;

import javax.persistence.*;

@Entity
@Table(name="matches")
public class Match {

        @Id
        @GeneratedValue
        private long id;

        @Column(name = "USER_ID" , unique = true , nullable = false)
        private int userId;

        @Column(name = "MATCHED_USER_ID" , nullable = false)
        private int matchedUserId;

        public Match() {
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public int getUserId() {
                return userId;
        }

        public void setUserId(int userId) {
                this.userId = userId;
        }

        public int getMatchedUserId() {
                return matchedUserId;
        }

        public void setMatchedUserId(int matchedUserId) {
                this.matchedUserId = matchedUserId;
        }
}
