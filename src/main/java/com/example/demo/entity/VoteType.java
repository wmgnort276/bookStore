package com.example.demo.entity;

public enum VoteType {
    UP_VOTE(1), DOWN_VOTE(-1),
    ;
    private int direction;

    VoteType(int direction) {

    }

   public Integer getDirection(){
        return direction;
   }
}
